package main.services;

import main.models.User;
import main.repositories.UserRepository;
import main.utils.C;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public Set<User> getAll() throws FileNotFoundException {

        Set<User> users = userRepository.getAll();

        return users;
    }

    public User getById(int id) throws FileNotFoundException {

        User user = userRepository.getById(id);

        return user;
    }

    public void create() throws IOException {

        User user = new User();
        Scanner reader = new Scanner(System.in);

        try {

            C.print("Entre com o nome");
            user.setName(reader.nextLine());

            C.print("\nEntre com a idade");
            user.setAge(reader.nextInt());

            userRepository.save(user);

        } catch (Exception e) {
            throw new IOException("Falha ao cadastrar usuario!\n");
        }
    }
}
