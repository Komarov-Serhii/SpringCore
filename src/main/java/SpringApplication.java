import com.spring.config.HibernateConfig;
import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring")
public class SpringApplication {
    @SneakyThrows
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringApplication.class);
        context.register(HibernateConfig.class);
        context.refresh();
    }
}
