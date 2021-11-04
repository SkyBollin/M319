package org.lauchcode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean isexit = false;
        String choose;
        while (!isexit) {
            System.out.println("|Was für ein Diagramm wollen sie verwenden:  |");
            System.out.println("|----------------------------------------|---|");
            System.out.println("| Balkendiagramm -gefüllt       -liegend | 1 |");
            System.out.println("| Balkendiagramm -nicht gefüllt -liegend | 2 |");
            System.out.println("| Balkendiagramm -gefüllt       -stehend | 3 |");
            System.out.println("| Balkendiagramm -nicht gefüllt -stehend | 4 |");
            System.out.println("|----------------------------------------|---|");
            boolean isexitchoosen = false;

            while (!isexitchoosen) {
                choose = scan.nextLine();
                switch (choose) {
                    case "1" -> {
                        balkendiagrammliegendgefuellt();
                        isexitchoosen = true;
                    }
                    case "2" -> {
                        balkendiagrammliegendnichtgefuellt();
                        isexitchoosen = true;
                    }
                    case "3" -> {
                        balkendiagrammstehendgefuellt();
                        isexitchoosen = true;
                    }
                    case "4" -> {
                        balkendiagrammstehendnichtgefuellt();
                        isexitchoosen = true;
                    }
                    default -> System.out.println("Dies ist keine option");
                }
            }

            //Nach beendung der Diagramme kann der User das Programm beenden
            boolean isexitexit = false;
            while (!isexitexit) {
                System.out.println("Wollen sie das Programm beenden? y/n");
                choose = scan.nextLine();
                switch (choose) {
                    case "y" -> {
                        isexit = true;
                        isexitexit = true;
                    }
                    case "n" -> isexitexit = true;
                    default -> System.out.println("Bitte eine korrekte Eingabe eingeben");
                }
            }

        }
    }

    public static void balkendiagrammliegendgefuellt() {
        String[] diagramm = Eingabe();

        String[] single = diagramm[1].split(" ");
        int counts = single.length;


        for (int i = 0; i != counts; i++) {
            try {Integer.parseInt(single[i]);}
            catch (NumberFormatException e) {single[i] = "0";}

            int repeater = Integer.parseInt(single[i]);

            for (int j = repeater; j > 0; j--) {
                System.out.print(diagramm[0] + " ");
            }
            System.out.println();
        }
    }

    public static void balkendiagrammliegendnichtgefuellt() {
        String[] diagramm = Eingabe();

        String[] single = diagramm[1].split(" ");
        int counts = single.length;

        for (int i = 0; i != counts; i++) {
            try {Integer.parseInt(single[i]);}
            catch (NumberFormatException e) {single[i] = "0";}

            int repeater = Integer.parseInt(single[i]);

            for (int j = repeater; j > 0; j--) {
                if (j == 1) {System.out.print(diagramm[0]); }
                else {System.out.print(" ");}
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void balkendiagrammstehendgefuellt() {
        String[] diagramm = Eingabe();

        String[] single = diagramm[1].split(" ");
        int counts = single.length;
        int highest = 0;

        for (int i = 0; i != counts; i++) {
                try {Integer.parseInt(single[i]);}
                catch (NumberFormatException e) {single[i] = "0";}
                if (Integer.parseInt(single[i]) >= highest) {highest = Integer.parseInt(single[i]);}
            }

        for (int i = highest; i > 0; i--) {
            for (int j = 0; j < counts; j++) {
                if (Integer.parseInt(single[j]) >= i) {System.out.print(diagramm[0]);}
                else {System.out.print(" ");}
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void balkendiagrammstehendnichtgefuellt() {
        String[] diagramm = Eingabe();

        String[] single = diagramm[1].split(" ");
        int counts = single.length;
        int highest = 0;

        for (int i = 0; i != counts; i++) {
            try {Integer.parseInt(single[i]);}
            catch (NumberFormatException e) {single[i] = "0";}
            if (Integer.parseInt(single[i]) >= highest) {highest = Integer.parseInt(single[i]);}
        }

        for (int i = highest; i > 0; i--) {
            for (int j = 0; j < counts; j++) {
                if (Integer.parseInt(single[j]) == i) {System.out.print(diagramm[0]);}
                else {System.out.print(" ");}
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static String[] Eingabe() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Was für ein Zeichen wollen sie beim Diagramm verwenden?");
        String rawinput = sc.nextLine();
        char input = rawinput.charAt(0);

        System.out.println("Geben sie bitte ihre Diagrammwerte ein (Mit Leerzeichen getrennt, nur Ganzzahlig und positiv):");
        String diagramm = sc.nextLine();

        String[] returnvalue = new String[2];
        returnvalue[0] = String.valueOf(input);
        returnvalue[1] = diagramm;

        return returnvalue;
    }

    }
