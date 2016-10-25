package com.mp3player.otherclasses;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class ViewClass extends JFrame implements ActionListener {

	/**
	 * Setting serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public JFrame framePlayer;

	// Instanciating the buttons
	private JButton btnOpen = new JButton("Open");
	private JButton btnPlay = new JButton("Play");
	private JButton btnPause = new JButton("Pause");
	private JButton btnStop = new JButton("Stop");

	// Instanciating the labels
	private JLabel labelNowPlaying = new JLabel("Now Playing:");
	private JLabel labelSongPlaying = new JLabel("");

	PlayerMethods pm = new PlayerMethods();
	

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
		framePlayer = new JFrame();
		framePlayer.setBackground(UIManager.getColor("Menu.selectionBackground"));
		framePlayer.setResizable(false);

		framePlayer.setTitle("Daniel's Mp3 Player");
		framePlayer.setBounds(100, 100, 460, 225);
		framePlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePlayer.getContentPane().setLayout(null);
		
		//framePlayer.setVisible(true);

		// Setting icon for the program
		framePlayer.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));
	}

	/**
	 * Method for adding the components to the frame
	 */
	public void addComponentsToFrame() {

		// Add button open
		framePlayer.getContentPane().add(btnOpen);
		btnOpen.setBounds(12, 81, 97, 68);
		btnOpen.setIcon(
				new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerEject.png")));

		// Add button play
		framePlayer.getContentPane().add(btnPlay);
		btnPlay.setBounds(121, 81, 97, 68);
		btnPlay.setIcon(
				new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));

		// Add button pause
		framePlayer.getContentPane().add(btnPause);
		btnPause.setBounds(230, 81, 97, 68);
		btnPause.setIcon(
				new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPause.png")));

		// Add button stop
		framePlayer.getContentPane().add(btnStop);
		btnStop.setBounds(339, 81, 103, 68);
		btnStop.setIcon(
				new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerStop.png")));

		// Add label now playing
		framePlayer.getContentPane().add(labelNowPlaying);
		labelNowPlaying.setBounds(12, 38, 85, 16);

		// Add label song playing
		framePlayer.getContentPane().add(labelSongPlaying);
		labelSongPlaying.setBounds(102, 38, 328, 16);

	}
	/**
	 * Adding actionlistners to the buttons
	 */
	public void addActionListners() {
		// add action listner to the buttons
		btnOpen.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);

	}
	
	/**
	 * Adding actions performed to each button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Add action performed to open song
		if (e.getSource() == btnOpen) {
			pm.open();
			labelSongPlaying.setText(pm.getLabelSongPlaying());

		}

		// Add action performed to play song
		if (e.getSource() == btnPlay) {
			pm.play();
			labelSongPlaying.setText(pm.getLabelSongPlaying());
		}

		// Add action performed to pause song
		if (e.getSource() == btnPause) {
				pm.pause();
			}
	

		// Add action performed to stop song
		if (e.getSource() == btnStop) {
			pm.stop();
		}
	} // Action performed

} // Class
