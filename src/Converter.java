/**  Класс Converter преобразует данные содержащиеся в объекте класса Data в формат согласно условиям задачи
 * и выводит их в консоль
 */
import java.util.Calendar;

public class Converter {
    /** Поля которые должны вернуться в кросоль после конвертации*/
    private String surname;
    //Инициалы 1 и 2
    private String ini1, ini2;
    private int age;
    // Постфикс "...лет" или "...года" (согласно условиям задачи)
    private String let_or_goda;
    private String gender;

    public Converter(Data person) {
        conversion(person);
    }

    public void conversion(Data p ){
        //  Преобразование фамилии и инициалов с учетом регистра
        surname = p.getSurname().substring(0,1).toUpperCase() + p.getSurname().substring(1).toLowerCase();
        ini1 = p.getName().substring(0,1).toUpperCase() + ". ";
        ini2 = p.getPatronymic().substring(0,1).toUpperCase() + ". ";

        // Вычисление полных лет
        Calendar birthDay = Calendar.getInstance();
        birthDay.set(p.getYear(), p.getMonth(), p.getDay());

        int years = Calendar.getInstance().get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
            // корректируем, если текущий месяц в дате проверки меньше месяца даты рождения
        int checkMonth = Calendar.getInstance().get(Calendar.MONTH);
        int birthMonth = birthDay.get(Calendar.MONTH) - 1;
        if ( checkMonth < birthMonth ) {
            years --;
        }  // корректируем, если месяцы равны
        else  if (checkMonth == birthMonth
                && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) < birthDay.get(Calendar.DAY_OF_MONTH)) {
            years --;
        }
        age = years;

        // Вычисление постфикса
        int lastNumber = age % 10;
        boolean b = (age % 100 >= 11) && (age % 100 <= 14);
        String postfix = "";

        if (lastNumber == 1) {
            postfix = "год";
        }else if(lastNumber == 0 || lastNumber >= 5 && lastNumber <= 9) {
            postfix = "лет";
        }else if(lastNumber >= 2 && lastNumber <= 4) {
            postfix = "года";
        }
        if (b)
            postfix = "лет";
        let_or_goda = postfix;

        // Определение пола. Если отчество заканчивается на "а" присваивается женский, иначе мужской
        String s = p.getPatronymic();
        if (s.substring(s.length()-1).equals("а")){
            gender = "Пол женский";
        } else gender = "Пол мужской";

        System.out.println(surname + " " + ini1 + ini2 + "\n" + age + " " + let_or_goda + "\n" + gender);

    }

}
