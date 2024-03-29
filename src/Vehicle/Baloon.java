package Vehicle;

import Helper.Logger;
import Simulation.WeatherTower;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() throws Exception{
        String newWeather = weatherTower.getWeather(coordinates);

        switch (newWeather){
            case "SUN":
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 2,
                        coordinates.getLatitude(),
                        coordinates.getHeight() + 4);
                Logger.log(getInfo() + "look how sunny it is.");
                break;

            case "RAIN":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 5);
                Logger.log(getInfo() + "it's super rainy.");
                break;

            case "FOG":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 3);
                Logger.log(getInfo() + "look how foggy it is.");
                break;

            case "SNOW":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 15);
                Logger.log(getInfo() + "it's super snowy here");
                break;

            default:
                throw new Exception("Weather \"" + newWeather + "\" does not exist");
        }

        if (coordinates.getHeight() <= 0)
        {
            weatherTower.unregister(this);
            Logger.log(getInfo() + "landed and deregistered from tower.");
            Logger.log("\tHeight: " + coordinates.getHeight() + " Latitude: " + coordinates.getLatitude() +  " Longitude: " + coordinates.getLongitude());
        }

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Logger.log(getInfo() + "registered to tower.");
    }

    private String getInfo(){
        return ("Baloon " + name + " (" + id + "): ");
    }
}
