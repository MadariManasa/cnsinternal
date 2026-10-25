import java.util.*;

class RC4 {
    static byte[] rc4(byte[] d, byte[] k) {
        int[] s = new int[256];
        for (int i = 0; i < 256; i++) s[i] = i;

        for (int i = 0, j = 0; i < 256; i++) {
            j = (j + s[i] + (k[i % k.length] & 255)) % 256;
            int t = s[i]; s[i] = s[j]; s[j] = t;
        }

        byte[] r = new byte[d.length];
        for (int i = 0, j = 0, n = 0; n < d.length; n++) {
            j = (j + s[i = (i + 1) % 256]) % 256;
            int t = s[i]; s[i] = s[j]; s[j] = t;
            r[n] = (byte)(d[n] ^ s[(s[i] + s[j]) % 256]);
        }
        return r;
    }

    public static void main(String[] args) {
        byte[] k = "key".getBytes();
        byte[] e = rc4("HELLO".getBytes(), k);
        System.out.println(Base64.getEncoder().encodeToString(e));
        System.out.println(new String(rc4(e, k)));
    }
}
