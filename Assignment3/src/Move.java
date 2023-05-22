public class Move extends Customer{
    private String customerName;
    private String stateMovedFrom;

    public Move(String cn, String smf)
    {
        super('C');
        customerName = cn;
        stateMovedFrom = smf;
    }
    @Override
    public String getCustomerInfo() {
        return "Moved from " + stateMovedFrom + ". Ticket Number " + getTicketNumber() + ". Name: " + customerName;
    }
}
