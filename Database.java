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

        Random rand = new Random();

        for (Customer customer : customers) {
            for (int i = 0; i < 2; i++) { // You can change the number of tickets per customer here
                Ticket ticket = new Ticket();
                customer.getTickets().add(ticket);
                tickets.add(ticket);
            }
        }

        // for (int i = 0; i < 10; i++) {
        //     Ticket ticket = new Ticket();
        //     int randomIndex = rand.nextInt(customers.size());
        //     customers.get(randomIndex).getTickets().add(ticket);
        //     tickets.add(ticket);

        // }

        // Ticket ticket1 = new Ticket();
        // Ticket ticket2 = new Ticket();
        // Ticket ticket3 = new Ticket();
        // // сделать через сет

        // customer1.getTickets().add(ticket1);
        // customer1.getTickets().add(ticket2);
        // customer1.getTickets().add(ticket3);
        // tickets.add(ticket1);
        // tickets.add(ticket2);
        // tickets.add(ticket3);
        // customers.add(customer1);

    }

    private static int counter = 100;

    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

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
}
