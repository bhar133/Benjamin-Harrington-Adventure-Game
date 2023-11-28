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
public class TreeMonster extends Sprite{
    public Picture tree;
    public Picture tree2;
    public Random rand;
    public double yLoc;
    public Picture tree3;
    
    final static ReusableClip clip = new ReusableClip("splash.wav");
    
    public TreeMonster(SpriteComponent sc) {
        super(sc);
        tree = new Picture("treeMon.png");
        tree2 = tree.resize(.215);
        setPicture(tree2);
        tree3 = tree.resize(.01);
        Image IM2 = tree3.getImage();
        rand = new Random(600);
        yLoc = (double) rand.nextInt(600);
        setX(920);
        setY(BenH_FinalProject.RAND.nextInt(BenH_FinalProject.BOARD_SIZE.height));
        setVelX(-.75);
        setVelY(0);
    }
}
