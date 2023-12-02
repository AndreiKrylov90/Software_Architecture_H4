import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TicketProvider {
    public final Database database;
    private final PaymentProvider paymentProvider;

    /**
     * Конструктор класса TicketProvider.
     *
     * @param database        База данных билетов.
     * @param paymentProvider Провайдер платежей.
     */
    public TicketProvider(Database database, PaymentProvider paymentProvider) {
        if (database == null || paymentProvider == null) {
            throw new IllegalArgumentException("Database и paymentProvider не могут быть пустыми.");
        }

        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    /**
     * Поиск билетов по ID клиента и дате.
     *
     * @param clientId ID клиента.
     * @param date     Дата билета.
     * @return Коллекция найденных билетов.
     */
    public Collection<Ticket> searchTicket(int clientId, Date date) {

        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date))
                tickets.add(ticket);
        }

        return tickets;
    }

    /**
     * Покупка билета по ID клиента и номеру карты.
     *
     * @param clientId ID клиента.
     * @param cardNo   Номер карты.
     * @return true, если покупка успешна, в противном случае - false.
     */
    public boolean buyTicket(int clientId, String cardNo) {

        int orderId = database.createTicketOrder(clientId);
        if (orderId < 0) {
            throw new IllegalStateException("Неверный номер заказа.");
        }
        double amount = database.getTicketAmount();
        if (amount < 0) {
            throw new IllegalStateException("Количество билетов не может быть отрицательным");
        }

        return paymentProvider.buyTicket(orderId, cardNo, amount);

    }

    /**
     * Проверка билета по QR-коду.
     *
     * @param qrcode QR-код билета.
     * @return true, если билет успешно проверен, в противном случае - false.
     */
    public boolean checkTicket(String qrcode) {
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                return database.updateTicketStatus(ticket.getId(), false);
            }
        }
        return false;
    }

}
