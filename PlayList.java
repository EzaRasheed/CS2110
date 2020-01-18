// Eza Rasheed
// er6qt
// Homework 4

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PlayList implements Playable {
	
	private String name; 
	private ArrayList<Playable> playableList;

	
	/** Getters and Setters for all fields **/
	/** getName method returns name of playlist for PlayList class **/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}
	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}
	
	
	/** toString method that returns the name of the playlist followed by its contents, one name/title per line **/
	public String toString(){
		String str = name + "\n";
		for(Playable pl:playableList){
			str += pl.toString() + "\n";
	    }
	       return str;
	}
	
	
	/** constructor with empty play list named "Untitled" **/
    public PlayList() { 
        name = "Untitled";
        playableList = new ArrayList<Playable>();
    }

    
    /** constructor with empty playlist **/
    public PlayList(String newName) { 
        name = newName;
        playableList = new ArrayList<Playable>();
    }
	
    
    /** loadSongs method that loads songs from a file **/
    public boolean loadSongs(String filename) {
        File input = new File(filename);
        Scanner inputFile;
        try {
        	inputFile = new Scanner(input);
        } 
        catch(Exception e) {
            return false; // could not find file
        }
        while(inputFile.hasNextLine()){
        	// store lines to variables
        	String title = inputFile.nextLine().trim();
            String artist = inputFile.nextLine().trim();
            String time = inputFile.nextLine().trim();
            // skip the 4th line
            inputFile.nextLine();
            // make the time into minutes and seconds
            String[] timeParts = time.split(":");
            // convert those values to integers
            int minutes = Integer.parseInt(timeParts[0]);
            int seconds = Integer.parseInt(timeParts[1]);
            // if there are more than 60 seconds
            if(seconds >= 60) {
                int addMin = seconds/60;
                seconds = seconds % 60;
                minutes += addMin;
            }
            Song s = new Song(artist, title, minutes, seconds);
            this.addSong(s);
        }
        inputFile.close();
        return true;
    }
    
    
    /** clear method that removes all playable elements in the play list **/
    public boolean clear(){
    	playableList.clear();
        return true;
    }
    
    /** addSong method that adds Song s to the end of the play list **/
    public boolean addSong(Song s){
        playableList.add(s);
        return true;
    }
    
    /** removePlayable method(type int) that removes Playable element at index from the list and returns it **/
    public Playable removePlayable(int index){ // removes Playable element at index from the list and returns it
        Playable obj = playableList.get(index);
        playableList.remove(index);
        return obj;
    }
    
    
    /** removePlayable method(type Playable) that removes every occurrence of Playable p from the list and returns p**/
    public Playable removePlayable(Playable p){
        while(playableList.contains(p)){
        	playableList.remove(p);
        }
        return p;
    }
  
    
    /** getPlayable method that returns the Playable element at the appropriate index **/
    public Playable getPlayable(int index) {
        try{
            Playable p = this.playableList.get(index);
            return p;
        }
        catch(Exception e) {
            return null;
        }
    }

    
    /** addPlayList method that adds a playlist to the end of the playable list and returns true,
    but if the playable list already contains a playlist(pl) with same name, then return false(do not add it) **/
    public boolean addPlayList(PlayList pl) {
        if (playableList.contains(pl)) {
            return false;
        } else {
            playableList.add(pl);
            return true;
        }
    }
	
    
    /** plays each item p(playlist) in playablelist by calling play() **/
	@Override
	public void play() {
		for(Playable p: playableList){
			p.play();
	    }		
	}

	/**Sorts the playlists by name in ascending order**/
	 public void sortByName() {
		 Collections.sort(this.playableList, new CompareByName());
	 }
	
	/**Sorts the playable items by time in ascending order**/
	public void sortByTime() {
		Collections.sort(playableList, new CompareByTime());
	}
	
	
	/** getPlayTimeSeconds method that returns the number of seconds in the whole playlist for the PLayList class **/
	@Override
	public int getPlayTimeSeconds() {
		int time = 0;
		for(Playable p: playableList) {
			time += p.getPlayTimeSeconds();
		}
		return time;
	}
	
	
	/** numberOfSong method that returns the number of songs(size) in the whole playlist in the PlayList class **/
	@Override
	public int numberOfSongs() {
		int numSongs = 0;
	    for(Playable p:this.playableList){
	    	if (p instanceof Song) {
	    		numSongs ++;
	        }
	        else if (p instanceof PlayList) {
	        	numSongs += p.numberOfSongs();
	        }
	    }
	        return numSongs;
	}

}