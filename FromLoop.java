/* File:	FromLoop.java
 * Author:	Stephen
 * Date:	11/09/2016
 * Purpose:	Adaptation of Coursera exercise for Python.
 * 		Reads through a file and finds all lines that
 *              Start with "From :" and extracts Email addresses.
 */

import java.io.*;  // Imports BufferReader and FileReader classes
import java.util.regex.*;  // Imports Pattern and Matcher classes
import java.util.ArrayList;
import java.util.HashSet;

public class FromLoop {
    public static void main(String[] args) throws java.io.IOException {

      //  Declare Local Variables
      int count = 0;
      String line;
      String pattern = "\\S+@\\S+";

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Create List Container 
      ArrayList<String> l = new ArrayList<String>();
      
      //  Read in the file
      FileReader in = new FileReader("mbox-short.txt");
      BufferedReader br = new BufferedReader(in);

      //  Loops through file line by line
      while ((line = br.readLine()) != null) {
 
            //  Extracts lines that start with "From: "
            if (line.startsWith("From: ")) {
               Matcher m = r.matcher(line);
               if (m.find()) {
                  System.out.println("Found Email: " + m.group(0));
                  l.add(m.group(0));  //  Adds email to list
               }  // End if
               count++;
            }  // End if
      }  // End While
      System.out.println("Number of Lines: " + count);
      System.out.println(l);
      ArrayList<String> newList = new ArrayList<String>(new HashSet<String>(l));
      System.out.println(newList);
    }  // End Main
}  //  End FromLoop

