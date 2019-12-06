/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradetracker.gui;

import java.util.Date;
import gradetracker.logic.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kenmcclure
 */
public class Global {

     //This variable holds the reference to the student for the whole application
    public static Student me = new Student();
    
    private static SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
    public static boolean printDebugMessages=true;

    //the following code handles saving that object to file when changed
    //and loading it when the program starts up
  
    //note that any classes which are to be saved using this method
    //****must implement Serializable****
    
    //This is the name of the gile I want to save my data in
    private static String fileName = "GradeTrackerData.ser";
    //public static ArrayList<Score>=new ArrayList<Score>();
    
    
    
    public static void saveToFile() {
        try {
            FileOutputStream outputFile = new FileOutputStream(fileName);
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(outputFile);
            oos.writeObject(me);
            outputFile.close();
            Global.debug("Data file " + fileName + " has been saved");

        } catch (Exception e) {
            Global.debug("There was an error saving the file:");
            e.printStackTrace();
        }

    }

    public static void loadFromFile() {
        // check if file exists
        //load it into properties arraylist
        // if no create and empty properties arraylist

        FileInputStream fis;
        try {
            fis = new FileInputStream(fileName);
            ObjectInputStream ois;
            ois = new ObjectInputStream(fis);
            me = (Student) ois.readObject();
            fis.close();
            Global.debug("Loaded student data correctly");
        } catch (Exception e) {
            Global.debug("There is no datafile - creating a new one with some default data");
            generateSomeTestData();
            saveToFile();  //save this to file so that a file exists the next time
        }

    }

    static void generateSomeTestData() {
        //Making a student    

        Global.debug("Making some default test data");
        me = new Student();

        //adding some subjects
        me.addSubject("Comp Sci", "John", true, 4);
        me.addSubject("Biology", "Paul", true, 4);
        me.addSubject("Physics", "Ringo", true, 4);
        me.addSubject("Chemistry", "George", true, 4);
        me.addSubject("ESS", "Stuart", true, 4);

        //the last 2 I will add without a current level
        me.addSubject("DT", "Ken", true);
        //Art should be rejected as there are already 6 subjects
        me.addSubject("Art", "Clark", true);

        // print out the subject list just to check
         me.printsubjects();

        //how many subjects do I currently have?
        Global.debug("I'm studying " + me.subjects.size() + " subjects");

        //removing a subject
        me.removeSubject("DT");

        //how many subjects do I have now?
        Global.debug("I'm now studying " + me.subjects.size() + " subjects");

        //check DT has gone now
        Global.debug("DT SHOULD BE GONE NOW");
        me.printsubjects();

        //changing subject details
        Subject cs = me.getSubject("Comp Sci");
        cs.teacher = "Ken";
        cs.HLorNot = true;
        cs.currentLevel = 5;

        //Handling Assessments
        //Adding an IA
        Assessment newIA = new Assessment(new Date(), "The Project");
        Assessment newExam = new Assessment(new Date(), "Paper 1");
        Assessment newTest = new Assessment(new Date(), "Algorithms");

        cs.addAssessment(newIA);
        cs.addAssessment(newExam);
        cs.addAssessment(newTest);



    }
    
    public static void debug(String message){
        if (printDebugMessages){
            System.out.print(formatter.format(new Date())+"-->"+message);
        }
        
    }

}
