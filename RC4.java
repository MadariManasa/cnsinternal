import java.util.*;

class RC4 {
    static byte[] rc4(byte[] data, byte[] key) {
        int[] s = new int[256];
        for(int i=0;i<256;i++) s[i]=i;

        for(int i=0,j=0;i<256;i++) {
            j=(j+s[i]+(key[i%key.length]&255))%256;
            int t=s[i]; s[i]=s[j]; s[j]=t;
        }

        byte[] out = new byte[data.length];
        for(int i=0,j=0,n=0;n<data.length;n++) {
            i=(i+1)%256; j=(j+s[i])%256;
            int t=s[i]; s[i]=s[j]; s[j]=t;
            out[n]=(byte)(data[n]^s[(s[i]+s[j])%256]);
        }
        return out;
    }

    public static void main(String[] args) {
        byte[] key = "secret".getBytes();
        byte[] e = rc4("HELLO".getBytes(),key);
        System.out.println("Encrypted: " +
            Base64.getEncoder().encodeToString(e));
        System.out.println("Decrypted: " +
            new String(rc4(e,key)));
    }
}