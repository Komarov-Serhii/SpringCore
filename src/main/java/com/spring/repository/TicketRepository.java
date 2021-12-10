package com.spring.repository;

import com.spring.model.Category;
import com.spring.model.Event;
import com.spring.model.Ticket;
import com.spring.model.User;

import java.util.List;

public interface TicketRepository extends EntityRepository<Long, Ticket> {


    public Ticket bookTicket(long userId, long eventId, int place, Category category);


    List<Ticket> getBookedTickets(User user, int pageSize, int pageNum);


    List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum);
}
