package main.repositories;

import main.interfaces.IUser;
import main.models.User;
import main.utils.C;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserRepository implements IUser {

    @Override
    public Set<User> getAll() throws FileNotFoundException {

        String line = "";
        Set<User> users = new HashSet<>();

        try (Scanner reader = new Scanner(new FileReader("user.txt"))) {

            while (reader.hasNextLine()) {

                line = reader.nextLine();
                line = line.trim();
                String[] atributes = line.split(",");

                User user = new User(false);

                for (int i = 0; i < atributes.length; i++) {

                    String[] attr = atributes[i].split(":");

                    String index = attr[0].trim();
                    String value = attr[1].trim();

                    switch (index) {
                        case "id" -> user.setId(Integer.parseInt(value));
                        case "name" -> user.setName(value);
                        case "age" -> user.setAge(Integer.parseInt(value));
                        default -> C.print("");
                    }
                }

                users.add(user);
            }
        }

        return users;
    }

    @Override
    public User getById(int id) throws FileNotFoundException {

        String line = "";
        User user = new User(false);

        try (Scanner reader = new Scanner(new FileReader("user.txt"))) {

            while (reader.hasNextLine()) {

                line = reader.nextLine();
                line = line.trim();

                if (line.contains(String.valueOf(id))) {

                    String[] atributes = line.split(",");

                    for (int i = 0; i < atributes.length; i++) {

                        String[] attr = atributes[i].split(":");

                        String index = attr[0].trim();
                        String value = attr[1].trim();

                        switch (index) {
                            case "id" -> user.setId(Integer.parseInt(value));
                            case "name" -> user.setName(value);
                            case "age" -> user.setAge(Integer.parseInt(value));
                            default -> C.print("");
                        }
                    }
                }
            }
        }

        User result = (user.getName() != null) ? user : null;

        return result;
    }

    @Override
    public void save(User user) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.txt", true))) {

            writer.write(user.toStringToSave());
            writer.newLine();
        }
    }

}
