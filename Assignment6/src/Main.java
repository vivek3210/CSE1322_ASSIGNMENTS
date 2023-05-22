import java.util.Scanner;
import java.util.ArrayList;
import java.net.*;
import java.io.*;
public class Main {
    static ArrayList<String> getData() {
        ArrayList<String> getData = new ArrayList<String>();
        Socket serverSocket;
        PrintWriter toSocket;

        try {
            serverSocket = new Socket("api.coindesk.com", 80);
            toSocket = new PrintWriter(serverSocket.getOutputStream());
            toSocket.println("GET http://api.coindesk.com/v1/bpi/currentprice.json HTTP/1.0\n\n");
            toSocket.flush();
            Scanner fromSocket = new Scanner(serverSocket.getInputStream());

            while (fromSocket.hasNextLine()) {
                String line = fromSocket.nextLine();
                getData.add(line);
            }
            return getData;
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static float getDollarPrice(ArrayList<String> lines) {
        boolean header=true;
        String json="";
        for(String line : lines) {
            if(line.equals("")) {
                header=false;
                continue;
            }
            if(header==false) {
                json=line;
                break;
            }
        }
//System.out.println("Json: "+json);
        String[] jsonParts = json.split(":");
        String priceLine=jsonParts[19];
        String justPrice=priceLine.replace("},\"GBP\"","");
        float price=Float.parseFloat(justPrice);
        return price;
    }
    static void buyBitcoin(float bitcoinPrice) throws FileNotFoundException {
        File file = new File("initialInvestmentUSD.txt");
        Scanner scanner = new Scanner(file);
        //read all lines of the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //each line should be split into 2 parts: name and US dollars invested
            String[] parts = line.split(":");
            String name = parts[0];
            float dollars = Float.parseFloat(parts[1]);
            //for each line, calculate the number of bitcoins purchased
            float bitcoins = dollars / bitcoinPrice;
            //write the name and number of bitcoins purchased to a file called clientBC.txt
            PrintWriter writer = null;

            writer = new PrintWriter(new FileOutputStream(new File("clientBC.txt"), true));
            writer.append(name + ":" + bitcoins);
            writer.append(System.lineSeparator());
            writer.close();
        }
    }
    static void getCurrentValue(float bitcoinPrice) throws FileNotFoundException {
        File file = new File("clientBC.txt");
        Scanner scanner = new Scanner(file);
        //read all lines of the file
        float value = 0;
        String name = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //each line should be split into 2 parts: name and number of bitcoins
            String[] parts = line.split(":");
            name = parts[0];
            float bitcoins = Float.parseFloat(parts[1]);
            //for each line, calculate the current value of the bitcoins
            value = bitcoins * bitcoinPrice;
            System.out.println(name + ":$" + value);


        }
    }
    public static class PersonNotFound extends Exception {
        public PersonNotFound(String message) {
            super(message);
        }
    }
    static String getPersonFromFile(String personName, String fileName) throws PersonNotFound {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                if (parts[0].equals(personName)) {
                    return parts[1];
                }
            }
        } catch (FileNotFoundException e) {
            throw new PersonNotFound("Person not found");
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userInput = 0;

        while(userInput != 4) {
            System.out.println("One BitCoin is currently worth " + getDollarPrice(getData()) + " USD");
            System.out.println("1. Buy Bitcoin\n" + "2. See everyones current value in USD\n" +
                    "3. See one persons gain/loss\n" + "4. Quit");
            userInput = sc.nextInt();
            switch(userInput) {
                case 1:
                    try {
                        buyBitcoin(getDollarPrice(getData()));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try {
                        getCurrentValue(getDollarPrice(getData()));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println("Enter the name of the person you want to see the gain/loss of: ");
                    String name = sc.next();
                    try {
                        System.out.println("Original Investment: $" + getPersonFromFile(name, "initialInvestmentUSD.txt"));
                        System.out.println("Number of bitcoins: " + getPersonFromFile(name, "clientBC.txt"));
                        float currentValue = getDollarPrice(getData()) * Float.parseFloat(getPersonFromFile(name, "clientBC.txt"));
                        System.out.println("Current Value: $" + currentValue);
                        float gainLoss = currentValue - Float.parseFloat(getPersonFromFile(name, "initialInvestmentUSD.txt"));
                        System.out.println("Change in value: $" + gainLoss);
                    } catch (PersonNotFound e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}