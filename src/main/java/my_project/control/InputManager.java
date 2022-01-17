package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;

import java.awt.event.KeyEvent;
import java.security.Key;

public abstract class InputManager extends InteractiveGraphicalObject {

    private final ViewController viewController;
    private final ProgramController programController;
    private final SoundController soundController;
    private long lastLoop,elapsedTime;

    public InputManager(ViewController viewController, ProgramController programController, SoundController soundController){
        this.viewController = viewController;
        this.programController = programController;
        this.soundController = soundController;
        this.soundController.loadSound("src/main/resources/sound/select.mp3","select",false);
        this.soundController.loadSound("src/main/resources/sound/exit.mp3","exit",false);
    }


    /**
     * Updates the soundController
     */
    protected void updateSoundController(){
        elapsedTime = System.nanoTime() - lastLoop;
        lastLoop = System.nanoTime();
        int dt = (int) ((elapsedTime / 1000000L));
        double dtSeconds = (double)dt/1000;
        if ( dtSeconds == 0 ) dtSeconds = 0.01;
        if(soundController != null) soundController.update(dtSeconds);
    }


    /**
     * Forces you back to the main menu if Esc is held for 5 seconds - this should be called in keyPressed() methods of any subclass
     */
    protected void forceMainMenu(int key){
        //TODO Fix I guess (After five seconds KAGO dies, console still works though)
        /*
        long time = System.nanoTime();
        while(key == KeyEvent.VK_ESCAPE){
            long timer = System.nanoTime();
            if(timer > time + (5000000000L)) {
                viewController.showScene(0);
                System.out.println("Main Menu force initialized");
                time = timer;
            }
        }
         */
    }
}
