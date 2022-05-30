package usaco.training;

/*
ID: zhangzh69
LANG: JAVA
TASK: transform
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class transform {
	/**
	 * USACO Section 1.3
	 */
	public static void main(String[] args) throws Exception {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader in = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		// read first line
		String line1 = in.readLine();
		int size = Integer.parseInt(line1);
		char[][] beforeArray = new char[size][size];
		char[][] afterArray = new char[size][size];
		for(int i = 0; i < size; i++){
			String line = in.readLine();
			for(int j = 0; j < size; j++){
				beforeArray[i][j] = line.charAt(j);
				System.out.print(beforeArray[i][j] + ",");
 			}
			System.out.println();
		}
		System.out.println(">>>>>>>>>>>>>>>>>>");
		for(int i = 0; i < size; i++){
			String line = in.readLine();
			for(int j = 0; j < size; j++){
				afterArray[i][j] = line.charAt(j);
				System.out.print(afterArray[i][j] + ",");
 			}
			System.out.println();
		}
		System.out.println("<<<<<<<<<<<<<<<<<<");
		// 
		int findNo = 7;
		boolean isFind = false;
		// #1
		if(!isFind){
			boolean isAllEqual = true;
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					int m = (size - 1) - j;
					int n = i;
					System.out.println(beforeArray[m][n] + "=" + afterArray[i][j]);
					if(beforeArray[m][n] != afterArray[i][j]){
						isAllEqual = false;
						break;
					}
	 			}
				if(!isAllEqual){
					break;
				}
			}
			if(isAllEqual){
				findNo = 1;
				isFind = true; 
			}
		}
		
		// #2
		if(!isFind){
			boolean isAllEqual = true;
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					int m = (size - 1) - i;
					int n = (size - 1) - j;
					System.out.println(beforeArray[m][n] + "=" + afterArray[i][j]);
					if(beforeArray[m][n] != afterArray[i][j]){
						isAllEqual = false;
						break;
					}
	 			}
				if(!isAllEqual){
					break;
				}
			}
			if(isAllEqual){
				findNo = 2;
				isFind = true; 
			}
		}
		
		
		// #3
		if(!isFind){
			boolean isAllEqual = true;
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					int m = j;
					int n = (size - 1) - i;
					System.out.println(beforeArray[m][n] + "=" + afterArray[i][j]);
					if(beforeArray[m][n] != afterArray[i][j]){
						isAllEqual = false;
						break;
					}
	 			}
				if(!isAllEqual){
					break;
				}
			}
			if(isAllEqual){
				findNo = 3;
				isFind = true; 
			}
		}
		
		// #4
		if(!isFind){
			boolean isAllEqual = true;
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					int m = i;
					int n = (size - 1) - j;
					System.out.println(beforeArray[m][n] + "=" + afterArray[i][j]);
					if(beforeArray[m][n] != afterArray[i][j]){
						isAllEqual = false;
						break;
					}
	 			}
				if(!isAllEqual){
					break;
				}
			}
			if(isAllEqual){
				findNo = 4;
				isFind = true; 
			}
		}
		
		// #4.1
		if(!isFind){
			boolean isAllEqual = true;
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					int m = i;
					int n = (size - 1) - j;
					int p = (size - 1) - n;
					int q = m;
					System.out.println(beforeArray[p][q] + "=" + afterArray[i][j]);
					if(beforeArray[p][q] != afterArray[i][j]){
						isAllEqual = false;
						break;
					}
	 			}
				if(!isAllEqual){
					break;
				}
			}
			if(isAllEqual){
				findNo = 5;
				isFind = true; 
			}
		}
		
		
		// #4.2
		if(!isFind){
			boolean isAllEqual = true;
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					int m = i;
					int n = (size - 1) - j;
					int p = (size - 1) - m;
					int q = (size - 1) - n;
					System.out.println(beforeArray[p][q] + "=" + afterArray[i][j]);
					if(beforeArray[p][q] != afterArray[i][j]){
						isAllEqual = false;
						break;
					}
	 			}
				if(!isAllEqual){
					break;
				}
			}
			if(isAllEqual){
				findNo = 5;
				isFind = true; 
			}
		}		
		
		// #4.3
		if(!isFind){
			boolean isAllEqual = true;
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					int m = i;
					int n = (size - 1) - j;
					int p = n;
					int q = (size - 1) - m;
					System.out.println(beforeArray[p][q] + "=" + afterArray[i][j]);
					if(beforeArray[p][q] != afterArray[i][j]){
						isAllEqual = false;
						break;
					}
	 			}
				if(!isAllEqual){
					break;
				}
			}
			if(isAllEqual){
				findNo = 5;
				isFind = true; 
			}
		}
		
		
		// #6
		if(!isFind){
			boolean isAllEqual = true;
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					int m = (size - 1) - j;
					int n = i;
					System.out.println(beforeArray[m][n] + "=" + afterArray[i][j]);
					if(beforeArray[m][n] != afterArray[i][j]){
						isAllEqual = false;
						break;
					}
	 			}
				if(!isAllEqual){
					break;
				}
			}
			if(isAllEqual){
				findNo = 1;
				isFind = true; 
			}
		}		
		
		System.out.println("findNo=" + findNo);		
		// output to output file
		out.println(findNo);
		out.close();// close the output file
		in.close();
	}
}
