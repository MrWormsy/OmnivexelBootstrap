package fr.mrwormsy.omnivexel.launcher.boostrap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoostrapFrame extends JFrame {

	public BoostrapFrame() {
		
		this.setTitle("Omnivexel Boostrap");
		this.setSize(250, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setIconImage(new ImageIcon(this.getClass().getResource("/fr/mrwormsy/omnivexel/launcher/boostrap/resources/logo.png")).getImage());
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		this.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		this.setBounds((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) - 125, (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - 125, 250, 250);
		this.setLayout(null);
		
		this.getContentPane().add(new BoostrapPanel());
		
		this.setOpacity(0f);
		
		this.setVisible(true);
		
		
		
	}
}

@SuppressWarnings("serial")
class BoostrapPanel extends JPanel {
	
	private Image background = (new ImageIcon(getClass().getResource("/fr/mrwormsy/omnivexel/launcher/boostrap/resources/background.png")).getImage());
	
	
	public BoostrapPanel() {

		this.setBounds(0, 0, 250, 250);
		this.setLayout(null);
		this.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
		
		
	}
	
}