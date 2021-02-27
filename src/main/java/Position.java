public class Position {
    /**
     *Creacion de atributos.
     */
    private int latitude;
    private int longitude;

    /**
     *Creacion de constructor.
     * @param latitude
     * @param longitude
     */
    public Position(int latitude, int longitude)
    {
        this.latitude=latitude;
        this.longitude=longitude;
    }

    /**
     *Creacion de getters.
     * @return
     */
    public int getLatitude() {
        return this.latitude;
    }
    public int getLongitude() {
        return this.longitude;
    }
}
