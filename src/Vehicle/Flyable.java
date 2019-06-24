package Vehicle;

import Simulation.WeatherTower;

public interface Flyable {
    public void updateConditions() throws Exception;
    public void registerTower(WeatherTower WeatherTower);

}
