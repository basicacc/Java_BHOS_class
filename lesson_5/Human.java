import java.util.Arrays;
import java.util.Objects;

class Human{
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;

    public Human(String name, String surname, int year, int iq, String[][] schedule){
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human (String name, String surname, int year){
        this.name = name;
        this.surname = surname;
        this.year = year;
    }
    
    public String GetName(){
        return name;
    }
    public void SetName(String name){
        this.name = name;
    }

    public String GetSurname(){
        return this.surname;
    }
    public void SetSurname(String surname){
        this.surname = surname;
    }

    public int GetYear(){
        return this.year;
    }
    public void SetYear(int year){
        this.year = year;
    }

    public int GetIQ(){
        return this.iq;
    }
    public void SetIQ(int iq){
        this.iq=iq;
    }

    public String[][] GetSchedule(){
        return this.schedule;
    }
    public void SetSchedule(String[][] schedule){
        this.schedule = schedule;
    }

    public Family GetFamily(){
        return this.family;
    }
    public void SetFamily(Family family){
        this.family=family;
    }

    @Override
    public String toString() {
        return "Human{name='" + name + "', surname='" + surname + "', year=" + year +
                ", iq=" + iq + ", schedule=" + Arrays.deepToString(schedule) + "}";
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Human human = (Human) obj;
        return year == human.year &&
                iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                Arrays.deepEquals(schedule, human.schedule);
    }
    @Override
    public int hashCode(){
        return Objects.hash(name, surname, year, iq, Arrays.deepHashCode(schedule));
    }
}