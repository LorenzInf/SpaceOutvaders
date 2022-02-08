package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.ArrayKeyboard;
import my_project.model.Player;
import my_project.view.Visual2DArray;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
