package lesson6.battleunit;

abstract public class BattleUnit {
    protected int health;
    protected int attackScore;

    public int getHealth() {
        return health;
    }

    public int getAttackScore() {
        return attackScore;
    }

    public BattleUnit(int health, int attackScore) {
        this.health = health;
        this.attackScore = attackScore;
    }

    public boolean isAlife(){
        return health > 0;
    }

    abstract public void attack(BattleUnit enemy);


}
