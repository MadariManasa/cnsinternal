import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;

class CBC {
    public static void main(String[] args) throws Exception {
        SecretKeySpec k = new SecretKeySpec(
            "1234567890123456".getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(
            "abcdefghijklmnop".getBytes());
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

        c.init(Cipher.ENCRYPT_MODE, k, iv);
        byte[] e = c.doFinal("HELLO WORLD".getBytes());
        System.out.println(Base64.getEncoder().encodeToString(e));

        c.init(Cipher.DECRYPT_MODE, k, iv);
        System.out.println(new String(c.doFinal(e)));
    }
}