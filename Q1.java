import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = kb.nextLine();
        
        String[] nameParts = name.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1].toLowerCase();

        int luckyNumberFirstName = firstName.length();
        int luckyNumberSecondName = 0;
        
        for(int i=0;i<lastName.length();i++){
            luckyNumberSecondName += ((int)lastName.charAt(i))-92;
        }
        System.out.println(luckyNumberFirstName);
        System.out.println(luckyNumberSecondName);
        int luckyNumber = luckyNumberFirstName + luckyNumberSecondName;
        System.out.println("Hi "+name+" your lucky number is " + luckyNumber);
    }
}