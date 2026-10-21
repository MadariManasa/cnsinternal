import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;

class DES {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();

        SecretKey key = new SecretKeySpec("12345678".getBytes(), "DES");
        Cipher c = Cipher.getInstance("DES");

        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] e = c.doFinal(s.getBytes());
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(e));

        c.init(Cipher.DECRYPT_MODE, key);
        System.out.println("Decrypted: " + new String(c.doFinal(e)));
        sc.close();
    }
}