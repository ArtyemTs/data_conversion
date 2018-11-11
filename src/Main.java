// Задача преобразования данных пользователя
// Необходимо ввести в консоль ФИО, дату рождения.
// В ответ полочить в консоль фамилию и инициалы, количество полных лет с постфиксом лет/года, пол.
// Все данные на русском.

import java.io.IOException;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**@exception IllegalArgumentException выбрасывается при создании объекта Data с недоступным диапазоном */
    public static void main(String[] args) {

//        try{
//            // Тестовое создание объекта Data с недопустимым диапазоном
//            Data p = new Data("аиваиыви", "ыиав", "ываивы", 34, 23, 2020);
//            p.print();
//        } catch (IllegalArgumentException i){
//            System.out.println(i.toString());
//        }

//            // Ввод из консоли
//            Data person = dataIn();
//            person.print();


    }
    /** Метод dataIn позволяет ввести данные из консоли при создании объекта класса Data
     * @exception IOException выбрасывается в случае неверного ввода диапазона дат, либо при несоответствии типа введенных данных. В ФИО допустимо вносить число и знаки, т.к. прецеденты использования данных значений в ФИО известны*/

    // заполнение матрицы из консоли
    public static Data dataIn(){
        Data enteredData;
        while (true) {
            Scanner dataIn = new Scanner(System.in);
            try {
                System.out.println("Введите фамилию");
                String surname = dataIn.next();
                System.out.println("Введите имя");
                String name = dataIn.next();
                System.out.println("Введите отчество");
                String patronymic = dataIn.next();
                System.out.println("Введите день (число) рождения");
                int day = dataIn.nextInt();
                if (day < 1 || day > 31){
                    throw new InputMismatchException("Введено несуществующие число месяца");
                }
                System.out.println("Введите номер месяца рождения");
                int month = dataIn.nextInt();
                if (month < 1 || month > 12){
                    throw new InputMismatchException("Введен несуществующий номер месяца");
                }
                System.out.println("Введите год рождения");
                int year = dataIn.nextInt();
                if (year > Calendar.getInstance().get(Calendar.YEAR)){
                    throw new InputMismatchException("Введен еще не наступивший год");
                }

                enteredData = new Data(surname, name, patronymic, day, month, year);
            } catch (InputMismatchException e) {
                System.out.println("Введены некорректные данные: " + e + "\n" + "Пожалуйста, повторите ввод.");
                continue;
            }
            return enteredData;
        }
    }
}
