package Helper;

import java.io.FileWriter;

import static java.lang.System.exit;

public class Logger {
    public static void log(String info){
        try {
            FileWriter fw = new FileWriter("simulation.txt", true);
            fw.write(info);
            fw.write("\n");
            fw.close();
        }
        catch(Exception e){
            System.out.println(e);
            exit(1);
        }
    }
}
