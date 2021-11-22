package Characters;

import Main.Main;

public class Thief extends DefaultChars {
    private int defaultAttack;

    public void setAttack(int attaque) {
        this.attack = attaque;
        this.defaultAttack = attaque;
    }

    public void damage(double damage) {
        int Luck = (int) (Math.random() * 101);
        if (Luck >= 50) {
            health -= 0;
            System.out.println("DODGED");
        } else {
            health -= damage;
        }
    }

    public void CriticalHit() {
        int Crits = (int) Math.round(Math.random() * 1); // Pick a random number between 0 and 1
        if (Crits == 0 && this.attack != this.defaultAttack*2) { // If random number == 0 && lastAttack is not a critical
            this.attack = this.defaultAttack*2;
            System.out.println("OMG CRIT ⚡️");
        } else {
            this.attack = this.defaultAttack;
        }
    }

    public void giveDodge() {
        setShield(Main.ScannerInt());
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int wif) {
        this.dodge = wif;
    }


    public void giveCriticalHit() {
        setShield(Main.ScannerInt());
    }

    public int getCriticalHit() {
        return critical;
    }

    public void setCriticalHit(int strike) {
        this.critical = strike;
    }
}

