import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;

class ECB {
    public static void main(String[] args) throws Exception {
        SecretKeySpec k = new SecretKeySpec(
            "1234567890123456".getBytes(), "AES");
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");

        c.init(Cipher.ENCRYPT_MODE, k);
        byte[] e = c.doFinal("HELLO WORLD".getBytes());
        System.out.println(Base64.getEncoder().encodeToString(e));

        c.init(Cipher.DECRYPT_MODE, k);
        System.out.println(new String(c.doFinal(e)));
        
    }
}