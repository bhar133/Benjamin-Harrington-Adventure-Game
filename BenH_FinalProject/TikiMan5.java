/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BenH_FinalProject;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Image;

/**
 *
 * @author swimf
 */
public class TikiMan5 extends Sprite{
    public Picture tiki;
    public Picture tiki2;
    public Picture tiki3;
    
    
    public TikiMan5(SpriteComponent sc, int y) {
        super(sc);
        tiki = new Picture("tikiman.png");
        tiki2 = tiki.resize(.15);
        setPicture(tiki2);
        tiki3 = tiki.resize(.01);
        Image IM2 = tiki3.getImage();
        setX(850);
        setY(y);
        setVelX(0);
        setVelY(0);
    }
}
