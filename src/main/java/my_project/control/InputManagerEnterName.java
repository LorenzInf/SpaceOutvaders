package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.view.EnterName;
import my_project.view.Game;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class InputManagerEnterName extends InputManager {

    public InputManagerEnterName(ProgramController programController,ViewController viewController, SoundManager soundManager) {
        super(viewController, programController, soundManager);
        viewController.register(this,6);
    }

    @Override
    public void keyPressed(int key){
        if (key == KeyEvent.VK_ENTER) {
            viewController.showScene(4);
        }



        /*switch (key){
            case KeyEvent.VK_A->
            case KeyEvent.VK_B->
            case KeyEvent.VK_C->
            case KeyEvent.VK_D->
            case KeyEvent.VK_E->
            case KeyEvent.VK_F->
            case KeyEvent.VK_G->
            case KeyEvent.VK_H->
            case KeyEvent.VK_I->
            case KeyEvent.VK_J->
            case KeyEvent.VK_K->
            case KeyEvent.VK_L->
            case KeyEvent.VK_M->
            case KeyEvent.VK_N->
            case KeyEvent.VK_O->
            case KeyEvent.VK_P->
            case KeyEvent.VK_Q->
            case KeyEvent.VK_R->
            case KeyEvent.VK_S->
            case KeyEvent.VK_T->
            case KeyEvent.VK_U->
            case KeyEvent.VK_V->
            case KeyEvent.VK_W->
            case KeyEvent.VK_X->
            case KeyEvent.VK_Y->
            case KeyEvent.VK_Z-> */




    }

}

