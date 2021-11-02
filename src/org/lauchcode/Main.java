package org.lauchcode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        String choose = "";
        while (!exit) {
            System.out.println("|Was für ein Diagramm wollen sie verwenden:  |");
            System.out.println("|----------------------------------------|---|");
            System.out.println("| Balkendiagramm -gefüllt       -liegend | 1 |");
            System.out.println("| Balkendiagramm -nicht gefüllt -liegend | 2 |");
            System.out.println("| Balkendiagramm gefüllt        -stehend | 3 |");
            System.out.println("| Balkendiagramm -nicht gefüllt -stehend | 4 |");
            System.out.println("|----------------------------------------|---|");
            boolean exitchoosen = false;
            while (!exitchoosen) {
                choose = sc.nextLine();
                switch (choose) {
                    case "1" -> {
                        Balkendiagrammliegendgefuellt();
                        exitchoosen = true;
                    }
                    case "2" -> {
                        Balkendiagrammliegendnichtgefuellt();
                        exitchoosen = true;
                    }
                    case "3" -> {
                        Balkendiagrammstehendgefuellt();
                        exitchoosen = true;
                    }
                    case "4" -> {
                        Balkendiagrammstehendnichtgefuellt();
                        exitchoosen = true;
                    }
                    default -> System.out.println("Dies ist keine option");
                }
            }

            //Nach beendung der Diagramme kann der User das Programm beenden
            boolean exitexit = false;
            while (!exitexit) {
                System.out.println("Wollen sie das Programm beenden? y/n");
                choose = sc.nextLine();
                switch (choose) {
                    case "y" -> {
                        exit = true;
                        exitexit = true;
                    }
                    case "n" -> exitexit = true;
                    default -> System.out.println("Bitte eine korrekte Eingabe eingeben");
                }
            }

        }
    }

    public static void Balkendiagrammliegendgefuellt() {
        String[] diagramm = Eingabe();

        String[] single = diagramm[1].split(" ");
        int counts = single.length;


        for (int i = 0; i != counts; i++) {
            try {Integer.parseInt(single[i]);}
            catch (NumberFormatException e) {single[i] = "0";}

            int repeater = Integer.parseInt(single[i]);

            for (int j = repeater; j > 0; j--) {
                System.out.print(diagramm[0]);
            }
            System.out.println();
        }
    }

    public static void Balkendiagrammliegendnichtgefuellt() {
        String[] diagramm = Eingabe();

        String[] single = diagramm[1].split(" ");
        int counts = single.length;

        for (int i = 0; i != counts; i++) {
            try {Integer.parseInt(single[i]);}
            catch (NumberFormatException e) {single[i] = "0";}

            int repeater = Integer.parseInt(single[i]);

            for (int j = repeater; j > 0; j--) {
                if (j == 1) {System.out.print(diagramm[0]);}
                else {System.out.print(" ");}

            }
            System.out.println();
        }
    }

    public static void Balkendiagrammstehendgefuellt() {
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
            }
            System.out.println();
        }
    }

    public static void Balkendiagrammstehendnichtgefuellt() {
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
