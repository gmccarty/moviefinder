package javapoint;

import java.io.BufferedReader;
import java.io.FileReader;  
public class LargeFileReader {  
    public static void main(String args[])throws Exception{    
          BufferedReader br = new BufferedReader(new FileReader ("C:\\Users\\Daniahome\\Documents\\Movie Finder Files\\movies.dat"));   
          int i;    
          while((i=br.read())!=-1)    
          System.out.print((char)i);    
          br.close();    
    }    
}    