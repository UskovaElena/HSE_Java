import java.time.format.DateTimeFormatter;
import java.time.*;

public class FIO {
    private final String surname;
    private final String name;
    private final String middleName;
    private final String initials;
    private final String date;
    private final String sex;
    private final int age;

    public FIO(String fio) throws RuntimeException  {
        //fio
        String[] words = fio.split(" ");
        this.surname = words[0];
        this.name = words[1];
        this.middleName = words[2];
        this.date = words[3];
        this.initials = this.name.charAt(0) + "." + this.middleName.charAt(0) + ".";

        //age
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate b_date = LocalDate.parse(this.date, formatter);
        LocalDate cur_date = LocalDate.now();
        Period period = Period.between(b_date, cur_date);
        this.age = period.getYears();

        //sex
        if(this.middleName.charAt(this.middleName.length() - 1) != 'а') {
            this.sex = "Male";
        } else {
            this.sex = "Female";
        }
    }

    public String getFio() {
        return this.surname + " " + this.initials;
    }

    public String getAge() {
        return Integer.toString(this.age);
    }

    public String getSex() {
        return this.sex;
    }
}
