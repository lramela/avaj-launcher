package avaj.oop.interfaces;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
    String getDescription();
}
