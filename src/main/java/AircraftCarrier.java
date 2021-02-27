import java.util.ArrayList;
import java.util.List;

public class AircraftCarrier {
    /**
     *Creacion de atributos de la clase como tal.
     */
    private int numberId;
    private int capacity;
    public final int crewMembers=5;
    /**
     *Creacion de atributos tipo arreglos (ArrayList)
     */
    private List<Marine> marines=new ArrayList<>();
    private List<Aircraft> aircrafts=new ArrayList<>();
    /**
     *Creacion de atributos tipo objeto.
     */
    private Position location;
    /**
     *Creacion de constructores.
     */
    public AircraftCarrier(int numberId,int capacity)
    {
        this.numberId=numberId;
        this.capacity=capacity;
    }
    public AircraftCarrier(int numberId,int capacity,Position location)
    {
        this.numberId=numberId;
        this.capacity=capacity;
        this.location=location;
    }
    /**
     *Creacion de getters.
     */
    public List<Aircraft> getAircrafts()
    {
        return aircrafts;
    }
    public int getCapacity()
    {
        return capacity;
    }
    public Position getLocation()
    {
        return location;
    }
    public List<Marine> getMarines()
    {
        return marines;
    }
}
