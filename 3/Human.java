class Human{
    String name;
    String surname;
    int year;
    int iq;
    Pet pet;
    Human mother;
    Human father;
    String[][] schedule;
    public Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String[][] schedule){
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }
    public Human(String name, String surname, int year){
        this.name = name;
        this.surname = surname;
        this.year = year;
    }
    public Human(String name, String surname, int year, Human mother, Human father){
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }
    public void greetPet(){
        System.out.println("Hello, " + this.pet.name);
        this.pet.respond();
    }
    public void DescribePet(){
        System.out.println("I have a " + this.pet.species + ", he is " + this.pet.age + " years old, he is " + this.pet.trickLevel + " level");
    }
    public void feedPet(boolean isTime){
        if(isTime){
            System.out.println("Time to feed " + this.pet.name);
        }else{
            System.out.println("I will feed " + this.pet.name + " later");
        }
    }
    @Override
    public String toString() {
        return "Human{name='" + name + "', surname='" + surname + "', year=" + year + ", iq=" + iq +
                ", mother=" + (mother != null ? mother.name + " " + mother.surname : "null") +
                ", father=" + (father != null ? father.name + " " + father.surname : "null") +
                ", pet=" + pet + "}";
    }

}