import java.util.Scanner;

public class Bug {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Type something (letters, numbers, or both): ");
        String str = input.nextInt();

        for(int x = 0; x < str.length(); x++) {
            System.out.print(Character.isDigit(x) + " ");
        }
    }
}
