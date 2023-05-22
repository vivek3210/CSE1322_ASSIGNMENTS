public abstract class Customer {

    private char ticketType;

    private int ticketNumber;

    private static int AticketCounter = 0;

    private static int BticketCounter = 0;

    private static int CticketCounter = 0;

    private static int DticketCounter = 0;

    public Customer(char tt)

    {

        ticketType = tt;

        if(tt == 'A')

        {

            AticketCounter++;

            ticketNumber = AticketCounter;

        }

        if(tt == 'B')

        {

            BticketCounter++;

            ticketNumber = BticketCounter;

        }

        if(tt == 'C')

        {

            CticketCounter++;

            ticketNumber = CticketCounter;

        }

        if(tt == 'D')

        {

            DticketCounter++;

            ticketNumber = DticketCounter;

        }



    }

    protected String getTicketNumber() {

        return ticketType + String.valueOf(ticketNumber);

    }

    public abstract String getCustomerInfo();

}



