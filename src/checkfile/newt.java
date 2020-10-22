package checkfile;

import java.io.FileInputStream;
import java.io.InputStream;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.JavaSoundAudioDevice;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class newt extends Thread{
	
	public AdvancedPlayer explay;
	public String muss = "1.mp3";
	public Thread t;
	
	public newt(String name)
	{
		t = new Thread(this, name);
		System.out.println("Новый поток: " + t);
		t.start(); 
	}
	
	public void run() {
		while(go());
	}
	
	boolean go()
	{
		try{
			InputStream potok = new FileInputStream(muss);
			AudioDevice auDev = new JavaSoundAudioDevice();
			explay = new AdvancedPlayer(potok,auDev);
			explay.play(); 		 
		}
		catch(Exception err)
		{
				 err.printStackTrace();
		}
		
		return true;	
	}
}
