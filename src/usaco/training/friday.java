package usaco.training;
/*
ID: zhangzh69
LANG: JAVA
TASK: friday
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class friday {
	/**
	 * USACO Section 1.2
	 */
	public static void main(String[] args) throws Exception{
		 // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader in = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

		String yearsStr = in.readLine();
		int years = Integer.parseInt(yearsStr);
		//System.out.println("N=" + years);
		// 1990-1-1 -> Monday
		int beginYear = 1900;
		int weekDayCount[] = new int[7];// 0-monday 6-sunday
		int weekDay = 1;// 1-7 monday - sunday
		for(int i = 0; i < years; i++){
			int year = beginYear + i;
			//System.out.println("Year=" + year);
			// isLeapYear?
			boolean isLeapYear = false;
			if(year % 100 == 0){
				if(year % 400 == 0){
					isLeapYear = true;
				}
			} else {
				if(year % 4 == 0){
					isLeapYear = true;
				}
			}			
			for(int j = 0; j < 12; j++){
				int monthDay = 1;// 1-maxMonthDay
				int maxMonthDay = 0;// 31/30/28/29
				if(j == 1){// 2
					if(isLeapYear){
						maxMonthDay = 29;
					} else {
						maxMonthDay = 28;
					}
				} else if(j == 8 || j == 3 || j == 5 || j == 10){// 9 4 6 11
					maxMonthDay = 30;					
				} else {
					maxMonthDay = 31;
				}
				//
				for(int k = 0; k < maxMonthDay; k++){
					monthDay = k + 1;
					//String day = year + "/" + (j + 1) + "/" + monthDay;					
					if(monthDay == 13){
						weekDayCount[weekDay - 1]++;						
						//day = day + "  >>>> weekDay=" + weekDay + ", count=" + weekDayCount[weekDay - 1];
					}					
					//System.out.println(day);		
					weekDay++;// week day ++
					if(weekDay > 7){
						weekDay = 1;
					}
				}// for month day 31				
			}// for month 12
		}// for year
		
		// 36 33 34 33 35 35 34
		String result = weekDayCount[5] + " " + weekDayCount[6] + " " + weekDayCount[0] + " " + weekDayCount[1] + " " + weekDayCount[2] + " " + weekDayCount[3] + " " + weekDayCount[4];
		System.out.println(result);
		out.println(result);
		// 
        out.close();// close the output file
        in.close();
	}
}
