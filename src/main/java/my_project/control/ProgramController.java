package my_project.control;

import KAGO_framework.control.SoundController;
import my_project.Config;
import my_project.model.*;
import KAGO_framework.control.ViewController;
import my_project.view.*;

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
    private Enemy[][] array;
    private VisualStack<PlayerLife> playerLifesStack;
    private VisualList<PlayerName> nameList;
    private VisualQueue<Buff> buffVisualQueue;
    private Player player;
    private PlayerLife playerLife;
    private PlayerLife emptyPlayerLife;
    private PlayerLife extraLife;
    private EnemyWave enemyWave;
    private Buff buff;
    private boolean moveTimerActive;


    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
        soundManager = new SoundManager(viewController);
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        array = new Enemy[11][6];
        playerLifesStack = new VisualStack<>(viewController);
        buffVisualQueue = new VisualQueue<>(viewController, 50, 950, "up");
        window = new GraphicalWindow(viewController, this);
        nameList = new VisualList<>(0,0,0,0);

        new InputManagerMainMenu(this, viewController, soundManager);
        new InputManagerOptions(this, viewController, window.getOptions(), soundManager);
        new InputManagerGame(this, viewController, soundManager);
        new InputManagerEnterName(this, viewController, soundManager);
        new InputManagerLeaderboard(this,viewController,soundManager);
        new InputManagerGuide(this, viewController, soundManager);

        player = new Player(viewController, getWindow().programController);

        emptyPlayerLife = new PlayerLife(1810, 810, viewController, this, 1);
        emptyPlayerLife = new PlayerLife(1810, 880, viewController, this, 1);
        emptyPlayerLife = new PlayerLife(1810, 950, viewController, this, 1);

        playerLife = new PlayerLife(1810, 810, viewController, this, 0);
        playerLife = new PlayerLife(1810, 880, viewController, this, 0);
        playerLife = new PlayerLife(1810, 950, viewController, this, 0);

        enemyWave = new EnemyWave(viewController,this, window.getGame());

        SoundController.playSound("mainMenuTheme");
    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

    }

    public void createBuff(){
        buff = new Buff(935, 0, viewController, this);
    }

    public void createExtraLife(){
        extraLife = new PlayerLife(1810, 740, viewController, this, 2);
    }

    public PlayerLife getExtraLife() {
        return extraLife;
    }

    public GraphicalWindow getWindow(){
        return window;
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy[][] getArray() {
        return array;
    }

    public EnemyWave getEnemyWave(){
        return enemyWave;
    }

    public Buff getBuff() {
        return buff;
    }

    public VisualStack<PlayerLife> getStack(){
        return playerLifesStack;
    }

    public void setMoveTimerActive(boolean moveTimerActive) {
        this.moveTimerActive = moveTimerActive;
    }

    public VisualQueue<Buff> getBuffVisualQueue() {
        return buffVisualQueue;
    }
}
