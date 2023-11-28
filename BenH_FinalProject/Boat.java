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

/**
 *
 * @author swimf
 */
public class Boat extends Sprite{
    
    public Picture ship;
    public Picture ship2;
    final static ReusableClip clip = new ReusableClip("win.wav");
    public Boat(SpriteComponent sc) {
        super(sc);
        ship = new Picture("ship.png");
        ship2 = ship.resize(.45);
        Dimension d = sc.getSize();
        setPicture(ship2);
        setX(233);
        setY(600);
        setVelX(0);
        setVelY(-1);
    }
}
