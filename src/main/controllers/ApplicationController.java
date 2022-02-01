package main.controllers;

import main.utils.C;

import java.util.Scanner;

public class ApplicationController {

    public static void start() {
        String option = "";

        C.print("==========");
        C.print("Bem vindo!");
        C.print("==========\n");

        try (Scanner reader = new Scanner(System.in)) {
            do {
                C.print("Selecione uma das seguintes opcoes\n");

                C.print("==================================");
                C.print("(a) - Castrar um usuario");
                C.print("(b) - Buscar usuarios");
                C.print("(c) - Buscar um usuario");
                C.print("(d) - Listar os veiculos disponiveis");
                C.print("(e) - Alugar um veiculo");
                C.print("(f) - Buscar contratos pelo id do usuario");
                C.print("(g) - Sair");
                C.print("==================================\n");

                option = reader.next();

                switch (option) {
                    case "a" -> UserController.createUser();
                    case "b" -> UserController.getUsers();
                    case "c" -> UserController.getUserById(reader);
                    case "d" -> VehicleController.getVehicles();
                    case "e" -> VehicleRentController.rentCartoUser(reader);
                    case "f" -> VehicleRentController.getContracts(reader);
                    case "g" -> option = null;
                    default -> C.print("Opção invalida!\n");
                }

            } while (option != null);
        }

        C.print("Fim da aplicacao!");
    }
}
