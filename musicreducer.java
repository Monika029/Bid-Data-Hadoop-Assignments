package com.music;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class musicreducer extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable>
{	
	public void reduce(IntWritable trackID1,
			Iterable<IntWritable> userIDs,
			Reducer<IntWritable, IntWritable, IntWritable, IntWritable>.Context context)
					throws IOException, InterruptedException
	{
		Set<Integer> userIdSet = new HashSet<Integer>();
		 for (IntWritable userID1 : userIDs){
			 userIdSet.add(userID1.get());
		 }
		 IntWritable size = new IntWritable(userIdSet.size());
		 context.write(trackID1, size);
	}
}
