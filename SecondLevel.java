import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.lang.Math;
/**
 * Write a description of class SecondLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondLevel extends World
{
    GreenfootSound coins = new GreenfootSound("coin.mp3");
    Peep player = new Peep();
    Health h = new Health();
    Health h1 = new Health();
    Health h2 = new Health();
    int counter = 0;
    Penguin airplane = new Penguin();
    Penguin airplane2 = new Penguin();
    Random rand = new Random();
    Coin coiner = new Coin();
    int health = 3;
    int coincounter = 0;
    int coinscollected = 0;
    int counter2 = 0;
    Point p5 = new Point();
    Point p1 = new Point();
    Point p2 = new Point();
    Point p3 = new Point();
    Point p4 = new Point();
    Point p6 = new Point();
    MissingPoint m1 = new MissingPoint();
    MissingPoint m2 = new MissingPoint();
    MissingPoint m3 = new MissingPoint();
    MissingPoint m4 = new MissingPoint();
    MissingPoint m5 = new MissingPoint();
    MissingPoint m6 = new MissingPoint();
    /**
     * Constructor for objects of class SecondLevel.
     * 
     */
    public SecondLevel()
    {    
        super(1000, 550, 1); 
        setBackground("Snow.jpg");
        addObject(player, 100, 250);
        addObject(h, 25, 50);
        addObject(h1, 100, 50);
        addObject(h2, 175, 50);
        addObject(airplane, 990, 250);
        addObject(coiner, 990, 350);
        addObject(airplane2, 990, 400);
        addObject(m1, 700, 50);
        addObject(m2, 750, 50);
        addObject(m3, 800, 50);
        addObject(m4, 850, 50);
        addObject(m5, 900, 50);
        addObject(m6, 950, 50);
    }
    
    public void act(){
        if ((Math.abs(player.getX() - airplane.getX()) < 100) && (Math.abs(player.getY() - airplane.getY()) < 100)){
            health--;
            airplane.setLocation(990, rand.nextInt(500));
            counter = 0;
        }
        if ((Math.abs(player.getX() - coiner.getX()) < 100) && (Math.abs(player.getY() - coiner.getY()) < 100)){
            coinscollected++;
            coiner.setLocation(990, rand.nextInt(500));
            coincounter = 0;
            coins.play();
        }
        if ((Math.abs(player.getX() - airplane2.getX()) < 100) && (Math.abs(player.getY() - airplane2.getY()) < 100)){
            health--;
            airplane2.setLocation(990, rand.nextInt(500));
            counter2 = 0;
            coins.play();
        }
        counter2++;
        counter++;
        coincounter++;
        int rander = 0;
        if (health == 2){
            removeObject(h2);
        }
        if (health == 1){
            removeObject(h1);
        }
        if (health == 0){
            Greenfoot.setWorld(new GameOver());
        }
        if (coinscollected == 1){
            removeObject(m1);
            addObject(p1, 700, 50);
        }
        if (coinscollected == 2){
            removeObject(m2);
            addObject(p2, 750, 50);
        }
        if (coinscollected == 3){
            removeObject(m3);
            addObject(p3, 800, 50);
        }
        if (coinscollected == 4){
            removeObject(m4);
            addObject(p4, 850, 50);
        }
        if (coinscollected == 5){
            removeObject(m5);
            addObject(p5, 900, 50);
        }
        if (coinscollected == 6){
            removeObject(m6);
            addObject(p6, 950, 50);
        }
        if (coinscollected == 7){
            Greenfoot.setWorld(new ExtraLevel());
        }
        if (Greenfoot.isKeyDown("up")){
            player.setLocation(player.getX(), player.getY() - 3);
        }
        if (Greenfoot.isKeyDown("down")){
            player.setLocation(player.getX(), player.getY() + 5);
        }
        if (Greenfoot.isKeyDown("right")){
            player.setLocation(player.getX() + 2, player.getY());
        }
        if (Greenfoot.isKeyDown("left")){
            player.setLocation(player.getX() - 2, player.getY());
        }
        
        if (counter < 350){
            airplane.setLocation(airplane.getX() - 3, airplane.getY());
        }
        if (counter == 350){
            counter = 0;
            airplane.setLocation(990, rand.nextInt(500));
        }
        if (coincounter < 250){
            coiner.setLocation(coiner.getX() - 4, coiner.getY());
        }
        if (coincounter == 250){
            coincounter = 0;
            coiner.setLocation(990, rand.nextInt(500));
        }
        if (counter2 < 250){
            airplane2.setLocation(airplane2.getX() - 4, airplane2.getY());
        }
        if (counter2 == 250){
            counter2 = 0;
            airplane2.setLocation(990, rand.nextInt(500));
        }
        
    }
}
