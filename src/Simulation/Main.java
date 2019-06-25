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
        //create new output file
        CreateNewFile();

        if (args.length != 1) {
            System.out.println("Please input 1 text file");
            exit(0);
        }


        String line = null;
        BufferedReader reader = null;

        String fileLocation = args[0];
        int numWeatherChange;
        // Open file
        try {
            reader = new BufferedReader(new FileReader(fileLocation));
            line = reader.readLine();

            numWeatherChange = Integer.parseInt(line);
            if (numWeatherChange <= 0)
                throw new NumberFormatException("Only positive intergers acceptable");


        } catch (IOException e) {
            System.out.println("There was an error with reading the file:");
            System.out.println(e.getMessage());
            return;
        }
        catch (NumberFormatException e){
            System.out.println("There was an error converting the number of weather changes:");
            System.out.println(e.getMessage());
            return;
        }
        catch (Exception e){
            System.out.println("There was an error:");
            System.out.println(e.getMessage());
            return;
        }


        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory aircraftFactory = new AircraftFactory();
        Flyable object;

        int i = 2;
        //read rest of lines
        try {
            line = reader.readLine();
            while (line != null) {
                String [] splitted = line.split(" ");

                if (splitted.length != 5)
                    throw new Exception("Bad ordered line");

                object = aircraftFactory.newAircraft(splitted[0], splitted[1],
                        Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]), Integer.parseInt(splitted[4]));

                object.registerTower(weatherTower);
                line = reader.readLine();
                i++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("There was an error creating the flying objects. On line " + i);
            System.out.println(e.getMessage());
            return;
        }

        // Run weather
        try {
            for (i = 1; i <= numWeatherChange; i++) {
                weatherTower.changeWeather();
            }
        } catch (Exception e) {
            System.out.println("There was an changing weather it was:");
            System.out.println(e.getMessage());
            return;
        }
    }

    private static void CreateNewFile(){
        //create new output file
        try {
            FileWriter fw = new FileWriter("simulation.txt");
            fw.write("");
            fw.close();
        }
        catch(Exception e){
            System.out.println("There was an error creating the output file:");
            System.out.println(e.getMessage());
            exit(1);
        }
    }
}
