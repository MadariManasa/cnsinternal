import java.security.*;
import java.util.*;

class SHA512 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] hash = md.digest(s.getBytes());

        for(byte b : hash)
            System.out.printf("%02x", b);
        sc.close();
        
    }
}