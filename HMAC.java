import javax.crypto.*;
import javax.crypto.spec.*;


class HMAC {
    public static void main(String[] args) throws Exception {
        String msg="Hello World", key="secret";

        Mac m=Mac.getInstance("HmacSHA256");
        m.init(new SecretKeySpec(key.getBytes(),"HmacSHA256"));
        byte[] h=m.doFinal(msg.getBytes());

        for(byte b:h) System.out.printf("%02x",b);
    }
}