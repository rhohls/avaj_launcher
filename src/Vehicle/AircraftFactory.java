package Vehicle;

public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        if (longitude < 0 || latitude < 0 || height <= 0) {
            throw new IllegalArgumentException("Aircraft parameters are incorrect");
        }
        Coordinates coords = new Coordinates(longitude, latitude, height);

        switch (type)
        {
            case "Baloon":
                return new Baloon(name, coords);
            case "Helicopter":
                return new Helicopter(name, coords);
            case "JetPlane":
                return new JetPlane(name, coords);
            default:
                throw new IllegalArgumentException("Aircraft type does not exist");
        }
    }
}
