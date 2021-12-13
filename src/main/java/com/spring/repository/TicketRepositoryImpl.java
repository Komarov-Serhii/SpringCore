package com.spring.repository;

import com.spring.model.Category;
import com.spring.model.Event;
import com.spring.model.Ticket;
import com.spring.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
     //   Ticket ticket = (Ticket) sessionFactory.getCurrentSession().save(saveTicket(userId,eventId,place,category));
//       Ticket ticket = (Ticket) sessionFactory.getCurrentSession().createQuery("INSERT INTO Ticket (userId,eventId,place,category)"
//               + "SELECT "+userId+", "+eventId+", "+place+", "+category);

       Ticket ticket = (Ticket) sessionFactory.getCurrentSession().createQuery("insert into Ticket (userId, eventId,place,category) select userId=:userId, firstName,lastName,age,education from Applicant");
        return ticket;
 //"INSERT INTO Ticket (userId,eventId,place,category) " +
        //                "SELECT userId, eventId, place, category from Ticket "


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

    private Ticket saveTicket(long userId, long eventId, int place, Category category) {
        User user = (User) userRepository.findById(userId);
        Event event = (Event) eventRepository.findById(eventId);

        return Ticket.builder()
                .userId(user)
                .eventId(event)
                .place(place)
                .category(category)
                .build();
    }

    @Override
    public Object findById(Long id) {
        return sessionFactory.getCurrentSession().get(Ticket.class, id);
    }

    @Override
    public List<Ticket> findAll() {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);
        Root<Ticket> rootEntry = cq.from(Ticket.class);
        CriteriaQuery<Ticket> all = cq.select(rootEntry);

        TypedQuery<Ticket> allQuery = sessionFactory.getCurrentSession().createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Ticket update(Ticket entity) {
        Ticket ticket = sessionFactory.getCurrentSession().get(Ticket.class, entity.getId());
        ticket.setCategory(entity.getCategory());
        ticket.setPlace(entity.getPlace());
        sessionFactory.getCurrentSession().merge(ticket);
        return ticket;
    }

    @Override
    public boolean deleteById(Long id) {
        Ticket ticket = sessionFactory.getCurrentSession().load(Ticket.class,id);
        sessionFactory.getCurrentSession().delete(ticket);
        sessionFactory.getCurrentSession().flush() ;
        return true;
    }

    @Override
    public Ticket save(Ticket entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }
}
