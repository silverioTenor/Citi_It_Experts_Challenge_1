package main.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class C {

    public static void print(String value) {
        System.out.println(value);
    }

    public static void readFile(String fileName) throws FileNotFoundException {

        String line = "";

        try (Scanner buffer = new Scanner(new FileReader(fileName))) {

            while (buffer.hasNext()) {
                line = buffer.nextLine();

                for (String l : line.split(",")) {

                    C.print(l.trim());
                }

                C.print("\n====================\n");
            }

        }
    }
}
