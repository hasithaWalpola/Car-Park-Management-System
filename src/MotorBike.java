
public class MotorBike extends Vehicle {

    private String engineCapacity;

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    //implementing the abstract methods in the vehicle class
    public String getVehicleType() {return vehicleType;}

    public void setVehicleType(String vehicleType) {this.vehicleType = vehicleType;}

    public String getIdPlate() { return idPlate; }

    public void setIdPlate(String idPlate) {
        this.idPlate = idPlate;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "ID : " + getIdPlate() + " Brand : " + getVehicleBrand() + " Time : " + dateTime.toString() + " Engine Capacity : " +engineCapacity;
    }

}
