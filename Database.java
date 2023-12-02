import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Database {

    public Database() {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        Customer customer4 = new Customer();
        Customer customer5 = new Customer();

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        for (Customer customer : customers) {
            for (int i = 0; i < 2; i++) { // You can change the number of tickets per customer here
                Ticket ticket = new Ticket();
                ticket.setCustomerId(customer.getId());
                customer.getTickets().add(ticket);
                tickets.add(ticket);
            }
        }

    }

    private static int counter = 100;

    public Collection<Ticket> tickets = new ArrayList<>();
    public Collection<Customer> customers = new ArrayList<>();

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    /**
     * Получить актуальную стоимость билета
     *
     * @return
     */
    public double getTicketAmount() {
        return 45;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     *
     * @return
     */
    public int createTicketOrder(int clientId) {
        return ++counter;
    }

    /**
     * Обновить статус билета по его ID.
     *
     * @param ticketId  ID билета.
     * @param newStatus Новый статус билета.
     * @return true, если обновление прошло успешно, в противном случае - false.
     */
    public boolean updateTicketStatus(int ticketId, boolean newStatus) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == ticketId) {
                ticket.setEnable(newStatus);
                return true;
            }
        }
        return false;
    }

}
