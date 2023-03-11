import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    @Test
    public void sortByIncreasingPriceSvoKzn() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        Ticket ticket1 = new Ticket(001, 1299, "SVO", "KZN", 95);
        Ticket ticket2 = new Ticket(002, 2199, "VKO", "KZN", 95);
        Ticket ticket3 = new Ticket(003, 2600, "SVO", "AER", 180);
        Ticket ticket4 = new Ticket(004, 2300, "SVO", "KZN", 95);
        Ticket ticket5 = new Ticket(005, 2000, "SVO", "KZN", 95);
        Ticket ticket6 = new Ticket(006, 1900, "SVO", "AER", 180);
        Ticket ticket7 = new Ticket(007, 1900, "SVO", "KZN", 95);
        Ticket ticket8 = new Ticket(100, 2600, "SVO", "AER", 180);



        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1, ticket7, ticket5, ticket4};
        Ticket[] actual = manager.findAll("SVO", "KZN");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void sortByIncreasingWithTheSamePrice() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        Ticket ticket1 = new Ticket(001, 1299, "SVO", "KZN", 95);
        Ticket ticket2 = new Ticket(002, 2199, "VKO", "KZN", 95);
        Ticket ticket3 = new Ticket(003, 2600, "SVO", "AER", 180);
        Ticket ticket4 = new Ticket(004, 2300, "SVO", "KZN", 95);
        Ticket ticket5 = new Ticket(005, 2000, "SVO", "KZN", 95);
        Ticket ticket6 = new Ticket(006, 1900, "SVO", "AER", 180);
        Ticket ticket7 = new Ticket(007, 1900, "SVO", "KZN", 95);
        Ticket ticket8 = new Ticket(100, 2600, "SVO", "AER", 180);



        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket6, ticket3, ticket8};
        Ticket[] actual = manager.findAll("SVO", "AER");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void sortByIncreasingWithSingleTicket() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        Ticket ticket1 = new Ticket(001, 1299, "SVO", "KZN", 95);
        Ticket ticket2 = new Ticket(002, 2199, "VKO", "KZN", 95);
        Ticket ticket3 = new Ticket(003, 2600, "SVO", "AER", 180);
        Ticket ticket4 = new Ticket(004, 2300, "SVO", "KZN", 95);
        Ticket ticket5 = new Ticket(005, 2000, "SVO", "KZN", 95);
        Ticket ticket6 = new Ticket(006, 1900, "SVO", "AER", 180);
        Ticket ticket7 = new Ticket(007, 1900, "SVO", "KZN", 95);
        Ticket ticket8 = new Ticket(100, 2600, "SVO", "AER", 180);



        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.findAll("VKO", "KZN");

        Assertions.assertArrayEquals(expected, actual);

    }
}
