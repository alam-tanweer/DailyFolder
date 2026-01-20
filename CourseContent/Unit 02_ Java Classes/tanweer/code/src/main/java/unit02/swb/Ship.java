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

    public Ship (String name,int hullAmount) {
        this(name,10,100,20,hullAmount);
    }

    //2.8
    //this one is not really needed. Probably part of assignment.
    public Boolean isOperational () {
        return operational;
    }

    public String getName () {
        return name;
    }    

}
