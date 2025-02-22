import java.util.Arrays;
import java.util.Objects;

public class Family {
    Human mother;
    Human father;
    Human[] children;
    Pet pet;

    public Family (Human mother, Human father){
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        mother.SetFamily(this);
        father.SetFamily(this);
    }

    public Human GetMother(){
        return this.mother;
    }
    public void SetMother(Human mother){
        this.mother = mother;
    }
    public Human GetFather(Human father){
        return father;
    }
    public void SetFather(Human father){
        this.father = father;
    }
    public Human[] GetChildren(){
        return this.children;
    }
    public void SetChildren(Human[] children){
        this.children = children;
    }
    public Pet GetPet(){
        return this.pet;
    }
    public void SetPet(Pet pet){
        this.pet = pet;
    }

    public void AddChild(Human child){
        child.SetFamily(this);
        Human[] newChildren = new Human[this.children.length + 1];
        newChildren[newChildren.length - 1] = child;
        children = newChildren;
    }

    public boolean DeleteChild(int index){
        if (index < 0 || index >= children.length) {
            return false;
        }
        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) {
                newChildren[j++] = children[i];
            } else {
                children[i].SetFamily(null); // Remove family link
            }
        }
        children = newChildren;
        return true;
    }

    public int CountFamily(){
        return 2 + children.length;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Family family = (Family) obj;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Arrays.equals(children, family.children) &&
                Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }
    protected void finalize(){
        System.out.println(Human mother);
    }
}
