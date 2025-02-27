public class Bird extends Animal {
    private double wingspan;

    public Bird(String name, int age, double wingspan) {
        super(name, age);
        this.wingspan = wingspan;
    }

    @Override
    public void makeSound() {
        System.out.println("Bird is chirping...");
    }

    @Override
    public void move() {
        System.out.println("Bird is flying...");
    }

    public void displayBirdInfo() {
        displayInfo();
        System.out.println("Wingspan: " + wingspan + " meters");
    }
}