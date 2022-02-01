package main.interfaces;

import main.models.Vehicle;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IVehicle {

    ArrayList<Vehicle> getAll() throws FileNotFoundException;

    Vehicle getByModel(String model) throws FileNotFoundException;
}
