import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Navy {
    private String name;
    public final int code=0;
    /**
     *Creacion de atributos de la clase como tal.
     */
    private List<Ship> ships=new ArrayList<>();
    private List<AircraftCarrier> carriers= new ArrayList<>();
    private List<Aircraft> aircrafts=new ArrayList<>();
    private List<Marine> marines=new ArrayList<>();
    private ArrayList<Object> damagedMachines = new ArrayList<>();
    /**
     *Creacion de atributos tipo objeto.
     */
    private Board board=new Board();
    /**
     *Creacion de arreglos (ArrayList)
     */
    private static Set<String> ac = new HashSet<>();

    /**
     *Creacion de constructor de Navy.
     * @param name
     */
    public Navy(String name)
    {
        this.name=name;
    }

    /**
     * Creacion de metodos.
     */

    /**
     * Consulta el número de flotas que tienen su mismo nombre
     *
     * @returns: numero de flotas con el mismo nombre
     */
    public int alias()
    {
        return this.board.countNavies(this.name)-1;
    }
    /**
     * Consulta la disponibilidad total de los portaaviones
     *
     * @returns: numero de nuevos aviones que podrían cargarse a los portaaviones
     */
    public int disponibilidadEnPortaAviones()
    {
        int result=0;
        for(int i=0; getCarriers().size()>i;i++)
        {
            result=getCarriers().get(i).getCapacity()-getAircrafts().size();
        }
        return result;
    }
    /**
     * Consulta la placa de los aviones enemigos que están en el aire
     *
     * @returns: la placa de los aviones enemigos que están en el aire
     */
    public ArrayList<String> enAire()
    {
        ArrayList<String> ia = new ArrayList<>();

        for (int i = 0; i< getAircrafts().size();i++)
        {
            if (getAircrafts().get(i).isInAir()==true)
            {
                ia.add(getAircrafts().get(i).getLicencePlate());
            }
        }
        return ia;
    }
    /**
     * Verifica si una ubicación de ataque en agua es adecuado(destruye elementos
     * enemigos sin ocasionar bajas propias)
     *
     * Parameters:
     *   longitud - longitud de la explosion
     *   latitud - latitud de la explosion
     */
    public boolean esBuenAtaque(int latitude, int longitude)
    {
        boolean result = true;
        for (int i=0;i<this.getShips().size();i++)
        {
            if((latitude==this.getShips().get(i).getLocation().getLatitude()&&longitude==this.getShips().get(i).getLocation().getLongitude()))
            {
                result = false;
            }
        }
        for (int i=0;i<this.getCarriers().size();i++)
        {
            if(latitude==this.getCarriers().get(i).getLocation().getLatitude()&&longitude==this.getCarriers().get(i).getLocation().getLongitude())
            {
                result = false;
            }
        }
        return result;
    }
    /**
     * Mueve todos los barcos la distancia definida
     *
     * Parameters:
     *   deltaLongitud - avance en longitud
     *   deltaLatitud - avance en latitud
     */
    public void muevase(int deltaLatitud, int deltaLongitud)
    {
        for (int i = 0;i<getShips().size();i++)
        {
            if (deltaLatitud+getShips().get(i).getLocation().getLatitude()<= board.maxLat && deltaLatitud+getShips().get(i).getLocation().getLongitude()<= board.maxlong && deltaLatitud+getShips().get(i).getLocation().getLongitude()>= board.minLong && deltaLatitud+getShips().get(i).getLocation().getLatitude()>= board.minLat ){

            }
            getShips().get(i).setLocation(new Position(getShips().get(i).getLocation().getLatitude()+deltaLatitud,getShips().get(i).getLocation().getLongitude()+deltaLongitud));
        }
    }
    /**
     * Consulta el numero de maquinas que tiene la flota
     *
     * @returns: numero de maquinas de la flota
     */
    public int numeroMaquinas()
    {
        return this.machinesCalculator();
    }
    public int machinesCalculator()
    {
        return this.getAircrafts().size()+this.getShips().size()+this.getCarriers().size();
    }
    /**
     * Consulta si puede confundir sus aviones con aviones enemigos considerando
     * las placas
     *
     * @returns: si hay problema en aire
     */
    public boolean problemaEnAire(List<String> n)
    {
        boolean result = false;

        for (int i = 0;i<n.size();i++)
        {
            result=ac.add(n.get(i));
        }

        return !result;
    }
    /**
     * Consulta si cuenta con suficientes marinos para conducir sus máquinas.
     * Un portaaviones requiere cinco marinos; un barco, 4; y un avión 2.
     *
     * @returns: si hay suficientes marinos
     */
    public boolean suficientesMarinos()
    {
        boolean result = false;
        for (int i = 0;i<getAircrafts().size();i++)
        {
            if (getAircrafts().get(i).getMarines().size()==getAircrafts().get(i).crewMembers)
            {
                result=true;
            }
        }
        for (int i = 0;i<getShips().size();i++)
        {
            if (getShips().get(i).getMarines().size()==getShips().get(i).crewMembers)
            {

                result=true;
            }
        }
        for (int i = 0;i<getCarriers().size();i++)
        {
            if (getCarriers().get(i).getMarines().size()==getCarriers().get(i).crewMembers)
            {
                result=true;
            }
        }

        return result;
    }
    /**
     * Consulta las máquinas que pueden afectarse por una explosion en agua
     *
     * Parameters:
     *   longitud - longitud de la explosion
     *   latitud - latitud de la explosion
     */
    public ArrayList<Object> seranDestruidas(int longitud,int latitud)
    {
        for(int i=0;getCarriers().size()>i;i++)
        {
            if(getCarriers().get(i).getLocation().getLongitude() == longitud && getCarriers().get(i).getLocation().getLatitude() == latitud)
            {
                this.damagedMachines.add(getCarriers().get(i));
            }
        }

        for(int i=0;getShips().size()>i;i++)
        {
            if(getShips().get(i).getLocation().getLongitude() == longitud && getShips().get(i).getLocation().getLatitude() == latitud)
            {
                this.damagedMachines.add(getShips().get(i));
            }
        }

        return this.damagedMachines;
    }
    /**
     * Creacion de getters
     */
    public String getName()
    {
        return this.name;
    }
    public List<AircraftCarrier> getCarriers()
    {
        return carriers;
    }
    public List<Aircraft> getAircrafts()
    {
        return aircrafts;
    }
    public List<Ship> getShips()
    {
        return this.ships;
    }
    /**
     * Creacion de un Override del equals para que compare segun el alias y no el espacio de memoria.
     */
    @Override
    public boolean equals(Object o)
    {
        if(o==null)
        {
            return false;
        }
        if(o instanceof Navy)
        {
            return false;
        }
        Navy n = (Navy)o;
        return this.name == board.getAlias();
    }
}
