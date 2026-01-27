package unit03.gvt;

public class Mage extends Goat {

    // 3.12 - Not needed after refactorying
    // private String name;
    // private int maximumHP;
    // private int currentHP;

    //3.11
    public Mage(String name){
        super(name,Constants.MAGE_HP);
    }

    //3.4
    // public Mage(String name) {
    //     //3.4
    //     this.name = name;
    //     this.maximumHP = 120;
    //     this.currentHP = 120;
    //     //        super(name, 100);
    // }

    // //3.4
    // public String getName() {
    //     return name;
    // }

    // //3.4
    // public int getMaxHp() {
    //     return maximumHP;
    // }

    // //3.4
    // public int getCurrentHP() {
    //     return currentHP;
    // }

    //3.5
    //3.12
    public Attack attack() {
        int[] hits = new int[]{9,9,9,9};
        return new Attack("Magic Missiles", hits, DamageType.MAGICAL);
    }


    // 3.5
    // 3.12
    public void takeDamage(Attack attack) {
        int totalDamage = 0;

        for (int hit : attack.getHits()) {
            totalDamage += hit;
        }

        // Apply damage modifiers
        if (attack.getDamageType() == DamageType.MAGICAL) {
            totalDamage *= 0.75;   // 25% reduction
        } else if (attack.getDamageType() == DamageType.PHYSICAL) {
            totalDamage *= 1.25;   // 25% increase
        }

        reduceHP(totalDamage);
        // currentHP -= totalDamage;

        // if (currentHP < 0) {
        //     currentHP = 0;
        // }
    }

    // /**
    //  * Heals the Mage by the specified amount,
    //  * without exceeding maximum HP.
    //  *
    //  * @param amount amount of HP to restore
    //  */
    // public void heal(int amount) {
    //     currentHP += amount;

    //     if (currentHP > maximumHP) {
    //         currentHP = maximumHP;
    //     }
    // }

    // /**
    //  * Indicates whether the Mage is conscious.
    //  *
    //  * @return true if current HP is greater than 0
    //  */
    // public boolean isConscious() {
    //     return currentHP > 0;
    // }

    // //3.4
    // @Override
    // public String toString() {
    //     return "A mage named " + name + " with " +
    //         currentHP + "/" + maximumHP + " hit points.";
    // }    


    //3.4
    //3.11
    public static void main(String[] args) {
        Mage mage1 = new Mage("Hairy Potter");
        Mage mage2 = new Mage("Merlamb");

        mage1.takeDamage(mage2.attack());
        mage2.takeDamage(mage1.attack());

        System.out.println(mage1);
        System.out.println(mage2);
    }

}
