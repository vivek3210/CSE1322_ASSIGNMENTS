public class NewTest extends Customer{
    private String customerName;
    private String dateOfBirth;
    public NewTest(String cn, String dob) {
        super('A');
        customerName = cn;
        dateOfBirth = dob;

    }
    @Override
    public String getCustomerInfo() {
        return "New Drivers License. Ticket Number " + getTicketNumber() + ". Name: " + customerName + ". Date of Birth: " + dateOfBirth;
    }
}
