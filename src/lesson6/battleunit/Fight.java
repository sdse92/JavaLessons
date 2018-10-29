package lesson6.battleunit;

public class Fight {
    private BattleUnit unit1;
    private BattleUnit unit2;

    public BattleUnit getUnit1() {
        return unit1;
    }

    public BattleUnit getUnit2() {
        return unit2;
    }

    public Fight (BattleUnit unit1, BattleUnit unit2){
        this.unit1 = unit1;
        this.unit2 = unit2;
    }

    public void fight(){
        while (unit1.isAlife() && unit2.isAlife()){
            unit1.attack(unit2);
            if(unit2.isAlife()){
                unit2.attack(unit1);
            }
        }
    }

    public String fightResult(){
        return "Health юнита 1 = " + unit1.getHealth() +
                "Health юнита 2 = " + unit2.getHealth();
    }
}
