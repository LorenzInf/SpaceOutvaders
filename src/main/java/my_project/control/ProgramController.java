package my_project.control;

import KAGO_framework.control.SoundController;
import my_project.model.EnemyWave;
import my_project.model.Player;
import KAGO_framework.control.ViewController;
import my_project.model.Shot;
import my_project.model.Entity;
import my_project.view.Visual2DArray;

import java.awt.*;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private final ViewController viewController;
    private final SoundManager soundManager;
    private GraphicalWindow window;
    private Visual2DArray<Entity> array;
    private Player player;
    private EnemyWave enemyWave;


    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
        soundManager = new SoundManager();
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        array = new Visual2DArray<>(11, 8, 0 , 0, new Visual2DArray.VisualizationConfig(0,-350, 173, 175, 0, true, false, false, null, Color.WHITE, new Color(29, 173, 11, 0)));
        window = new GraphicalWindow(viewController, this);

        new InputManagerMainMenu(this, viewController, soundManager);
        new InputManagerOptions(this, viewController, window.getOptions(), soundManager);
        new InputManagerGame(this, viewController, soundManager, getWindow().getGame());

        player = new Player(5,0,0,false, 0, viewController, getWindow().programController);
        array.set(player,5,7);
        enemyWave = new EnemyWave(viewController,this);

        viewController.draw(array, 3);
        viewController.register(array);

        soundManager.updateSoundController();
        SoundController.playSound("mainMenuTheme");
    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

    }

    public GraphicalWindow getWindow(){
        return window;
    }

    public Player getPlayer() {
        return player;
    }

    public Visual2DArray<Entity> getArray() {
        return array;
    }

    public EnemyWave getEnemyWave(){
        return enemyWave;
    }
}
