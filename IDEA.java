class IDEA {
    static int mul(int a, int b) {
        long x = a == 0 ? 65536 : a;
        long y = b == 0 ? 65536 : b;
        int r = (int)((x * y) % 65537);
        return r == 65536 ? 0 : r;
    }

    public static void main(String[] args) {
        int[] key = {
            1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16
        };

        System.out.println("IDEA key size: " + (key.length * 8) + " bits");
        System.out.println("IDEA multiplication example: " + mul(5, 7));
        System.out.println("IDEA requires 8 rounds and a final transformation.");
    }
}