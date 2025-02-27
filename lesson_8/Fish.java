public class Fish extends Animal {
    private String waterType;

    public Fish(String name, int age, String waterType) {
        super(name, age);
        this.waterType = waterType;
    }

    @Override
    public void makeSound() {
        System.out.println("Fish is bubbling...");
    }

    @Override
    public void move() {
        System.out.println("Fish is swimming...");
    }

    public void displayFishInfo() {
        displayInfo();
        System.out.println("Water type: " + waterType);
    }
}