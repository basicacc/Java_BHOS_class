import java.util.*;

class Person {
    private String firstName;
    private String lastName;
    private int birthYear;
    private int intelligence;
    private String[][] dailyRoutine;
    public Household household;

    static {
        System.out.println("Person class has been initialized.");
    }

    {
        System.out.println("A new person instance has been created.");
    }

    public Person(String firstName, String lastName, int birthYear, int intelligence, String[][] dailyRoutine) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.intelligence = intelligence;
        this.dailyRoutine = dailyRoutine;
    }

    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String[][] getDailyRoutine() {
        return dailyRoutine;
    }

    public Household getHousehold() {
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }

    public void setDailyRoutine(String[][] dailyRoutine) {
        this.dailyRoutine = dailyRoutine;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void greetCompanion() {
        System.out.println("Hello, " + household.getCompanion().getNickname() + "!");
    }

    public void describeCompanion() {
        String cunningLevel = household.getCompanion().getTrickLevel() > 50 ? "very clever" : "not very clever";
        System.out.println("I have a " + household.getCompanion().getSpecies() + " named " + household.getCompanion().getNickname() +
                ". It is " + household.getCompanion().getAge() + " years old and is " + cunningLevel + ".");
    }

    public boolean feedCompanion(boolean isFeedingTime) {
        if (isFeedingTime) {
            System.out.println("Alright, I will feed " + firstName + "'s " + household.getCompanion().getSpecies());
            return true;
        } else {
            Random rand = new Random();
            int randomChance = rand.nextInt(101);
            if (household.getCompanion().getTrickLevel() > randomChance) {
                System.out.println("Alright, I will feed " + firstName + "'s " + household.getCompanion().getSpecies());
                return true;
            } else {
                System.out.println("I think " + firstName + "'s " + household.getCompanion().getSpecies() + " isn't hungry right now.");
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                ", intelligence=" + intelligence +
                ", dailyRoutine=" + Arrays.deepToString(dailyRoutine) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return birthYear == person.birthYear &&
                intelligence == person.intelligence &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Arrays.deepEquals(dailyRoutine, person.dailyRoutine);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(firstName, lastName, birthYear, intelligence);
        result = 31 * result + Arrays.deepHashCode(dailyRoutine);
        return result;
    }

    @SuppressWarnings("removal")
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Person object " + this.firstName + " " + this.lastName + " (" + this.birthYear + ") is being removed.");
    }
}
