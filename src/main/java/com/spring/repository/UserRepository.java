package com.spring.repository;

import com.spring.model.Event;
import com.spring.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends EntityRepository<Long, User> {

    public User getByEmail(String email);

    public List<User> getByName(String name, int pageSize, int pageNum);

}
