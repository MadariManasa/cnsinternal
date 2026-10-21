import java.util.*;

class RowColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine().replace(" ", "");
        if (s.length()%2 != 0) s += "X";

        String e = "";
        for(int i=0;i<s.length();i+=2)
            e += s.charAt(i);
        for(int i=1;i<s.length();i+=2)
            e += s.charAt(i);

        System.out.println("Encrypted: " + e);
        sc.close();
    }
}