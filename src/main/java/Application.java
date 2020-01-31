import com.kafka.configuration.consumer.ConsumingChannelConfig;
import com.kafka.configuration.producer.ProducingChannelConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import({ProducingChannelConfig.class, ConsumingChannelConfig.class})
@ComponentScan(basePackages = {"com.kafka.configuration"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
