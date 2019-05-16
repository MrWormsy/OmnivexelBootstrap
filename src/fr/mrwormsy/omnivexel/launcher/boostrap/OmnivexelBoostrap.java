package fr.mrwormsy.omnivexel.launcher.boostrap;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

import fr.theshark34.supdate.SUpdate;
import fr.trxyy.launcherlib.Init;
import fr.trxyy.launcherlib.OSUtil;



public class OmnivexelBoostrap {

	private static SUpdate su;
	
	private static long now;
	
	static BoostrapFrame bf;
	
	public static void main(String[] args) {
		
		Init.registerLauncherConfiguration("", 0, 0, "omnivexelproject/launcher", "/resources/");
		
		//Check if the guy is connected to the internet (to download the launcher)
		bf = new BoostrapFrame();
		
		if (!netIsAvailable()) {
			// If we are here that means we are not connected to the internet... We have to cases, either the guy has already download the game and if not we tell him that he needs internet
			if (new File(OSUtil.getPath() + "\\OmnivexelLauncher.jar").exists()) {
				launchLauncher();
			} else {
				JOptionPane.showMessageDialog(bf, "ERROR : You are not connected to the internet, and you don't have the launcher installed.", "No internet connection", JOptionPane.ERROR_MESSAGE);				
				System.exit(0);
			}
		}
		
		now = System.currentTimeMillis();
		
		//Thread for the animation
		new Thread() {
			 
			@Override
			public void run() {

				for (int i = 1; i <= 95; i++) {
					bf.setOpacity((float) (i * 0.01));
					while (System.currentTimeMillis() - now < 5) {}
					now = System.currentTimeMillis();
				}
			}
		}.start();
		
		
		
		su = new SUpdate("http://51.75.254.98/omnivexel/", OSUtil.getDirectory());
		
		try {
			update();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void update() throws Exception {
		
		su.getFileManager().download(new URL("http://51.75.254.98/omnivexel/OmnivexelLauncher.jar"), new File(OSUtil.getPath() + "\\OmnivexelLauncher.jar"));
		
		while (! new File(OSUtil.getPath() + "\\OmnivexelLauncher.jar").exists()) {}
		
		launchLauncher();	
	}
	
	public static void launchLauncher() {
		
		// Run a java app in a separate system process
		try {
			Runtime.getRuntime().exec("java -jar " + OSUtil.getPath() + "\\OmnivexelLauncher.jar");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        System.exit(0);
	}	
	
	private static boolean netIsAvailable() {
	    try {
	        final URL url = new URL("http://www.google.com");
	        final URLConnection conn = url.openConnection();
	        conn.connect();
	        conn.getInputStream().close();
	        return true;
	    } catch (MalformedURLException e) {
	        throw new RuntimeException(e);
	    } catch (IOException e) {
	        return false;
	    }
	}
}
