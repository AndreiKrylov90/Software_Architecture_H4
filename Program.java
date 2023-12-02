import java.util.Collection;
import java.util.Date;

// Переработать один из модулей ( на выбор TicketProvider, CustomerProvider) в рамках комплекса "Покупка онлайн билетов на автобус в час пик" 
// с точки зрения контрактного программирования.

public class Program {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус
     * в час пик".
     * 
     * @param args
     */
    public static void main(String[] args) {

        Core core = new Core();
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        BusStation busStation = new BusStation(core.getTicketProvider());

        System.out.println("Базовые клиенты, которые уже были при начале вызова программы");
        System.out.println(core.getCustomerProvider().database.getCustomers());


        // Создается новый заказ через мобильное приложение
        mobileApp.buyTicket("1000000000001");

        System.out.println("Новый реестр клиентов");
        System.out.println(core.getCustomerProvider().database.getCustomers());

        mobileApp.searchTicket(new Date());
        Collection<Ticket> tickets = mobileApp.getTickets();

        busStation.checkTicket("AAA");


        

    }

}
