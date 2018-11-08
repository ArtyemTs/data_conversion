// Задача преобразования данных пользователя
// Необходимо ввести в консоль ФИО, дату рождения.
// В ответ полочить в консоль фамилию и инициалы, количество полных лет с постфиксом лет/года, пол.
// Все данные на русском.

public class Main {

    public static void main(String[] args) {
        DataIn dataIn = new DataIn();
        Data person = dataIn.in();

        Converter conv = new Converter(person);

    }
}
