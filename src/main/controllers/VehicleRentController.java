package main.controllers;

import main.models.User;
import main.models.Vehicle;
import main.models.VehicleRent;
import main.services.UserService;
import main.services.VehicleRentService;
import main.services.VehicleService;
import main.utils.C;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class VehicleRentController {

    public static void rentCartoUser(Scanner reader) {

        UserService userService = new UserService();
        VehicleService vehicleService = new VehicleService();
        VehicleRentService vehicleRentService = new VehicleRentService();

        try {
            C.print("Informe o id do cliente");
            int id = reader.nextInt();

            User user = userService.getById(id);

            if (user != null) {

                String model = "";
                int qtdDays = 0;
                int qtdVehicles = 0;

                VehicleController.getVehicles();

                C.print("Informe a marca ou modelo do veiculo");
                model = reader.next();

                Vehicle selectedVehicle = vehicleService.getByModel(model);

                if (selectedVehicle != null) {

                    C.print("Entre com o numero de dias para alugar");
                    qtdDays = reader.nextInt();

                    C.print("Entre com a quantidade de veiculos");
                    qtdVehicles = reader.nextInt();

                    double total = selectedVehicle.getPrice() * (qtdDays * qtdVehicles);

                    do {
                        C.print("Confirma a operacao? (s) sim ou (n) nao?");
                        String confirm = reader.next();

                        if (!confirm.equals("s") && !confirm.equals("n")) {

                            C.print("Opcao invalida!");

                        } else if (confirm.equals("s")) {

                            vehicleRentService.saveOperation(user, selectedVehicle, qtdDays, qtdVehicles, total);
                            break;

                        } else {

                            C.print("Operacao cancelada!");
                            break;
                        }

                    } while (true);

                } else {
                    C.print("Veiculo nao encontrado!");
                }
            } else {
                C.print("Usuario nao encontrado!");
            }

        } catch (FileNotFoundException e) {
            C.print(e.getMessage());
        }
    }

    public static void getContracts(Scanner reader) {

        UserService userService = new UserService();
        VehicleRentService vehicleRentService = new VehicleRentService();

        try {
            C.print("Entre com o id do usuario");
            int id = reader.nextInt();

            User user = userService.getById(id);

            Set<VehicleRent> vehicleRents = vehicleRentService.getContracts(user.getId());

            if (vehicleRents.size() <= 0) {
                C.print("Contrato(s) nao encontrado(s)");
                return;
            }

            printContracts(user, vehicleRents);

        } catch (FileNotFoundException e) {
            C.print(e.getMessage());
        }
    }

    private static void printContracts(User user, Set<VehicleRent> vehicleRents) throws FileNotFoundException {

        VehicleService vehicleService = new VehicleService();

        double total = 0;

        C.print("=======");
        C.print("Cliente");
        C.print("=======\n");

        C.print("Nome: " + user.getName());
        C.print("Idade: " + user.getAge() + " anos");

        C.print("\n=======================");
        C.print("Resumo das contratacoes");
        C.print("=======================\n");

        for (VehicleRent vehicleRent : vehicleRents) {

            Vehicle vehicle = vehicleService.getByModel(vehicleRent.getVehicleModel());

            C.print(vehicle.toString());
            C.print("Dias alugados: " + vehicleRent.getQtdDays());
            C.print("Valor: R$ " + vehicleRent.getTotal() + "\n");

            total += vehicleRent.getTotal();
        }

        C.print("Valor total do aluguel de " + user.getName() + ": R$ " + total);

    }
}
