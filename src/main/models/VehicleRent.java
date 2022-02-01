package main.models;

public class VehicleRent {

    private String vehicleModel;

    private int userId;

    private int qtdDays;

    private int qtdVehicles;

    private double total;

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQtdDays() {
        return qtdDays;
    }

    public void setQtdDays(int qtdDays) {
        this.qtdDays = qtdDays;
    }

    public int getQtdVehicles() {
        return qtdVehicles;
    }

    public void setQtdVehicles(int qtdVehicles) {
        this.qtdVehicles = qtdVehicles;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "VehicleRent {" +
                "vehicleModel=" + vehicleModel +
                ", userId=" + userId +
                ", qtdDays=" + qtdDays +
                ", qtdVehicles=" + qtdVehicles +
                ", total=" + total +
                '}';
    }

    public String toStringToSave() {
        return "vehicleModel: " + vehicleModel +
                ", userId: " + userId +
                ", qtdDays: " + qtdDays +
                ", qtdVehicles: " + qtdVehicles +
                ", total: " + total;
    }
}
