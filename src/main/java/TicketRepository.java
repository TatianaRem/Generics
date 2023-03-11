public class TicketRepository {

        private Ticket[] tickets = new Ticket[0];

        public void saveTickets(Ticket ticket) {
            Ticket[] tmp = new Ticket[tickets.length + 1];
            for (int i = 0; i < tickets.length; i ++) {
                tmp[i] = tickets[i];
            }
            tmp[tmp.length - 1] = ticket;
            tickets = tmp;
        }

        public void deleteById(int deleteId) {
            Ticket[] tmp = new Ticket[tickets.length - 1];
            int copyToIndex = 0;
            for (Ticket ticket : tickets) {
                if (ticket.getId() != deleteId) {
                    tmp[copyToIndex] = ticket;
                    copyToIndex++;
                }
            }
            tickets = tmp;
        }

        private Ticket findById(int id) {
            for (Ticket ticket : tickets) {
                if (ticket.getId() == id) {
                    return ticket;
                }
            }
            return null;
        }

        public Ticket[] findAll() {

            return tickets;
        }

    }
