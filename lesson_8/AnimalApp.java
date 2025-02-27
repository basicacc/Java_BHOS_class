public class AnimalApp {
    public static void main(String[] args) {
        Mammal lion = new Mammal("Lion", 5, "Golden");
        Bird eagle = new Bird("Eagle", 3, 2.5);
        Fish shark = new Fish("Shark", 10, "Saltwater");

        lion.displayMammalInfo();
        lion.makeSound();
        lion.move();

        eagle.displayBirdInfo();
        eagle.makeSound();
        eagle.move();

        shark.displayFishInfo();
        shark.makeSound();
        shark.move();
    }
}