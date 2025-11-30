public class Visitor extends Person {
    private String visitorId;
    private int tickets;

    public Visitor() {
    }

    public Visitor(String name, int age, String gender, String visitorId, int tickets) {
        super(name, age, gender);
        this.visitorId = visitorId;
        this.tickets = tickets;
    }

    // Getters and Setters
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
}