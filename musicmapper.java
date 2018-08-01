package com.music;


import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;


	
	public class musicmapper extends Mapper<Object, Text, IntWritable, IntWritable> {
		
				IntWritable trackID= new IntWritable();
		IntWritable userID = new IntWritable();
	
		public void map(Object key, Text value,
				Mapper<Object, Text, IntWritable, IntWritable>.Context context) 
				throws IOException, InterruptedException {
			
			String[] lineArray = value.toString().split("[|]");
			userID.set(Integer.parseInt(lineArray[0]));
			trackID.set(Integer.parseInt(lineArray[1]));
			context.write(userID, trackID);
		}
	}
	
		

