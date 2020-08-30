package avaj.oop.craft;

import avaj.oop.interfaces.Coordinates;
import avaj.oop.interfaces.Logger;

import avaj.oop.interfaces.WeatherTower;
import avaj.oop.interfaces.Flyable;

import java.util.HashMap;


    public class JetPlane extends Aircraft implements Flyable {

        private WeatherTower weatherTower;

        JetPlane(String name, Coordinates coordinates) {
            super(name, coordinates);
        }

        public void updateConditions() {
            HashMap<String, String> map = new HashMap<>();
            map.put("SUN", "Even for me life had its gleams of sunshine.");
            map.put("FOG", "And ambience is important - no fog machines.");
            map.put("SNOW", "With every falling flake, a unique spark of interest falls from heaven");
            map.put("RAIN", "Some people feel the rain.Others just get wet");


            String weather = weatherTower.getWeather(this.coordinates);

            if (weather.equals("SUN")) {
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10,
                        Math.min(coordinates.getHeight() + 2, 100));
            }
            if (weather.equals("RAIN")) {
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5,
                        coordinates.getHeight());
            }
            if (weather.equals("FOG")) {
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1,
                        coordinates.getHeight());
            }
            if (weather.equals("SNOW")) {
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        Math.min(coordinates.getHeight() + 7, 100));
            }
            if (coordinates.getHeight() == 0) {
                Logger.addMessage("JetPlane# " + this.name + this.id + " landing.");
                this.weatherTower.unregister(this);
            }

            Logger.addMessage("JetPlane#" + this.name + "(" + this.id + "): " + map.get(weather));
        }

        public void registerTower(WeatherTower weatherTower) {
            this.weatherTower = weatherTower;
            this.weatherTower.register(this);
            Logger.addMessage("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
        }

        @Override
        public String getDescription() {
            return null;
        }
    }

