/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BenH_FinalProject;

import static basicflyer.Plasma.makeBall;
import basicgraphics.BasicFrame;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import basicgraphics.sounds.ReusableClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author swimf
 */
public class Acid extends Sprite{
    final static ReusableClip clip = new ReusableClip("splash.wav");
    final static ReusableClip clip2 = new ReusableClip("steam.wav");
    public static Picture makeAcid(Color color, int size) {
        Image im = BasicFrame.createImage(size, size);
        Graphics g = im.getGraphics();
        g.setColor(color);
        g.fillOval(0, 0, size, size);
        return new Picture(im);
    }
    public Acid(SpriteComponent sc) {
        super(sc);
        setPicture(makeBall(Color.black, 15));
    }
    
}
