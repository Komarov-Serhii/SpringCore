package com.spring.facade.impl;

import com.spring.facade.BookingFacade;
import com.spring.model.Category;
import com.spring.model.Event;
import com.spring.model.Ticket;
import com.spring.model.User;
import com.spring.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingFacadeImpl implements BookingFacade {

    @Autowired
    BookingService bookingService;


    @Override
    public Event getEventById(long eventId) {
        return bookingService.getEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return bookingService.getEventsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return bookingService.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return bookingService.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return bookingService.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return bookingService.deleteEvent(eventId);
    }





    @Override
    public User getUserById(long userId) {
        return bookingService.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return bookingService.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return bookingService.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        return bookingService.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return bookingService.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return bookingService.deleteUser(userId);
    }



    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        return bookingService.bookTicket(userId,eventId,place,category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return false;
    }

}
