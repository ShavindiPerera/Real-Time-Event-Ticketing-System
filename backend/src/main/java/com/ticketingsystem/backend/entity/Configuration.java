/*package com.ticketingsystem.backend.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Configuration_Details")
public class Configuration {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 10)
    private int id;

    @Column(name = "total_tickets", nullable = false)
    private int totalTickets;

    @Column(name = "tickets_release_rate", nullable = false)
    private int ticketReleaseRate;

    @Column(name = "customer_retrieval_rate", nullable = false)
    private int customerRetrievalRate;

    @Column(name = "max_ticket_capacity", nullable = false)
    private int maxTicketCapacity;

    public Configuration() {

    }

    public Configuration(int id,int totalTickets,  int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.id = id;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public static int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public static int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public static int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }
}*/

package com.ticketingsystem.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Configuration_Details")
public class Configuration {

    @Id
    @Column(name = "id", length = 10)
    private Long id;

    @Column(name = "total_tickets", nullable = false)
    private int totalTickets;

    @Column(name = "tickets_release_rate", nullable = false)
    private int ticketReleaseRate;

    @Column(name = "customer_retrieval_rate", nullable = false)
    private int customerRetrievalRate;

    @Column(name = "max_ticket_capacity", nullable = false)
    private int maxTicketCapacity;

    public Configuration() {
    }

    public Configuration(Long id, int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.id = id;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }
}

