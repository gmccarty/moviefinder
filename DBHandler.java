package moviefinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DBHandler {

		public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
			   Class.forName("com.mysql.cj.jdbc.Driver");   
			   Connection con = DriverManager.getConnection("jdbc:mysql://localhost/moviefinder?useSSL=false", "grantmcarty", "HelloWorld78#");
	           
			   Statement stmt=con.createStatement();   
			   String str="CREATE TABLE movies (title VARCHAR(255) NOT NULL, year YEAR(4), aud_score DECIMAL NOT NULL, RTPictureUrl VARCHAR(255), IMDBPictureUrl VARCHAR(255))";   
		       stmt.executeUpdate(str);
			   
			   stmt.executeUpdate("INSERT INTO movies VALUES('Toy Story', 1995, 92.0, 'http://content7.flixster.com/movie/10/93/63/10936393_det.jpg', 'https://www.imdb.com/title/tt0114709/mediaviewer/rm3813007616')");   
			   stmt.executeUpdate("INSERT INTO movies VALUES('Jumanji', 1995, 62.0, 'https://resizing.flixster.com/aQkeh9mK3o4op0Ndw-iFiShJFjo=/206x305/v1.bTsxMTIwODEwMTtqOzE4MjE5OzEyMDA7MjI1MDszMDAw', 'https://www.imdb.com/title/tt0113497/mediaviewer/rm496894208')");
			   stmt.executeUpdate("INSERT INTO movies VALUES('Grumpy Old Men', 1993, 63.0, 'https://resizing.flixster.com/DuNIjkEYNnv5l19VZdm-K1xJtgk=/206x305/v1.bTsxMTE3MzY2MTtqOzE4MjE5OzEyMDA7ODAwOzEyMDA', 'https://www.imdb.com/title/tt0107050/mediaviewer/rm1178533888')");
			   ResultSet rs=stmt.executeQuery("SELECT * FROM movies");   
			   while (rs.next()) {      
				   int year = rs.getInt("year"); 
				   String title = rs.getString("title");
				   String RTPictureUrl = rs.getString("RTPictureUrl");
				   String IMDBPictureUrl = rs.getString("IMDBPictureUrl");
				   System.out.print(title);
				   System.out.print(RTPictureUrl);
				   System.out.print(IMDBPictureUrl);
				   System.out.println("\t"+year);   
			   }   
			   stmt.close();   
			   con.close();    
		       
		BufferedReader br = new BufferedReader(new FileReader ("C:\\Users\\Daniahome\\Documents\\Movie Finder Files\\movies.dat"));   
        int i;    
        while((i=br.read())!=-1)    
        System.out.print((char)i);    
        br.close();    
  }    
}  