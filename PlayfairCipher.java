import java.util.*;
public class PlayfairCipher {
	static char[][] keyMatrix = {
	        {'M','O','N','A','R'},
	        {'C','H','Y','B','D'},
	        {'E','F','G','I','K'},
	        {'L','P','Q','S','T'},
	        {'U','V','W','X','Z'}
	    };
	    static int[] findPosition(char ch) {
	        if (ch == 'J')
	            ch = 'I';
	        for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 5; j++) {
	                if (keyMatrix[i][j] == ch)
	                    return new int[]{i, j};
	            }
	        }
	        return null;
	    }
	    static String encrypt(String text) {
	        text = text.toUpperCase().replace("J", "I");
	        String result = "";
	        for (int i = 0; i < text.length(); i += 2) {
	            char a = text.charAt(i);
	            char b = text.charAt(i + 1);
	            int[] p1 = findPosition(a);
	            int[] p2 = findPosition(b);
	            if (p1[0] == p2[0]) { // Same row
	                result += keyMatrix[p1[0]][(p1[1] + 1) % 5];
	                result += keyMatrix[p2[0]][(p2[1] + 1) % 5];
	            } else if (p1[1] == p2[1]) { // Same column
	                result += keyMatrix[(p1[0] + 1) % 5][p1[1]];
	                result += keyMatrix[(p2[0] + 1) % 5][p2[1]];
	            } else { // Rectangle rule
	                result += keyMatrix[p1[0]][p2[1]];
	                result += keyMatrix[p2[0]][p1[1]];
	            }
	        }
	        return result;
	    }
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter Plain Text (even letters): ");
	        String text = sc.nextLine();
	        System.out.println("Encrypted Text: " + encrypt(text));
	        sc.close();
	    }
}