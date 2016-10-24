package com.mp3player.viewclass;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

import jaco.mp3.player.MP3Player;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class ViewClass {

	private JFrame frmDanielsMpPlayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewClass window = new ViewClass();
					window.frmDanielsMpPlayer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		MP3Player player = new MP3Player();
		
		frmDanielsMpPlayer = new JFrame();
		frmDanielsMpPlayer.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));
		frmDanielsMpPlayer.setTitle("Daniel's Mp3 Player");
		frmDanielsMpPlayer.setBounds(100, 100, 460, 225);
		frmDanielsMpPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDanielsMpPlayer.getContentPane().setLayout(null);
		
		JButton btnPlay = new JButton("play");
		btnPlay.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPlay.png")));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  new MP3Player(new File("C:\\Users\\dansj\\Desktop\\jingle-bells-guitar-glenn-jarrett.mp3")).play();
				  
			}
		});
		btnPlay.setBounds(121, 81, 97, 25);
		frmDanielsMpPlayer.getContentPane().add(btnPlay);
		
		JButton btnStop = new JButton("stop");
		btnStop.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerStop.png")));
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MP3Player().stop();
			
			}
		});
		btnStop.setBounds(339, 81, 97, 25);
		frmDanielsMpPlayer.getContentPane().add(btnStop);
		
		JButton btnOpen = new JButton("open");
		btnOpen.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerEject.png")));
		btnOpen.setBounds(12, 81, 97, 25);
		frmDanielsMpPlayer.getContentPane().add(btnOpen);
		
		JButton btnPause = new JButton("pause");
		btnPause.setIcon(new ImageIcon(ViewClass.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerPause.png")));
		btnPause.setBounds(230, 81, 97, 25);
		frmDanielsMpPlayer.getContentPane().add(btnPause);
		
		JLabel labelNowPlaying = new JLabel("Now Playing:");
		labelNowPlaying.setBounds(12, 38, 85, 16);
		frmDanielsMpPlayer.getContentPane().add(labelNowPlaying);
		
		JLabel labelSongPlaying = new JLabel("");
		labelSongPlaying.setBounds(102, 38, 328, 16);
		frmDanielsMpPlayer.getContentPane().add(labelSongPlaying);
	}

}
