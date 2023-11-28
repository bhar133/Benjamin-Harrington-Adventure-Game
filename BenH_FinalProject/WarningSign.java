package BenH_FinalProject;


import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Dimension;
import java.awt.Image;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author swimf
 */
public class WarningSign extends Sprite{
    public Picture sign;
    
    public WarningSign(SpriteComponent sc) {
        super(sc);
        sign = new Picture("2dpixelsign.png");
        Image IM = sign.getImage();
        Dimension d = sc.getSize();
        setPicture(sign);
        setX(d.width/2);
        setY(d.height/2);
    }
}
