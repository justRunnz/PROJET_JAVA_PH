package Characters;
import Command.Menu.*;
import Main.Main;

public class Mage extends DefaultChars{
    int magicDemage=10;

    int GetMagicDamage(){
        int tempMagicDamage = this.magicDemage;
        this.magicDemage = (int) Math.floor(this.magicDemage/2);
        return tempMagicDamage;
    }


    public int getAttack() {
        return (int) (this.attack+GetMagicDamage());
    }


    public void giveMagical() { setShield(Main.getMyScanner().nextInt());}

    public int getMagical() { return magic;}

    public void setMagical(int fiou) { this.magic = fiou;}
}
