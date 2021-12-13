package com.spring.service;

import com.spring.model.Category;
import com.spring.model.Event;
import com.spring.model.Ticket;
import com.spring.model.User;
import com.spring.repository.EventRepository;
import com.spring.repository.EventRepositoryImpl;
import com.spring.repository.TicketRepository;
import com.spring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    UserRepository userRepository;


    EventRepository eventRepository;

    TicketRepository ticketRepository;


    public BookingServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Autowired
    public void setEngine(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    private Logger logger = LogManager.getLogger(BookingServiceImpl.class);


    @Override
    public Event getEventById(long eventId) {
        logger.info("logger");
        return (Event) eventRepository.findById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventRepository.getEventsByTitle(title,pageSize,pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventRepository.getEventsForDay(day,pageSize,pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.update(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventRepository.deleteById(eventId);
    }

    @Override
    public User getUserById(long userId) {
        return (User) userRepository.findById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userRepository.getByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.update(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userRepository.deleteById(userId);
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        return ticketRepository.bookTicket(userId, eventId, place, category);
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
        return ticketRepository.deleteById(ticketId);
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.update(ticket);
    }
}
