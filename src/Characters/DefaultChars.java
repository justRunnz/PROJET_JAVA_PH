package Characters;

import java.util.*;

import Main.*;

public class DefaultChars {

    // DECLARATION OF VARIABLES
    protected String name;
    protected int health;
    protected int attack;
    protected int initiative;
    protected int shield;
    protected int dodge;
    protected int critical;
    protected String classe;
    protected int magic;

    public void setClasse(String classee) {
        this.classe = classee;
    }


    // Function to change and give a name to a new created char
    public void giveName() {
        setName(Main.getMyScanner().next());
    }

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    // Function to change and give a health value to a new created char
    public void giveHealth() {
        setHealth(Main.ScannerInt());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int hp) {
        this.health = hp;
    }

    // give an attack value to a new char
    public void giveAttack() {
        setAttack(Main.ScannerInt());
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attaque) {
        this.attack = attaque;
    }

    // give an initiative to a new char
    public void giveInitiative() {
        setInitiative(Main.ScannerInt());
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int init) {
        this.initiative = init;
    }

    public void damage(double damage) {
        this.health -= damage;
    } // method for damage taken by the char

    public void giveShield() {
        setShield(Main.getMyScanner().nextInt());
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int block) {
        this.shield = block;
    }

    public void CriticalHit() {

    }


    //to display chars' information
    public String toString() {
        return "Char : " +
                " Name='" + name +
                ", Health=" + health +
                ", Attack=" + attack +
                ", Initiative=" + initiative
                ;
    }
}


