import java.util.*;

class DiffieHellman {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
int p=sc.nextInt();
int g=sc.nextInt();
int a=sc.nextInt();
int b=sc.nextInt();
        int A=(int)Math.pow(g,a)%p;
        int B=(int)Math.pow(g,b)%p;

        int keyA=(int)Math.pow(B,a)%p;
        int keyB=(int)Math.pow(A,b)%p;

        System.out.println("Public A: "+A);
        System.out.println("Public B: "+B);
        System.out.println("Key A: "+keyA);
        System.out.println("Key B: "+keyB);
        sc.close();
    }
}
