package main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String input = sc.nextLine();
        while (true) {
            System.out.println(verwerkingInput(sc.nextLine()));
        }
    }

    private static String verwerkingInput(String s) {
        if (s.startsWith("\\t ")) {
            return terminalInput(s.substring(4));
        } else {
            //todo: woorddelen
            if (s.contains("\'")) {
                s = replaceApostrophe(s);
            }

        }
        return s;
    }

    private static String replaceApostrophe(String s) {
        s = s.replaceAll("n\'t", " not");
        s = s.replaceAll("'re", " are");
        s = s.replaceAll("\'m", " am");
        s = s.replaceAll("\'ll", " will");
        //todo: interpretatie
        if (s.contains("\'s")) {
            if (s.contains(" got ") || hasReferenceToDirectObject(s)) {
                s = s.replace("\'s", " has");
            } else {
                s = s.replace("\'s", " is");
            }
        }

        return s;
    }

    private static boolean hasReferenceToDirectObject(String s) {
        return false;
    }

    private static String terminalInput(String s) {
        String[] helpContent = {"help", "quit"};
        switch (s) {
            case "quit":
                System.exit(0);
                break;
            case "help":
                return Arrays.toString(helpContent);
            default:
                return "not a valid command. type \"help\" for a list of commands";
        }
        return "not a valid command. type \"help\" for a list of commands";
    }
}
