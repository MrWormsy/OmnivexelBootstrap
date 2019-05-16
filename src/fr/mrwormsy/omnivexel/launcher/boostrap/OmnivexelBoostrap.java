package fr.mrwormsy.omnivexel.launcher.boostrap;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import fr.theshark34.supdate.SUpdate;
import fr.trxyy.launcherlib.Init;
import fr.trxyy.launcherlib.OSUtil;



public class OmnivexelBoostrap {

	private static SUpdate su;
	
	private static long now;
	
	public static void main(String[] args) {
		
		BoostrapFrame bf = new BoostrapFrame();
		
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
		
		Init.registerLauncherConfiguration("", 0, 0, "omnivexelproject/launcher", "/resources/");
		
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
	
}
