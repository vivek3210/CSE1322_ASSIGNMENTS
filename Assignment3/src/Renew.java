public class Renew extends Customer {
    private String customerName;
     public Renew(String cn)
     {
        super('B');
         customerName = cn;
     }
     @Override
    public String getCustomerInfo() {
         return "Renewal License. Ticket Number " + getTicketNumber() + ". Name: " + customerName;
     }
}
