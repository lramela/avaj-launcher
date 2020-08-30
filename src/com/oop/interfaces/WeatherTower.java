package com.oop.interfaces;

import com.oop.interfaces.Coordinates;
import com.oop.interfaces.Tower;
import com.oop.interfaces.WeatherProvider;

public class WeatherTower  extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather()
    {
        this.conditionsChanged();
    }
}
