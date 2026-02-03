package unit04.gvt;

public abstract class Goat {
    private final String name;
    private final int maxHP;
    private int currentHP; // could be protected

    public Goat(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
        currentHP = maxHP;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }


    public abstract Attack attack();

    public abstract void takeDamage(Attack attack);
    
    public boolean isConscious() {
        return currentHP > 0;
    }

    public void heal(int amount) {
        currentHP += amount;
        currentHP = currentHP < maxHP ? currentHP : maxHP;
    }

    protected void takeDamage(Attack attack, double adjustment) {
        // two ways to solve this, either make currentHP a protected
        // field or add a helper method; I prefer this way
        for(int hit : attack.getHits()) {
            int amount = (int)(hit * adjustment);
            currentHP -= amount;
        }
        currentHP = currentHP > 0 ? currentHP : 0;
    }
    
    @Override
    public String toString() {
        return "Goat: " + getName() + " Current HP: " + getCurrentHP();
    }

}
