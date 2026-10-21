import java.security.*;
import javax.crypto.Cipher;
import java.util.*;

class RSA {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();

        KeyPairGenerator g = KeyPairGenerator.getInstance("RSA");
        g.initialize(2048);
        KeyPair kp = g.generateKeyPair();

        Cipher c = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        c.init(Cipher.ENCRYPT_MODE, kp.getPublic());
        byte[] e = c.doFinal(s.getBytes());
        System.out.println("Encrypted: " +
            Base64.getEncoder().encodeToString(e));

        c.init(Cipher.DECRYPT_MODE, kp.getPrivate());
        System.out.println("Decrypted: " + new String(c.doFinal(e)));
        sc.close();
    }
}