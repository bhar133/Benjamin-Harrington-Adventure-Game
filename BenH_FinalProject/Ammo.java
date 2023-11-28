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
public class Ammo extends Sprite{
    public Picture ammo;
    public Picture ammo2;
    public Random randY;
    public Random randX;
    public double yVelocity;
    public double xVelocity;
    public Picture ammo3;
    
    final static ReusableClip clip = new ReusableClip("splash.wav");
    
    public Ammo(SpriteComponent sc) {
        super(sc);
        ammo = new Picture("ammo.png");
        ammo2 = ammo.resize(.0395);
        setPicture(ammo2);
        ammo3 = ammo.resize(.01);
        Image IM2 = ammo3.getImage();
        randY = new Random(5);
        yVelocity = (double) randY.nextInt(5);
        randX = new Random(5);
        yVelocity = (double) randX.nextInt(5);
        setX(1001);
        setY(BenH_FinalProject.RAND.nextInt(BenH_FinalProject.BOARD_SIZE.height));
        setVelX(-2);
        setVelY(-2.5);
    }
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
