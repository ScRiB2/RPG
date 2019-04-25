package reflection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {
    static ArrayList<Car> cars = new ArrayList<>();
    static String fileName = "C:\\Users\\ScRiB\\Desktop\\data.txt";

    public static void main(String[] args) {
        cars.add(new Car("Nissan", "green", 96, "Sapronov"));
        cars.add(new Car("Audi", "white", 300, "Nesterov"));
        cars.add(new Car("BMW", "black", 600, "Sedikov"));
        write();

    }

    public static void write() {
        File file = new File(fileName);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            for (Car car : cars) {
                StringBuilder s = new StringBuilder();
                for (Field field : car.getClass().getDeclaredFields()) {
                    if (field.isAnnotationPresent(Writable.class)) {
                        try {
                            field.setAccessible(true);
                            String ss = field.get(car).toString();
                            s.append(field.get(car).toString() + " ");
                        } catch (IllegalAccessException e1) {
                            e1.printStackTrace();
                        }

                    }
                }
                out.print(car.getClass() + ": " + s);
                out.println();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
