import java.util.Arrays;
import java.util.Objects;

class Pet{
    String species;
    String name;
    int age;
    int trickLevel;
    String[] habits;

    public Pet(String species, String name, int age, int trickLevel, String[] habits){
        this.species = species;
        this.name = name;
        this.age = 0;
        this.trickLevel = 0;
        this.habits = habits;
    }
    public Pet(String species, String name){
        this.species = species;
        this.name = name;
    }
    public Pet(){
        
    }
    static void eat(){
        System.out.println("I am eating");
    }
    void respond(){
        System.out.println("Hello, owner. I am - " + this.name + ". I miss you!");
    }
    void foul(){
        System.out.println("I need to cover it up");
    }
   
    @Override
    public String toString(){
        return species + "{" + "nickname='" + name + '\'' + ", age=" + age + ", trickLevel=" + trickLevel + ", habits=" + Arrays.toString(habits) + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pet pet = (Pet) obj;
        return age == pet.age &&
                trickLevel == pet.trickLevel &&
                Objects.equals(species, pet.species) &&
                Objects.equals(name, pet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, name, age, trickLevel);
    }
}