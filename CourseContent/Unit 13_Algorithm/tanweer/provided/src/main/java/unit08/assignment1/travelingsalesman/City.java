package unit08.assignment1.travelingsalesman;

public class City {
    private final String name;
    private final String state;
    private final double latitude;
    private final double longitude;

    public City(String name, String state, double latitude, double longitude) {
        this.name = name;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double distanceFrom(City other) {
        double latDiff = this.latitude - other.latitude;
        double lngDiff = this.longitude - other.longitude;

        return Math.sqrt(latDiff*latDiff + lngDiff*lngDiff);
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

    @Override
    public boolean equals(Object o) {
        if(o instanceof City) {
            City city = (City)o;
            return this.longitude == city.longitude 
                && this.latitude == latitude;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int)Math.pow(longitude, latitude);
    }

    @Override
    public String toString() {
        return name + ", " + state;
    }
}
