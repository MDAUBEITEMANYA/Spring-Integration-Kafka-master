import com.sample.spring.itegration.kafka.configuration.consumer.ConsumingChannelConfig;
import com.sample.spring.itegration.kafka.configuration.producer.PracticalAdvice;
import com.sample.spring.itegration.kafka.configuration.producer.ProducingChannelConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@SpringBootApplication
@Import({ProducingChannelConfig.class, ConsumingChannelConfig.class})
@ComponentScan(basePackages = {"com.sample.spring.itegration.kafka.configuration"})

public class Application implements CommandLineRunner {

  public static Logger logger = LoggerFactory.getLogger(Application.class);
  private final CountDownLatch latch = new CountDownLatch(10);

  @Autowired
  private KafkaTemplate<String, Object> template;
  private final int messagesPerRequest = 8;

  @Value("${kafka.topic.test1}")
  private String testTopic;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {
    IntStream.range(0, messagesPerRequest)
            .forEach(i -> this.template.send(testTopic, String.valueOf(i),
                    new PracticalAdvice("A Practical Advice", i))
            );
    latch.await(1, TimeUnit.SECONDS);
    logger.info("All messages received");
    while (true){}
  }
}
