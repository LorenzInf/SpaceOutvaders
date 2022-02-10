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

    /** Checks which Button gets pressed in EnterName; Moving the Cursor | Pressing the Letter | Checking if LetterNumber is not too high
     * @param key The pressed key
     */
    @Override
    public void keyPressed(int key){
        Visual2DArray<ArrayKeyboard> array = programController.getPlayerName().getArray2DKeyboard();
        if(key == KeyEvent.VK_ENTER || key == KeyEvent.VK_SPACE) {
            if (array.getPointerX() == 2 && array.getPointerY() == 3 && array.getPointerX() < 3) {
                programController.getPlayerName().insert(programController.getWindow().getEnterName());
                programController.getWindow().switchScene(GraphicalWindow.LEADERBOARD_INDEX);
                programController.getWindow().getEnterName().setLetterNumber(0);
            } else if (array.getPointerX() < 3 || array.getPointerY() < 3){
                programController.getWindow().getEnterName().attachToName(array.get(array.getPointerX(), array.getPointerY()).getLetter());
            }
        }

        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) array.setPointer(array.getPointerX() + 1,array.getPointerY());
        if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) array.setPointer(array.getPointerX() - 1,array.getPointerY());
        if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) array.setPointer(array.getPointerX(), array.getPointerY() - 1);
        if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) array.setPointer(array.getPointerX(), array.getPointerY() + 1);

        if(programController.getWindow().getEnterName().getLetterNumber() == 19){
            programController.getPlayerName().insert(programController.getWindow().getEnterName());
            programController.getWindow().switchScene(GraphicalWindow.LEADERBOARD_INDEX);
            programController.getWindow().getEnterName().setLetterNumber(0);
        }


    }





}

