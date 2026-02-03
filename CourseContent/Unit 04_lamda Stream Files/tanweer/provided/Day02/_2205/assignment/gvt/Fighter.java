package Day02._2205.assignment.gvt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Fighter extends Goat {
    private static final Map <String, Ability> abilities = new HashMap<> ();

    static {
        abilities.put ("Cleave",
            (enemies, party) -> {
                int hits[] = {0};
                Set<Troll> targets = new HashSet<> ();
                while (targets.size() < enemies.size() && targets.size() < 3) {
                    targets.add (getRandomTarget(enemies));
                }
                boolean first = true; 
                for (Troll target : targets) {
                    hits[0] = (first) ? 25 : 13;
                    first = false;
                    target.takeDamage (new Attack ("", hits, DamageType.PHYSICAL));
                    removeVanquished (enemies, target); 
                }
            }
        );

        abilities.put ("Shield Bash",
            (enemies, party) -> {
                int hits[] = {18};
                Troll target = getRandomTarget (enemies);
                target.takeDamage (new Attack ("", hits, DamageType.PHYSICAL));
                removeVanquished (enemies, target);
            }
        );

        abilities.put ("Punch", Goat::basicAttack);
    }

    public Fighter(String name) {
        super(name, 150, abilities);
    }
    
    @Override
    public Attack attack() {
        int[] hits = {25};
        return new Attack("Cleave", hits, DamageType.PHYSICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 1.25;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 0.75;
        }
        takeDamage(attack, adjustment);
    }
}
