package main.repositories;

import main.interfaces.IVehicle;
import main.models.Vehicle;
import main.utils.C;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleRepository implements IVehicle {

    @Override
    public ArrayList<Vehicle> getAll() throws FileNotFoundException {

        String line = "";
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try (Scanner reader = new Scanner(new FileReader("vehicle.txt"))) {

            while (reader.hasNextLine()) {

                line = reader.nextLine();
                line = line.trim();
                String[] atributes = line.split(",");

                Vehicle vehicle = new Vehicle();

                for (int i = 0; i < atributes.length; i++) {

                    String[] attr = atributes[i].split(":");

                    String index = attr[0].trim();
                    String value = attr[1].trim();

                    switch (index) {
                        case "brand" -> vehicle.setBrand(value);
                        case "model" -> vehicle.setModel(value);
                        case "engine" -> vehicle.setEngine(Double.parseDouble(value));
                        case "color" -> vehicle.setColor(value);
                        case "price" -> vehicle.setPrice(Double.parseDouble(value));
                        case "category" -> vehicle.setCategory(value);
                        default -> C.print("");
                    }
                }

                vehicles.add(vehicle);
            }
        }

        return vehicles;
    }

    @Override
    public Vehicle getByModel(String model) throws FileNotFoundException {

        String line = "";
        Vehicle vehicle = new Vehicle();

        try (Scanner reader = new Scanner(new FileReader("vehicle.txt"))) {

            while (reader.hasNextLine()) {

                line = reader.nextLine();
                line = line.trim();

                if (line.contains(model)) {

                    String[] atributes = line.split(",");

                    for (int i = 0; i < atributes.length; i++) {

                        String[] attr = atributes[i].split(":");

                        String index = attr[0].trim();
                        String value = attr[1].trim();

                        switch (index) {
                            case "brand" -> vehicle.setBrand(value);
                            case "model" -> vehicle.setModel(value);
                            case "engine" -> vehicle.setEngine(Double.parseDouble(value));
                            case "color" -> vehicle.setColor(value);
                            case "price" -> vehicle.setPrice(Double.parseDouble(value));
                            case "category" -> vehicle.setCategory(value);
                            default -> C.print("");
                        }
                    }
                }
            }
        }

        Vehicle result = (vehicle.getModel() != null) ? vehicle : null;

        return result;
    }
}
