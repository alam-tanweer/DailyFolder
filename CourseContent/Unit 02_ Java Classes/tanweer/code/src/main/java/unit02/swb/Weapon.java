package unit02.swb;

public class Weapon {

    //2.2
    private String name;
    private int damageAmount;
    // public String damageType;
    private DamageType damageType;
    private int fireRate;

    //2.9
    public Weapon (String name, int amount, int fireRate, DamageType damageType) {
    //2.4
    // public Weapon (String name, int amount, int fireRate, String damageType) {
        this.name = name;
        damageAmount = amount;
        this.damageType = damageType;
        this.fireRate = fireRate;
    }

    //2.3
    // public Weapon(){
    //     System.out.println("In Weapon Constructor");
    //     this.name = "Star Ship";
    // }

    //2.8
    public String getName () {
        return name;
    }

    public int getDamageAmount () {
        return damageAmount;
    }

    //2.9
    public DamageType getDamageType () {
        return damageType;
    }

    public int getFireRate () {
        return fireRate;
    }

    //2.11
    @Override
    public String toString() {
        return "{ Weapon: " + this.name + " Damage:" + this.damageAmount + " Damage Type" +
            this.damageType.getColor() + " Fire rate:" + this.fireRate + "}";
    }

    //2.12
    @Override
    public boolean equals(Object obj) {
        // if (obj instanceof Weapon) {
        //     Weapon other = (Weapon)obj;
        if (obj instanceof Weapon other) {
            return (this.damageAmount == other.damageAmount)
                && (this.damageType == other.damageType);
        } else {
            return false;
        }
    }
}
