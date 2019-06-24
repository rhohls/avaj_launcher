package Simulation;

import Vehicle.Coordinates;

public class WeatherTower extends Tower {


    public String getWeather(Coordinates coordinates) throws Exception
    {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    void changeWeather() throws Exception {
        conditionsChanged();
    }
}
