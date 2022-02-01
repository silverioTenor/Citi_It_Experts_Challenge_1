package main.interfaces;

import main.models.VehicleRent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public interface IVehicleRent {

    Set<VehicleRent> getContractsByUserId(int userId) throws FileNotFoundException;

    void save(VehicleRent vehicleRent) throws IOException;
}
