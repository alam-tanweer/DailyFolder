package unit02.swb;

import java.util.Arrays;

class StarWarsBattle {
    public static final String X_WING = "X-Wing";
    public static final String TIE_FIGHTER = "TIE Fighter";
    public static final String TAIM_AND_BAK = "Taim & Bak KX9 Laser Cannon";
    public static final String L_S1 = "L-s1 Laser Cannon";

    private Ship createXWing () throws Exception {
        Ship xwing = new Ship (X_WING, 4, 25, 10, 45);
        Weapon laserCannon = new Weapon (TAIM_AND_BAK, 15, 1, DamageType.NORMAL);
        for (int i = 0; i < 4; i++) {
            xwing.addArmament (laserCannon);
        }

        return xwing;
    }

    private Ship createTieFighter () throws Exception {
        Ship tieFighter = new Ship (TIE_FIGHTER, 2, 0, 0, 50);
        Weapon laserCannon = new Weapon (L_S1, 12, 1, DamageType.HEAVY);
        for (int i = 0; i < 2; i++) {
            tieFighter.addArmament (laserCannon);
        }

        return tieFighter;
    }

    private void runSimulation () throws Exception {
        int numberOfCombatants = 3;
        Ship [] combatants = new Ship [numberOfCombatants];
        Ship redLeader = createXWing ();
        Ship tie1 = createTieFighter ();
        Ship tie2 = createTieFighter ();
        
        combatants [0] = tie1;
        combatants [1] = tie2;
        combatants [2] = redLeader;

        redLeader.acquireTarget (tie1);
        tie1.acquireTarget (redLeader);
        tie2.acquireTarget (redLeader);

        while (redLeader.isOperational () && tie2.isOperational ()) {
            if (!tie1.isOperational ()) {
                redLeader.acquireTarget (tie2);
            }
            for (Ship combatant : combatants) {
                combatant.attack ();
            }
        }  

        String normalString = DamageType.NORMAL.toString();
        System.out.println(normalString);
        String heavyString = DamageType.HEAVY.toString();
        System.out.println(heavyString);
        String ionString = DamageType.ION.toString();
        System.out.println(ionString);

        DamageType normal = DamageType.valueOf("NORMAL");
        System.out.println(normal);
        DamageType heavy = DamageType.valueOf("HEAVY");
        System.out.println(heavy);
        DamageType ion = DamageType.valueOf("ION");
        System.out.println(ion);

        DamageType[] values = DamageType.values();
        System.out.println(Arrays.toString(values));
    }

    public static void main (String[] args) throws Exception{
        System.out.println ("Star Wars Battle!");
        
        StarWarsBattle battle = new StarWarsBattle ();
        battle.runSimulation ();
    }
}