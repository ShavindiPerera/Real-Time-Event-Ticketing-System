package com.ticketingsystem.backend.ticketmanagement;

public class CustomerThread implements Runnable {
    private TicketPool ticketPool;
    private int cRetrievalRate;
    private int quantity;

    public CustomerThread(TicketPool ticketPool, int cRetrievalRate, int quantity) {
        this.ticketPool = ticketPool;
        this.cRetrievalRate = cRetrievalRate;
        this.quantity = quantity;
    }




    @Override
    public void run() {
        for (int i = 1; i < quantity; i++) {
            Ticket ticket = ticketPool.removeTicket();

            try {
                Thread.sleep(cRetrievalRate * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
