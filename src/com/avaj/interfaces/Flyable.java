package com.avaj.interfaces;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
    String getDescription();
}
