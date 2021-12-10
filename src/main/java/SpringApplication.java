import com.spring.config.HibernateConfig;
import com.spring.facade.BookingFacade;
import com.spring.facade.impl.BookingFacadeImpl;
import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;

import static com.spring.model.Category.PREMIUM;

@Configuration
@ComponentScan("com.spring")
public class SpringApplication {
    @SneakyThrows
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringApplication.class);
        context.register(HibernateConfig.class);
        context.refresh();
        BookingFacade bookingFacade = context.getBean(BookingFacadeImpl.class);
       // System.out.println(bookingFacade.getUserByEmail("basket779@gmail.com"));
       // System.out.println(bookingFacade.getEventsByTitle("Teambuilding",10,26));
       // System.out.println(bookingFacade.getEventsForDay(Date.valueOf("2021-12-09 23:38:13.000000"),10,26));
       System.out.println(bookingFacade.bookTicket(1, 1, 20,PREMIUM));

    }
}
