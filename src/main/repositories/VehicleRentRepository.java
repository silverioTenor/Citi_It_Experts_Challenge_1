package main.repositories;

import main.interfaces.IVehicleRent;
import main.models.VehicleRent;
import main.utils.C;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class VehicleRentRepository implements IVehicleRent {

    @Override
    public Set<VehicleRent> getContractsByUserId(int userId) throws FileNotFoundException {

        String line = "";
        Set<VehicleRent> vehicleRents = new HashSet<>();

        try (Scanner reader = new Scanner(new FileReader("vehicleRent.txt"))) {

            while (reader.hasNextLine()) {

                line = reader.nextLine();
                line = line.trim();

                String id = String.valueOf(userId);

                if (line.contains(id)) {

                    String[] atributes = line.split(",");
                    VehicleRent vehicleRent = new VehicleRent();

                    for (int i = 0; i < atributes.length; i++) {

                        String[] attr = atributes[i].split(":");

                        String index = attr[0].trim();
                        String value = attr[1].trim();

                        switch (index) {
                            case "vehicleModel" -> vehicleRent.setVehicleModel(value);
                            case "userId" -> vehicleRent.setUserId(Integer.parseInt(value));
                            case "qtdDays" -> vehicleRent.setQtdDays(Integer.parseInt(value));
                            case "qtdVehicles" -> vehicleRent.setQtdVehicles(Integer.parseInt(value));
                            case "total" -> vehicleRent.setTotal(Double.parseDouble(value));
                            default -> C.print("");
                        }
                    }

                    vehicleRents.add(vehicleRent);
                }
            }
        }

        return vehicleRents;
    }

    @Override
    public void save(VehicleRent vehicleRent) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("vehicleRent.txt", true))) {

            writer.write(vehicleRent.toStringToSave());
            writer.newLine();
        }
    }
}
