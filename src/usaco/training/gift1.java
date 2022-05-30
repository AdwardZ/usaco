package usaco.training;
/*
ID: zhangzh69
LANG: JAVA
TASK: gift1
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class gift1 {
	/**
	 * USACO Section 1.2
	 */
	public static void main(String[] args) throws Exception{
		 // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        
        // 读第一行内容，是一个数字，表示一共有几个人
		String peopleCountStr = in.readLine();
		// 将第一行人数String转化为Integer
		int peopleCount = Integer.parseInt(peopleCountStr);
		LinkedHashMap<String, Integer> peopleMap = new LinkedHashMap<String, Integer>();
		// 根据读到的人数，继续往下读各行。比如人数是5，则往下读5行，每行表示一个人名。初始每人余额为0
		for (int i = 0; i < peopleCount; i++) {
			String key = in.readLine();
			Integer value = 0;
			peopleMap.put(key, value);
		}
		// 再接下来是某人取到钱，按规则分配。这是一个循环操作，直到所有人取完钱
		// 读第1行：表示第一个人名		
		String peopleName = in.readLine();
        while(peopleName != null && !peopleName.trim().equals("")){
        	// 读第2行：有两个值，第一个是总共取了多少钱，第二个是分配给几个人，中间空格分开，可以使用StringTokenizer
        	String totalAndCount = in.readLine();
        	StringTokenizer st = new StringTokenizer(totalAndCount);
        	// 一共取到多少钱
        	String totalMoneyStr = st.nextToken();
        	//System.out.println("totalMoneyStr=" + totalMoneyStr);
        	// 要分配给几个人
        	String divCountStr = st.nextToken();
        	//System.out.println("divCountStr=" + divCountStr);
        	int totalMoney = Integer.parseInt(totalMoneyStr);
        	int divCount = Integer.parseInt(divCountStr);
        	if(divCount > 0){
	        	// 每人分多少钱？
	        	int moneyPerPeople =  totalMoney / divCount;
	        	int remainMoney =  totalMoney % divCount;
	        	//System.out.println("moneyPerPeople="  +moneyPerPeople + ", remainMoney=" + remainMoney);
	        	
	        	for(int i=0;i < divCount;i++){
	        		String name = in.readLine();
	        		Integer myMoney = peopleMap.get(name);
	        		Integer nowMoney = myMoney + moneyPerPeople;
	        		peopleMap.put(name, nowMoney);
	        	}
	        	// 
	        	Integer myMoney = peopleMap.get(peopleName);
	    		Integer nowMoney = myMoney - totalMoney + remainMoney;//
	    		peopleMap.put(peopleName, nowMoney);
        	}
        	peopleName = in.readLine();
        }
        
        for(String key : peopleMap.keySet()){
        	String name = key;
        	Integer money  = peopleMap.get(key);
        	System.out.println("name="  +name + ", money=" + money);
        	out.println(name + " " + money);
        }        
        out.close();// close the output file
        in.close();
	}

}
