package com.spring.repository;

import com.spring.model.Category;
import com.spring.model.Event;
import com.spring.model.Ticket;
import com.spring.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class TicketRepositoryImpl implements TicketRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        //  Ticket ticket = saveTicket(userId, eventId,place, category);
        //Ticket ticket = (Ticket) sessionFactory.getCurrentSession().save(saveTicket(userId,eventId,place,category));
//       Ticket ticket = (Ticket) sessionFactory.getCurrentSession().createQuery("INSERT INTO Ticket (userId,eventId,place,category)"
//               + "SELECT "+userId+", "+eventId+", "+place+", "+category);
        return (Ticket) sessionFactory.getCurrentSession().createQuery("INSERT INTO Ticket (userId,eventId,place,category) " +
                "SELECT userId, eventId, place, category from Ticket ").uniqueResult();



        //return (Ticket) sessionFactory.getCurrentSession().save(ticket);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return null;
    }
    //return (UserPlans) sessionFactory.getCurrentSession().createQuery("from UserPlans e where e.tariff.id=:tariffId and  e.user.id=:userId")
    //           .setParameter("tariffId", tariffId).setParameter("userId", userId).uniqueResult();

//    private Ticket saveTicket(long userId, long eventId, int place, Category category) {
//        User user = (User) userRepository.findById(userId);
//        Event event = (Event) eventRepository.findById(eventId);
//
//        return Ticket.builder()
//                .userId(user)
//                .eventId(event)
//                .place(place)
//                .category(category)
//                .build();
//    }

    @Override
    public Object findById(Long id) {
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }

    @Override
    public Ticket update(Ticket entity) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public Ticket save(Ticket entity) {
        return null;
    }
}
