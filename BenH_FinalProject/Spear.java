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

/**
 *
 * @author swimf
 */
public class Spear extends Sprite{
    public Picture spear;
    public Picture spear2;
    public Picture spear3;
    final static ReusableClip clip = new ReusableClip("splash.wav");
    
    public Spear(SpriteComponent sc, int y) {
        super(sc);
        spear = new Picture("spear.png");
        spear2 = spear.resize(.15);
        setPicture(spear2);
        spear3 = spear.resize(.01);
        Image IM2 = spear3.getImage();
        setX(850);
        setY(y);
        setVelX(-2);
        setVelY(0);
    }
}
