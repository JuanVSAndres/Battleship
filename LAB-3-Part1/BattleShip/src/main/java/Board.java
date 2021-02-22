import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Board {

    public static final int maxlong=100;
    public static final int maxLat=100;
    public static final int minLong=-100;
    public static final int minLat=-100;

    private int latitud;
    private int longitud;

    List<Navy> navies=new ArrayList<>();

    public int countNavies(String name){
        int count = 0;

        for(Navy n: this.navies){
            if(n.name.equals(name)){
                count++;
            }

        }

        return count;
    }

    public void move (int lat, int lng){
        if(Board.minLong <= lng && Board.maxlong >= lng && Board.maxLat >= lat && Board.minLat <= lat){

           this.longitud= lng;
           this.latitud = lat;

        }
    }
}
