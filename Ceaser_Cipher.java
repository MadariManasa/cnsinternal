import java.util.*;

class Ceaser_Cipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();
        System.out.print("Enter key: ");
        int k = sc.nextInt();

        String e = "";
        for (char c : s.toCharArray())
            e += Character.isLetter(c)
                ? (char)('A' + (Character.toUpperCase(c) - 'A' + k) % 26)
                : c;

        System.out.println("Encrypted: " + e);

        String d = "";
        for (char c : e.toCharArray())
            d += Character.isLetter(c)
                ? (char)('A' + (c - 'A' - k + 26) % 26)
                : c;

        System.out.println("Decrypted: " + d);
        sc.close();
    }
}