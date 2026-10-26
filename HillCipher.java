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




import java.util.*;

class HillCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 2 letters: ");
        String s = sc.next().toUpperCase();

        int a = s.charAt(0) - 'A';
        int b = s.charAt(1) - 'A';

        // Encryption
        int c1 = (3 * a + 3 * b) % 26;
        int c2 = (2 * a + 5 * b) % 26;

        System.out.println("Encrypted: " +
            (char)(c1 + 'A') + (char)(c2 + 'A'));

        // Decryption using the same variables
        a = (15 * c1 + 17 * c2) % 26;
        b = (20 * c1 + 9 * c2) % 26;

        System.out.println("Decrypted: " +
            (char)(a + 'A') + (char)(b + 'A'));

        sc.close();
    }
}
