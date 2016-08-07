package bartender;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class SoundEffect{

	String fileLocation;
	
	public SoundEffect(String location){
		fileLocation = location;
	}
	
	public void SetSound(String N){
		fileLocation = N;
	}
	
	public void Play() {
		// TODO Auto-generated method stub
		try {
		    File yourFile = new File("sfx/" + fileLocation);
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;

		    stream = AudioSystem.getAudioInputStream(yourFile);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}catch (Exception e) {
		    //whatevers
		}
	}
}
