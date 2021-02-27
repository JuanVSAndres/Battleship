import java.util.ArrayList;
import java.util.List;

public class Board {
    /**
     *Creacion de el tablero(sus limites).
     */
    public static final int maxlong=100;
    public static final int maxLat=100;
    public static final int minLong=-100;
    public static final int minLat=-100;
    /**
     *Creacion de atributos de la clase como tal.
     */
    private static int count=0;
    private String alias;
    /**
     *Creacion de atributos tipo arreglos (ArrayList)
     */
    private static List<Navy> navies=new ArrayList<>();
    /**
     *este constructor vacio es necesario ya que al crear un constructor el contructor por defecto que crea java se borra.
     */
    public Board()
    {

    }

    /**
     *Creacion de constructor.
     * @param na
     */
    public Board(List<Navy> na)
    {
        navies = na;
    }

    /**
     *Metodo utilizado para contar navies.
     * @param alias
     * @return
     */
    public int countNavies(String alias)
    {
        this.alias=alias;
        count=0;
        for (Navy n:navies)
        {
            if(n.getName().equals(alias))
            {
                count++;
            }
        }
        return count;
    }
    /**
     *Creacion de getters.
     */
    public List<Navy> getNavies()
    {
        return navies;
    }

    public String getAlias()
    {
        return this.alias;
    }
}
