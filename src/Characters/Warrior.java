package Characters;

import Main.Main;

import java.util.*;

public class Warrior extends DefaultChars {


    public void damage(double damage) {
        if (shield >= damage){
            health -= 0;
            System.out.println("Blocked");
        }else{
            this.health -= (damage-shield) ;
        }
    }

    public void giveShield() {
        setShield(Main.ScannerInt());
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int aegis) {
        this.shield = aegis;
    }
}

