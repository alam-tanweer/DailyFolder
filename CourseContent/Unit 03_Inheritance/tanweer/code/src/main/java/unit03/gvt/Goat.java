package unit03.gvt;

public abstract class Goat {
    //3.10
    private String name;
    private int maximumHP;
    private int currentHP;

    public Goat (String name, int maximumHP) {
        this.name = name;
        this.maximumHP = maximumHP;
        this.currentHP = maximumHP;
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

    //3.15
    //3.18
    public abstract Attack attack();

    //3.15
    public abstract void takeDamage(Attack attack);

    // public Attack attack() {
    //     int[] hits = new int[]{9,9,9,9};
    //     return new Attack("Magic Missiles", hits, DamageType.MAGICAL);
    // }


    // public void takeDamage(Attack attack) {
    //     int totalDamage = 0;

    //     for (int hit : attack.getHits()) {
    //         totalDamage += hit;
    //     }

    //     // Apply damage modifiers
    //     if (attack.getDamageType() == DamageType.MAGICAL) {
    //         totalDamage *= 0.75;   // 25% reduction
    //     } else if (attack.getDamageType() == DamageType.PHYSICAL) {
    //         totalDamage *= 1.25;   // 25% increase
    //     }

    //     currentHP -= totalDamage;

    //     if (currentHP < 0) {
    //         currentHP = 0;
    //     }
    // }

    /**
     * Heals the Mage by the specified amount,
     * without exceeding maximum HP.
     *
     * @param amount amount of HP to restore
     */
    public void heal(int amount) {
        currentHP += amount;

        if (currentHP > maximumHP) {
            currentHP = maximumHP;
        }
    }

    /**
     * Indicates whether the Mage is conscious.
     *
     * @return true if current HP is greater than 0
     */
    public boolean isConscious() {
        return currentHP > 0;
    }

    protected void reduceHP(int amount) {
        currentHP -= amount;
        if (currentHP <= 0) {
            currentHP = 0;
        }
    }    

    @Override
    public String toString() {
        return "A Goat named " + name + " with " +
            currentHP + "/" + maximumHP + " hit points.";
    }    


}
