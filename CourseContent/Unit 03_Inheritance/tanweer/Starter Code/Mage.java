package unit03.gvt;

public class Mage extends Goat {

    public Mage(String name) {
        this.name = name;
        this.maximumHP = 120;
        this.currentHP = 120;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maximumHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    /** Method to be implemented */
    public Attack attack() {
        return null;
    }


    public void takeDamage(Attack attack) {
    }

    public void heal(int amount) {
    }

    /** Method to be implemented */
    
    @Override
    public String toString() {
        return "A mage named " + name + " with " +
            currentHP + "/" + maximumHP + " hit points.";
    }    


    public static void main(String[] args) {
        Mage mage1 = new Mage("Hairy Potter");
        Mage mage2 = new Mage("Merlamb");

        mage1.takeDamage(mage2.attack());
        mage2.takeDamage(mage1.attack());

        System.out.println(mage1);
        System.out.println(mage2);
    }

}
