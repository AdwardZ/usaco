package usaco.training;

/*
ID: zhangzh69
LANG: JAVA
TASK: beads
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class beads {	
	/**
	 * USACO Section 1.2
	 */
	public static void main(String[] args) throws Exception{
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader in = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		// read first line
		String line1 = in.readLine();
		String line2 = in.readLine();
		// split first line to string
		// StringTokenizer st = new StringTokenizer(lineStr);
		// get each string
		// String str = st.nextToken();
		//System.out.println("line1=" + line1);
		//System.out.println("line2=" + line2);
		
		int size = Integer.parseInt(line1);
		char[] beads = new char[size];
		for(int i = 0; i < size; i++){
			beads[i] = line2.charAt(i);
		}
		
		int totalSize = 0;
		// b r w
		for(int i = 0; i < size; i++){
		//for(int i = 1; i < 2; i++){
			int leftMax = 0;
			int rightMax = 0;
			int count = 0;
			
			// right
			int rightBegIndex = i;
			char firstRightChar =  beads[rightBegIndex];
			do {
				rightMax++;
				int nextIndex = rightBegIndex + 1;
				if(nextIndex > (size - 1)){
					nextIndex = 0;
				}
				char nextChar = beads[nextIndex];
				//System.out.println(">> rightBegIndex=" + rightBegIndex + ",nextIndex=" + nextIndex + " > " + firstRightChar + "," + nextChar);
				if(firstRightChar == 'r' || firstRightChar == 'b'){
					if(nextChar == firstRightChar || nextChar == 'w'){

					} else {
						break;
					}
				} else {// w
					if(nextChar == 'b'){
						firstRightChar = 'b';
					} else if(nextChar == 'r'){
						firstRightChar = 'r';
					} else {
						// w						
					}
				}
				//
				rightBegIndex++;
				if(rightBegIndex > (size - 1)){
					rightBegIndex = 0;
				}
				count++;
			} while (count < size);
			//System.out.println("## right=" + rightMax);
			
			
			int remainCount = size - rightMax;
			if(remainCount > 0){			
				// left
				int leftBegIndex = i - 1;
				if(leftBegIndex < 0){
					leftBegIndex = size - 1;
				}
				count = 0;
				char firstLeftChar =  beads[leftBegIndex];
				do {
					leftMax++;
					int nextIndex = leftBegIndex - 1;
					if(nextIndex < 0){
						nextIndex = size - 1;
					}
					char nextChar = beads[nextIndex];
					//System.out.println("<< leftBegIndex=" + leftBegIndex + ",nextIndex=" + nextIndex + " > " + firstLeftChar + "," + nextChar);
					if(firstLeftChar == 'r' || firstLeftChar == 'b'){
						if(nextChar == firstLeftChar || nextChar == 'w'){
	
						} else {
							break;
						}
					} else {// w
						if(nextChar == 'b'){
							firstLeftChar = 'b';
						} else if(nextChar == 'r'){
							firstLeftChar = 'r';
						} else {
							// w						
						}
					}
					//
					leftBegIndex--;
					if(leftBegIndex < 0){
						leftBegIndex = size - 1;
					}
					count++;
				} while (count < remainCount);
				//System.out.println("## left=" + leftMax);
				//System.out.println("@@ Max=" + (leftMax + rightMax));
			}
			//
			if(totalSize < (leftMax + rightMax)){
				totalSize = leftMax + rightMax;
			}
		}
		System.out.println("Final Size=" + totalSize);
		out.println(totalSize);
		// out.println(name + " " + money);
		out.close();// close the output file
		in.close();
	}
}
