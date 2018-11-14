package lesson6.battleunit;

public class Spearman extends BattleUnit {
    public Spearman(int health, int attackScore) {
        super(health, attackScore);
    }

    @Override
    public void attack(BattleUnit enemy) {
        enemy.health -= this.attackScore;
    }
}
