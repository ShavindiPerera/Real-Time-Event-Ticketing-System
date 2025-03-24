/*package com.ticketingsystem.backend.ticketmanagement;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;



public class TicketPool {
    private ConcurrentLinkedQueue<Ticket> ticketQueue;
    private int maximumCapacity;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public TicketPool(int saveConfigurationDTO) {
        this.maximumCapacity = maximumCapacity;
        this.ticketQueue = new ConcurrentLinkedQueue<>();
    }

    public void addTickets(Ticket ticket) {
        lock.lock();
        try {
            while (ticketQueue.size() >= maximumCapacity) {
                notFull.await(); // Wait until space is available
            }

            ticketQueue.add(ticket);
            System.out.println(Thread.currentThread().getName() + " released a ticket. Currently available tickets: " + ticketQueue.size());
            notEmpty.signalAll(); // Notify threads waiting for a ticket
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
            throw new RuntimeException(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public Ticket removeTicket() {
        lock.lock();
        try {
            while (ticketQueue.isEmpty()) {
                notEmpty.await(); // Wait until a ticket is available
            }

            Ticket ticket = ticketQueue.poll();
            System.out.println(Thread.currentThread().getName() + " has bought a ticket. Currently available tickets: " + ticketQueue.size());
            notFull.signalAll(); // Notify threads waiting for space
            return ticket;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
            throw new RuntimeException(e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}*/

package com.ticketingsystem.backend.ticketmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TicketPool {
    private static final Logger logger = LoggerFactory.getLogger(TicketPool.class);

    private final ConcurrentLinkedQueue<Ticket> ticketQueue;
    private final int maximumCapacity;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public TicketPool(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.ticketQueue = new ConcurrentLinkedQueue<>();
    }

    public void addTickets(Ticket ticket) {
        lock.lock();
        try {
            while (ticketQueue.size() >= maximumCapacity) {
                notFull.await(); // Wait until space is available
            }

            ticketQueue.add(ticket);
            logger.info("{} released a ticket. Available tickets: {}",
                    Thread.currentThread().getName(), ticketQueue.size());
            notEmpty.signalAll(); // Notify threads waiting for a ticket
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
            logger.error("Thread interrupted while adding tickets: {}", e.getMessage());
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public Ticket removeTicket() {
        lock.lock();
        try {
            while (ticketQueue.isEmpty()) {
                notEmpty.await(); // Wait until a ticket is available
            }

            Ticket ticket = ticketQueue.poll();
            logger.info("{} bought a ticket. Available tickets: {}",
                    Thread.currentThread().getName(), ticketQueue.size());
            notFull.signalAll(); // Notify threads waiting for space
            return ticket;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread interrupted while removing tickets: {}", e.getMessage());
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}

