package com.ticketingsystem.backend.ticketmanagement;

public class VendorThread implements Runnable {

    private TicketPool ticketPool;
    private int totalTicketsReleased;
    private int tReleaseRate;



    public VendorThread( TicketPool ticketPool, int totalTicketsReleased, int tReleaseRate) {
        this.ticketPool = ticketPool;
        this.totalTicketsReleased = totalTicketsReleased;
        this.tReleaseRate = tReleaseRate;

    }

    @Override
    public void run() {
        for (int i = 1; i <= totalTicketsReleased; i++ ){

            Ticket ticket = new Ticket(1, "Show","Colombo",1000, "25th of December","Musical");


            ticketPool.addTickets(ticket);
            try {
                Thread.sleep(tReleaseRate * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
