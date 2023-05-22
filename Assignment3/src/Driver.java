
import java.util.Scanner;
import java.util.ArrayList;
public class Driver {
    public ArrayList menu(ArrayList customers)
    {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Take test for new license\n2. Renew existing license\n3. Move from out of state\n" +
                    "4. Answer citation/suspended license\n5. See current queue\n6. Quit");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("What is your name?");
                    String n = input.next();
                    System.out.println("What is your data of birth?");
                    String dob = input.next();
                    customers.add(new NewTest(n, dob));
                    break;
                case 2:
                    System.out.println("What is your name?");
                    String n1 = input.next();
                    customers.add(new Renew(n1));
                    break;
                case 3:
                    System.out.println("What is your name?");
                    String n2 = input.next();
                    System.out.println("What state did you move from?");
                    String smf = input.next();
                    customers.add(new Move(n2, smf));
                    break;
                case 4:
                    System.out.println("What is your name?");
                    String n3 = input.next();
                    System.out.println("What violation did you commit?");
                    String vc = input.next();
                    customers.add(new Suspended(n3, vc));
                    break;
                case 5:
                    for (int i = 0; i < customers.size(); i++) {
                        if (customers.get(i) instanceof NewTest) {
                            NewTest nt = (NewTest) customers.get(i);
                            System.out.println(nt.getCustomerInfo());
                        } else if (customers.get(i) instanceof Renew) {
                            Renew r = (Renew) customers.get(i);
                            System.out.println(r.getCustomerInfo());
                        } else if (customers.get(i) instanceof Move) {
                            Move m = (Move) customers.get(i);
                            System.out.println(m.getCustomerInfo());
                        } else if (customers.get(i) instanceof Suspended) {
                            Suspended s = (Suspended) customers.get(i);
                            System.out.println(s.getCustomerInfo());
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 6);
        return customers;
    }
    public static void main(String[] args) {
        Driver d = new Driver();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        d.menu(customers);
    }
}
