/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BenH_FinalProject;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import basicgraphics.sounds.ReusableClip;
import java.awt.Image;
import java.util.Random;

/**
 *
 * @author swimf
 */
public class Gun extends Sprite{
    public Picture gun;
    public Picture gun2;
    public Random rand;
    public double yLoc;
    public Picture gun3;
    final static ReusableClip clip = new ReusableClip("splash.wav");
    final static ReusableClip clip2 = new ReusableClip("shoot.wav");
    
    public Gun(SpriteComponent sc) {
        super(sc);
        gun = new Picture("gun.png");
        gun2 = gun.resize(.05);
        setPicture(gun2);
        gun3 = gun.resize(.01);
        Image IM2 = gun3.getImage();
        rand = new Random(600);
        yLoc = (double) rand.nextInt(600);
        setX(1001);
        setY(BenH_FinalProject.BOARD_SIZE.height/2);
        setVelX(-.75);
        setVelY(0);
    }
}
