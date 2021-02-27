import java.util.ArrayList;
import java.util.List;

public class Aircraft {
    /**
     *Creacion de atributos de la clase como tal.
     */
    private String licencePlate;
    private boolean inAir;
    public static int score;
    public final int crewMembers=2;
    /**
     *Creacion de atributos tipo objeto.
     */
    private Marine copilot;
    private Marine pilot;
    private Position location;
    /**
     *Creacion de arreglos (ArrayList)
     */
    private List<Marine> marines = new ArrayList<>();
    /**
     * Creacion de constructores
     * varios constructores por conveniencia debido a que no queriamos actualizar todas las pruebas constantemente.
     */
    public Aircraft(String licencePlate,boolean inAir)
    {
        this.licencePlate=licencePlate;
        this.inAir=inAir;
    }
    public Aircraft(String licencePlate,boolean inAir,List<Marine> marines)
    {
        this.licencePlate=licencePlate;
        this.inAir=inAir;
        this.marines=marines;
    }
    public Aircraft(String licencePlate,boolean inAir,Position location)
    {
        this.licencePlate=licencePlate;
        this.inAir=inAir;
    }
    public Aircraft(String licencePlate,boolean inAir,Marine marines)
    {
        this.licencePlate=licencePlate;
        this.inAir=inAir;
    }
    /**
     *Creacion de getters.
     */
    public String getLicencePlate() {
        return licencePlate;
    }
    public List<Marine> getMarines() {
        return marines;
    }
    /**
     *El "is" es el getter del boolean.
     */
    public boolean isInAir() {
        return inAir;
    }
    /**
     *Creacion de setters.
     */
    public void setPilot(Marine pilot)
    {
        this.pilot = pilot;
    }

}
