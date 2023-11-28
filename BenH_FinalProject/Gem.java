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
public class Gem extends Sprite{
    public Picture Gem;
    public Picture Gem2;
    public Picture Gem3;
    final static ReusableClip clip = new ReusableClip("collect.wav");
    
    public Gem(SpriteComponent sc) {
        super(sc);
        Gem = new Picture("Gems.png");
        Gem2 = Gem.resize(.1);
        setPicture(Gem2);
        Gem3 = Gem.resize(.01);
        Image IM2 = Gem3.getImage();
        setX(750);
        setY(300);
        setVelX(0);
        setVelY(0);
    }
}
