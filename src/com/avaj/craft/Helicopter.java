package com.avaj.craft;

import com.avaj.interfaces.Coordinates;
import com.avaj.interfaces.Logger;
import com.avaj.interfaces.WeatherTower;
import com.avaj.interfaces.Flyable;

import java.util.HashMap;



    public class Helicopter extends Aircraft implements Flyable {

        private WeatherTower weatherTower;

        Helicopter(String name, Coordinates coordinates) {
            super(name, coordinates);
        }

        public void updateConditions() {
            HashMap<String, String> map = new HashMap<>();
            map.put("SUN", "keep your face to the sun and you will never see the shadows.");
            map.put("FOG", "Its impossible to know what happens in the fog of war.");
            map.put("SNOW", "How about some snowball war ...");
            map.put("RAIN", "Kissing in the rain!");


            String weather = weatherTower.getWeather(this.coordinates);

            if (weather.equals("SUN")) {
                this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(),
                        Math.min(coordinates.getHeight() + 2, 100));
            }
            if (weather.equals("RAIN")) {
                this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(),
                        coordinates.getHeight());
            }
            if (weather.equals("FOG")) {
                this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(),
                        coordinates.getHeight());
            }
            if (weather.equals("SNOW")) {
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        Math.max(coordinates.getHeight() - 12, 0));
            }
            if (coordinates.getHeight() == 0) {
                Logger.addMessage("Helicopter# " + this.name + this.id + " landing.");
                this.weatherTower.unregister(this);
            }

            Logger.addMessage("Helicopter#" + this.name + "(" + this.id + "): " + map.get(weather));
        }

        public void registerTower(WeatherTower weatherTower) {
            this.weatherTower = weatherTower;
            this.weatherTower.register(this);
            Logger.addMessage("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
        }

        public String getDescription() {
            return null;
        }

        public void unregisterTower() {
            this.weatherTower.unregister(this);
        }
    }

