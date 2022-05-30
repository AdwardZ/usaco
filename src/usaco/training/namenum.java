package usaco.training;

/*
ID: zhangzh69
LANG: JAVA
TASK: namenum
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class namenum {
	/**
	 * USACO Section 1.3
	 */
	public static void main(String[] args) throws Exception {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
		BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		// read first line
		ArrayList<String> dictList = new ArrayList<String>();
		String line = dict.readLine();
		while (line != null && !line.trim().equals("")) {
			dictList.add(line);
			line = dict.readLine();
		}
		// System.out.println("Dict.size=" + dictList.size());

		String line1 = in.readLine();
		// System.out.println("line1=" + line1);
		int size = line1.length();
		int[] numArr = new int[size];
		for (int i = 0; i < size; i++) {
			numArr[i] = Integer.parseInt(String.valueOf(line1.charAt(i)));
			//System.out.println("int[" + i + "]=" + numArr[i]);
		}

		// 2:A,B,C
		// 3:D,E,F
		// 4:G,H,I
		// 5:J,K,L
		// 6:M,N,O
		// 7:P,R,S
		// 8:T,U,V
		// 9:W,X,Y

		HashMap<Integer, String> charMap = new HashMap<Integer, String>();
		charMap.put(2, "ABC");
		charMap.put(3, "DEF");
		charMap.put(4, "GHI");
		charMap.put(5, "JKL");
		charMap.put(6, "MNO");
		charMap.put(7, "PRS");
		charMap.put(8, "TUV");
		charMap.put(9, "WXY");
		List<String> names = new ArrayList<String>();
		for (String dictName : dictList) {
			boolean same = true;
			if (size == dictName.length()) {
				for (int i = 0; i < size; i++) {
					int num = numArr[i];
					String str = charMap.get(num);
					char dictChar = dictName.charAt(i);
					if (str.indexOf(dictChar) == -1) {
						same = false;
						break;
					}
				}
				if (same){					
					names.add(dictName);
				}
			}
		}
		if (names.size() > 0) {
            for (String name : names) {
            	System.out.println(name);
                out.println(name);
            }
        } else {
        	System.out.println("NONE");
            out.println("NONE");
        }
		out.close();// close the output file
		in.close();
		dict.close();
	}
}
