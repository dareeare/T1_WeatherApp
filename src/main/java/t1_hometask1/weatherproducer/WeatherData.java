package t1_hometask1.weatherproducer;

import java.time.LocalDateTime;

public class WeatherData {
    private String city;
    private LocalDateTime timestamp;
    private int temperature;
    private String condition;

    WeatherData(String city, LocalDateTime timestamp, int temperature, String condition) {
        this.city = city;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.condition = condition;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public int getTemperature() {
        return temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
}
