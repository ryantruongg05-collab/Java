package A2;

import java.util.Scanner;

public class IOHelper {
    
    public static String getString(String prompt) {
        Scanner kb = new Scanner(System.in);
        System.out.print(prompt+":");
        String s = kb.nextLine();
        return s;
    }

    public static double getDouble(String prompt){
        String s = getString(prompt);
        Double d = Double.parseDouble(s);
        return d;
    }

    public static int getInt(String prompt){
        String s = getString(prompt);
        int n = Integer.parseInt(s);
        return n;
    }

    public static char getChar(String prompt) {
        String s = getString(prompt);
        char c = s.charAt(0);
        return c;
    }

    public static char getlowerCaseChar(String prompt) {
        String s = getString(prompt);
        s = s.toLowerCase();
        char c = s.charAt(0);
        return c;
    }

    public static void println(String msg){
        System.out.println(msg);
    }

    public static void println(int n){
        System.out.println(n);
    }

    public static void println(double d){
        System.out.println(d);
    }

    public static void println(){
        System.out.println();
    }

    public static void print(String msg){
        System.out.print(msg);
    }

    public static void main(String[] args){
        char c = IOHelper.getlowerCaseChar("Enter char: ");
        System.out.println(c);
    }
}