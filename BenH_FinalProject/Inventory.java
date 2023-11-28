/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BenH_FinalProject;

import basicgraphics.BasicFrame;
import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author swimf
 */
public class Inventory extends Sprite{
    
        private BufferedImage image;
        private Graphics graphic;
        private Graphics amG;
        private Picture pic;
        private Picture pic2;
        private BufferedImage image2;

        static Picture newInventoryPicture(int ammo) {
        BufferedImage image = BasicFrame.createImage(450, 50);
        Graphics graphic = image.getGraphics();
        graphic.setColor(Color.white);
        graphic.fillRect(0, 0, 175, 40);
        Color c = new Color(0, 0, 0);
        graphic.setColor(c);
        Font f = new Font("Arial", 3, 20);
        graphic.setFont(f);
        String ammoS = "Gun Ammo: " + ammo + "";
        graphic.drawString(ammoS, 20, 25);
        return  new Picture(image);
        }
    public Inventory(SpriteComponent sc, int ammo) {
        super(sc);
        this.setX(1);
        this.setY(1);
        pic = newInventoryPicture(ammo);
        this.setPicture(pic);
    }
}
