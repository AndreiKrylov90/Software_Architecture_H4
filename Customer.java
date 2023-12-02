import java.util.ArrayList;
import java.util.Collection;

public class Customer {

    private static int counter = 100;

    public Customer(){
        id = ++counter;
    }

    private int id;
    private Collection<Ticket> tickets = new ArrayList<>();

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Customer ID: ").append(id).append("\n");

        if (tickets != null && !tickets.isEmpty()) {
            stringBuilder.append("Tickets: ");
            boolean firstTicket = true;

            for (Ticket ticket : tickets) {
                if (!firstTicket) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append("Ticket ID: ").append(ticket.getId());
                firstTicket = false;
            }
            stringBuilder.append("\n");
        } else {
            stringBuilder.append("No tickets.\n");
        }

        return stringBuilder.toString();
    }

}
