package com.spring.repository;

import com.spring.model.Event;
import com.spring.model.User;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends EntityRepository<Long, Event> {

    List<Event> getEventsByTitle(String title, int pageSize, int pageNum);

    List<Event> getEventsForDay(Date day, int pageSize, int pageNum);
}
