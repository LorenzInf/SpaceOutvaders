package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.ArrayKeyboard;
import my_project.view.Visual2DArray;

import java.awt.event.KeyEvent;

public class InputManagerEnterName extends InputManager {


    public InputManagerEnterName(ProgramController programController,ViewController viewController, SoundManager soundManager) {
        super(viewController,programController,soundManager);
        viewController.register(this,6);

    }

    @Override
    public void keyPressed(int key){

        Visual2DArray<ArrayKeyboard> array = programController.getPlayerName().getArray2DKeyboard();
        switch (key) {
            case KeyEvent.VK_ENTER -> {
                if (array.getPointerX() == 2 && array.getPointerY() == 3) {
                    //programController.getPlayerName().insert(programController.getWindow().getEnterName());
                    programController.getPlayerName().getList().append(programController.getWindow().getEnterName());
                    programController.getWindow().switchScene(GraphicalWindow.LEADERBOARD_INDEX);
                } else {
                    programController.getWindow().getEnterName().attachToName(array.get(array.getPointerX(), array.getPointerY()).getLetter());
                }
            }
            case KeyEvent.VK_D -> array.setPointer(array.getPointerX() + 1,array.getPointerY());
            case KeyEvent.VK_A -> array.setPointer(array.getPointerX() - 1,array.getPointerY());
            case KeyEvent.VK_W -> array.setPointer(array.getPointerX(), array.getPointerY() - 1);
            case KeyEvent.VK_S-> array.setPointer(array.getPointerX(), array.getPointerY() + 1);
        }
        if(programController.getWindow().getEnterName().getLetterNumber() == 19){
            //programController.getPlayerName().insert(programController.getWindow().getEnterName());
            programController.getPlayerName().getList().append(programController.getWindow().getEnterName());
            programController.getWindow().switchScene(GraphicalWindow.LEADERBOARD_INDEX);
        }


    }





}

