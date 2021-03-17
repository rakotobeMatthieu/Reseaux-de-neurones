/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backup;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.Logistic;
import weka.classifiers.trees.J48;
import weka.core.Debug;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author Matthieu
 */
public class test_and_set {
      public static void main(String args[]) throws Exception{
    /*DataSource source = new DataSource("dataset/beach.arff");
    Instances data = source.getDataSet();
    System.out.println(data.numInstances()+" instances loaded.");
    System.out.println(data.toString());
    
    
    
    String[] opts = new String[]{ "-R", "2"};
    Remove remove = new Remove();  
    remove.setOptions(opts);
    remove.setInputFormat(data); 
    Instances newData = Filter.useFilter(data, remove);
    
    
    AttributeSelection filter = new AttributeSelection();  // package weka.filters.supervised.attribute!
    CfsSubsetEval eval = new CfsSubsetEval();
    GreedyStepwise search = new GreedyStepwise();
    search.setSearchBackwards(true);
    filter.setEvaluator(eval);
    filter.setSearch(search);
    filter.setInputFormat(data);
    Instances newData2 = Filter.useFilter(data, filter);

    
    String[] options = new String[1];
    options[0] = "-U";
    J48 tree = new J48();
    tree.setOptions(options);
    tree.buildClassifier(data);*/
    
      // SUMMARY -----------------------------------
    ConverterUtils.DataSource source = new ConverterUtils.DataSource("dataset/iris.arff");

    Instances data = source.getDataSet();
    data.setClassIndex(data.numAttributes() - 1);
    J48 classifier = new J48();
    classifier.buildClassifier(data);
    Logistic classifier2 = new Logistic();

    Evaluation eval = new Evaluation(data);
    eval.crossValidateModel(classifier, data, 10, new Debug.Random(1));

    
    
    System.out.println(data.numInstances()+" instances loaded.");
    System.out.println(data.toString());
    System.out.println("---------------------------------------------");
    System.out.println(eval.toSummaryString("Results\n ", false));
    System.out.println("---------------------------------------------");
    
    
    // CONFUSION MATRIX -----------------------------------
    Debug.Random rand = new Debug.Random(1);  // using seed = 1
    int folds = 10;
    eval.crossValidateModel(classifier, data, folds, rand);
    System.out.println(eval.toMatrixString());
    
    
    // TREE VISUALIZER -----------------------------------
    /*TreeVisualizer tv = new TreeVisualizer(null, classifier.graph(), new PlaceNode2());

    JFrame frame = new javax.swing.JFrame("Tree Visualizer");
    frame.setSize(800, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.getContentPane().add(tv);
    frame.setVisible(true);

    tv.fitToScreen();
    */
  }
}
