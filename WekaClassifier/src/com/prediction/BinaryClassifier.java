package com.prediction;

import java.io.File;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;//csv file cleaned of single and double quotes and other characters which may impede converting
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class BinaryClassifier {

	public static void main(String[] args) throws Exception{
		
		// load CSV file
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File("C:\\\\Users\\\\thesk\\\\eclipse-workspace\\\\crowdsource2018_copy.csv"));
		Instances data = loader.getDataSet();
		
		// save as ARFF as requested by the Java ML library Weka
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File("C:\\Users\\thesk\\eclipse-workspace\\crowdsource2018_copy.arff"));
		saver.writeBatch();
		
		DataSource source = new DataSource("C:\\Users\\thesk\\eclipse-workspace\\crowdsource2018_copy.arff");
		Instances df = source.getDataSet();
		df.setClassIndex(df.numAttributes()-1);

		Remove remove = new Remove();
		int[] indices = {0, 1};//index from 0
		remove.setAttributeIndicesArray(indices);
		//remove.setAttributeIndices("4"); //if need to remove only one column, Weka reranks the columns, starts with 1, here removes the 4th column
        remove.setInputFormat(df);
		Instances newdf = Filter.useFilter(df, remove);
		System.out.println(newdf);
		
		NaiveBayes nb = new NaiveBayes();
		nb.buildClassifier(newdf);
		Evaluation eval = new Evaluation(newdf);
		eval.evaluateModel(nb, newdf);
		System.out.println(eval.toSummaryString());

	}
}
