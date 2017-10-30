FileInputStream fis = new FileInputStream("svmmodel2.txt");
BufferedReader reader =new BufferedReader(new InputStreamReader(fis));
String line = reader.readLine();
libsvm.DefaultDataset data = new libsvm.DefaultDataset();
while(line != null){
           StringTokenizer st = new StringTokenizer(line,",");
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
           String cl = st.nextToken();
     double[] dd = new double[]{s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16};
     Instance instance = new DenseInstance(dd,cl);
     data.add(instance);
            line = reader.readLine();
        }
SVMhlpr svm = new SVMhlpr();
svm.buildClassifier(data);
System.out.println("Train file loaded");
int correct = 0, wrong = 0;
FileInputStream fis2 = new FileInputStream("lc.txt");
BufferedReader reader2 =new BufferedReader(new InputStreamReader(fis2));
String line2 = reader2.readLine();
while(line2 != null){
           StringTokenizer st = new StringTokenizer(line2,",");
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
     Instance inst = new DenseInstance(dd,cl);
     Object predictedClassValue = svm.classify(inst);
            Object realClassValue = inst.classValue();
            if (predictedClassValue.equals(realClassValue))
                correct++;
            else
                wrong++;
            line2 = reader2.readLine();
        }
System.out.println("Correct predictions  " + correct);
        System.out.println("Wrong predictions " + wrong);
