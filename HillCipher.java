import java.util.*;

class HillCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 2 letters: ");
        String s = sc.next().toUpperCase();

        int a = s.charAt(0)-'A', b = s.charAt(1)-'A';
        System.out.println("Encrypted: " +
            (char)((3*a+3*b)%26+'A') +
            (char)((2*a+5*b)%26+'A'));
            sc.close();
    }
}