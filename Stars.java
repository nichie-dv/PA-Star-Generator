package StarGenerator;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public final class Stars {

    private static final char[] stars = ".,-*/\\ ".toCharArray(); //0 to 5 in order of size -- size chances in order: 10 8 4 2 2
    private static final Random r = new Random(); 
    
    public static void main(String[] args) throws IOException {
        boolean place = false;
        Scanner in = new Scanner(System.in);
        System.out.print("\nLength: ");
        int length = in.nextInt();
        System.out.print("\nHeight: ");
        int height = in.nextInt();
        System.out.print("\nStar Frequency (1-100): "); // 1 - 100
        int frequency = in.nextInt();
        try {
            PrintStream output = new PrintStream(new FileOutputStream("Output.txt"), true, "UTF-8");
            StringBuilder sb = new StringBuilder();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < length; x++) {
                    int rfreq = r.nextInt(100) + 1;
                    if (rfreq <= frequency) {
                        place = true;
                    }
                    if (place) {
                        int size = r.nextInt(28) + 1;
                        if (size <= 10) {
                            sb.append(stars[0]);
                        } else if (size > 10 && size <= 18) {
                            sb.append(stars[1]);
                        } else if (size > 18 && size <= 22) {
                            sb.append(stars[2]);
                        } else if (size > 22 && size <= 24) {
                            sb.append(stars[3]);
                        } else if (size > 24 && size <= 26) {
                            sb.append(stars[4]);
                        } else if (size > 26 && size <= 28) {
                            sb.append(stars[5]);
                        }
                    } else {
                        sb.append(stars[6]);
                    }
                    place = false;
                }
                String out = new String(sb.toString().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
                output.print(out);
                output.print("<br>");
                sb.setLength(0);
            }
            output.close();
        } catch (IOException ex) {
            ex.printStackTrace();     
        }
        in.close();
    }

    

    

    

    

    
}
