package unit04.swb;

/**
 * Represents a spaceship with a name, weapons (armaments), shields, hull, and
 * basic combat behavior. Ships may acquire targets, attack using installed
 * weapons, take damage, recharge shields, and dock to fully repair.
 */
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

    /**
     * Constructs a Ship with the given characteristics.
     *
     * @param name             the ship's name
     * @param numberOfWeapons  number of weapon slots to allocate
     * @param shieldAmount     initial and maximum shield amount
     * @param rechargeRate     shield recharge per cycle
     * @param hullAmount       initial and maximum hull amount
     */
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

    /**
     * Sets the ship's combat target. A ship will not target itself.
     *
     * @param target the ship to target; ignored if same as this ship
     */
    public void acquireTarget (Ship target) {
        if (target != this) {
            this.target = target;
        }
    }

    /**
     * Adds a Weapon to the first available armament slot.
     *
     * @param armament weapon to add
     * @throws Exception if no free armament slots are available
     */
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

    /**
     * Performs an attack on the currently acquired target by invoking
     * takeDamage for each installed weapon. If the ship is not operational
     * the attack is skipped.
     */
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

    /**
     * Applies damage from a Weapon to this ship. Damage is first applied to
     * shields with behavior depending on the weapon's damage type; any
     * overflow affects hull. If hull drops below zero the ship becomes
     * non-operational.
     *
     * @param damager the weapon inflicting damage
     */
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

    /**
     * Recharges the ship's shields by the configured recharge rate, up to the
     * maximum shield capacity.
     */
    public void rechargeShield () {
        shieldAmount += rechargeRate;
        if (shieldAmount > maxShieldAmount) {
            shieldAmount = maxShieldAmount;
        }
    }

    /**
     * @return true if the ship is still operational (hull >= 0)
     */
    public Boolean isOperational () {
        return operational;
    }

    /**
     * @return the ship's name
     */
    public String getName () {
        return name;
    }

    /**
     * Returns a short status string describing shield and hull values.
     */
    @Override
    public String toString () {
        return name + ": shields " + shieldAmount + ", hull " + hullAmount;
    }

    /**
     * Fully repairs the ship by restoring shields and hull to their maximums.
     */
    public void dockAtStation () {
        shieldAmount = maxShieldAmount;
        hullAmount = maxHullAmount;
    }

}
