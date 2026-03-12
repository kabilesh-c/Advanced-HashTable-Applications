/**
 * ParkingSpot
 *
 * Represents a parking slot in the parking lot.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class ParkingSpot {

    String licensePlate;
    long entryTime;

    boolean occupied;

    public ParkingSpot() {
        this.occupied = false;
    }
}