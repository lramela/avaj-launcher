package com.avaj.interfaces;

import com.avaj.interfaces.Coordinates;
import com.avaj.interfaces.Tower;
import com.avaj.interfaces.WeatherProvider;

public class WeatherTower  extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather()
    {
        this.conditionsChanged();
    }
}
