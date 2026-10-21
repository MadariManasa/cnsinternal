import java.util.*;

class RailFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine().replace(" ", "");
        String a = "", b = "";

        for (int i = 0; i < s.length(); i++)
            if (i % 2 == 0) a += s.charAt(i);
            else b += s.charAt(i);

        String e = a + b;
        System.out.println("Encrypted: " + e);

        String d = "";
        int n = (s.length()+1)/2, i=0, j=n;
        for(int k=0;k<s.length();k++)
            d += k%2==0 ? e.charAt(i++) : e.charAt(j++);
        System.out.println("Decrypted: " + d);
        sc.close();
    }
}