/** Класс Data содержит все необхожимые поля для создания объекта данного класса */

public class Data {
    private String surname = new String();
    private String name = new String();
    private String patronymic = new String();
    private int day, month, year;

    public Data(String surname, String name, String patronymic,int day, int month, int year){
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.day = day;
        this.year = year;
        this.month = month;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString()
    {
        return surname+" "+name+" "+patronymic+" "+day+" "+month+" "+year;
    }

}
