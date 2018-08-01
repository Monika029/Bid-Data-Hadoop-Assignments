package com.shared;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class sharedReducer extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable>
{	
	
	public void reduce(IntWritable trackID,
			Iterable<IntWritable> sharedIDs,
			Reducer<IntWritable, IntWritable, IntWritable, IntWritable>.Context context)
					throws IOException, InterruptedException
	{
			int trackIDSet = 0;
	
			for(IntWritable sharedID : sharedIDs) {				
			 trackIDSet+=sharedID.get();
		}
		    IntWritable size = new IntWritable(trackIDSet);
				 context.write(trackID,size);
}
}

