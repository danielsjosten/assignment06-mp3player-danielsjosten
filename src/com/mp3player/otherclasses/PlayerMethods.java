package com.mp3player.otherclasses;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.mp3player.interfaces.PlayerInterface;

import jaco.mp3.player.MP3Player;

public class PlayerMethods implements PlayerInterface{

	private MP3Player mp3player = new MP3Player();
	private String labelSongPlaying = "";
	final JFileChooser fileChooser = new JFileChooser();

	@Override
	public void open() {
		int returnVal = fileChooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();

			if (file.getName().contains(".mp3")) {
				stop();	// If a song is playing it's stopped before the new song is choosen
				
				this.labelSongPlaying = file.getName().toString(); // Setting label of the playing song

				// Setting player to the choosen filepath and start playing file
				setPlayer(new MP3Player(file));
				getPlayer().play();
			} else {
				JOptionPane.showMessageDialog(null, "Not a valid .mp3 file!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		
//				JFileChooser fileChooser = new JFileChooser();
//				int returnVal = fileChooser.showOpenDialog(null);
//				File file = fileChooser.getSelectedFile();
//				stop();
//				this.labelSongPlaying = file.getName().toString(); // Setting label of the playing song
//				setPlayer(new MP3Player(file));
//				getPlayer().play();
				
		}
		
	}

	@Override
	public void play() {
		if (labelSongPlaying == "") {
			open();
		}else{
			mp3player.play();
		}	
	}

	@Override
	public void pause() {
		mp3player.pause();
	}

	@Override
	public void stop() {
		mp3player.stop();
	}
	
	public String getLabelSongPlaying() {
		return labelSongPlaying;
	}

	public void setLabelSongPlaying(String labelSongPlaying) {
		this.labelSongPlaying = labelSongPlaying;
	}

	public MP3Player getPlayer() {
		return mp3player;
	}

	public void setPlayer(MP3Player mp3player) {
		this.mp3player = mp3player;
	}
	

}
