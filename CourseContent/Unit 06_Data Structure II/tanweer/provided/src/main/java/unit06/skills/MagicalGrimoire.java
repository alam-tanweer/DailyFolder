package unit06.skills;

public class MagicalGrimoire {
    private BinaryNode root;

    public MagicalGrimoire() {
        root = null;
    }

    // Exercise 1
    public void addSpell(int SpellID) {
        root = insert(root, SpellID);
    }

    private BinaryNode insert(BinaryNode current, int spellID) {
        if (current == null) {
            return new BinaryNode(spellID);
        }

        if (spellID < current.getValue()) {
            current.setLeft(insert(current.getLeft(), spellID));
        } else if (spellID > current.getValue()) {
            current.setRight(insert(current.getRight(), spellID));
        }

        return current;
    }

    // Exercise 2
    public void chantSpells() {
        if (root != null) {
            System.out.println(root.infixTraversal());
        }
    }

    // Exercise 3
    public String findSpell(int spellID) {
        boolean result = root.search(spellID);
		
		if(result)
			return "FOUND " + spellID + "!";
		else
            return "DID NOT FIND " + spellID + "!";
    }

    // Exercise 4
    public void showStats() {
        if (root != null) {
            String chant = root.infixTraversal();
			String[] spells = chant.split(" ");
			String smallest = spells[0];
			String largest = spells[spells.length - 1];
            System.out.println("Total spells = " + spells.length);
			System.out.println("Smallest spell ID = " + smallest);
			System.out.println("Largest spell ID = " + largest);
        }
    }

    public static void main(String[] args) {
        MagicalGrimoire grimoire = new MagicalGrimoire();

        // Exercise 1
        int[] spells = {1016, 1008, 1022, 1004, 1012, 1018, 1025, 1002, 1006, 1010, 1014, 1020, 1024};
        for (int spell : spells) {
            grimoire.addSpell(spell);
        }

        // Exercise 2
        grimoire.chantSpells();

        // Exercise 3
        System.out.println(grimoire.findSpell(1014));
        System.out.println(grimoire.findSpell(1025));
        System.out.println(grimoire.findSpell(1003));

        // Exercise 4
        grimoire.showStats();
    }
}
