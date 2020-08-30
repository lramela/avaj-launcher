package com.oop.craft;

import com.oop.interfaces.Coordinates;
import com.oop.interfaces.Flyable;

public abstract class AircraftFactory {


    public static Flyable newAircraft(final String type, final String name, final int longitude, final int latitude, final int height) {

        final Coordinates coordinates = new Coordinates(longitude, latitude, height);

        Flyable flyable;

        switch (type.toLowerCase()) {
            case "baloon":
                flyable = new Baloon(name, coordinates);
                return flyable;
            case "jetplane":
                flyable = new JetPlane(name, coordinates);
                return flyable;
            case "helicopter":
                flyable = new Helicopter(name, coordinates);
                return flyable;
            default:
                System.out.println("Incorrect aircraft input!");
                System.exit(1);
        }
        return null;
    }
}
