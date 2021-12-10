package com.spring.repository;

import com.spring.model.Event;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public class EventRepositoryImpl implements EventRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object findById(Long id) {
        return null;
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
        return null;
    }

    @Override
    public Event update(Event entity) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public Event save(Event entity) {
        return null;
    }
}
