package unit08;

/**
 * A class representing a US city.
 * 
 * @author GCCIS Faculty
 */
public class City {
    /**
     * The radius of the planet Earth in kilometers.
     */
    private static final double RADIUS = 6371;

    private final String name;
    private final String state;
    private final double latitude;
    private final double longitude;
    private final String string;
    private final int hashCode;

    /**
     * Creates a new city with the specified attributes.
     * 
     * @param name The name of the city.
     * @param state The state of the city.
     * @param latitude The latitude of the city.
     * @param longitude The longitude of the city.
     */
    public City(String name, String state, double latitude, double longitude) {
        this.name = name;
        this.state = state;
        this.longitude = longitude;
        this.latitude = latitude;
        this.string = name + ", " + state + " (" + latitude + ", " 
            + longitude + ")";
        this.hashCode = string.hashCode();
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    /**
     * Uses the Haversine Formula to compute the distance between this city and
     * the other city.
     * 
     * @param other The other city.
     * @return The distance between this city and the other city in kilometers.
     */
    public double distance(City other) {
        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(other.latitude);
        double lon2 = Math.toRadians(other.longitude);

        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;

        double a = Math.pow(Math.sin(dlat / 2), 2) 
            + Math.cos(lat1) * Math.cos(lat2) 
            * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RADIUS * c;
    }

    @Override
    public String toString() {
        return string;   
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof City other) {
            return this.string.equals(other.string);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        City city1 = new City("New York City", "New York", 40.7128, -74.0060);
        City city2 = new City("Los Angeles", "California", 34.0522, -118.2437);

        System.out.println("distance from " + city1 + " to " + city2 
            + " = " + city1.distance(city2) + "km");
    }
}
