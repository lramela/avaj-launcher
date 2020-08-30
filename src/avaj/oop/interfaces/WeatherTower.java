package avaj.oop.interfaces;

import avaj.oop.interfaces.Coordinates;
import avaj.oop.interfaces.Tower;
import avaj.oop.interfaces.WeatherProvider;

public class WeatherTower  extends Tower {
    public String getWeather(final Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather()
    {
        this.conditionsChanged();
    }
}
