import java.util.*;

class Companion {
    private String type;
    private String name;
    private int yearsOld;
    private int skillLevel;
    private String[] activities;

    static {
        System.out.println("Companion class has been initialized.");
    }

    {
        System.out.println("A new companion object has been created.");
    }

    public Companion(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public Companion(String type, String name, int yearsOld, int skillLevel, String[] activities) {
        this.type = type;
        this.name = name;
        this.yearsOld = yearsOld;
        this.skillLevel = skillLevel;
        this.activities = activities;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String[] getActivities() {
        return activities;
    }

    public void setActivities(String[] activities) {
        this.activities = activities;
    }

    public void eat() {
        System.out.println("I am eating.");
    }

    public void greetOwner() {
        System.out.println("Hello, my owner! I am " + name + ". I missed you!");
    }

    public void mischief() {
        System.out.println("Oops! I made a mess, let me cover it up.");
    }

    @Override
    public String toString() {
        return type + "{name='" + name + "', age=" + yearsOld + ", skillLevel=" + skillLevel + ", activities=" + Arrays.toString(activities) + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Companion companion = (Companion) obj;
        return yearsOld == companion.yearsOld &&
                skillLevel == companion.skillLevel &&
                Objects.equals(type, companion.type) &&
                Objects.equals(name, companion.name) &&
                Arrays.equals(activities, companion.activities);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(type, name, yearsOld, skillLevel);
        result = 31 * result + Arrays.hashCode(activities);
        return result;
    }

    @SuppressWarnings("removal")
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Companion object " + this.name + " is being removed.");
    }
}
