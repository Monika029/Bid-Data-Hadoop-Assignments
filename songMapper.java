package com.song;

import java.io.IOException;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class songMapper extends Mapper<Object, Text, IntWritable, IntWritable> {
	// private final static IntWritable one = new IntWritable(1);
	IntWritable listenID= new IntWritable();
    IntWritable trackID = new IntWritable();

public void map(Object key, Text value,
	Mapper<Object, Text, IntWritable, IntWritable>.Context context) 
	throws IOException, InterruptedException {

       String[] lineArray = value.toString().split("[|]");
       trackID.set(Integer.parseInt(lineArray[1]));
       listenID.set(Integer.parseInt(lineArray[4]));
       if(listenID.get()!=0)
       context.write(this.trackID,listenID);
       }
  }
