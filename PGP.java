import java.util.zip.*;
import java.io.*;

class PGP {
    public static void main(String[] args) throws Exception {
        String msg="Hello, secure email!";
        ByteArrayOutputStream b=new ByteArrayOutputStream();
        DeflaterOutputStream d=new DeflaterOutputStream(b);
        d.write(msg.getBytes());
        d.close();

        System.out.println("Original: "+msg);
        System.out.println("Compressed size: "+b.toByteArray().length);
        System.out.println("Compression demonstration complete");
    }
}