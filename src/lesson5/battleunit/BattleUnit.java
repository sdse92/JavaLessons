package lesson5.battleunit;

public class BattleUnit {
    protected int health;
    protected int attackScore;

    public BattleUnit(int health, int attackScore) {
        this.health = health;
        this.attackScore = attackScore;
    }

    public boolean isAlife(){
        return health > 0;
    }

    public void attack(BattleUnit enemy){
        enemy.health -= this.attackScore;
    }

}
