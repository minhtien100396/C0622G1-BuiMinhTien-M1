package demo_menu;

import java.util.Scanner;

public class Menu {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        while (true) {
            showMenu("cha");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    menuCon();
                    break;
                case 2:
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void menuCon() {
        int choice;
        while (true) {
            showMenu("con");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void showMenu( String mes) {
        System.out.println("1. chuc nag " + mes);
        System.out.println("2. chuc nag "+ mes);
        System.out.println("3. thoat ");
        System.out.println("Chon chung nang:");

    }
}


