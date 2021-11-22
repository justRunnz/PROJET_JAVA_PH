package Main;

import java.util.*;

import Command.*;

//------Class main-------//
public class Main {

    static Scanner myScanner = new Scanner(System.in);

    public static Scanner getMyScanner() {
        return myScanner;
    }
    public static String ScannerString() {
        String result = "";
        try {
            result = getMyScanner().next();
        } catch (Exception e) {
            System.out.println("");
        }
        return result;
    }
    public static Integer ScannerInt() {
        String select = Main.getMyScanner().next();
        try {
            return Integer.parseInt(select);
        } catch (Exception e) {
            System.out.println("• Please enter a valid term");
            return ScannerInt();
        }
    }

    public static void main(String[] args) {
        //Instance menu
        Menu menu = new Menu();

        //call the method
        menu.DisplayMenu();
    }
}
