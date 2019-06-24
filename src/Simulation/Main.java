package Simulation;

import Helper.Logger;
import Vehicle.Aircraft;
import Vehicle.AircraftFactory;
import Vehicle.Flyable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        int numWeatherChange;
        String fileLocation = "scenario.txt";

        //create new sim file
        try {
            FileWriter fw = new FileWriter("simulation.txt");
            fw.write("");
            fw.close();
        }
        catch(Exception e){
            System.out.println(e);
            exit(1);
        }


/*
        String fileLocation = System.getProperty("user.dir");
        System.out.println(fileLocation);
*/


        String line = null;
        BufferedReader reader = null;

        // Open file
        try {
            reader = new BufferedReader(new FileReader(fileLocation));
            line = reader.readLine();

            numWeatherChange = Integer.parseInt(line);


        } catch (IOException e) {
            System.out.println("There was an error with reading the file");
//            e.printStackTrace();
            return;
        }
        catch (NumberFormatException e){
            System.out.println("There was an error converting the number");

            return;
        }
        catch (Exception e){
            System.out.println("There was an error:");
            e.printStackTrace();
            return;
        }


        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory aircraftFactory = new AircraftFactory();
        Flyable object;

        //read rest of lines
        try {

            line = reader.readLine();
            while (line != null) {

                String [] splitted = line.split(" ");

                if (splitted.length != 5)
                    throw new Exception("Bad ordered line");

//                System.out.println(Arrays.toString("read and split " + splitted));

                object = aircraftFactory.newAircraft(splitted[0], splitted[1],
                        Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]), Integer.parseInt(splitted[4]));

                object.registerTower(weatherTower);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("There was an error creating the flying objects. It was:");
            e.printStackTrace();
            return;
        }

        // Run weather
        try {
            for (int i = 1; i <= numWeatherChange; i++) {
//            System.out.println(i);
//            Logger.Log(i + "");
                weatherTower.changeWeather();
            }
        } catch (Exception e) {
            System.out.println("There was an changing weather it was:");
            e.printStackTrace();
            return;
        }

    }
}
