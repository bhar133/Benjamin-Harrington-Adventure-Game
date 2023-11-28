/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BenH_FinalProject;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Image;
import java.util.Random;

/**
 *
 * @author swimf
 */
public class Fern extends Sprite{
    
    public Picture fern;
    public Picture fern2;
    public Random rand;
    public double yLoc;
    public double xLoc;
    public double yVel;
    public double xVel;
    public Random rand2;
    
    public Fern(SpriteComponent sc) {
        super(sc);
        fern = new Picture("fern.png");
        fern2 = fern.resize(.157);
        setPicture(fern2);
        rand = new Random(600);
        rand2 = new Random(100);
        yLoc = (double) rand.nextInt(600);
        xLoc = (double) rand2.nextInt(1000);
        setX(BenH_FinalProject.RAND.nextInt(BenH_FinalProject.BOARD_SIZE.width));
        setY(BenH_FinalProject.RAND.nextInt(BenH_FinalProject.BOARD_SIZE.height));
        setVelX(0);
        setVelY(0);
    }
}
