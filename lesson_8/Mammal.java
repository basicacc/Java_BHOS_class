public class Mammal extends Animal {
    private String furColor;

    public Mammal(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }

    @Override
    public void makeSound() {
        System.out.println("Mammal sound...");
    }

    @Override
    public void move() {
        System.out.println("Mammal is walking...");
    }

    public void displayMammalInfo() {
        displayInfo();
        System.out.println("Fur color: " + furColor);
    }
}