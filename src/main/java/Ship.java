import java.util.ArrayList;
import java.util.List;

public class Ship {
    /**
     *Creacion de atributos de la clase como tal.
     */
    private int numberId;
    public final int crewMembers=4;
    public int score;
    /**
     *Creacion de atributos tipo objeto.
     */
    private Position location;
    /**
     *
     */
    private List<Marine> marines=new ArrayList<>();
    /**
     *Creacion de arreglos (ArrayList)
     */
    public Ship(int numberId)
    {
        this.numberId=numberId;

    }
    public Ship(int numberId, Position location)
    {
        this.numberId=numberId;
        this.location=location;

    }
    /**
     *Creacion de getters.
     */
    public List<Marine> getMarines()
    {
        return marines;
    }
    public Position getLocation()
    {
        return location;
    }
    /**
     *Creacion de setters.
     */
    public void setMarines(List<Marine> marines,Marine m)
    {
        this.marines = marines;
        marines = new ArrayList<>();
        marines.add(m);
    }
    public void setLocation(Position location)
    {
        this.location = location;
    }
}
