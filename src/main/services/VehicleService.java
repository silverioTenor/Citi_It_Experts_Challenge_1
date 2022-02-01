package main.services;

import main.models.Vehicle;
import main.repositories.VehicleRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService() {
        vehicleRepository = new VehicleRepository();
    }

    public ArrayList<Vehicle> getAll() throws FileNotFoundException {

        ArrayList<Vehicle> vehicle = vehicleRepository.getAll();

        return vehicle;
    }

    public Vehicle getByModel(String model) throws FileNotFoundException {

        Vehicle vehicle = vehicleRepository.getByModel(model);

        return vehicle;
    }
}
