package unit03.gvt;

/**
 * Represents any entity that can participate in combat.
 * Implemented by both Goats and Trolls.
 */
public interface Combatant {

    /**
     * Performs an attack.
     *
     * @return the Attack being performed
     */
    Attack attack();

    /**
     * Takes damage from an incoming attack.
     *
     * @param attack the incoming attack
     */
    void takeDamage(Attack attack);
    String getName();
}

