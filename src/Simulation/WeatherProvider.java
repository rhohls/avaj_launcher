package Simulation;

import Vehicle.Coordinates;

import java.util.Random;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) throws Exception {

        int sum = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        int rand = sum % weather.length;

//        Random gen = new Random(sum);
//        int rand = gen.nextInt(weather.length);
//        System.out.println("rand " + rand);

        return weather[rand];
    }
}
