package com.oop.interfaces;

public class WeatherProvider {

    private static String weather[] = {"RAIN" , "FOG" , "SUN" , "SNOW"};
    private static WeatherProvider weatherProvider = new WeatherProvider();

    private WeatherProvider() {
        weatherProvider = this;
    }

    public static WeatherProvider getProvider() {
        weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather (Coordinates coordinates) {
        int value = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();

        return weather[value % 4];
    }

}
