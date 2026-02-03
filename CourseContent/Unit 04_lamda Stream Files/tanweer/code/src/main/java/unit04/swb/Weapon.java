package unit04.swb;

/**
 * Represents a weapon with a name, damage amount, damage type and fire rate.
 */
public class Weapon {
    private String name;
    private int damageAmount;
    private DamageType damageType;
    private int fireRate;

    /**
     * Constructs a Weapon with the specified properties.
     *
     * @param name       the weapon name
     * @param amount     the damage amount
     * @param fireRate   the weapon's fire rate
     * @param damageType the type of damage this weapon deals
     */
    public Weapon(String name, int amount, int fireRate, DamageType damageType) {
        this.name = name;
        this.damageAmount = amount;
        this.damageType = damageType;
        this.fireRate = fireRate;
    }

    /**
     * Constructs a Weapon with default values.
     */
    public Weapon() {
        this("Default Name", 100, 1, DamageType.NORMAL);
    }

    /**
     * Returns the name of the weapon.
     *
     * @return weapon name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the damage amount of the weapon.
     *
     * @return damage amount
     */
    public int getDamageAmount() {
        return damageAmount;
    }

    /**
     * Returns the damage type of the weapon.
     *
     * @return damage type
     */
    public DamageType getDamageType() {
        return damageType;
    }

    /**
     * Returns the fire rate of the weapon.
     *
     * @return fire rate
     */
    public int getFireRate() {
        return fireRate;
    }

    @Override
    public String toString() {
        return "{ Weapon: " + this.name + " Damage:" + this.damageAmount + " Damage Type: "
                + this.damageType.getColor() + " Fire rate:" + this.fireRate + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Weapon) {
            Weapon other = (Weapon) obj;
            return (this.damageAmount == other.damageAmount)
                    && (this.damageType == other.damageType);
        } else {
            return false;
        }
    }

    //4.1
    // private enum DamageType {
    //     NORMAL("Red"),
    //     HEAVY("Green"),
    //     ION("Blue");

    //     private String color;

    //     private DamageType(String color) {
    //         this.color = color;
    //     }

    //     public String getColor() {
    //         return color;
    //     }

    //     @Override
    //     public String toString() {
    //         return name() + " (" + color + ")";
    //     }
    // }

}
