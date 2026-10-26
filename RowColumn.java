
import java.util.*;

class RowColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String s = sc.nextLine().replace(" ", "").toUpperCase();

        if (s.length() % 2 != 0) s += "X";

        // Encryption
        String e = "";
        for (int i = 0; i < s.length(); i += 2)
            e += s.charAt(i);
        for (int i = 1; i < s.length(); i += 2)
            e += s.charAt(i);

        System.out.println("Encrypted: " + e);

        // Decryption
        String d = "";
        int n = e.length() / 2;

        for (int i = 0; i < n; i++)
            d += e.charAt(i) + "" + e.charAt(i + n);

        System.out.println("Decrypted: " + d);

        sc.close();
    }
}
