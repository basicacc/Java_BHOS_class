import java.util.*;

class Household {
    private Human matriarch;
    private Human patriarch;
    private Human[] offspring;
    private Pet companion;

    static {
        System.out.println("Household class is now available.");
    }

    {
        System.out.println("A new household has been established.");
    }

    public Household(Human matriarch, Human patriarch) {
        this.matriarch = matriarch;
        this.patriarch = patriarch;
        this.offspring = new Human[0];
        this.companion = new Pet(Species.DOG, "Bruno", 4, 70, new String[]{"running", "barking"});
        this.patriarch.setFamily(this);
        this.matriarch.setFamily(this);
    }

    public Human getMatriarch() {
        return matriarch;
    }

    public Human getPatriarch() {
        return patriarch;
    }

    public Human[] getOffspring() {
        return offspring;
    }

    public void setOffspring(Human[] offspring) {
        this.offspring = offspring;
    }

    public void setMatriarch(Human matriarch) {
        this.matriarch = matriarch;
    }

    public void setPatriarch(Human patriarch) {
        this.patriarch = patriarch;
    }

    public Pet getCompanion() {
        return companion;
    }

    public void setCompanion(Pet companion) {
        this.companion = companion;
    }

    public void addChild(Human child) {
        Human[] newChildren = new Human[offspring.length + 1];
        System.arraycopy(offspring, 0, newChildren, 0, offspring.length);
        newChildren[offspring.length] = child;
        offspring = newChildren;
        child.setFamily(this);
    }

    public void removeChild(Human child) {
        int count = 0;
        Human[] updatedChildren = new Human[offspring.length - 1];
        for (Human h : offspring) {
            if (!h.equals(child)) {
                updatedChildren[count++] = h;
            }
        }
        offspring = updatedChildren;
        child.setFamily(null);
    }

    public void removeChildAt(int index) {
        if (index < 0 || index >= offspring.length) {
            System.out.println("Invalid position");
            return;
        }
        Human[] updatedChildren = new Human[offspring.length - 1];
        for (int i = 0, j = 0; i < offspring.length; i++) {
            if (i != index) {
                updatedChildren[j++] = offspring[i];
            }
        }
        offspring = updatedChildren;
    }

    public int totalMembers() {
        return offspring.length + 2;
    }

    @Override
    public String toString() {
        return "Household:\nMatriarch: " + matriarch + "\nPatriarch: " + patriarch + "\nChildren: " + Arrays.toString(offspring) + "\nCompanion: " + companion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Household household = (Household) obj;
        return Objects.equals(matriarch, household.matriarch) &&
               Objects.equals(patriarch, household.patriarch) &&
               Arrays.equals(offspring, household.offspring) &&
               Objects.equals(companion, household.companion);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(matriarch, patriarch, companion);
        result = 31 * result + Arrays.hashCode(offspring);
        return result;
    }

    @SuppressWarnings("removal")
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Household instance is being removed.");
    }
}
