package com.moviefinder;

public class Movie {
	
	private int year, audScore;
	private String title, rtUrl, imdbUrl;
	private String[] userTags;
	
	//Constructor - Query 1, 3, 4, 5
	public Movie(String title, int year, int audScore, String rtUrl, String imdbUrl) {
		this.title = title;
		this.year = year;
		this.audScore = audScore;
		this.rtUrl = rtUrl;
		this.imdbUrl = imdbUrl;
	}
	
	public int getYear() 			{ return year;		}
	public int getAudScore()		{ return audScore;	}
	public String getTitle() 		{ return title;		}
	public String getRtUrl() 		{ return rtUrl;		}
	public String getImdbUrl() 		{ return imdbUrl;	}
	public String[] getUserTags() 	{ return userTags;	}
	
}
