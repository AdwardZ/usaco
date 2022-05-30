package usaco.training;

/*
ID: zhangzh69
LANG: JAVA
TASK: <SubjecName>
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Templete {
	
	/**
	 * USACO Section *.* <br>
	 * This is the subject Template. <br>
	 * You can directly copy this Template to a new class before making a subject.<br>
	 * So you can save some time.
	 */
	public static void main(String[] args) throws Exception {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader in = new BufferedReader(new FileReader("<SubjecName>.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("<SubjecName>.out")));
		// read first line
		String line1 = in.readLine();		
		int size = Integer.parseInt(line1);
		// split first line to string
		StringTokenizer st = new StringTokenizer(line1);
		// get each string
		String str = st.nextToken();		
		System.out.println("size=" + size + ", str=" + str);
		
		
		
		
		
		// output to output file
		out.println(size + " " + str);
		out.close();// close the output file
		in.close();
	}
}
