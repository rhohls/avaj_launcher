package Vehicle;

public abstract class Aircraft {
    protected long id;
    protected String name;
    Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId(){
        idCounter += 1;
        return (idCounter);
    }
}
