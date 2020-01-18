// Eza Rasheed
// er6qt
// Homework 4

/** Java interface named Playable that has the following 4 methods in it**/
public interface Playable {
	
	public void play();
	/** returns the name for PlayList class, and title for Song class **/
	public String getName();
	/** returns number of seconds for Song class, and number of seconds in the whole playlist in the PlayList class **/
	public int getPlayTimeSeconds();
	/** returns 1 for Song class, and the number of songs in the playlist in the PLayList class **/
	public int numberOfSongs();
}
