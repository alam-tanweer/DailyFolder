package unit02.swb;

public class Weapon {
    private String name;
    private int damageAmount;
    private DamageType damageType;
    private int fireRate;

    /**
     * 
     * @param name
     * @param amount
     */
    public Weapon (String name, int amount, int fireRate, DamageType damageType) {
        this.name = name;
        damageAmount = amount;
        this.damageType = damageType;
        this.fireRate = fireRate;
    }

    public Weapon() {
        this("Default Name", 100, 1, DamageType.NORMAL);
    }

    public String getName () {
        return name;
    }

    public int getDamageAmount () {
        return damageAmount;
    }

    public DamageType getDamageType () {
        return damageType;
    }

    public int getFireRate () {
        return fireRate;
    }

    @Override
    public String toString() {
        return "{ Weapon: " + this.name + " Damage:" + this.damageAmount + " Damage Type" +
            this.damageType.getColor() + " Fire rate:" + this.fireRate + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Weapon) {
            Weapon other = (Weapon)obj;
            return (this.damageAmount == other.damageAmount)
                && (this.damageType == other.damageType);
        } else {
            return false;
        }
    }

}
