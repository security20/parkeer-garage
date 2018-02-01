package nl.parkingsimulator.logic;

public class Reservation {

    private int id;
    private int carType;
    private int startTime;
    private int endTime;

    public Reservation(int carType) {
        this.carType = carType;
        this.id = hashCode();
        System.out.println("Reservation: " + id + " made for carID: " + carType);
    }

    public Reservation(int carType, int startTime, int endTime) {
        this.carType = carType;
        this.id = hashCode();
        System.out.println("Reservation: " + id + " made for carID: " + carType + "Starting: " + startTime + ", Ending:" + endTime);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getCarType() {
        return carType;
    }

    public int getId() {
        return id;
    }

    public void setCarType(int carId) {
        this.carType = carId;
    }

    public void setId(int id) {
        this.id = id;
    }
}
