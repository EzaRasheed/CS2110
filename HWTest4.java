// Eza Rasheed
// er6qt
// Homework 4

import static org.junit.Assert.*;
import org.junit.Test;

public class HWTest4 {

	// test equals method for songs
	@Test
	public void testEquals1() {
		Song s = new Song("Drake", "God's Plan", 2, 55);
		Song d = new Song("Drake", "God's Plan", 2, 55);
		boolean isEqual = s.equals(d);
		assertTrue(isEqual);
	}
	
	@Test
	public void testEquals2() {
		Song s = new Song("Drake", "God's Plan", 2, 55);
		Song d = new Song("Kendrick Lamar", "All the Stars", 3, 56);
		boolean isEqual = s.equals(d);
		assertFalse(isEqual);
	}
	
	// test toString method for songs
	@Test
	public void testToString1() {
		Song s = new Song("Weeknd", "Pray for Me", 3, 32);;
		String output = s.toString();
		assertEquals("{Song: title = Pray for Me artist = Weeknd}",output);	
	}
	
	@Test
	public void testToString2() {
		Song s = new Song("Weeknd", "Pray for Me", 3, 32);;
		String output1 = s.toString();
		String song = "{Song: title = Pray for Me artist = Weeknd}";
		boolean isEqual = output1.equals(song);
		assertTrue(isEqual);		
	}	
	
	// test for getPlayTimeSeconds for songs
	@Test
	public void testGetPlayTimeSeconds() {
		Song s1 = new Song ("Weeknd", "Pray for Me", 3, 32);
		Song s2 = new Song ("Drake", "God's Plan", 2, 55);
		Song s3 = new Song ("Weeknd", "Pray for Me", 3, 32);
		int result = s2.getPlayTimeSeconds();
		assertEquals(175, s2.getPlayTimeSeconds()); 
		assertFalse(result == 25); 
	}
	
	// test for getName method for songs
	@Test
	public void testGetName() {
		Song s1 = new Song ("Weeknd", "Pray for Me", 3, 32);
		Song s2 = new Song ("Drake", "God's Plan", 2, 55);
		Song s3 = new Song ("Weeknd", "Pray for Me", 3, 32);
		assertEquals("Pray for Me", s1.getName()); 
		assertEquals("God's Plan", s2.getName()); 
		assertFalse(s3.getName().equals("Weeknd")); 
	}
	
	
	// test for numberOfSongs method for songs
	@Test
	public void testNumberOfSongs() {
		Song s1 = new Song ("Weeknd", "Pray for Me", 3, 32);
		Song s2 = new Song ("Drake", "God's Plan", 2, 55);
		Song s3 = new Song ("Weeknd", "Pray for Me", 3, 32);
		assertEquals(1, s2.numberOfSongs());
		assertFalse(s3.numberOfSongs() == 2); 
	}
	
	// test compareTo method for songs
    @Test
    public void testCompareTo1() {
    	Song s1 = new Song ("Weeknd", "Pray for Me", 3, 32);
		Song s2 = new Song ("Drake", "God's Plan", 2, 55);
        int t1 = s1.compareTo(s2);
        assertEquals(19, t1);
    }

    @Test
    public void testCompareTo2() {
    	Song s1 = new Song ("Weeknd", "Pray for Me", 3, 32);
		Song s2 = new Song ("Drake", "God's Plan", 2, 55);
        int t2 = s2.compareTo(s1);
        assertEquals(-19, t2);
    }
	
	 // test getPlayTimeSeconds for playlist
	 @Test
	 public void testGetPlayTimeSeconds3() {
		PlayList play1 = new PlayList("Trending Now");
		PlayList play2 = new PlayList();
		Song s1 = new Song ("Weeknd", "Pray for Me");
		Song s2 = new Song ("Drake", "God's Plan");
		play1.addSong(s1);
		play1.addSong(s2);
	    int t1 = play1.getPlayTimeSeconds();
	    assertEquals(0, t1);
	}
	  
	 @Test
	 public void testGetPlayTimeSeconds4() {
		PlayList play1 = new PlayList("Trending Now");
		PlayList play2 = new PlayList();
		Song s1 = new Song ("Weeknd", "Pray for Me");
		Song s2 = new Song ("Drake", "God's Plan");
	    play1.addSong(s1);
	    int t2 = play1.getPlayTimeSeconds();
	    assertEquals(0, t2);
	}
	  
