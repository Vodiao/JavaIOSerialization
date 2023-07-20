import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
//        task1();

        task2();


    }

    public static void task1() {

        String text = "Java world";

        File directory = new File("C:\\Users\\Vadim\\OneDrive\\Рабочий стол\\AutomationJava 29.05.2023\\HomeWorkQA13\\Task1");

        File firstFile = new File("C:\\Users\\Vadim\\OneDrive\\Рабочий стол\\AutomationJava 29.05.2023\\HomeWorkQA13\\Task1\\file1.txt");

        File secondFile = new File("C:\\Users\\Vadim\\OneDrive\\Рабочий стол\\AutomationJava 29.05.2023\\HomeWorkQA13\\Task1\\file2.txt");


        boolean createDirectory = directory.mkdir();
        boolean createFirstFile = false;
        boolean createSecondFile = false;

        if (createDirectory) {
            System.out.println("Directory is create");
        }

        try {
            createFirstFile = firstFile.createNewFile();
        } catch (IOException exception) {
            throw new RuntimeException();
        }

        if (createFirstFile) {
            System.out.println("First file was create");
        }

        try (FileOutputStream fos = new FileOutputStream(firstFile)) {
            fos.write(text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            createSecondFile = secondFile.createNewFile();
        } catch (IOException exception) {
            throw new RuntimeException();
        }

        try (FileWriter writer = new FileWriter(secondFile, false)) {
            writer.write(text);

        } catch (IOException exception) {
            throw new RuntimeException();
        }

        if (createSecondFile) {
            System.out.println("Second file was create");
        }


        if (firstFile.delete() && secondFile.delete()) {
            System.out.println("Both files were deleted.");
        } else {
            System.out.println("Failed to delete one or both files.");
        }


        if (directory.delete()) {
            System.out.println("Directory was deleted.");
        } else {
            System.out.println("Failed to delete the directory.");
        }
    }

    public static void task2() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cat.dat"))) {

            Cat cat = new Cat("Olezhka", 2, 4);

            oos.writeObject(cat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("cat.dat"))) {
            Cat c = (Cat) oos.readObject();
            System.out.println(c);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}