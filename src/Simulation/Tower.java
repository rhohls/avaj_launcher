package Simulation;

import Helper.Logger;
import Vehicle.Aircraft;
import Vehicle.Flyable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Tower {

    ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable)
    {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        observers.remove(flyable);
    }

    protected void conditionsChanged() throws Exception {
        for (int i=0; i<observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}