	 // test numberOfSongs method for playlist
	 @Test
	 public void testNumberOfSongs3() {
		PlayList play1 = new PlayList("Trending Now");
		Song s1 = new Song ("Charlie Puth", "How Long");
		Song s2 = new Song ("Shakira", "Chantaje");
		Song s3 = new Song ("Charlie Puth", "Long");
	    play1.addSong(s1);
	    play1.addSong(s2);
	    play1.addSong(s3);
	    int t1 = play1.numberOfSongs();
	    assertEquals(3, t1);
	 }
	  
	 @Test
	 public void testNumberOfSongs4() {
		Song s2 = new Song ("Shakira", "Chantaje");
		PlayList play2 = new PlayList();
	    play2.addSong(s2);
	    int t2 = play2.numberOfSongs();
	    assertEquals(1, t2);
	 }
	 
	  // test toString method for playlist
	  @Test
	  public void testToString3() {
		PlayList play1 = new PlayList("Trending Now");
		String output = play1.toString();
	    assertEquals("Trending Now\n", output);
	 }
	    
	  @Test
	  public void testToString4() {
	    PlayList play2 = new PlayList();
		String output = play2.toString();
	    assertEquals("Untitled\n", output);
	 }
	    
	  // test loadSong method for playlist
	  @Test
	  public void testLoadSongs1() {
		 PlayList play3 = new PlayList();
		 play3.loadSongs("loadSongTest");
		 System.out.println(play3.getPlayableList());
	 }

	  @Test
	  public void testLoadSongs2() {
		 PlayList play1 = new PlayList();
	     play1.loadSongs("loadSongTest");
	     System.out.println(play1.getPlayableList());
	  }
	    
	  // test removePlayable(int index) method for playlist
	  @Test
	  public void testRemovePlayableInt1() {
		  PlayList play1 = new PlayList("Trending Now");
	      Song s2 = new Song ("Shakira", "Chantaje");
	      Song s3 = new Song ("Charlie Puth", "Long");
	      play1.addSong(s2);
	      System.out.println(play1);
	      play1.addSong(s3);
	      System.out.println(play1);
	      play1.removePlayable(0);
	      System.out.println(play1);
	      assertEquals(1, play1.getPlayableList().size());
	 }

	  @Test
	  public void testRemovePlayableInt2() {
		  Song s2 = new Song ("Shakira", "Chantaje");
		  PlayList play2 = new PlayList();
	      play2.addSong(s2);
	      System.out.println(play2);
	      play2.removePlayable(0);
	      System.out.println(play2);
          assertFalse(play2.getPlayableList().contains(s2));
	  }
	    
	    // test removePlayable(Playable p) method for playlist
	  @Test
	  public void testRemovePlayablePlayable1() {
		  PlayList play1 = new PlayList("Trending Now");
		  Song s3 = new Song ("Charlie Puth", "Long");
	      play1.addSong(s3);
	      System.out.println(play1);
	      play1.removePlayable(s3);
	      System.out.println(play1);
	      assertFalse(play1.getPlayableList().contains(s3));

	  }
	    
	  @Test
	  public void testRemovePlayablePlayable2() {
		  Song s4 = new Song ("Blackbears", "Do Re Mi");
	      PlayList play2 = new PlayList();
	      play2.addSong(s4);
	      System.out.println(play2);
	      Playable t1 = play2.removePlayable(s4);
	      assertEquals(s4, t1);
	  }
	    
	  // test clear method for playlist
	  @Test
	  public void testClear1() {
		  PlayList play1 = new PlayList("Trending Now");
	      PlayList play2 = new PlayList();
	      Song s1 = new Song ("Charlie Puth", "How Long");
	      Song s2 = new Song ("Shakira", "Chantaje");
	      play1.addSong(s1);
	      play2.addSong(s2);
	      System.out.println(play1);
	      play1.clear();
	      assertEquals(0, play1.getPlayableList().size());
	    }

	  @Test
	  public void testClear2() {
		  Song s1 = new Song ("Charlie Puth", "How Long");
	      PlayList play2 = new PlayList();
	      play2.addSong(s1);
	      System.out.println(play2);
	      play2.clear();
	      assertEquals(0, play2.getPlayableList().size());
	    }
	    
	  // test addSong method for playlist
	  @Test
	  public void testAddSong1(){
		  PlayList play1 = new PlayList("Trending Now");
		  Song s5 = new Song ("Weeknd", "Pray for Me", 3, 32);
	      play1.addSong(s5);
	      assertTrue(play1.getPlayableList().contains(s5));
	  }

	  @Test
	  public void testAddSong2() {
		  PlayList play1 = new PlayList("Trending Now");
		  Song s4 = new Song ("Blackbears", "Do Re Mi");
		  Song s5 = new Song ("Weeknd", "Pray for Me", 3, 32);
		  play1.addSong(s4);
		  assertFalse(play1.getPlayableList().contains(s5));
	  }
	  
