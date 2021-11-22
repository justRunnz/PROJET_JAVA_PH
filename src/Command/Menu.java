package Command;

import Characters.*;

import java.util.*;

import Main.*;

import static Characters.DefaultChars.*;


public class Menu {
    //----------display a table from information-------------//

    private ArrayList<DefaultChars> CharactersList;
    private DefaultChars charOfPlayer1;
    private DefaultChars charOfPlayer2;

    //main class which contains everything even the world:
    public Menu() {
        CharactersList = new ArrayList<DefaultChars>();

        // Default characthers which is already created
        DefaultChars defaultChar1 = new DefaultChars();
        defaultChar1.setName("bapt");
        defaultChar1.setHealth(100);
        defaultChar1.setAttack(8);
        defaultChar1.setInitiative(10);

        DefaultChars defaultChar2 = new DefaultChars();
        defaultChar2.setName("louis");
        defaultChar2.setHealth(100);
        defaultChar2.setAttack(8);
        defaultChar2.setInitiative(8);

        Warrior warrior1 = new Warrior();
        warrior1.setName("moh");
        warrior1.setHealth(100);
        warrior1.setAttack(11);
        warrior1.setInitiative(5);
        warrior1.setShield(5);

        Thief thief1 = new Thief();
        thief1.setName("Rui");
        thief1.setHealth(80);
        thief1.setAttack(10);
        thief1.setInitiative(15);
        thief1.setCriticalHit(2);
        thief1.setDodge(9);

        Mage mage1 = new Mage();
        mage1.setName("PH");
        mage1.setHealth(80);
        mage1.setAttack(10);
        mage1.setInitiative(15);
        mage1.setMagical(2);


        //add these chars to arraylist
        setCharactersList(defaultChar1);
        setCharactersList(defaultChar2);
        setCharactersList(warrior1);
        setCharactersList(thief1);
        setCharactersList(mage1);
    }
    //--------------------------METHOD TO ADD CHARS INTO --------------------//
    public DefaultChars getCharOfPlayer(int number) {
        if (number == 1) return this.charOfPlayer1;
        else return this.charOfPlayer2;
    }

    public void setCharOfPlayer(int number, DefaultChars charOfPlayer) {
        if (number == 1) this.charOfPlayer1 = charOfPlayer;
        else this.charOfPlayer2 = charOfPlayer;
    }


    // -------- Get arraylist of created chars------//
    public ArrayList<DefaultChars> getCharactersList() {
        return this.CharactersList;
    }

    //-------- Add char to the arraylist of created chars -------//
    public void setCharactersList(DefaultChars charactersList) {
        this.CharactersList.add(charactersList);
    }

    //------ Display all created chars and their stats -----//

    private void CharMenu() {
        String select = Main.getMyScanner().next();
        switch (select) {
            case "1":
                DisplayMenu();

            case "2":
                Quit();

            default:
                System.out.println("Retry (tap 1 or 2)");
                CharMenu();
        }
    }
//            System.out.println(focus.getName());
//            System.out.println(focus.getHealth());
//            System.out.println(focus.getAttack());
//            System.out.println(focus.getInitiative());

    //-----------------------------------DISPLAY MENU SECTION-------------------------------------//
    //------method to display a menu------//
    public void DisplayMenu() {
        System.out.println("""
                /*************************** WELCOME **************************/
                /************************* IN RPG SIMULATOR *******************/
                /************************* 1 . To START ***********************/
                /************************* 2 . Characters *********************/
                /*************************  3 . QUIT  *************************/
                /**************************************************************/
                """);
        MenuSelection();
    }

    //----------- method to pick where to go------------//

    private void MenuSelection() {
        String select = Main.getMyScanner().next();

        switch (select) {
            case "1":
                System.out.println("The game has start");
                Start();
                break;
            case "2":
                listCharacters();
                System.out.println("1 -Return to the menu \n 2 - Quit");
                CharMenu();
                break;
            case "3":
                Quit();
                break;
            default:
                System.out.println("command is not recognize" + "\n" + "type a valid option");
                MenuSelection();
                break;
        }
    }

