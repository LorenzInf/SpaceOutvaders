package my_project.control;

import KAGO_framework.control.ViewController;

import java.awt.event.KeyEvent;

public class InputManagerLeaderboard extends InputManager{

    public InputManagerLeaderboard(ProgramController programController,ViewController viewController, SoundManager soundManager) {
        super(viewController, programController, soundManager);
        viewController.register(this,4);

    }

    @Override
    public void keyPressed(int key){
        if(key == KeyEvent.VK_UP){

        }
        if(key == KeyEvent.VK_DOWN){

        }
        forceMainMenu(key);

    }
}
