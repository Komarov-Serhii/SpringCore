package com.spring.repository;

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
import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public class EventRepositoryImpl implements EventRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object findById(Long id) {
        return sessionFactory.getCurrentSession().get(Event.class, id);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return (List<Event>) sessionFactory.getCurrentSession().createQuery("from Event e where e.title=:title")
                .setParameter("title", title).list();
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return (List<Event>) sessionFactory.getCurrentSession().createQuery("from Event d where d.date=:date")
                .setParameter("day", day).list();
    }

    @Override
    public List<Event> findAll() {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Event> cq = cb.createQuery(Event.class);
        Root<Event> rootEntry = cq.from(Event.class);
        CriteriaQuery<Event> all = cq.select(rootEntry);

        TypedQuery<Event> allQuery = sessionFactory.getCurrentSession().createQuery(all);
        return allQuery.getResultList();
    }
    @Override
    public Event update(Event entity) {
        Event event = sessionFactory.getCurrentSession().get(Event.class, entity.getId());
        event.setDate(entity.getDate());
        event.setTitle(entity.getTitle());
        sessionFactory.getCurrentSession().merge(event);
        return event;
    }

    @Override
    public boolean deleteById(Long id) {
        Event event = sessionFactory.getCurrentSession().load(Event.class,id);
        sessionFactory.getCurrentSession().delete(event);
        sessionFactory.getCurrentSession().flush() ;
        return true;
    }

    @Override
    public Event save(Event entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }
}
