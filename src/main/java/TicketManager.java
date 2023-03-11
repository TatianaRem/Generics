import java.util.Arrays;

public class TicketManager {

        private TicketRepository repository;

        public TicketManager(TicketRepository repository) {

            this.repository = repository;
        }

        public void add(Ticket ticket) {

            repository.saveTickets(ticket);
        }

        public Ticket[] findAll(String departureAirport, String arrivalAirport) {
            Ticket[] result = new Ticket[0];
            for (Ticket ticket : repository.findAll()) {
                if (matches(ticket, departureAirport, arrivalAirport)) {
                    Ticket[] tmp = new Ticket[result.length + 1];
                    for (int i = 0; i < result.length; i++) {
                        tmp[i] = result[i];
                    }
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;
                }
            }
            Arrays.sort(result);
            return result;
        }

        public boolean matches(Ticket ticket, String departureAirport, String arrivalAirport) {

            for (Ticket currentTicket : repository.findAll()) {
                if (ticket.getDepartureAirport().equals(departureAirport)) {
                    if (ticket.getArrivalAirport().equals(arrivalAirport)) {
                        return true;
                    }
                }
            }
            return false;
    }
}
