import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class AircraftCarrier {
    private int numberId;
    private int capacity;
    private int marines;
    public int score;

    List<Aircraft> aircrafts = new ArrayList<>();


    public AircraftCarrier(int capacity, int numberId) {
        this.capacity = capacity;
        this.numberId = numberId;
    }

    public int countAicrafts(){

        return this.capacity- aircrafts.size();

    }
}
