import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Navy {

    public String name;
    public final int code=0;
    public Board board;

    List<AircraftCarrier> carriers=new ArrayList<>();

    public Navy(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    /**
     * Consulta el número de flotas que tienen su mismo nombre
     *
     * @returns: numero de flotas con el mismo nombre
     */

    public int Alias(){
        return this.board.countNavies(this.name)-1;
    }

    /**
     * Consulta la disponibilidad total de los portaaviones
     *
     * @returns: numero de nuevos aviones que podrían cargarse a los portaaviones
     */
    public int disponibilidadEnPortaAviones(){
        int dispo=0;
        for(AircraftCarrier ac: this.carriers){
            dispo += ac.countAicrafts();
        }
        return dispo;
    }

}
