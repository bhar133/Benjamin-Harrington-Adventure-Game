/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BenH_FinalProject;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import basicgraphics.sounds.ReusableClip;
import java.awt.Image;
import java.util.Random;

/**
 *
 * @author swimf
 */
public class Rocks extends Sprite{
    public Picture rock;
    public Picture rock2;
    public Random rand;
    public double yLoc;
    public Picture rock3;
    public double yVel;
    public double xVel;
    public Random rand3;
    public Random rand2;
    
    final static ReusableClip clip = new ReusableClip("splash.wav");
    
    public Rocks(SpriteComponent sc) {
        super(sc);
        rock = new Picture("rock.png");
        rock2 = rock.resize(.15);
        setPicture(rock2);
        rock3 = rock.resize(.70);
        Image IM2 = rock3.getImage();
        rand = new Random(600);
        rand2 = new Random(10);
        yVel = (double) rand.nextInt(5);
        rand2 = new Random(3);
        yVel = (double) rand.nextInt(3);
        yLoc = (double) rand.nextInt(600);
        setX(1001);
        setY(BenH_FinalProject.RAND.nextInt(BenH_FinalProject.BOARD_SIZE.height));
        setVelX(-2.35);
        setVelY(1.3);
    }
    
    @Override
    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        System.out.println("Process event, " + se.eventType);
        if(se.eventType == CollisionEventType.WALL_INVISIBLE || se.eventType == CollisionEventType.WALL) {
            if (se.ylo) {
                setVelY(-getVelY());
            }
            if (se.yhi) {
                setVelY(-getVelY());
            }
        }
    }
}
