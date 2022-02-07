package my_project.control;

import KAGO_framework.control.ViewController;

public class InputManagerGuide extends InputManager{

    public InputManagerGuide(ProgramController programController, ViewController viewController, SoundManager soundManager) {
        super(viewController, programController, soundManager);
        viewController.register(this,5);

    }

    @Override
    public void keyPressed(int key){
        forceMainMenu(key);
    }
}