    //----------------- Section start---------------//
    private void Start() {
        System.out.println("""
                1. choose an already define character
                2. create a character
                3. delete a character
                 """);
        String select = Main.ScannerString();   // when type it permit to acces to the section
        switch (select) {
            case "1":
                ChooseChars();
                break;

            case "2":
                Character();
                break;

            case "3":
                DeleteChars();
                DisplayMenu();
                break;

            default:
                System.out.println("command is not recognize");
                System.out.println("Type a valid option p");
                Start();
                break;
        }
    }

    //------- Section quit to permit to leave the game -------//
    private void Quit() {
        System.out.println("you left");

        System.exit(0);
        System.out.println("you left");
    }

//-----------------------Fight section : select a character and start the fight--------------------------//

    private void ChooseChars() {
        PlayerSelect(1);
        PlayerSelect(2);
        Fight();
    }

    private void DeleteChars() {
        listCharacters();
        String select = Main.getMyScanner().next();
        int nb = 0;
        try {
            nb = Integer.parseInt(select);
        } catch (Exception e) {
            System.out.println("• Please enter a valid term");
        }
        if (nb <= getCharactersList().size() && nb > 0) {
            DefaultChars selected = getCharactersList().get(nb - 1);
            System.out.println("• You want do delete :");
            System.out.println("    - 🥷 name: " + selected.getName() + " ⚔️ ️attack: " + selected.getAttack() + " 🫀 Health:" + selected.getHealth() + " 🔮 initiative:" + selected.getInitiative() + " type:" + selected.getClass());
            System.out.println("    \"yes\" ► Delete Character");
            System.out.println("    \"no\" ► Cancel");
            String confirm = Main.ScannerString();
            if (confirm.equals("yes")) {
                System.out.println("• Deleted ✔️");
                getCharactersList().remove(nb - 1);
            } else if (confirm.equals("no")) {
                System.out.println("• Canceled ✔️");
            } else {
                System.out.println("• Invalid Choice");
            }
        } else System.out.println("• Invalid choice, retry please");
    }

    private void PlayerSelect(int player) {
        while (true) { // While user choose existed Char
            if (player == 1) System.out.println("-► Player ONE : Please choose your Character ");
            else if (player == 2) System.out.println("-►  Player TWO : Please choose your Character ");
            System.out.println("• Available Characters : ");
            listCharacters(); // Display list of available Characters
            String select = Main.getMyScanner().next();
            int nb = 0;
            try {
                nb = Integer.parseInt(select);
            } catch (Exception e) {
                System.out.println("• Please enter a valid term");
            }
            if (nb <= getCharactersList().size() && nb > 0) { // Check if select char exist in the list
                DefaultChars selectedChar = getCharactersList().get(nb - 1); // Get selected char
                setCharOfPlayer(player, selectedChar); // Change char of selected player
                System.out.println("• You choose " + selectedChar.getName());
                break;
            } else {
                System.out.println("• Invalid choice, retry please");
                PlayerSelect(player); // If player choose incorrect value, continue the while
                continue;
            }
        }
    }

    //display the list of characters and theirs characteristiques
    private void listCharacters() {
        for (int i = 1; i <= getCharactersList().size(); i++) {
            DefaultChars focus = getCharactersList().get(i - 1);
            System.out.println("    " + i + " ► 🥷 name: " + focus.getName() + " ⚔️ ️attack: " + focus.getAttack() + " 🫀 Health:" + focus.getHealth() + " 🔮 initiative:" + focus.getInitiative() + " type:" + focus.getClass());
        }
    }

