/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BenH_FinalProject;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import basicgraphics.sounds.ReusableClip;
import java.awt.Dimension;

/**
 *
 * @author swimf
 */
public class Explorer extends Sprite{
    
    public Picture explorer;
    public Picture explorer2;
    final static ReusableClip clip = new ReusableClip("splash.wav");
    final static ReusableClip clip2 = new ReusableClip("splat.wav");
    public Explorer(SpriteComponent sc) {
        super(sc);
        explorer = new Picture("explorer.png");
        explorer2 = explorer.resize(.15);
        Dimension d = sc.getSize();
        setPicture(explorer2);
        setX(d.width/2);
        setY(d.height/2);
        setVelX(0);
        setVelY(0);
    }
    
    public void move(double incr, int direction) {
        if(direction == 0){
            setVelY(incr);
            setVelX(0);
        }
        else if(direction == 1){
            setVelX(incr);
            setVelY(0);
        }
        else{
            setVelX(0);
            setVelY(0);
        }
        setPicture(explorer2);
    }
    
    @Override
    public void processEvent(SpriteCollisionEvent se) {
        SpriteComponent sc = getSpriteComponent();
        if(se.eventType == CollisionEventType.WALL_INVISIBLE) {
            if (se.xlo) {
                setX(sc.getSize().width - getWidth());
            }
            if (se.xhi) {
                setX(0);
            }
            if (se.ylo) {
                setY(sc.getSize().height - getHeight());
            }
            if (se.yhi) {
                setY(0);
            }
        }
    }
}
