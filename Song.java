// Eza Rasheed
// er6qt
// Homework 4

public class Song implements Comparable<Song>, Playable {
	
	/** Declaring fields in Song class **/
	private String artist; 
	private String title; 
	private int minutes; 
	private int seconds; 
	

	/** Getters and Setters for all fields **/
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
	    this.artist = artist;
	}
	public String getTitle() {
	    return title;
	}
	public void setTitle(String title) {
	    this.title = title;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	
	/** Three song constructors that initialize all the fields, regardless of the given parameters **/
	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title;
	    this.minutes = 0;
	    this.seconds = 0;
	}
	
	public Song(String artist, String title, int minutes, int seconds) {
		this.artist= artist;
	    this.title = title;
	    this.minutes = minutes;
	    this.seconds = seconds;
	}
	
	public Song(Song s) {
		this.title = s.getTitle();
		this.artist = s.getArtist();
		this.minutes = s.getMinutes();
		this.seconds = s.getSeconds();
	}
	
	
	/** equals method that checks to see if two songs are equal, depending on if all the fields are the exact same(equal) **/
	public boolean equals(Object o)  {
		if(o instanceof Song){
			Song s = (Song) o;
			return ((getArtist().equals(s.getArtist())) && (getTitle().equals(s.getTitle())) && (this.minutes == s.minutes) && (this.seconds == s.seconds));
		}
		else
			return false;
	}
	
	
	/** toString method code copied from instructions **/
	public String toString() { 
		return "{Song: title = " + title + " artist = " + artist + "}";
	}
	
	

	/** play method code copied from instructions **/
	public void play() {
		System.out.printf("Playing Song: artist = %-20s title = %s\n", artist, title);	
	}

	/** getName method returns title of song for Song class **/
	public String getName() {
		return title;
	}

	
	/** getPlayTimeSeconds method that returns the number of seconds in the song for the Song class **/
	public int getPlayTimeSeconds() {
		return (minutes*60) + seconds;
	}

	
	/** numberOfSong method that returns 1 for the Song class **/
	public int numberOfSongs() {
		return 1;
	}
	
	
	/** previous unimplemented compareTo method that compares the current Song object's artist and title references to the artist and title references of the Song object passed to compareTo()**/
	@Override
	public int compareTo(Song s) {
		int retVal = this.artist.compareTo(s.getArtist());
	    if(retVal != 0) return retVal;
	    else return this.title.compareTo(s.getTitle());
	}
}
