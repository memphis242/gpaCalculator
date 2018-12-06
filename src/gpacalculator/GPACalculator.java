/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpacalculator;

import java.util.*;
import java.io.*;

/**
 *
 * @author abdullah.almosalami
 */
public class GPACalculator {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
                
        String fileName = args[0];
        //String fileName = "C:\\Users\\abdullah.almosalami\\Documents\\NetBeansProjects\\GPACalculator\\transcript.txt";
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        
        double gpa;
        int totalCredits = 0, creditPoints = 0, courseLoad = 0;
        String temp;
        char grade;
        
        while( input.hasNext() ){
            
            temp = input.next();
            
            if( temp.equals("SPRING") || temp.equals("SUMMER") || temp.equals("FALL") )
            {
                
                //Skip paragraph title
                input.nextLine();
                
            } else if( temp.equals("END") )
            {
                break;
            } else
            {
                //TODO Make a key-valued pair data structure to hold all the courses, their credit load, and their grade
                
                while( !(temp.equals("SPRING") || temp.equals("SUMMER") || temp.equals("FALL") || temp.equals("END")) )
                {
                    //Skip past course name
                    //temp = input.next();
                    
                    //Get credit load for course
                    totalCredits += (courseLoad = input.nextInt());

                    //Obtain credit points earned for course
                    switch( grade = (temp = input.next()).charAt(0) )
                    {
                        case 'A': creditPoints += (4 * courseLoad);
                                  break;

                        case 'B': creditPoints += (3 * courseLoad);
                                  break;

                        case 'C': creditPoints += (2 * courseLoad);
                                  break;

                        case 'D': creditPoints += (1 * courseLoad);
                                  break;
                                  
                        case 'F': break;

                        default: break;

                    }
                    
                    //Have temp hold the course name
                    try
                    {
                        temp = (input.hasNext("SPRING") || input.hasNext("SUMMER") || input.hasNext("FALL")) ? "SPRING" : input.next();
                    } catch ( Exception e)
                    {
                        
                    }
                        
                }
                
            }
            
        }
        
        System.out.format("Your cumulative GPA with the entries you put in is: %.2f\n", calculateGPA(totalCredits, creditPoints));
    }
    
    private static double calculateGPA(int totalCredits, int creditPoints){
        return (creditPoints / (double) totalCredits);
    }
    
}
