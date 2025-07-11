package t1_hometask1.weatherproducer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class WeatherConsumer {

    @KafkaListener(topics = "weather-topic", groupId = "weather-group")
    public void consume(WeatherData weatherData) {
        System.out.println("Consumed weather data: " + weatherData);

        if (weatherData.getCondition().equals("Rainy")) {
            System.out.println("ALERT: Rain detected in " + weatherData.getCity());
        }
    }
}
