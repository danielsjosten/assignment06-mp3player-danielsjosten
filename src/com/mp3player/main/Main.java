package com.mp3player.main;

import com.mp3player.otherclasses.ViewClass;

/**
* <h1>Daniel's Mp3Player</h1>
* This is a Mp3Player program that lets you open a mp3-file 
* from your computer and play the file.
* <p>
* You can also pause or stop the playing song.
* 
* @author  Daniel Sjösten
* @version 1.0
* @since   2016-10-27 
*/
public class Main {

	   /**
	   * This is the main method that starts up the program.
	   * @param args Unused.
	   * @return Nothing.
	   */
	public static void main(String[] args) {
		ViewClass window = new ViewClass();
		window.framePlayer.setVisible(true);		
	}

}
