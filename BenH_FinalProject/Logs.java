/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BenH_FinalProject;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import basicgraphics.sounds.ReusableClip;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Random;

/**
 *
 * @author swimf
 */
public class Logs extends Sprite{
    public Picture log;
    public Picture log2;
    public Random rand;
    public double yLoc;
    public Picture log3;
    
    final static ReusableClip clip = new ReusableClip("splash.wav");
    
    public Logs(SpriteComponent sc) {
        super(sc);
        log = new Picture("Log_Side.png");
        log2 = log.resize(.15);
        setPicture(log2);
        log3 = log.resize(.01);
        Image IM2 = log3.getImage();
        rand = new Random(600);
        yLoc = (double) rand.nextInt(600);
        setX(1001);
        setY(BenH_FinalProject.RAND.nextInt(BenH_FinalProject.BOARD_SIZE.height));
        setVelX(-3);
        setVelY(0);
    }
}
