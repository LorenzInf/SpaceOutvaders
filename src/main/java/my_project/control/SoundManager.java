package my_project.control;

import KAGO_framework.control.SoundController;

public class SoundManager {
    private final SoundController soundController;
    private long lastLoop;
    private boolean soundOff, soundOn;

    public SoundManager() {
        soundController = new SoundController();
        this.soundController.loadSound("src/main/resources/sound/select.mp3","select",false);
        this.soundController.loadSound("src/main/resources/sound/exit.mp3","exit",false);
        this.soundController.loadSound("src/main/resources/sound/Joshua McLean - Mountain Trials.mp3","mainMenuTheme",true);
        this.soundController.loadSound("src/main/resources/sound/AdhesiveWombat - Night Shade.mp3","gameTheme1",true);
        this.soundController.loadSound("src/main/resources/sound/shoot.mp3","shootPlayer",false);
        soundOff = false;
        soundOn = false;
    }

    /**
     * Updates the soundController
     */
    protected void updateSoundController(){
        long soundElapsedTime = System.nanoTime() - lastLoop;
        lastLoop = System.nanoTime();
        int dt = (int) ((soundElapsedTime / 1000000L));
        double dtSeconds = (double)dt/1000;
        if ( dtSeconds == 0 ) dtSeconds = 0.01;
        if(soundController != null) soundController.update(dtSeconds);
    }
}
