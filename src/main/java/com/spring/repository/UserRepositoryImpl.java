package com.spring.repository;

import com.spring.model.Event;
import com.spring.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Object findById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User getByEmail(String email) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User u where u.email=:email")
                .setParameter("email", email).uniqueResult();
    }

    @Override
    public List<User> getByName(String name, int pageSize, int pageNum) {
        return (List<User>) sessionFactory.getCurrentSession().createQuery("from User u where u.name=:name")
                .setParameter("name", name).list();
    }

    @Override
    public List<User> findAll() {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);

        TypedQuery<User> allQuery = sessionFactory.getCurrentSession().createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public User update(User entity) {
        User user = sessionFactory.getCurrentSession().get(User.class, entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        sessionFactory.getCurrentSession().merge(user);
        return user;
    }

    @Override
    public boolean deleteById(Long id) {
        User user = sessionFactory.getCurrentSession().load(User.class,id);
        sessionFactory.getCurrentSession().delete(user);
        sessionFactory.getCurrentSession().flush() ;
        return true;
    }

    @Override
    public User save(User entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }
}