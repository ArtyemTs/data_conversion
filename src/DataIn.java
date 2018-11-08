/** Класс DataIn позволяет ввести данные из консоли при создании объекта класса Data*/

import java.util.Scanner;

public class DataIn {
    private static Scanner dataIn = new Scanner(System.in);
    // заполнение матрицы из консоли
    Data in() {
        System.out.println("Введите фамилию");
        String surname = dataIn.next();
        System.out.println("Введите имя");
        String name = dataIn.next();
        System.out.println("Введите отчество");
        String patronymic = dataIn.next();
        System.out.println("Введите день (число) рождения");
        int day = dataIn.nextInt();
        System.out.println("Введите номер месяца рождения");
        int month = dataIn.nextInt();
        System.out.println("Введите год рождения");
        int year = dataIn.nextInt();
        Data enteredData = new Data(surname, name, patronymic, day, month, year);

        return enteredData;
    }

}
