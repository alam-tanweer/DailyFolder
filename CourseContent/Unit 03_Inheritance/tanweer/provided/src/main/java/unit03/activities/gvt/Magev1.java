package unit03.activities;

public class Magev1 {
    private final String name;
    private final int maxHP;
    private int currentHP;

    public Magev1(String name) {
        this.name = name;
        maxHP = 100;
        currentHP = maxHP;
    }
    
    public String getName() {
        return name;
    }

    public Attack attack() {
        int[] hits = {9, 9, 9, 9};
        return new Attack("Magic Missiles", hits, DamageType.MAGICAL);
    }

    public void attacked(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 0.75;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 1.25;
        }
        for(int hit : attack.getHits()) {
            currentHP -= (hit * adjustment);
        }
        currentHP = currentHP > 0 ? currentHP : 0;
    }
    
    public boolean isConscious() {
        return currentHP > 0;
    }

    public void heal(int amount) {
        currentHP += amount;
        currentHP = currentHP < maxHP ? currentHP : maxHP;
    }
}
