import java.util.*;

/**
 * ParkingLotSystem
 *
 * Implements a parking lot using open addressing hash table.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class ParkingLotSystem {

    private ParkingSpot[] table;

    private int capacity;

    public ParkingLotSystem(int capacity) {

        this.capacity = capacity;

        table = new ParkingSpot[capacity];

        for (int i = 0; i < capacity; i++) {
            table[i] = new ParkingSpot();
        }
    }

    /**
     * Hash function
     */
    private int hash(String licensePlate) {

        return Math.abs(licensePlate.hashCode()) % capacity;
    }

    /**
     * Park vehicle using linear probing
     */
    public void parkVehicle(String licensePlate) {

        int index = hash(licensePlate);

        int probes = 0;

        while (table[index].occupied) {

            index = (index + 1) % capacity;
            probes++;

            if (probes >= capacity) {
                System.out.println("Parking Lot Full");
                return;
            }
        }

        table[index].licensePlate = licensePlate;
        table[index].entryTime = System.currentTimeMillis();
        table[index].occupied = true;

        System.out.println(
                "Vehicle " + licensePlate +
                        " parked at spot #" + index +
                        " (" + probes + " probes)"
        );
    }

    /**
     * Exit vehicle
     */
    public void exitVehicle(String licensePlate) {

        int index = hash(licensePlate);

        int probes = 0;

        while (table[index].occupied) {

            if (table[index].licensePlate.equals(licensePlate)) {

                long duration =
                        (System.currentTimeMillis() -
                                table[index].entryTime) / 1000;

                table[index].occupied = false;

                System.out.println(
                        "Vehicle " + licensePlate +
                                " exited from spot #" + index +
                                " Duration: " + duration + " seconds"
                );

                return;
            }

            index = (index + 1) % capacity;
            probes++;

            if (probes >= capacity) {
                break;
            }
        }

        System.out.println("Vehicle not found");
    }

    /**
     * Display statistics
     */
    public void displayStatistics() {

        int occupied = 0;

        for (ParkingSpot spot : table) {

            if (spot.occupied) {
                occupied++;
            }
        }

        double occupancy =
                (occupied * 100.0) / capacity;

        System.out.println("Occupancy: " + occupancy + "%");
    }

    /**
     * Demo
     */
    public static void main(String[] args) {

        ParkingLotSystem parking = new ParkingLotSystem(10);

        parking.parkVehicle("ABC-1234");
        parking.parkVehicle("ABC-1235");
        parking.parkVehicle("XYZ-9999");

        parking.exitVehicle("ABC-1234");

        parking.displayStatistics();
    }
}