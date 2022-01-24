package my_project.control;

import KAGO_framework.control.SoundController;

public class SoundManager {
    private final SoundController soundController;
    private long lastLoop;

    public SoundManager() {
        soundController = new SoundController();
        this.soundController.loadSound("src/main/resources/sound/select.mp3","select",false);
        this.soundController.loadSound("src/main/resources/sound/exit.mp3","exit",false);
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
