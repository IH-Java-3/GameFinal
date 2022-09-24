import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Sound implements Runnable {
    private String fileLocation;
    public String getFileLocation() {
        return fileLocation;
    }

    public Sound() {
    }

    public void play(String fileLocation) {
        Thread t = new Thread(this);
        this.fileLocation = fileLocation;
        t.start();
    }

    public void run ()
    {
        playSound(fileLocation);
    }

    public static void playSound(String fileName) {
        File soundFile = new File(fileName);
        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Clip clip;

        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        AudioFormat audioFormat = audioInputStream.getFormat();
        SourceDataLine line = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }

        line.start();
        int nBytesRead = 0;
        byte[] abData = new byte[128000];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                int nBytesWritten = line.write(abData, 0, nBytesRead);
            }
        }
        line.drain();
        line.close();

    }
}