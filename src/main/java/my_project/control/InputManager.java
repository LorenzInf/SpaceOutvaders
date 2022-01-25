package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;

import java.awt.event.KeyEvent;

public abstract class InputManager extends InteractiveGraphicalObject {

    protected final ViewController viewController;
    protected final ProgramController programController;
    protected final SoundManager soundManager;

    public InputManager(ViewController viewController, ProgramController programController, SoundManager soundManager){
        this.viewController = viewController;
        this.programController = programController;
        this.soundManager = soundManager;
    }

    /**
     * Forces you back to the main menu if Esc is held for 5 seconds - this should be called in keyPressed() methods of any subclass
     */
    protected void forceMainMenu(int key){
        if(key == KeyEvent.VK_P) {
            viewController.showScene(1);
            System.out.println("Main Menu force initialized");
        }
    }

    protected void setVolume(int key){
        if(key == KeyEvent.VK_MINUS) {
            soundManager.modifyVolume(-0.1);
        }
        if(key == KeyEvent.VK_PLUS) {
            soundManager.modifyVolume(0.1);
        }
    }

}