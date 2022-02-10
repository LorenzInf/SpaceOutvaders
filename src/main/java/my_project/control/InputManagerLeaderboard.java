package my_project.control;

import KAGO_framework.control.ViewController;

public class InputManagerLeaderboard extends InputManager{

    public InputManagerLeaderboard(ProgramController programController,ViewController viewController, SoundManager soundManager) {
        super(viewController, programController, soundManager);
        viewController.register(this,4);

    }

    @Override
    public void keyPressed(int key){
        forceMainMenu(key);
    }
}
