package my_project.control;

import KAGO_framework.control.ViewController;

public class InputMangerGuide extends InputManager{

    public InputMangerGuide(ProgramController programController,ViewController viewController, SoundManager soundManager) {
        super(viewController, programController, soundManager);
        viewController.register(this,5);

    }

    @Override
    public void keyPressed(int key){
        forceMainMenu(key);
    }
}
