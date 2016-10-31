package com.mp3player.otherclasses;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.mp3player.interfaces.PlayerInterface;

import jaco.mp3.player.MP3Player;

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
public class PlayerMethods implements PlayerInterface {

	private MP3Player mp3player = new MP3Player();
	private String labelSongPlaying = "";
	final JFileChooser fileChooser = new JFileChooser();

	/**
	 * Method that lets you open a mp3-file and starts playing the file
	 */
	@Override
	public void open() {
		int returnVal = fileChooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();

			if (file.getName().contains(".mp3")) {
				// If a song is playing it's stopped before the new song is choosen
				stop(); 
				// Setting label of the playing song
				this.labelSongPlaying = file.getName().toString(); 

				// Setting player to the choosen filepath and start playing file
				setPlayer(new MP3Player(file));
				getPlayer().play();
			} else {
				// Shows a pop-up window presenting a errormessage if you didnt
				// choose a .mp3-file
				JOptionPane.showMessageDialog(null, file.getName() + " Is not a valid .mp3 file!", "Critical Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Method for the playbutton that starts the song over if you are listening
	 * to a song
	 */
	@Override
	public void play() {
		if (labelSongPlaying == "") {
			open();
		} else {
			mp3player.play();
			

		}
	}

	/**
	 * Method that pauses current song
	 */
	@Override
	public void pause() {
		mp3player.pause();
	}

	/**
	 * Method that lets you stop playing a song
	 */
	@Override
	public void stop() {
		mp3player.stop();
	}

	/**
	 * Method for getting labelSongPlaying
	 * 
	 * @return labelSongPlaying Returns a string with the name of the song
	 *         playing
	 */
	public String getLabelSongPlaying() {
		return labelSongPlaying;
	}

	/**
	 * Method for setting labelSongPlaying
	 * 
	 * @param labelSongPlaying
	 */
	public void setLabelSongPlaying(String labelSongPlaying) {
		this.labelSongPlaying = labelSongPlaying;
	}

	/**
	 * Method for getting mp3player
	 * 
	 * @return mp3player Returns the mp3player
	 */
	public MP3Player getPlayer() {
		return mp3player;
	}

	/**
	 * Method for setting mp3player
	 * 
	 * @param mp3player
	 */
	public void setPlayer(MP3Player mp3player) {
		this.mp3player = mp3player;
	}

}
