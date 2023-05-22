public class Suspended extends Customer{
    private String customerName;
    private String violationCommited;
    public Suspended(String cn, String vc)
    {
        super('D');
        customerName = cn;
        violationCommited = vc;
    }
    @Override
    public String getCustomerInfo() {
        return "Violation: " + violationCommited + ". Ticket Number " + getTicketNumber() + ". Name: " + customerName;
    }
}
