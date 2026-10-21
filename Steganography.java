import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

class Steganography {
    public static void main(String[] args) throws Exception {
        BufferedImage img = ImageIO.read(new File("input.jpg"));
        String msg = "HELLO";
        String bits = "";
        for(char c : (msg + "\0").toCharArray())
            bits += String.format("%8s",
                Integer.toBinaryString(c)).replace(' ', '0');

        int k = 0;
        for(int y=0;y<img.getHeight() && k<bits.length();y++)
            for(int x=0;x<img.getWidth() && k<bits.length();x++) {
                int p = img.getRGB(x,y);
                int r = (p>>16)&255, g=(p>>8)&255, b=p&255;
                b = (b&254) | (bits.charAt(k++)-'0');
                img.setRGB(x,y,(p&0xFF000000)|(r<<16)|(g<<8)|b);
            }

        ImageIO.write(img,"png",new File("output.png"));
        System.out.println("Message hidden in output.png");
        
    }
}