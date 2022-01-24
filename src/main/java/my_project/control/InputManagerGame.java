package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Shot;
import my_project.view.Game;

import java.awt.event.KeyEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManagerGame extends InputManager {

    private Game game;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManagerGame(ProgramController programController, ViewController viewController, SoundManager soundManager, Game game){
        super(viewController,programController,soundManager);
        this.game = game;
        viewController.register(this, 2);
    }

    @Override
    public void keyPressed(int key){

        if(key == KeyEvent.VK_SPACE){
            Shot shot = new Shot(viewController, programController.getPlayer().getX()+92.5, programController.getPlayer().getY()-55,100,false,programController);
            // ToDo: Schießen
        }

        if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            if (programController.getPlayer().getArrayX() != 0){
                programController.getArray().set(null, programController.getPlayer().getArrayX(), 7);
                programController.getArray().set(programController.getPlayer(), programController.getPlayer().getArrayX() - 1, 7);
                programController.getPlayer().setArrayX(programController.getPlayer().getArrayX() - 1);
            }
        }

        if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
            if (programController.getPlayer().getArrayX() != 10) {
                programController.getArray().set(null, programController.getPlayer().getArrayX(), 7);
                programController.getArray().set(programController.getPlayer(), programController.getPlayer().getArrayX() + 1, 7);
                programController.getPlayer().setArrayX(programController.getPlayer().getArrayX() + 1);
            }
        }

        if(key == KeyEvent.VK_F){
            programController.getEnemyWave().summonWaveNormal11();
        }
        forceMainMenu(key);
    }
}