package com.spring.facade.impl;

import com.spring.facade.BookingFacade;
import com.spring.model.Category;
import com.spring.model.Event;
import com.spring.model.Ticket;
import com.spring.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;

public class BookingFacadeImpl implements BookingFacade {
    @Override
    public Event getEventById(long eventId) {
        return null;
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public Event createEvent(Event event) {
        return null;
    }

    @Override
    public Event updateEvent(Event event) {
        return null;
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return false;
    }

    @Override
    public User getUserById(long userId) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUser(long userId) {
        return false;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        return null;
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


    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        int b = 0;
        int h = 0;
        try {
            String str = reader.readLine();
            if (check(str)) {
                a = Integer.parseInt(str);
            }
            else {
                String string = reader.readLine();
                a = Integer.parseInt(string);
            }
            String str1 = reader.readLine();
            if (check(str1)) {
                b = Integer.parseInt(str1);
            }
            String str2 = reader.readLine();
            if (check(str2)) {
                h = Integer.parseInt(str2);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        int fut = 0;
        int day = 0;

        if (a > 0 && b > 0 && h > 0) {
            if (a < b) {
                System.out.println("Impossible");
            }

            while (fut <= h) {
                day++;
                fut += a;
                if (fut >= h) {
                    break;
                }
                if (a == b) {
                    System.out.println("Impossible");
                    System.exit(0);
                }
                fut -= b;
            }
            System.out.println(day);
        }
    }



    public static boolean check(String str) {
        if (str.matches("\\d+")) {
            return true;
        }
        return false;
    }


}
