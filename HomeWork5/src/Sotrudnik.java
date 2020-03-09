public class Sotrudnik {
    public String fio;
    public String doljnost;
    public String email;
    public String telephone;
    public int zarplata;
    public int vozrast;



    public Sotrudnik (String fio, String doljnost, String email, String telephone, int zarplata, int vozrast ){
        this.fio=fio;
        this.doljnost=doljnost;
        this.email=email;
        this.telephone=telephone;
        this.zarplata=zarplata;
        this.vozrast=vozrast;

        System.out.println("Сотрудник: " + fio + ", должность: " + doljnost + ", email: " + email + ", телефон: " + telephone + ", зарплата: " + zarplata + ", возраст: " + vozrast);
    }
}











































