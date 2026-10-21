import java.security.*;


class DigitalSignature {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator g=KeyPairGenerator.getInstance("RSA");
        g.initialize(2048);
        KeyPair kp=g.generateKeyPair();

        byte[] msg="Hello World".getBytes();
        Signature s=Signature.getInstance("SHA256withRSA");

        s.initSign(kp.getPrivate());
        s.update(msg);
        byte[] sign=s.sign();

        s.initVerify(kp.getPublic());
        s.update(msg);
        System.out.println("Valid: "+s.verify(sign));
    }
}