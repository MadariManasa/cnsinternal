import java.util.*;

class PlayFair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter key: ");
        String key = sc.nextLine().toUpperCase().replace("J", "I");

        char[][] a = new char[5][5];
        String s = "";
        for (char c : (key + "ABCDEFGHIKLMNOPQRSTUVWXYZ").toCharArray())
            if (Character.isLetter(c) && s.indexOf(c) < 0)
                s += c;

        for (int i = 0, k = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                a[i][j] = s.charAt(k++);

        System.out.print("Enter plaintext: ");
        String p = sc.nextLine().toUpperCase()
                     .replace("J", "I").replaceAll("[^A-Z]", "");

        String out = "";
        for (int i = 0; i < p.length();) {
            char x = p.charAt(i++), y;
            if (i == p.length() || p.charAt(i) == x) y = 'X';
            else y = p.charAt(i++);

            int r1=0,c1=0,r2=0,c2=0;
            for(int r=0;r<5;r++) for(int c=0;c<5;c++) {
                if(a[r][c]==x){r1=r;c1=c;}
                if(a[r][c]==y){r2=r;c2=c;}
            }
            if(r1==r2) out += ""+a[r1][(c1+1)%5]+a[r2][(c2+1)%5];
            else if(c1==c2) out += ""+a[(r1+1)%5][c1]+a[(r2+1)%5][c2];
            else out += ""+a[r1][c2]+a[r2][c1];
        }
        System.out.println("Encrypted: " + out);
        sc.close();
    }
}