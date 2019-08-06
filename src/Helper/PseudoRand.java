package Helper;

import java.util.Arrays;
import java.util.Random;

public class PseudoRand {
    int[] store;
    int range;
    int size;

    // range is throw strict the number generator is
    // n = number may occur n times before being repeated
    public PseudoRand(int size, int range){
        this.size = size;
        store = new int[size];
        this.range = range;
    }


    public int RandInt() throws Exception {
        Random gen = new Random();

        int rand = -1;
        int max = Arrays.stream(store).max().getAsInt() - range;

        for (int i=0; i < 4; i++) {
            rand = gen.nextInt(size);

            if (store[rand] <= max)
                break;
        }
        store[rand]++;
//        System.out.println(Arrays.toString(store));

        if (rand == -1)
            throw new Exception("The random number generator failed");
        return (rand);
    }
}
