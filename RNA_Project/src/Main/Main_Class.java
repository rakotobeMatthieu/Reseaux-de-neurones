/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.core.converters.ArffSaver;
import java.io.File;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Debug.Random;
import java.lang.Object;
import weka.classifiers.functions.Logistic ;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFrame;

import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;
 import weka.core.Instances;
 import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.trees.REPTree;
 import weka.classifiers.trees.J48;
import java.util.ArrayList;
import java.util.List;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMOreg;
import weka.classifiers.trees.REPTree;
/**
/**
 *
 * @author Matthieu
 */
public class Main_Class {
    
    public String listData(String sourceFile){
        String rep="";
        try{
            DataSource source = new DataSource(sourceFile);

           Instances data = source.getDataSet();
           data.setClassIndex(data.numAttributes() - 1);
           J48 classifier = new J48();
           classifier.buildClassifier(data);
           Logistic classifier2 = new Logistic();

           Evaluation eval = new Evaluation(data);
           eval.crossValidateModel(classifier, data, 10, new Random(1));

            rep = data.toString();
        }catch(Exception e){
            
        }
        return rep;
    }
    public String summary(String sourceFile){
        String rep ="";
        try{
            DataSource source = new DataSource(sourceFile);
            Instances data = source.getDataSet();
            data.setClassIndex(data.numAttributes() - 1);
            
            J48 classifier = new J48();
            classifier.buildClassifier(data);

            Evaluation eval = new Evaluation(data);
            eval.crossValidateModel(classifier, data, 10, new Random(1));
            
            rep=eval.toSummaryString("RESULTATS GLOBALES", false);
            

           /* System.out.println(data.numInstances()+" instances loaded.");
            System.out.println(data.toString());
            System.out.println(eval.toSummaryString("RESULTATS GLOBALES", false));*/
            
        }catch(Exception e){
            e.printStackTrace();
        }
            return rep;
    }
    
    public String confusionMatrix(String sourceFile){
        String rep="";
        try{
            DataSource source = new DataSource(sourceFile);
            Instances data = source.getDataSet();
            data.setClassIndex(data.numAttributes() - 1);
            
            J48 classifier = new J48();
            classifier.buildClassifier(data);
            
            Evaluation eval = new Evaluation(data);
            eval.crossValidateModel(classifier, data, 10, new Random(1));
            
            Random rand = new Random(1);  // using seed = 1
            int folds = 10;
            eval.crossValidateModel(classifier, data, folds, rand);
            //System.out.println(eval.toMatrixString());
            
            rep=eval.toMatrixString("MATRICE DE CONFUSION");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }
    
    
    public String newClassification(String sourceFile , String testFile){
        String rep="";
        try{
            List<String> classes = new ArrayList<String>() {
                {
                    add("Iris-setosa");
                    add("Iris-versicolor");
                    add("Iris-virginica");
                }
            };
		//load training dataset
		DataSource source = new DataSource(sourceFile);
		Instances trainDataset = source.getDataSet();	
		//set class index to the last attribute
		trainDataset.setClassIndex(trainDataset.numAttributes()-1);

		//build model
		REPTree smo = new REPTree();
		smo.buildClassifier(trainDataset);
		//output model
		System.out.println(smo);

		//load new dataset
		DataSource source1 = new DataSource(testFile);
		Instances testDataset = source1.getDataSet();	
		//set class index to the last attribute
		testDataset.setClassIndex(testDataset.numAttributes()-1);

		//loop through the new dataset and make predictions
		/*System.out.println("===================");
		System.out.println("Actual Class, SMO Predicted");*/
		for (int i = 0; i < testDataset.numInstances(); i++) {
			//get class double value for current instance
			double actualValue = testDataset.instance(i).classValue();

			//get Instance object of current instance
			Instance newInst = testDataset.instance(i);
			//call classifyInstance, which returns a double value for the class
			double predSMO = smo.classifyInstance(newInst);
                        
                        String valeur_act = "";
                        String prediction="";
                        if(new Double(actualValue).isNaN()){
                            //System.out.println("Inconnu , "+classes.get(new Double(predSMO).intValue()));
                            rep = rep +""+"Inconnu , "+classes.get(new Double(predSMO).intValue())+"<br>";
                        }else{rep = rep +""+classes.get(new Double(predSMO).intValue())+", "+classes.get(new Double(predSMO).intValue())+"<br>";
                            //System.out.println(classes.get(new Double(predSMO).intValue())+", "+classes.get(new Double(predSMO).intValue()));
                        }
			
		}
        }catch(Exception e){
            
        }
        return rep;
    }
            
    public void arbreDeVisualisation(String sourceFile){
        try{
            DataSource source = new DataSource(sourceFile);
            Instances data = source.getDataSet();
            data.setClassIndex(data.numAttributes() - 1);
            
            J48 classifier = new J48();
            classifier.buildClassifier(data);        
        
            TreeVisualizer tv = new TreeVisualizer(null, classifier.graph(), new PlaceNode2());

            
            JFrame frame = new javax.swing.JFrame("Tree Visualizer");
            frame.setSize(800, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.getContentPane().add(tv);
            frame.setVisible(true);

            tv.fitToScreen();        
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    
    public String arbreDeVisualisation1(String sourceFile){
        String rep="";
        try{
            DataSource source = new DataSource(sourceFile);
            Instances data = source.getDataSet();
            data.setClassIndex(data.numAttributes() - 1);
            
            J48 classifier = new J48();
            classifier.buildClassifier(data);    
            
            REPTree model = new REPTree();
            model.buildClassifier(data);
            
            rep = ""+model;
        }catch(Exception e){
            e.printStackTrace();
        }
        return rep;
    }
}
