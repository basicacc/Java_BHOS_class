import java.util.Arrays;

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
    void eat(){
        System.out.println("I am eating");
    }
    void respond(){
        System.out.println("Hello, owner. I am - " + this.name + ". I miss you!");
    }
    void foul(){
        System.out.println("I need to cover it up");
    }
    public String toString(){
        return species + "{" + "nickname='" + name + '\'' + ", age=" + age + ", trickLevel=" + trickLevel + ", habits=" + Arrays.toString(habits) + '}';
    }
    
}