package main.controllers;

import main.models.Vehicle;
import main.services.VehicleService;
import main.utils.C;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class VehicleController {

    private static VehicleService vehicleService = new VehicleService();

    public static void getVehicles() {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try {
            vehicles = vehicleService.getAll();

        } catch (FileNotFoundException e) {

            C.print(e.getMessage());

        } finally {

            if (vehicles.size() > 0) {

                for (Vehicle vehicle : vehicles) {
                    C.print("====================");
                    C.print(vehicle.toString());
                    C.print("====================\n");
                }

            } else {
                C.print("Nenhum registro encontrado!");
            }
        }
    }
}
