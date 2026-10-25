
import java.util.*;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

class IDEA {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String text = sc.nextLine();

        System.out.print("Enter 16-character key: ");
        String k = sc.nextLine();

        SecretKeySpec key = new SecretKeySpec(k.getBytes("UTF-8"), "IDEA");
        Cipher c = Cipher.getInstance("IDEA/ECB/PKCS5Padding", "BC");

        c.init(Cipher.ENCRYPT_MODE, key);
        String e = Base64.getEncoder().encodeToString(
            c.doFinal(text.getBytes("UTF-8")));
        System.out.println("Encrypted: " + e);

        c.init(Cipher.DECRYPT_MODE, key);
        String d = new String(
            c.doFinal(Base64.getDecoder().decode(e)), "UTF-8");
        System.out.println("Decrypted: " + d);

        sc.close();
    }
}
