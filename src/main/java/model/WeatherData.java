package model;



import java.sql.Timestamp;

public class WeatherData {
    private int locationId;
    private double temperature;
    private double humidity;
    private double windSpeed;
    private String condition;
    private Timestamp observationTime;
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Timestamp getObservationTime() {
		return observationTime;
	}
	public void setObservationTime(Timestamp observationTime) {
		this.observationTime = observationTime;
	}

    // getters and setters
    
}

