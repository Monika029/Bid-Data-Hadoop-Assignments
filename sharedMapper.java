package com.shared;

import java.io.IOException;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class sharedMapper extends Mapper<Object, Text, IntWritable, IntWritable> {
	// private final static IntWritable one = new IntWritable(1);
	IntWritable sharedID= new IntWritable();
    IntWritable trackID = new IntWritable();

public void map(Object key, Text value,
	Mapper<Object, Text, IntWritable, IntWritable>.Context context) 
	throws IOException, InterruptedException {

       String[] lineArray = value.toString().split("[|]");
       trackID.set(Integer.parseInt(lineArray[1]));
       sharedID.set(Integer.parseInt(lineArray[2]));
       if(sharedID.get()!=0)
       context.write(this.trackID,sharedID);
       }
  }
