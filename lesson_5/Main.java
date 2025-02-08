class Main{
    public static void main(String[] args) {
        Pet pet = new Pet("dog", "Rock", 5, 75, new String[]{"eat", "sleep", "play"});
        Human mother = new Human("Jane", "Karleone", 1950);
        Human father = new Human("Vito", "Karleone", 1945);
        String[][] schedule = {{"Monday", "Gym"}, {"Tuesday", "Swimming"}};
        Human child = new Human("Michael", "Karleone", 1970, 90, schedule);      
        System.out.println(child);
        pet.eat();
        pet.respond();
        pet.foul();
    }
}