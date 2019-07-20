package com.moviefinder;
import java.sql.*;

public class DBHandler {
	
	
	@SuppressWarnings("finally")
	public Movie[] query1(int k) {
		Statement stmt = null;
		try {
			stmt = databaseConnector().createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		String sql = "SELECT title, year, aud_score, rt_url, imdb_url " +
					 "FROM movies " +
					 "ORDER BY aud_score DESC" +
					 "LIMIT " + k;
		Movie[] movies = new Movie[k];
		try {
			ResultSet rs = stmt.executeQuery(sql);
			int count = 0;
			while(rs.next()) {
				String name = rs.getString("title");
				int year = rs.getInt("year");
				int aud_score = rs.getInt("aud_score");
				String rt_url = rs.getString("rt_url");
				String imdb_url = rs.getString("imdb_url");
				Movie m = new Movie(name, year, aud_score, rt_url, imdb_url);
				movies[count] = m;
				count++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			return movies;
		}
	}
	
	public Movie query2(String title) {
		databaseConnector();
		
		
		
		return null;
	}
	
	public Movie query3(String genre, int k) {
		databaseConnector();
		
		
		
		return null;
	}
	
	public Movie query4(String director) {
		databaseConnector();
		
		
		
		return null;
	}
	
	public Movie query5(String actor) {
		databaseConnector();
		
		
		
		return null;
	}
	
	public Movie query6(String tag) {
		databaseConnector();
		
		
		
		return null;
	}
	
	public Movie query7(int k) {
		databaseConnector();
		
		
		
		return null;
	}
	
	public Movie query8(int k) {
		databaseConnector();
		
		
		
		return null;
	}
	
	public Movie query9(int k) {
		databaseConnector();
		
		
		
		return null;
	}
	
	public Movie query10(String title) {
		databaseConnector();
		
		
		
		return null;
	}
	
	@SuppressWarnings("finally")
	public Connection databaseConnector() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "De356fine");
			if (con != null) {
                System.out.println("Connected to the database");
			}
		}
		catch(SQLException e){
			System.out.println("An error occurred. Maybe user/password is invalid");
            e.printStackTrace();
		}
		finally {
           return con;
        }
	}
}
