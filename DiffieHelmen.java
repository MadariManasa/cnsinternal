

class DiffieHellman {
    public static void main(String[] args) {
        int p=23, g=5, a=6, b=15;

        int A=(int)Math.pow(g,a)%p;
        int B=(int)Math.pow(g,b)%p;

        int keyA=(int)Math.pow(B,a)%p;
        int keyB=(int)Math.pow(A,b)%p;

        System.out.println("Public A: "+A);
        System.out.println("Public B: "+B);
        System.out.println("Key A: "+keyA);
        System.out.println("Key B: "+keyB);
    }
}