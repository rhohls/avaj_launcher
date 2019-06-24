package Vehicle;

import Helper.Logger;
import Simulation.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() throws Exception{
        String newWeather = weatherTower.getWeather(coordinates);

        switch (newWeather){
            case "SUN":
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 10,
                        coordinates.getLatitude(),
                        coordinates.getHeight() + 2);
                Logger.log(getInfo() + "is warming up in the sun");
                break;

            case "RAIN":
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 5,
                        coordinates.getLatitude(),
                        coordinates.getHeight() );
                Logger.log(getInfo() + "gets pelted by rain.");
                break;

            case "FOG":
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 1,
                        coordinates.getLatitude(),
                        coordinates.getHeight());
                Logger.log(getInfo() + "is shrouded in fog.");
                break;

            case "SNOW":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 12);
                Logger.log(getInfo() + "Look at all this white");
                break;

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
        return ("Helicopter " + name + " (" + id + "): ");
    }
}
