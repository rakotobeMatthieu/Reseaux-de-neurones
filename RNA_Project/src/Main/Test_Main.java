/*
 *  How to use WEKA API in Java 
 *  Copyright (C) 2014 
 *  @author Dr Noureddin M. Sadawi (noureddin.sadawi@gmail.com)
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it as you wish ... 
 *  I ask you only, as a professional courtesy, to cite my name, web page 
 *  and my YouTube Channel!
 *  
 */
package Main;
//import required classes
import java.util.ArrayList;
import java.util.List;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMOreg;
import weka.classifiers.trees.REPTree;
import Main.Main_Class;

public class Test_Main{
	public static void main(String args[]) throws Exception{
            Main_Class main = new Main_Class();
            String source="C:\\Users\\Matthieu\\Desktop\\DESKTOP\\BOSY\\M1\\Réseaux de neurone\\RNA_Project\\dataset\\iris.arff";
            String test="C:\\Users\\Matthieu\\Desktop\\DESKTOP\\BOSY\\M1\\Réseaux de neurone\\RNA_Project\\dataset\\iras.arff";
            
            System.out.println(main.newClassification(source, test));
            //main.arbreDeVisualisation(source);
	}
}