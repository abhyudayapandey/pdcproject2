import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class svmlib  {

	public static void main(String args[]) throws Exception {

		Configuration conf = new Configuration();
		 
		Job job = Job.getInstance(conf, "svmlib");

		job.setJarByClass(svmlib.class);
		 
		job.setMapperClass(TmpltMapper.class);
		job.setCombinerClass(TmpltCombiner.class);
		job.setReducerClass(TmpltReducer.class);
		 
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		 
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		 
		job.waitForCompletion(true);
		
			public static class TmpltReducer extends
			Reducer<Text, IntWritable, Text, IntWritable> {
		@Override
		public void reduce(Text key, Iterable<IntWritable> values,
				Context context) throws IOException, InterruptedException {
		      for (IntWritable value : values) {

		      }
			 context.write(key, new IntWritable(0));
		}
	}
	}


	public static class TmpltMapper extends
			Mapper<LongWritable, Text, Text, IntWritable> {
		@Override
		public void map(LongWritable key, Text value, Mapper.Context context)
				throws IOException, InterruptedException {
				context.write(new Text("MKEY"), value);

		}
	}

	public static class TmpltReducer extends
			Reducer<Text, IntWritable, Text, Text> {
		@Override
		public void reduce(Text key, Iterable<Text> values,
				Context context) throws IOException, InterruptedException {
for (Text value : values) {
context.write(key,value);
}

		}
	}
	
		public static class TmpltCombiner extends
			Reducer<Text, IntWritable, Text, Text> {
		@Override
		public void reduce(Text key, Iterable<Text> values,
				Context context) throws IOException, InterruptedException {
Dataset data = new DefaultDataset();

Iterator<Text> itr = values.iterator();
   while (itr.hasNext()) {
     String text = itr.next().toString();
    StringTokenizer st = new StringTokenizer(text,",");
    String cl = st.nextToken();
     double s1 = Double.parseDouble(st.nextToken());
     double s2 = Double.parseDouble(st.nextToken());
     double s3 = Double.parseDouble(st.nextToken());
     double s4 = Double.parseDouble(st.nextToken());
     double s5 = Double.parseDouble(st.nextToken());
     double s6 = Double.parseDouble(st.nextToken());
     double s7 = Double.parseDouble(st.nextToken());
     double s8 = Double.parseDouble(st.nextToken());
     double s9 = Double.parseDouble(st.nextToken());
     double s10 = Double.parseDouble(st.nextToken());
     double s11 = Double.parseDouble(st.nextToken());
     double s12 = Double.parseDouble(st.nextToken());
     double s13 = Double.parseDouble(st.nextToken());
     double s14 = Double.parseDouble(st.nextToken());
     double s15 = Double.parseDouble(st.nextToken());
     double s16 = Double.parseDouble(st.nextToken());
     double[] dd = new double[]{s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16};
     Instance instance = new DenseInstance(dd,cl);
     data.add(instance);
   }

 SVMhlpr a = new SVMhlpr();

   int[] rs =a.buildClassifier(data);
        for (int i = 0; i < rs.length; i++) {
        String ss=data.get(rs[i]-1).value(0)+","+data.get(rs[i]-1).value(1)+","+data.get(rs[i]-1).value(2)+","+data.get(rs[i]-1).value(3)+","+data.get(rs[i]-1).value(4)+","+data.get(rs[i]-1).value(5)+","+data.get(rs[i]-1).value(6)+","+data.get(rs[i]-1).value(7)+","+data.get(rs[i]-1).value(8)+","+data.get(rs[i]-1).value(9)+","+data.get(rs[i]-1).value(10)+","+data.get(rs[i]-1).value(11)+","+data.get(rs[i]-1).value(12)+","+data.get(rs[i]-1).value(13)+","+data.get(rs[i]-1).value(14)+","+data.get(rs[i]-1).value(15)+","+data.get(rs[i]-1).classValue();
        context.write(key, new Text(ss));
        }

		}
	}

}
