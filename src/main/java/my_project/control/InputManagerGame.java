package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import my_project.model.Buff;
import my_project.model.PlayerLife;
import my_project.model.Shot;

import java.awt.event.KeyEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManagerGame extends InputManager {

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManagerGame(ProgramController programController, ViewController viewController, SoundManager soundManager){
        super(viewController,programController,soundManager);
        viewController.register(this, 3);
    }

    @Override

    public void keyPressed(int key){
        if(key == KeyEvent.VK_SPACE){
            if(programController.getPlayer().getShootCooldown() == 0){
                SoundController.playSound("shootPlayer");
                new Shot(viewController, programController, programController.getPlayer().getX()-28, programController.getPlayer().getY() - 120,1300,false);
                programController.getPlayer().setShootCooldown(programController.getPlayer().isRapidFire() ? 0.1 : 0.5);
            }
        }

        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            /*if (programController.getPlayer().getArrayX() != 1 && programController.getPlayer().getMoveCooldown() == 0){
                programController.getArray().set(null, programController.getPlayer().getArrayX(), 7);
                programController.getArray().set(programController.getPlayer(), programController.getPlayer().getArrayX() - 1, 7);
                programController.getPlayer().setArrayX(programController.getPlayer().getArrayX() - 1);
                programController.getPlayer().setMoveCooldown(0.33);
            }*/
            programController.getPlayer().setMove(0);
        }

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            /*if (programController.getPlayer().getArrayX() != 11 && programController.getPlayer().getMoveCooldown() == 0) {
                programController.getArray().set(null, programController.getPlayer().getArrayX(), 7);
                programController.getArray().set(programController.getPlayer(), programController.getPlayer().getArrayX() + 1, 7);
                programController.getPlayer().setArrayX(programController.getPlayer().getArrayX() + 1);
                programController.getPlayer().setMoveCooldown(0.33);
            }*/
            programController.getPlayer().setMove(2);
        }

        if (key == KeyEvent.VK_M) {
            viewController.showScene(6);
        }

        if(key == KeyEvent.VK_F){
            programController.getEnemyWave().summonAWave();
        }

        if (key == KeyEvent.VK_B) { // Für Test-Zwecke
            programController.createBuff();
        }

        if (key == KeyEvent.VK_H) { // Verwenden der Buffs, Taste kann noch geändert werden
            if (programController.getBuffVisualQueue().getFront() != null) {
                switch (programController.getBuffVisualQueue().getFront().getRandomNumber()) {
                    case 0 -> {
                        programController.createExtraLife();
                        programController.getPlayer().setExtraLife(true);
                    }
                    case 1 -> programController.getPlayer().setRapidFire(true);
                    case 2 -> programController.getPlayer().setSpeedBoost(true);
                    case 3 -> programController.getPlayer().setPiercing(true);
                    case 4 -> programController.getPlayer().setShield(true);
                }
                programController.getBuffVisualQueue().dequeue();
            }
        }

        setVolume(key);
        forceMainMenu(key);
    }

    @Override
    public void keyReleased(int key) {
        if(key == KeyEvent.VK_A || key == KeyEvent.VK_D || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            programController.getPlayer().setMove(1);
        }
    }
}