package com.moviefinder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBHandler {

	private Connection connection;
	
	public DBHandler() {
		connect();
	}
	
	public ArrayList<Movie> query1(int k) throws SQLException {
		Statement stmt = getStatement();
		String sql = "SELECT title, year, aud_score, rt_url, imdb_url " +
				"FROM movies " +
				"ORDER BY aud_score DESC" +
				"LIMIT " + k;

		ArrayList<Movie> movies = new ArrayList<>();

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
		
		close(stmt, rs);
		return movies;
	}

	public ArrayList<Movie> query2(String title) throws SQLException {
		Statement stmt = getStatement();
		String sql = ""; 										//TODO: write query
		
		ArrayList<Movie> movies = new ArrayList<>();
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
																//TODO: extract data
		}
		
		close(stmt, rs);
		return movies;
	}
	
	public ArrayList<Movie> query3(String genre, int k) throws SQLException {
		Statement stmt = getStatement();
		String sql = "SELECT m.title, m.year, m.aud_score, m.rt_url, m.imdb_url " +
				"FROM movies m, movie_genres mg " +
				"WHERE m.movie_id = mg.movie_id AND mg.genre LIKE" + genre + " " +
				"ORDER BY aud_score DESC " +
				"LIMIT " + k;
		
		ArrayList<Movie> movies = new ArrayList<>();
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
		
		close(stmt, rs);
		return movies;
	}
	
	public ArrayList<Movie> query4(String director) throws SQLException {
		Statement stmt = getStatement();
		String sql = "SELECT m.title, m.year, m.aud_score, m.rt_url, m.imdb_url " +
				"FROM movies m, movie_directors md " +
				"WHERE m.movie_id = md.movie_id AND md.director_name LIKE " + director;
		
		ArrayList<Movie> movies = new ArrayList<>();
		
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
		
		close(stmt, rs);
		return movies;
	}

	public ArrayList<Movie> query5(String actor) throws SQLException {
		Statement stmt = getStatement();
		String sql = "SELECT m.title, m.year, m.aud_score, m.rt_url, m.imdb_url " +
				"FROM movies m, movie_actors ma " +
				"WHERE m.movie_id = ma.movie_id AND ma.actor_name LIKE " + actor;
		
		ArrayList<Movie> movies = new ArrayList<>();
		
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
		
		close(stmt, rs);
		return movies;
	}

	public ArrayList<Movie> query6(String tag) throws SQLException {
		Statement stmt = getStatement();
		String sql = ""; 										//TODO: write query
		
		ArrayList<Movie> movies = new ArrayList<>();
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
																//TODO: extract data
		}
		
		close(stmt, rs);
		return movies;
	}

	public ArrayList<Movie> query7(int k) throws SQLException {
		Statement stmt = getStatement();
		String sql = ""; 										//TODO: write query
		
		ArrayList<Movie> movies = new ArrayList<>();
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
																//TODO: extract data
		}
		
		close(stmt, rs);
		return movies;
	}

	public ArrayList<Movie> query8(int k) throws SQLException {
		Statement stmt = getStatement();
		String sql = ""; 										//TODO: write query
		
		ArrayList<Movie> movies = new ArrayList<>();
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
																//TODO: extract data
		}
		
		close(stmt, rs);
		return movies;
	}

	public ArrayList<Movie> query9(int k) throws SQLException {
		Statement stmt = getStatement();
		String sql = ""; 										//TODO: write query
		
		ArrayList<Movie> movies = new ArrayList<>();
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
																//TODO: extract data
		}
		
		close(stmt, rs);
		return movies;
	}

	public ArrayList<Movie> query10(String title) throws SQLException {
		Statement stmt = getStatement();
		String sql = ""; 										//TODO: write query
		
		ArrayList<Movie> movies = new ArrayList<>();
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
																//TODO: extract data
		}
		
		close(stmt, rs);
		return movies;
	}

	
	/* HELPERS */
	
	private void connect() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "De356fine");
			if (connection != null)
				System.out.println("Connected to the database.");
			
		} catch (SQLException e) {
			System.out.println("An error occurred. Check user credentials.");
			e.printStackTrace();
		}
	}
	
	private Statement getStatement() {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			System.out.println("An error occurred while creating Statement.");
			e.printStackTrace();
		}
		return null;
	}
	
	private void close(Statement stmt, ResultSet rs) {
		try {
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("An error occurred while closing Statment and ResultSet.");
			e.printStackTrace();
		}
	}
	
}
