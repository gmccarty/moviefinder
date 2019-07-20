package com.moviefinder;
import java.sql.*;
import java.util.*;

public class DBHandler {
	
	
	@SuppressWarnings("finally")
	public ArrayList<Movie> query1(int k) {
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
		ArrayList<Movie> movies = new ArrayList<>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString("title");
				int year = rs.getInt("year");
				int aud_score = rs.getInt("aud_score");
				String rt_url = rs.getString("rt_url");
				String imdb_url = rs.getString("imdb_url");
				Movie m = new Movie(name, year, aud_score, rt_url, imdb_url);
				movies.add(m);
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			return movies;
		}
		
		
	}
	
	public ArrayList<Movie> query2(String title) {
		Statement stmt = null;
		try {
			stmt = databaseConnector().createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		
		
		
		return null;
	}
	
	@SuppressWarnings("finally")
	public ArrayList<Movie> query3(String genre, int k) {
		Statement stmt = null;
		try {
			stmt = databaseConnector().createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		String sql = "SELECT m.title, m.year, m.aud_score, m.rt_url, m.imdb_url " +
				 	 "FROM movies m, movie_genres mg " +
				 	 "WHERE m.movie_id = mg.movie_id AND mg.genre LIKE" + genre + " " +
				 	 "ORDER BY aud_score DESC " +
				 	 "LIMIT " + k;
		ArrayList<Movie> movies = new ArrayList<>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString("title");
				int year = rs.getInt("year");
				int aud_score = rs.getInt("aud_score");
				String rt_url = rs.getString("rt_url");
				String imdb_url = rs.getString("imdb_url");
				Movie m = new Movie(name, year, aud_score, rt_url, imdb_url);
				movies.add(m);
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			return movies;
		}

	}
	
	@SuppressWarnings("finally")
	public ArrayList<Movie> query4(String director) {
		Statement stmt = null;
		try {
			stmt = databaseConnector().createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		String sql = "SELECT m.title, m.year, m.aud_score, m.rt_url, m.imdb_url " +
					 "FROM movies m, movie_directors md " +
					 "WHERE m.movie_id = md.movie_id AND md.director_name LIKE " + director;
		ArrayList<Movie> movies = new ArrayList<>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString("title");
				int year = rs.getInt("year");
				int aud_score = rs.getInt("aud_score");
				String rt_url = rs.getString("rt_url");
				String imdb_url = rs.getString("imdb_url");
				Movie m = new Movie(name, year, aud_score, rt_url, imdb_url);
				movies.add(m);
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			return movies;
		}
		
	}
	
	public ArrayList<Movie> query5(String actor) {
		Statement stmt = null;
		try {
			stmt = databaseConnector().createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		String sql = "SELECT m.title, m.year, m.aud_score, m.rt_url, m.imdb_url " +
				 "FROM movies m, movie_actors ma " +
				 "WHERE m.movie_id = ma.movie_id AND ma.actor_name LIKE " + actor;
		ArrayList<Movie> movies = new ArrayList<>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString("title");
				int year = rs.getInt("year");
				int aud_score = rs.getInt("aud_score");
				String rt_url = rs.getString("rt_url");
				String imdb_url = rs.getString("imdb_url");
				Movie m = new Movie(name, year, aud_score, rt_url, imdb_url);
				movies.add(m);
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			return movies;
		}
		
		

	}
	
	public ArrayList<Movie> query6(String tag) {
		Statement stmt = null;
		try {
			stmt = databaseConnector().createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		
		
		
		return null;
	}
	
	public ArrayList<Movie> query7(int k) {
		Statement stmt = null;
		try {
			stmt = databaseConnector().createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		
		
		
		return null;
	}
	
	public ArrayList<Movie> query8(int k) {
		Statement stmt = null;
		try {
			stmt = databaseConnector().createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		
		
		
		return null;
	}
	
	public ArrayList<Movie> query9(int k) {
		Statement stmt = null;
		try {
			stmt = databaseConnector().createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		
		
		
		return null;
	}
	
	public ArrayList<Movie> query10(String title) {
		Statement stmt = null;
		try {
			stmt = databaseConnector().createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		
		
		
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
