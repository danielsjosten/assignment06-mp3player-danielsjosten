package com.mp3player.viewclass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import jaco.mp3.player.MP3Player;

public class ViewClass implements ActionListener {

	private JFrame frmDanielsMpPlayer;

	// Instanciating the buttons
	JButton btnOpen = new JButton("open");
	JButton btnPlay = new JButton("play");
	JButton btnPause = new JButton("pause");
	JButton btnStop = new JButton("stop");

	// Instanciating the labels
	JLabel labelNowPlaying = new JLabel("Now Playing:");
	JLabel labelSongPlaying = new JLabel("");

	// Instanciating a filechooser
	JFileChooser fileChooser = new JFileChooser();

	MP3Player player = new MP3Player();

	/**
	 * Main
	 */
	public static void main(String[] args) {
		ViewClass window = new ViewClass();
		window.frmDanielsMpPlayer.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public ViewClass() {
		createGUI();
		addComponentsToFrame();
		addActionListners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createGUI() {
		frmDanielsMpPlayer = new JFrame();

		frmDanielsMpPlayer.setTitle("Daniel's Mp3 Player");
		frmDanielsMpPlayer.setBounds(100, 100, 460, 225);
		frmDanielsMpPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDanielsMpPlayer.getContentPane().setLayout(null);

		frmDanielsMpPlayer.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));

		// btnPlay.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		// new MP3Player(new
		// File("C:\\Users\\dansj\\Desktop\\jingle-bells-guitar-glenn-jarrett.mp3")).play();
		//
		// }
		// });

	}

	public void addComponentsToFrame() {
		// Add button open
		frmDanielsMpPlayer.getContentPane().add(btnOpen);
		btnOpen.setBounds(12, 81, 97, 25);
		btnOpen.setIcon(
				new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerEject.png")));

		// Add button play
		frmDanielsMpPlayer.getContentPane().add(btnPlay);
		btnPlay.setBounds(121, 81, 97, 25);
		btnPlay.setIcon(
				new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));

		// Add button pause
		frmDanielsMpPlayer.getContentPane().add(btnPause);
		btnPause.setBounds(230, 81, 97, 25);
		btnPause.setIcon(
				new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPause.png")));

		// Add button stop
		frmDanielsMpPlayer.getContentPane().add(btnStop);
		btnStop.setBounds(339, 81, 97, 25);
		btnStop.setIcon(
				new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerStop.png")));

		// Add label now playing
		frmDanielsMpPlayer.getContentPane().add(labelNowPlaying);
		labelNowPlaying.setBounds(12, 38, 85, 16);

		// Add label song playing
		frmDanielsMpPlayer.getContentPane().add(labelSongPlaying);
		labelSongPlaying.setBounds(102, 38, 328, 16);

	}

	public void addActionListners() {
		// add action listner to the buttons
		btnOpen.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Add action performed to open song
		if (e.getSource() == btnOpen) {
			int returnVal = fileChooser.showOpenDialog(btnOpen);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				labelSongPlaying.setText(file.getName());
				player.addToPlayList(new File(file.getPath()));
				player.play();
			}
		}

		// Add action performed to play song
		if (e.getSource() == btnPlay) {
			player.play();
		}

		// Add action performed to pause song
		if (e.getSource() == btnPause) {
			if (player.isEnabled()) {
				player.pause();
			}
		}

		// Add action performed to stop song
		if (e.getSource() == btnStop) {
			player.stop();

		}
		
		
		
	}

}
