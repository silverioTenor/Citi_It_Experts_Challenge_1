package main.services;

import main.models.User;
import main.models.Vehicle;
import main.models.VehicleRent;
import main.repositories.VehicleRentRepository;
import main.utils.C;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public class VehicleRentService {

    private static VehicleRentRepository vehicleRentRepository;

    public VehicleRentService() {
        vehicleRentRepository = new VehicleRentRepository();
    }

    public Set<VehicleRent> getContracts(int userId) throws FileNotFoundException {

        Set<VehicleRent> vehicleRent = vehicleRentRepository.getContractsByUserId(userId);

        return vehicleRent;
    }

    public void saveOperation(User user, Vehicle vehicle, int qtdDays, int qtdVehicles, double total) {

        VehicleRent vehicleRent = new VehicleRent();
        vehicleRent.setUserId(user.getId());
        vehicleRent.setVehicleModel(vehicle.getModel());
        vehicleRent.setQtdDays(qtdDays);
        vehicleRent.setQtdVehicles(qtdVehicles);
        vehicleRent.setTotal(total);

        try {
            vehicleRentRepository.save(vehicleRent);
            C.print("Operacao feita com sucesso!\n");

        } catch (IOException e) {
            C.print("Falha ao concluir a operacao!\n");
        }
    }
}
