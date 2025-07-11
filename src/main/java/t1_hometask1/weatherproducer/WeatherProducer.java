package t1_hometask1.weatherproducer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class WeatherProducer {

    private final KafkaTemplate<String, WeatherData> kafkaTemplate;
    private final Random random = new Random();
    private static final List<String> CITIES = Arrays.asList("Minsk", "Grodno", "Gomel", "Vitebsk", "Mogilev", "Brest");
    private static final List<String> CONDITIONS = Arrays.asList("Sunny", "Rainy", "Windy", "Cloudy", "Overcast", "Rainstorm");

    @Scheduled(fixedRate = 2000) // Every 2 seconds
    public void generateWeatherData() {
        String city = CITIES.get(random.nextInt(CITIES.size()));
        WeatherData weatherData = new WeatherData(
                city,
                LocalDateTime.now(),
                random.nextInt(36), // 0-35°C
                CONDITIONS.get(random.nextInt(CONDITIONS.size()))
        );

        kafkaTemplate.send("weather-topic", city, weatherData);
        System.out.println("Produced weather data: " + weatherData);
    }
}
