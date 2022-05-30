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
import java.util.StringTokenizer;


public class milk2 {	
	/**
	 * USACO Section 1.3
	 */
	public static void main(String[] args) throws Exception {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		// read first line
		String line1 = in.readLine();		
		int size = Integer.parseInt(line1);

		ArrayList<WorkTime2> mergeWorkTimeList = new ArrayList<WorkTime2>();
		for(int i = 0; i < size; i++){
			String line = in.readLine();	
			StringTokenizer st = new StringTokenizer(line);
			String begTimeStr = st.nextToken();
			String endTimeStr = st.nextToken();
			Integer begTime = Integer.parseInt(begTimeStr);
			Integer endTime = Integer.parseInt(endTimeStr);
			// merge
			ArrayList<WorkTime2> newMergeWorkTimeList = new ArrayList<WorkTime2>();
			ArrayList<WorkTime2> coinCideWorkTimeList = new ArrayList<WorkTime2>();
			int mergeSize = mergeWorkTimeList.size();
			for(int j = 0; j < mergeSize; j++){
				WorkTime2 workTime = mergeWorkTimeList.get(j);
				Integer bTime = workTime.getBegTime();
				Integer eTime = workTime.getEndTime();
				if(eTime < begTime || bTime > endTime){// No Coincide
					newMergeWorkTimeList.add(workTime);
				} else {// Coincide
					coinCideWorkTimeList.add(workTime);
				}
			}
			// No Coincide
			if(coinCideWorkTimeList.isEmpty()){
				WorkTime2 workTime = new WorkTime2(begTime, endTime);
				mergeWorkTimeList.add(workTime);
			} else {// is Coincide
				WorkTime2 workTime = new WorkTime2(begTime, endTime);
				coinCideWorkTimeList.add(workTime);
				// Coincide -> one
				Integer startTime = -1;
				Integer finishTime = 0;
				for(WorkTime2 wt : coinCideWorkTimeList){
					int bTime = wt.getBegTime();
					int eTime = wt.getEndTime();
					if(startTime == -1){
						startTime = bTime;
					} else {
						if(startTime > bTime){
							startTime = bTime;
						}
					}
					if(finishTime < eTime){
						finishTime = eTime;
					}
				}				
				WorkTime2 mergeWorkTime = new WorkTime2(startTime, finishTime);
				newMergeWorkTimeList.add(mergeWorkTime);
				mergeWorkTimeList = newMergeWorkTimeList;
			}
		}
		// 
		java.util.Collections.sort(mergeWorkTimeList);
		int maxWorkTime = 0;
		int maxIdleTime = 0;
		WorkTime2 lastWorkTime = null;
		for(WorkTime2 workTime : mergeWorkTimeList){
			Integer begTime = workTime.getBegTime();
			Integer endTime = workTime.getEndTime();
			//System.out.println(">begTime=" + begTime + ", endTime=" + endTime);
			int wTime = endTime - begTime;
			if(maxWorkTime < wTime){
				maxWorkTime = wTime;
			}
			if(lastWorkTime != null){
				int idleTime = begTime - lastWorkTime.getEndTime();
				if(maxIdleTime < idleTime){
					maxIdleTime = idleTime;
				}
			}
			lastWorkTime = workTime;
		}
		
		System.out.println("maxWorkTime=" + maxWorkTime + ", maxIdleTime=" + maxIdleTime);
		// output to output file
		out.println(maxWorkTime + " " + maxIdleTime);
		out.close();// close the output file
		in.close();
	}
}


class WorkTime2 implements Comparable<WorkTime2>{
	private Integer begTime;
	private Integer endTime;

	public WorkTime2(Integer begTime, Integer endTime) {
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
	public int compareTo(WorkTime2 o) {
		return begTime.compareTo(o.getBegTime());
	}
}

