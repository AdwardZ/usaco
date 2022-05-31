import java.io.*;
import java.util.StringTokenizer;
/*
ID: zhangzh69
LANG: JAVA
TASK: ride
*/
public class ride {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st1 = new StringTokenizer(f.readLine());

        // Get line, break into tokens
        String s1 = st1.nextToken().toUpperCase();
        int size1 = s1.length();


        int sum1 = 1;
        for (int i = 0; i < size1; i++) {
            sum1 = sum1 * ((int) (s1.charAt(i)) - 64);
        }
        int mod1 = sum1 % 47;
        // System.out.println("s1="+ s1 + ",sum1=" + sum1 + ",mod1="+ mod1);

        StringTokenizer st2 = new StringTokenizer(f.readLine());
        String s2 = st2.nextToken().toUpperCase();
        int size2 = s2.length();
        int sum2 = 1;
        for (int i = 0; i < size2; i++) {
            sum2 = sum2 * ((int) (s2.charAt(i)) - 64);
        }
        int mod2 = sum2 % 47;
        // System.out.println("s2="+ s2 + ",sum2=" + sum2 + ",mod2="+ mod2);

        if (mod1 == mod2) {
            out.println("GO");
        } else {
            out.println("STAY");
        }
        out.close();// close the output file
        f.close();
    }
}
