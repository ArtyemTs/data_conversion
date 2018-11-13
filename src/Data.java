import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.InputMismatchException;

/** Класс Data содержит все необхожимые поля для создания объекта данного класса*/

public class Data {
    private String surname;
    private String name;
    private String patronymic;
    private int day, month, year;

    /** @param day в диапазоне от 1 до 31
     * @param  month в диапазоне от 1 до 12
     * @param year не более текущего года*/
    Data(String surname, String name, String patronymic,int day, int month, int year){
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.day = day;
        this.month = month;
        this.year = year;
//Проверка валидности введенной даты. Если не валидна выбрасывается DateTimeException
        LocalDate localDate = LocalDate.of(year, month, day);
        LocalDate dateNow = LocalDate.now();
        Boolean isBetween = ( ! dateNow.isBefore( localDate ) ) ;
        if(! isBetween){
            throw new DateTimeException("Введенная дата рождения еще не наступила.");
        }

    }
    // Преобразование фамилии и инициалов с учетом регистра
    private String getInitials(){
        surname = surname.substring(0,1).toUpperCase() + surname.substring(1).toLowerCase();
        String ini1 = name.substring(0,1).toUpperCase() + ". ";
        String ini2 = patronymic.substring(0,1).toUpperCase() + ". ";
        return surname + " " + ini1 + ini2;
    }
    // Вычисление полных лет
    private int getAge(){
        Calendar birthDay = Calendar.getInstance();
        birthDay.set(year, month, day);

        int age = Calendar.getInstance().get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        if (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) <= birthDay.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }
    // Вычисление постфикса
    private String getPostfix(){
        int age = getAge();
        int lastNumber = age % 10;
        boolean b = (age % 100 >= 11) && (age % 100 <= 14);
        String postfix = "";

        if (lastNumber == 1) {
            postfix = "год";
        } else if (lastNumber == 0 || lastNumber >= 5 && lastNumber <= 9) {
            postfix = "лет";
        } else if (lastNumber >= 2 && lastNumber <= 4) {
            postfix = "года";
        }
        if (b)
            postfix = "лет";
        return postfix;
    }
    // Определение пола. Если отчество заканчивается на "а" присваивается женский, иначе мужской
    private String getSex() {
        String gender;
        if (patronymic.substring(patronymic.length() - 1).equals("а")) {
            gender = "Пол женский";
        } else gender = "Пол мужской";
        return gender;
    }
    // Вывод в консоль преобразованных данных в соответствии с условиями задачи
    public void print(){
        System.out.println(getInitials() + "\n" + getAge() + " " + getPostfix() + "\n" + getSex());
    }

    @Override
    public String toString()
    {
        return surname+" "+name+" "+patronymic+" "+day+" "+month+" "+year;
    }

}