	  // test getPlayable method for playlist
	  @Test
		public void testGetPlayableIndex1() {
			PlayList songList = new PlayList();
			Song s1 = new Song ("Charlie Puth", "How Long");
		    Song s2 = new Song ("Shakira", "Chantaje");
		    Song s3 = new Song ("Charlie Puth", "Long");
			songList.addSong(s1); songList.addSong(s2); songList.addSong(s3);
			assertEquals(songList.getPlayable(0), s1);
	  }
	  
	  @Test
		public void testGetPlayableIndex2() {
			PlayList songList = new PlayList();
			Song s1 = new Song ("Charlie Puth", "How Long");
		    Song s2 = new Song ("Shakira", "Chantaje");
		    Song s3 = new Song ("Charlie Puth", "Long");
			songList.addSong(s1); songList.addSong(s2); songList.addSong(s3);
			assertTrue(songList.getPlayable(1).equals(s2));
	  }
	  
	  // test addPlayList method for playlist
	  @Test
	  public void testAddPlayList1() {
		  PlayList play1 = new PlayList("Trending Now");
	      PlayList play2 = new PlayList();
	      Song s1 = new Song ("Charlie Puth", "How Long");
		  Song s2 = new Song ("Shakira", "Chantaje");
	      play1.addSong(s1);
	      play2.addSong(s2);
	      boolean t1 = play1.addPlayList(play2);
	      assertEquals(true, t1);
	  }

	  @Test
	  public void testAddPlayList2() {
		  PlayList play1 = new PlayList("Trending Now");
	      PlayList play2 = new PlayList();
	      Song s1 = new Song ("Charlie Puth", "How Long");
		  Song s2 = new Song ("Shakira", "Chantaje");
	      Song s3 = new Song ("Charlie Puth", "Long");
	      Song s4 = new Song ("Blackbears", "Do Re Mi");
	      play1.addSong(s1);
	      play1.addSong(s3);
	      play1.addSong(s4);
	      play2.addSong(s2);
	      play1.addPlayList(play2);
	      assertTrue(play1.getPlayableList().contains(play2));
	  }
	    
	  // test sortByName method for playlist
	  @Test
	  public void testSortByName1() {
		  PlayList play1 = new PlayList("Trending Now");
		  Song s7 = new Song ("G Easy", "No Limit");
		  Song s8 = new Song ("Cardi B", "Bodak Yellow");
		  play1.addSong(s7);
		  play1.addSong(s8);
		  play1.sortByName();
		  assertEquals("[{Song: title = Bodak Yellow artist = Cardi B}, {Song: title = No Limit artist = G Easy}]", play1.getPlayableList().toString());
	  }

	  @Test
	  public void testSortByName2() {
		  PlayList play1 = new PlayList("Trending Now");
		  Song s7 = new Song ("G Easy", "No Limit");
		  Song s8 = new Song ("Cardi B", "Bodak Yellow");
		  Song s9 = new Song ("Post Malone", "Rockstar");
		  play1.addSong(s7);
		  play1.addSong(s8);
		  play1.addSong(s9);
	      play1.sortByName();
	      assertEquals("[{Song: title = Bodak Yellow artist = Cardi B}, {Song: title = No Limit artist = G Easy}, {Song: title = Rockstar artist = Post Malone}]", play1.getPlayableList().toString());
	  }
	    
	  // test sortByTime method for playlist
	  @Test
	  public void testSortByTime1() {
		  PlayList play1 = new PlayList("Trending Now");
		  Song s5 = new Song ("Weeknd", "Pray for Me", 3, 32);
		  Song s6 = new Song ("Drake", "God's Plan", 2, 55);
		  play1.addSong(s5);
		  play1.addSong(s6);
		  play1.sortByTime();
		  assertEquals("[{Song: title = God's Plan artist = Drake}, {Song: title = Pray for Me artist = Weeknd}]", play1.getPlayableList().toString());
	  }

	  @Test
	  public void testSortByTime2() {
		  PlayList play1 = new PlayList("Trending Now");
		  Song s6 = new Song ("Drake", "God's Plan", 2, 55);
		  Song s10 = new Song ("Selena Gomez", "Fetish", 4, 23);
		  play1.addSong(s6);
		  play1.addSong(s10);
		  play1.sortByTime();
		  assertEquals("[{Song: title = God's Plan artist = Drake}, {Song: title = Fetish artist = Selena Gomez}]", play1.getPlayableList().toString());
	  }
}