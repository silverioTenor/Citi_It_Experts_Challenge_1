package main.controllers;

import main.models.User;
import main.services.UserService;
import main.utils.C;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserController {

    private static UserService userService = new UserService();

    public static void getUsers() {

        Set<User> users = new HashSet<>();

        try {
            users = userService.getAll();

        } catch (FileNotFoundException e) {

            C.print(e.getMessage());

        } finally {

            if (users.size() > 0) {

                for (User user : users) {
                    C.print("====================");
                    C.print(user.toString());
                    C.print("====================\n");
                }

            } else {
                C.print("Nenhum registro encontrado!");
            }
        }
    }

    public static User getUserById(Scanner reader) {

        try {
            C.print("Informe o id do cliente");
            int id = reader.nextInt();

            User user = userService.getById(id);

            if (user != null) {

                C.print("\n====================");
                C.print(user.toString());
                C.print("====================\n");

            } else {
                C.print("Usuario nao encontrado!");
            }

            return user;

        } catch (FileNotFoundException e) {
            C.print(e.getMessage());
            return null;
        }
    }

    public static void createUser() {

        try {
            userService.create();

            C.print("Usuario cadastrado com sucesso!\n");

        } catch (IOException e) {

            C.print(e.getMessage());
        }
    }
}
