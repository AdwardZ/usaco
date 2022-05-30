package usaco.training;

/*
ID: zhangzh69
LANG: JAVA
TASK: milk2
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class milk3 {
	/**
	 * USACO Section 1.3 <br>
	 * Another solution to "milk2" problem.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

		String sizeStr = in.readLine();
		int size = Integer.parseInt(sizeStr);
		
		ArrayList<WorkTime3> workTimeList = new ArrayList<WorkTime3>();
		for (int i = 0; i < size; i++) {
			String startEndStr = in.readLine();
			StringTokenizer st = new StringTokenizer(startEndStr);
			String startTimeStr = st.nextToken();
			int startTime = Integer.parseInt(startTimeStr);
			String endTimeStr = st.nextToken();
			int endTime = Integer.parseInt(endTimeStr);
			WorkTime3 workTime = new WorkTime3(startTime, endTime);
			workTimeList.add(workTime);
		}
		
		Collections.sort(workTimeList);
		
		int maxWorkTime = 0;
		int maxIdleTime = 0;
		int lastMinBegTime = 0;
		int lastMaxEndTime = 0;
		for (int i = 0; i < size; i++) {
			WorkTime3 workTime = workTimeList.get(i);
			Integer begTime = workTime.getBegTime();
			Integer endTime = workTime.getEndTime();
			//System.out.println(begTime + " " + endTime);
			if (i == 0) {
				lastMinBegTime = begTime;
				lastMaxEndTime = endTime;
				maxWorkTime = endTime - begTime;
				maxIdleTime = 0;
				continue;
			}
			//
			if(endTime <= lastMaxEndTime){
				continue;
			}
			//
			if (begTime <= lastMaxEndTime) {
				lastMaxEndTime = endTime;
				int tempWorkTime = lastMaxEndTime - lastMinBegTime;
				if (tempWorkTime > maxWorkTime) {
					maxWorkTime = tempWorkTime;
					//System.out.println("#[" + begTime + "," + endTime + "] maxWorkTime=" + maxWorkTime + ",maxIdleTime=" + maxIdleTime);
				}
			} else {// begTime > maxEndTime
				int idleTime = begTime - lastMaxEndTime;
				if (idleTime > maxIdleTime) {
					maxIdleTime = idleTime;
				}
				int tempWorkTime = endTime - begTime;
				if (tempWorkTime > maxWorkTime) {
					maxWorkTime = tempWorkTime;
				}
				//System.out.println("@[" + begTime + "," + endTime + "] maxWorkTime=" + maxWorkTime + ",maxIdleTime=" + maxIdleTime);
				lastMinBegTime = begTime;
				lastMaxEndTime = endTime;
			}
		}

		System.out.println("maxWorkTime=" + maxWorkTime + " maxIdleTime=" + maxIdleTime);
		out.println(maxWorkTime + " " + maxIdleTime);
		out.close();
		in.close();
	}

}


class WorkTime3 implements Comparable<WorkTime3>{
	private Integer begTime;
	private Integer endTime;

	public WorkTime3(Integer begTime, Integer endTime) {
		super();
		this.begTime = begTime;
		this.endTime = endTime;
	}

	public Integer getBegTime() {
		return begTime;
	}

	public void setBegTime(Integer begTime) {
		this.begTime = begTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	@Override
	public int compareTo(WorkTime3 o) {
		return begTime.compareTo(o.getBegTime());
	}
}
