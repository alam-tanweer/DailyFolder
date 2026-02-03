package Day02._2205.assignment.gvt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mage extends Goat {
    private static final Map <String, Ability> abilities = new HashMap<> ();
    static {
        abilities.put ("Magic Missile", 
            new Ability () {
                public void use(List<Troll> enemies, List<Goat> party) {
                    for (int i = 0; i < 4 && i < enemies.size(); i++) {
                        Troll target = getRandomTarget (enemies);
                        int [] hits = {9};
                        target.takeDamage (new Attack ("", hits, DamageType.MAGICAL));
                        removeVanquished (enemies, target);
                    }
                }            
            }
        );

        abilities.put ("Fireball",
            (enemies, party) -> {
                Troll target = getRandomTarget (enemies);
                int [] hits = {48};
                target.takeDamage (new Attack ("", hits, DamageType.ELEMENTAL));
                removeVanquished (enemies, target);  
            }
        );

        abilities.put ("Staff Attack", Goat::basicAttack);
    }

    public Mage(String name) {
        super(name, 100, abilities);
    }

    public Attack attack() {
        int[] hits = {9, 9, 9, 9};
        return new Attack("Magic Missiles", hits, DamageType.MAGICAL);
    }

    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 0.75;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 1.25;
        }
        takeDamage(attack, adjustment);
    }
}
