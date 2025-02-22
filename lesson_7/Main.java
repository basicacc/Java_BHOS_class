public class Main {
    public static void main(String[] args) {
        Human elena = new Human("Elena", "Romano", 1890);
        Human marco = new Human("Marco", "Romano", 1885);
        Human alessio = new Human("Alessio", "Romano", 1918);
        
        Pet cat = new Pet(Species.CAT, "Whiskers", 7, 85, new String[]{"playing", "hunting", "climbing"});
        Pet parrot = new Pet(Species.PARROT, "Rio", 4, 40, new String[]{"talking", "flying"});
        
        Family familyA = new Family(elena, marco);
        
        Human daniel = new Human("Daniel", "Miller", 1985);
        Human sophia = new Human("Sophia", "Miller", 1988);
        
        Family familyB = new Family(sophia, daniel);
        
        Human emily = new Human("Emily", "Miller", 2010);
        Human ethan = new Human("Ethan", "Miller", 2012);
        
        String[][] scheduleAlessio = {
                {DayOfWeek.MONDAY.name(), "go fishing"},
                {DayOfWeek.WEDNESDAY.name(), "visit friends"},
                {DayOfWeek.SATURDAY.name(), "watch football"}
        };
        
        String[][] scheduleEmily = {
                {DayOfWeek.TUESDAY.name(), "attend piano class"},
                {DayOfWeek.THURSDAY.name(), "go swimming"},
                {DayOfWeek.SUNDAY.name(), "spend time with family"}
        };
        
        alessio.setSchedule(scheduleAlessio);
        emily.setSchedule(scheduleEmily);
        
        familyB.addChild(emily);
        familyB.addChild(ethan);
        familyA.addChild(alessio);
        
        System.out.println(familyA);
        System.out.println("----------------------------");
        System.out.println(familyB);
        System.out.println("----------------------------");
        
        familyB.deleteChild(1);
        
        System.out.println(familyB);
        System.out.println("Number of family members: " + familyA.countFamily());
        System.out.println("Number of family members: " + familyB.countFamily());
    }
}
