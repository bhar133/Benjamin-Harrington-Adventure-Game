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
public class River extends Sprite{
    public Picture river;
    public Picture river2;
    public Picture river3;
    
    public River(SpriteComponent sc) {
        super(sc);
        river = new Picture("river.png");
        river2 = river.resize(2.5);
        setPicture(river2);
        river3 = river.resize(.70);
        Image IM2 = river3.getImage();
        setX(-435);
        setY(-100);
        setVelX(0);
        setVelY(0);
    }
}
