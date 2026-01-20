package unit02.swb;

public class Ship {
    private String name;
    private Weapon[] armaments;
    private int shieldAmount;
    private int maxShieldAmount;
    private int rechargeRate;
    private int maxHullAmount;
    private int hullAmount;
    private Ship target;
    private Boolean operational;

    public Ship (String name, int numberOfWeapons, int shieldAmount, int rechargeRate, int hullAmount) {
        this.name = name;
        this.armaments = new Weapon [numberOfWeapons];
        maxShieldAmount = shieldAmount;
        this.shieldAmount = shieldAmount;
        this.rechargeRate = rechargeRate;
        this.hullAmount = hullAmount;
        maxHullAmount = hullAmount;
        operational = true;
        target = null;
    }

    public void acquireTarget (Ship target) {
        if (target != this) {
            this.target = target;
        }
    }

    public void addArmament (Weapon armament) throws Exception {
        if (armaments [armaments.length - 1] != null) {
            throw new Exception ("All armament positions already in use!");
        }

        int index = 0;
        while (armaments [index] != null) {
            index++;
        }
        armaments [index] = armament;
    }

    public void attack () {
        if (!operational) {
            return;
        }
        
        System.out.println (name + " attacks " + target.getName ());
        for (Weapon armament : armaments) {
            target.takeDamage (armament);
        }
        System.out.println (target);
    }

    public void takeDamage (Weapon damager) {
        int damageAmount = damager.getDamageAmount ();
        double hullMultiplier = 1;
        switch (damager.getDamageType ()) {
            case NORMAL:
                shieldAmount -= damageAmount;
                break;
            case HEAVY:
                hullMultiplier = 2;
                shieldAmount -= (int) (damageAmount * 0.66);
                break;
            case ION:
                shieldAmount -= damageAmount * 3;
                hullMultiplier = 0.25;
        }
        if (shieldAmount < 0) {
            hullAmount += shieldAmount * hullMultiplier;
            shieldAmount = 0;
        }
        if (hullAmount < 0) {
            operational = false;
        }
    }

    public void rechargeShield () {
        shieldAmount += rechargeRate;
        if (shieldAmount > maxShieldAmount) {
            shieldAmount = maxShieldAmount;
        }
    }

    public Boolean isOperational () {
        return operational;
    }

    public String getName () {
        return name;
    }

    public String toString () {
        return name + ": shields " + shieldAmount + ", hull " + hullAmount;
    }

    public void dockAtStation () {
        shieldAmount = maxShieldAmount;
        hullAmount = maxHullAmount;
    }

}
