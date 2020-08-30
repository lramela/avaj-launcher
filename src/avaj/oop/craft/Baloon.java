package avaj.oop.craft;

import avaj.oop.interfaces.Coordinates;
import avaj.oop.interfaces.Logger;
import avaj.oop.interfaces.WeatherTower;
import avaj.oop.interfaces.Flyable;


import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);

    }

    public void updateConditions() {
        HashMap<String, String> map = new HashMap<>();
        map.put("SUN", "What sunshine is to flowers, smiles are to humanity.");
        map.put("FOG", "Fog is not mysterious, fog is the mystery itself!.");
        map.put("SNOW", "When snow falls,nature listen.");
        map.put("RAIN", "Into each life some rain must fall.");


        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(),
                    Math.min(coordinates.getHeight() + 4, 100));
        }
        if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    Math.max(coordinates.getHeight() - 5, 0));
        }
        if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    Math.max(coordinates.getHeight() - 3, 0));
        }
        if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    Math.max(coordinates.getHeight() - 15, 0));
        }
        if (coordinates.getHeight() == 0) {
            Logger.addMessage("Baloon# " + this.name + this.id + " landing.");
            this.weatherTower.unregister((Flyable) this);
        }

        Logger.addMessage("Baloon#" + this.name + "(" + this.id + "): " + map.get(weather));
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.addMessage("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }

    @Override
    public String getDescription() {
        return null;
    }
}
