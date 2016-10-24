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
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import jaco.mp3.player.MP3Player;

public class ViewClass implements ActionListener {

	private JFrame frmDanielsMpPlayer;

	// Instanciating the buttons
	JButton btnOpen = new JButton("Open");
	JButton btnPlay = new JButton("Play");
	JButton btnPause = new JButton("Pause");
	JButton btnStop = new JButton("Stop");

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
		frmDanielsMpPlayer.setBackground(UIManager.getColor("Menu.selectionBackground"));
		frmDanielsMpPlayer.setResizable(false);

		frmDanielsMpPlayer.setTitle("Daniel's Mp3 Player");
		frmDanielsMpPlayer.setBounds(100, 100, 460, 225);
		frmDanielsMpPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDanielsMpPlayer.getContentPane().setLayout(null);

		// Setting icon for the program
		frmDanielsMpPlayer.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));
	}

	public void addComponentsToFrame() {

		// Add button open
		frmDanielsMpPlayer.getContentPane().add(btnOpen);
		btnOpen.setBounds(12, 81, 97, 68);
		btnOpen.setIcon(
				new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerEject.png")));

		// Add button play
		frmDanielsMpPlayer.getContentPane().add(btnPlay);
		btnPlay.setBounds(121, 81, 97, 68);
		btnPlay.setIcon(
				new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));

		// Add button pause
		frmDanielsMpPlayer.getContentPane().add(btnPause);
		btnPause.setBounds(230, 81, 97, 68);
		btnPause.setIcon(
				new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPause.png")));

		// Add button stop
		frmDanielsMpPlayer.getContentPane().add(btnStop);
		btnStop.setBounds(339, 81, 103, 68);
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

				if (file.getName().contains(".mp3")) {
					// If a song is playing it's stopped before the new song is
					// choosen
					player.stop();
					// Setting label of the playing song
					labelSongPlaying.setText(file.getName());
					// Setting player to the choosen filepath
					player = new MP3Player(file);

					player.play();
				} else {
					JOptionPane.showMessageDialog(null, "Choose vaild .mp3 file!", "Error", JOptionPane.ERROR_MESSAGE);
				}

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
	} // Action performed

} // Class
