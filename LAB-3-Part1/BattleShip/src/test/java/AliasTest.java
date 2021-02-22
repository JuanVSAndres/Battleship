import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class AliasTest {
    @Test
    @DisplayName("Porfavor!!")
    public void shouldGetAliasNaviesCount(){
        Board b= new Board();

        Navy n1 = new Navy("A",b);
        Navy n2 = new Navy("B",b);
        Navy n3 = new Navy("A",b);

        b.navies.add(n1);
        b.navies.add(n2);
        b.navies.add(n3);

        int r1 = n1.Alias();
        assertEquals(1,r1);
        int r2 = n2.Alias();
        assertEquals(0,r2);

    }
    @Test
    @DisplayName("tenga piedad!!")
    public void shouldGetCarriersAvailableCapacityCount(){
        Board b= new Board();
        Navy n1 = new Navy("A",b);

        AircraftCarrier ac1 = new AircraftCarrier(4,1);
        AircraftCarrier ac2 = new AircraftCarrier(3,1);

        Aircraft a1 = new Aircraft();
        Aircraft a2 = new Aircraft();

        ac1.aircrafts.add(a1);
        ac2.aircrafts.add(a2);

        n1.carriers.add(ac1);
        n1.carriers.add(ac2);

        int z1 = n1.disponibilidadEnPortaAviones();
        assertEquals(5,z1);

    }
}
