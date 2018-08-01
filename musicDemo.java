package com.music;

import org.apache.hadoop.fs.Path; 

import org.apache.hadoop.conf.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat; 
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat; 
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat; 
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import com.music.musicmapper;
import com.music.musicreducer;

import org.apache.hadoop.io.IntWritable;



//import org.apache.hadoop.io.Text;
public class musicDemo 
{
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		Job job = new Job(conf, "musicDemo");
		job.setJarByClass(musicDemo.class);

		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setMapperClass(musicmapper.class);
		job.setReducerClass(musicreducer.class);
		 
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
       	FileInputFormat.addInputPath(job, new Path(args[0])); 
		FileOutputFormat.setOutputPath(job,new Path(args[1]));
         job.waitForCompletion(true);
		
		}

		
}

