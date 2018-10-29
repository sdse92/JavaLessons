package lesson6.battleunit;

public class BatttleUnitFactory {
    public BattleUnit create(String userChoice){
        if(userChoice.equals("knight")){
            return  new Knight(100, 20);
        }
        if(userChoice.equals("spearman")){
            return new Spearman(70, 40);
        }
        return new Doctor(50, 10);
    }
}
