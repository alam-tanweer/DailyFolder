package unit03.activities;

public class Fighterv1 {
    private final String name;
    private final int maxHP;
    private int currentHP;

    public Fighterv1(String name) {
        this.name = name;
        maxHP = 100;
        currentHP = maxHP;
    }

    public Attack attack() {
        int[] hits = {25};
        return new Attack("Cleave", hits, DamageType.PHYSICAL);
    }

    public String getName() {
        return name;
    }

    public void attacked(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 1.25;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 0.75;
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
