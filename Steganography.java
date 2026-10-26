import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

class Steganography {
    public static void main(String[] args) throws Exception {
        BufferedImage img = ImageIO.read(new File("input.jpg"));
        String msg = "HELLO";
        int k = 0;

        for (int y = 0; y < img.getHeight() && k < msg.length(); y++) {
            for (int x = 0; x < img.getWidth() && k < msg.length(); x++) {
                int p = img.getRGB(x, y);
                char c = msg.charAt(k++);
                p = (p & 0xFFFFFF00) | c;
                img.setRGB(x, y, p);
            }
        }

        ImageIO.write(img, "png", new File("output.png"));
        System.out.println("Message hidden successfully");
    }
}
