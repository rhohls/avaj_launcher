package Vehicle;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {


        //Longitude
        if (longitude < 0)
            this.longitude = 0;
        else
            this.longitude = longitude;

        //Latitude
        if (latitude < 0)
            this.latitude = 0;
        else
            this.latitude = latitude;

        //Height
        if (height > 100)
            this.height = 100;
        else if (height < 0)
            this.height = 0;
        else
            this.height = height;
    }

    public int getLongitude()
    {
        return (longitude);
    }
    public int getLatitude()
    {
        return (latitude);
    }
    public int getHeight()
    {
        return (height);
    }
}