    private void Fight() {
        System.out.println("START ");
        DefaultChars PlayerOne = getCharOfPlayer(1);
        DefaultChars PlayerTwo = getCharOfPlayer(2);
        double Round = 0;

        while (PlayerOne.getHealth() > 0 && PlayerTwo.getHealth() > 0) { // While until any player health is lower or equal to zero
            Round++;
            System.out.println("»\uD83E\uDD41 ROUND " + Round + " \uD83E\uDD41«\n");
            int PlayerInitiative = 1;
            if (PlayerTwo.getInitiative() > PlayerOne.getInitiative()) PlayerInitiative = 0;
            if (Round % 2 == PlayerInitiative) {
                PlayerOne.CriticalHit();
                PlayerTwo.damage(PlayerOne.getAttack());
                if (PlayerTwo.getHealth() < 0) PlayerTwo.setHealth(0);
                System.out.println(PlayerOne.getName() + " Attack " + PlayerTwo.getName() + " 🥊  OMGGG ");
                System.out.println(PlayerOne.getName() + " has " + PlayerOne.getHealth() + " ❤");
                System.out.println(PlayerTwo.getName() + " has " + PlayerTwo.getHealth() + " ❤");
            } else {
                PlayerTwo.CriticalHit();
                PlayerOne.damage(PlayerTwo.getAttack());
                if (PlayerOne.getHealth() < 0) PlayerOne.setHealth(0);
                System.out.println(PlayerTwo.getName() + " Attack " + PlayerOne.getName() + " 🥊  OMGGG ");
                System.out.println(PlayerOne.getName() + " has " + PlayerOne.getHealth() + " ❤");
                System.out.println(PlayerTwo.getName() + " has " + PlayerTwo.getHealth() + " ❤");
            }
            System.out.println();
        }
        if (PlayerOne.getHealth() <= 0) System.out.println("🏆 " + PlayerTwo.getName() + " WIN the fight ");
        else System.out.println("🏆 " + PlayerOne.getName() + " WIN the fight ");
        Rematch();
    }


    //ask to rematch or to return or to quit the game//

    private void Rematch() {

        System.out.println("Do you want to fight again ? ");
        System.out.println("""
                1.REFIGHT
                2.Go to the menu 
                3.Quit
                 """);
        String select = Main.getMyScanner().next();
        switch (select) {

            case "1":           //when "1" is typed refight
                Fight();

            case "2":           //when "2" is typed display the menu
                DisplayMenu();

            case "3":           // when "3" is typed game is closed
                Quit();
                System.out.println("you choose to quit the game");
        }
    }
//---------------------Method to create a character and to save it , so we can use it -------------------------------//

    public void Character() {
        DefaultChars dc = null;
        int SelectedCharacter = findAvailableClass();
        if (SelectedCharacter == 2) dc = new Mage(); // instanciate DefaultChars
        else if (SelectedCharacter == 3) dc = new Thief(); // instanciate DefaultChars
        else if (SelectedCharacter == 4) dc = new Warrior(); // instanciate DefaultChars
        else if (SelectedCharacter == 1) dc = new DefaultChars();
        //-----section to iniate and get info from users-----//
        System.out.println("Enter the NAME of your character");
        dc.giveName();
        if (SelectedCharacter == 4) {
            System.out.println("Enter the value of your character SHIELD");
            dc.giveShield();
        }
        System.out.println("Enter the HP your character");
        dc.giveHealth();
        System.out.println("Enter the ATTACK your character");
        dc.giveAttack();
        System.out.println("Enter the INITIATIVE your character");
        dc.giveInitiative();
        //add that information in the charac list
        setCharactersList(dc);
        DisplayMenu(); //we display the menu (back to menu)
    }

    public Integer findAvailableClass() {
        System.out.println("Enter the CLASS of you character");
        String[] avaibleClass = {"Default", "Mage", "Thief", "Warrior"}; // Liste of available class
        for (int i = 1; i <= avaibleClass.length; i++) { // For of available class
            String focus = avaibleClass[i - 1];
            System.out.println("    ► " + i + " " + focus);
        }
        String select = Main.getMyScanner().next();
        int nb = 0;
        try {
            nb = Integer.parseInt(select);
            if (!(nb < avaibleClass.length && nb > 0)) nb = 1;
            System.out.println("• You choose " + avaibleClass[nb - 1] + " class");
        } catch (Exception e) {
            System.out.println("• Please enter a valid term");
        }
        return nb;
    }
}

