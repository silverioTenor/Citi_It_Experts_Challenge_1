package main.interfaces;

import main.models.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public interface IUser {

    Set<User> getAll() throws FileNotFoundException;

    User getById(int id) throws FileNotFoundException;

    void save(User user) throws IOException;

}
