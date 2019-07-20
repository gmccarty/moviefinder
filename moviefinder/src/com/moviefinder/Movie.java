package com.moviefinder;

public class Movie {
	
	private String title, rtUrl, imdbUrl;
	private int year, audScore;
	private String[] userTags;
	
	//Constructor for Query 1 
	public Movie(String title, int year, int audScore, String rtUrl, String imdbUrl) {
		this.title = title;
		this.year = year;
		this.audScore = audScore;
		this.rtUrl = rtUrl;
		this.imdbUrl = imdbUrl;
	}
	
	
	
	
}
