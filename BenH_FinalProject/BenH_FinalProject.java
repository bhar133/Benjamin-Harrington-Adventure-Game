/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BenH_FinalProject;




import basicgraphics.BasicContainer;
import basicgraphics.BasicFrame;
import basicgraphics.Clock;
import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.SpriteSpriteCollisionListener;
import basicgraphics.Task;
import basicgraphics.images.Picture;
import basicgraphics.sounds.ReusableClip;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author swimf
 */
public class BenH_FinalProject{
    
    public Picture map;
    public int direction = 0;
    final public static Random RAND = new Random();
    final public static Dimension BOARD_SIZE = new Dimension(1000,600);
    public boolean gunActive = false;//For making gun active and not active
    public int ammo = 0;
    public int tikiCount = 5;//Checks for how many TikiMen are alive
    public boolean gemGot = false;//Checks if gem has been picked up
    public int gemCount = 0;
    public boolean logsClip;//Makes sure the sound only plays once per sprite hitting the river
    public boolean exClip;//Makes sure the sound only plays once per sprite hitting the river
    public boolean rocksClip;//Makes sure the sound only plays once per sprite hitting the river
    public boolean treeClip;//Makes sure the sound only plays once per sprite hitting the river
    public boolean acidClip;//Makes sure the sound only plays once per sprite hitting the river
    public boolean spearClip;//Makes sure the sound only plays once per sprite hitting the river
    public boolean tikiA1;//These tikiA# are checking if the TikiMan# that each number corolates to is alive
    public boolean tikiA2;
    public boolean tikiA3;
    public boolean tikiA4;
    public boolean tikiA5;
    
    public void run() {
        
        final BasicFrame bf = new BasicFrame("Adventure");
        final Container content = bf.getContentPane();
        final CardLayout cards = new CardLayout();
        content.setLayout(cards);
        BasicContainer bc1 = new BasicContainer();
        content.add(bc1,"HomeScreen");
        final BasicContainer bc2 = new BasicContainer();
        content.add(bc2,"Game");
        //The BasicContainers below are created for the story of the game and he controls
        final BasicContainer bc3 = new BasicContainer();
        content.add(bc3,"Info");
        final BasicContainer bc4 = new BasicContainer();
        content.add(bc4,"Story");
        final BasicContainer bc5 = new BasicContainer();
        content.add(bc5,"WarningPics");
        final BasicContainer bc6 = new BasicContainer();
        content.add(bc6,"WarningLog");
        final BasicContainer bc7 = new BasicContainer();
        content.add(bc7,"WarningRock");
        final BasicContainer bc8 = new BasicContainer();
        content.add(bc8,"WarningTreeMonster");
        final BasicContainer bc9 = new BasicContainer();
        content.add(bc9,"WarningTikiMan");
        final BasicContainer bc10 = new BasicContainer();
        content.add(bc10,"Gem");
        final BasicContainer bc11 = new BasicContainer();
        content.add(bc11,"GunInfo");
        final BasicContainer bc12 = new BasicContainer();
        content.add(bc12,"BoatInfo");  
        final BasicContainer bc13 = new BasicContainer();
        content.add(bc13,"Controls"); 
        final BasicContainer bc14 = new BasicContainer();
        content.add(bc14,"GoodLuck"); 
        final SpriteComponent sc = new SpriteComponent() {
            @Override
            public void paintBackground(Graphics g) {
                Dimension d = getSize();
                g.setColor(Color.green);
                g.fillRect(0, 0, d.width, d.height);
                final int NUM_SPECS = 34;
                Random rand = new Random();
                rand.setSeed(0);
                g.setColor(Color.lightGray);
                for(int i=0;i<NUM_SPECS;i++) {
                    int diameter = 20;
                    int xpos = rand.nextInt(d.width);
                    int ypos = rand.nextInt(d.height);
                    g.fillRect(xpos, ypos, diameter, diameter);
                }
                Color c = new Color(0, 0, 0);
                g.setColor(c);
                Font f = new Font("Arial", 3, 10);
                g.setFont(f);
                String ammoS = "Gun Ammo: " + ammo + "";
                g.drawString(ammoS, 50, 100);
            }
        };
        
        sc.setPreferredSize(new Dimension(1000,600));
        String[][] HomeScreenLayout = {
            {"Title"},
            {"WarningLabel"},
            {"QuickStart"},
            {"Button"},
            {"Button2"}
        };
        bc1.setStringLayout(HomeScreenLayout);
        bc1.add("Title",new JLabel("The Adventure of the Mystical Jungle"));
        bc1.add("WarningLabel",new JLabel("If you have not read the Mission Info click the button below"));
        bc1.add("QuickStart",new JLabel("If you have read the Mission Info and do not wish to again, click the Begin Adventure Here button"));
        JButton jstart = new JButton("Begin Adventure Here");
        Task t = new Task(10000){ //This Task calls the flow of all the enemy sprites, the gem sprite, and the boat sprite
            @Override
            public void run() {
                if(iteration() <= 3100){
                    if (iteration() % 245 == 0 && iteration() <= 2500) {
                        for (int i = 0; i <= 3; i++) {
                            Logs l = new Logs(sc);
                            logsClip = true;
                        }
                    } else if (iteration() % 750 == 0 && iteration() <= 3100) {
                        for (int i = 0; i <= 4; i++) {
                            Rocks rock = new Rocks(sc);
                            rocksClip = true;
                        }
                    } else if (iteration() % 1000 == 0 && iteration() <= 3000) {
                        for (int i = 0; i <= 2; i++) {
                            TreeMonster tree = new TreeMonster(sc);
                            treeClip = true;
                            if (iteration() % 10  == 0 && iteration() >= 1000) {
                                Acid acid = new Acid(sc);
                                acid.setVelX(-2.5);
                                acid.setVelY(tree.getVelY());
                                acid.setCenterX(tree.centerX());
                                acid.setCenterY(tree.centerY());
                                acidClip = true;
                            }
                        }
                    } else if (iteration() % 950 == 0 && iteration() == 950) {
                        for (int i = 0; i < 1; i++) {
                            Gun g = new Gun(sc);
                        }
                    } else if (iteration() % 1250 == 0) {
                        for (int i = 0; i < 1; i++) {
                            Ammo a = new Ammo(sc);
                        }
                    }
                }else {
                    if(iteration() % 3200 == 0 && iteration() <= 3201){
                        for(int i = 0; i < 1; i++){
                            TikiMan tiki1 = new TikiMan(sc, 100);
                            tikiA1 = true;
                            TikiMan2 tiki2 = new TikiMan2(sc,200);
                            tikiA2 = true;
                            TikiMan3 tiki3 = new TikiMan3(sc,300);
                            tikiA3 = true;
                            TikiMan4 tiki4 = new TikiMan4(sc,400);
                            tikiA4 = true;
                            TikiMan5 tiki5 = new TikiMan5(sc,500);
                            tikiA5 = true;
                        }
                    }
                    if (iteration() % 150 == 0 && tikiCount > 0 && iteration() > 3200) {
                        for (int i = 0; i < 1; i++) {
                            if(tikiA1){
                            Spear s1 = new Spear(sc, 100);}
                            if(tikiA2){
                            Spear s2 = new Spear(sc, 200);}
                            if(tikiA3){
                            Spear s3 = new Spear(sc, 300);}
                            if(tikiA4){
                            Spear s4 = new Spear(sc, 400);}
                            if(tikiA5){
                            Spear s5 = new Spear(sc, 500);}
                            spearClip = true;
                        }
                    }
                    if (iteration() % 390 == 0 && tikiCount > 0) {
                        Ammo a2 = new Ammo(sc);
                    }
                    if(tikiCount == 0 && !gemGot){
                        if(iteration() % 100 == 0 && iteration() <= 5000){
                            gemCount++;
                            if(gemCount == 1){
                            for(int i = 0; i < 1; i++){
                                Gem gem = new Gem(sc);}}
                        }
                    }
                }
                if (gemGot) {
                    if (iteration() % 5200 == 0 && iteration() < 5201) {
                        for(int i = 0; i < 1; i++){
                        Boat boat = new Boat(sc);}
                    }
                }
            }
        };
        jstart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content,"Game");
                bc2.requestFocus();
                System.out.println("Works");
                Clock.start(10);
                Clock.addTask(t);
            }
        });
        JButton jinfo = new JButton("Mission Info");
        jinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content,"Info");
                bc3.requestFocus();
                Clock.start(10);
            }
        });
        bc1.add("Button",jinfo);
        bc1.add("Button2",jstart);
        
        String[][] layout = {
            {"Adventure"}
        };
        bc2.setStringLayout(layout);
        bc2.add("Adventure",sc);
        
        String[][] infoLayout = {
            {"Info"},
            {"Story"},
            {"Story2"},
            {"Next"},
            {"Back"}
        };
        bc3.setStringLayout(infoLayout);  
        bc3.add("Info", new JLabel("Welcome to the Adventure of The Mystical Jungle"));
        bc3.add("Story", new JLabel("You have set out on an adventure to find the lost jewel of the Amazon!"));
        bc3.add("Story2", new JLabel("The jewel is hidden somewhere in middle most dense part of the jungle"));
        
        JButton jinfoNext = new JButton("Next");
        jinfoNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "Story");
                bc4.requestFocus();
                Clock.start(10);
            }
        });
        bc3.add("Next", jinfoNext);
        JButton jinfoBack = new JButton("Back");
        jinfoBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "HomeScreen");
                bc1.requestFocus();
                Clock.start(10);
            }
        });
        bc3.add("Back", jinfoBack);
        
        String[][] storyLayout = {
            {"Warning"},
            {"Explination"},
            {"More"},
            {"NextInfo"},
            {"Next"},
            {"Title Screen"}
        };
        bc4.setStringLayout(storyLayout);
        bc4.add("Warning", new JLabel("BEWARE Jungle is very deadly!"));
        bc4.add("Explination", new JLabel("There are lots of dangerous creatures and obsticles within the jungle!"));
        bc4.add("More", new JLabel("Whatever you do, DO NOT TOUCH anything that looks dangerous!"));
        bc4.add("NextInfo", new JLabel("Click next to see a preview of the dangers within the jungle"));
        
        JButton jinfoNext2 = new JButton("Next");
        jinfoNext2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "WarningPics");
                bc5.requestFocus();
                Clock.start(10);
            }
        });
        bc4.add("Next", jinfoNext2);
        JButton jinfoHome = new JButton("Title Screen");
        jinfoHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "HomeScreen");
                bc1.requestFocus();
                Clock.start(10);
            }
        });
        bc4.add("Title Screen", jinfoHome);
        
        String[][] warningLayout = {
            {"Dangers"},
            {"Hit"},
            {"Click"},
            {"Warning"},
            {"Next"},
            {"Title Screen"}
        };
        bc5.setStringLayout(warningLayout);
        bc5.add("Dangers", new JLabel("Watch out for these things!"));
        bc5.add("Hit", new JLabel("If they hit you, you will be terminated!"));
        bc5.add("Click", new JLabel("Click next and the pictures of the dangers will appear"));
        Picture p1 = new Picture("Log_Side.png");
        Picture p1jr = p1.resize(.38);
        Image im1 = p1jr.getImage();
        ImageIcon ic1 = new ImageIcon(im1);
        JButton warning1 = new JButton(ic1);
        Picture p2 = new Picture("2dpixelsign.png");
        Picture p2jr = p2.resize(.4);
        Image im2 = p2.getImage();
        ImageIcon ic2 = new ImageIcon(im2);
        JButton warning2 = new JButton(ic2);
        Picture p3 = new Picture("rock.png");
        Picture p3jr = p3.resize(.23);
        Image im3 = p3.getImage();
        ImageIcon ic3 = new ImageIcon(im3);
        JButton warning3 = new JButton(ic3);
        bc5.add(warning2);
        JButton jinfoNext3 = new JButton("Next");
        jinfoNext3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "WarningLog");
                bc6.requestFocus();
                Clock.start(10);
            }
        });
        bc5.add("Next", jinfoNext3);
        JButton jinfoHome2 = new JButton("Title Screen");
        jinfoHome2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "HomeScreen");
                bc1.requestFocus();
                Clock.start(10);
            }
        });
        bc5.add("Title Screen", jinfoHome2);
        String[][] warning2Layout = {
            {"Log"},
            {"Log2"},
            {"Beware"},
            {"More"},
            {"Next"},
            {"Title Screen"}
        };
        bc6.setStringLayout(warning2Layout);
        bc6.add("Log", new JLabel("This is a picture of the logs that will be heading towards you on your journey"));
        bc6.add("Log2", new JLabel("Four logs will come straight at you!"));
        bc6.add("Beware", new JLabel("BEWARE! These will not be the only dangers!"));
        bc6.add("More", new JLabel("Click Next for more dangers that will be found in this Jungle!"));
        JButton jinfoNext4 = new JButton("Next");
        jinfoNext4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "WarningRock");
                bc7.requestFocus();
                Clock.start(10);
            }
        });
        bc6.add("Next", jinfoNext4);
        JButton jinfoHome3 = new JButton("Title Screen");
        jinfoHome3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "HomeScreen");
                bc1.requestFocus();
                Clock.start(10);
            }
        });
        bc6.add("Title Screen", jinfoHome3);
        bc6.add(warning1);
        
        String[][] warning3Layout = {
            {"Rock"},
            {"Rock2"},
            {"Beware"},
            {"More"},
            {"Next"},
            {"Title Screen"}
        };
        bc7.setStringLayout(warning3Layout);
        bc7.add("Rock", new JLabel("This is a picture of the rocks that you might encounter on your journey"));
        bc7.add("Rock2", new JLabel("Five rocks will come tumbling at you!!"));
        bc7.add("Beware", new JLabel("BEWARE! These will not be heading in a straight line!"));
        bc7.add("More", new JLabel("Click Next for more dangers that will be found in this Jungle!"));
        JButton jinfoNext5 = new JButton("Next");
        jinfoNext5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "WarningTreeMonster");
                bc8.requestFocus();
                Clock.start(10);
            }
        });
        bc7.add("Next", jinfoNext5);
        JButton jinfoHome4 = new JButton("Title Screen");
        jinfoHome4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "HomeScreen");
                bc1.requestFocus();
                Clock.start(10);
            }
        });
        bc7.add("Title Screen", jinfoHome4);
        bc7.add(warning3);
        
        String[][] warning4Layout = {
            {"Monster"},
            {"Monster2"},
            {"Beware"},
            {"Hint"},
            {"More"},
            {"Next"},
            {"Title Screen"}
        };
        bc8.setStringLayout(warning4Layout);
        bc8.add("Monster", new JLabel("This is a picture of the rare Tree Monster that has been spotted lurking in the Jungle!"));
        bc8.add("Monster2", new JLabel("They are rare but if they see you they will attack"));
        bc8.add("Beware", new JLabel("BEWARE! These have been rumored to spit acid!"));
        bc8.add("Hint", new JLabel("Hint: They can only shoot acid once, but it is extremly deadly!"));
        bc8.add("More", new JLabel("Click Next for more dangers that will be found in this Jungle!"));
        JButton jinfoNext6 = new JButton("Next");
        jinfoNext6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "WarningTikiMan");
                bc9.requestFocus();
                Clock.start(10);
            }
        });
        bc8.add("Next", jinfoNext6);
        JButton jinfoHome5 = new JButton("Title Screen");
        jinfoHome5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "HomeScreen");
                bc1.requestFocus();
                Clock.start(10);
            }
        });
        bc8.add("Title Screen", jinfoHome5);
        Picture p4 = new Picture("treeMon.png");
        Picture p4jr = p4.resize(.45);
        Image im4 = p4jr.getImage();
        ImageIcon ic4 = new ImageIcon(im4);
        JButton warning4 = new JButton(ic4);
        bc8.add(warning4);
        String[][] warning5Layout = {
            {"TikiMan"},
            {"TikiMan2"},
            {"Beware"},
            {"Spear"},
            {"More1"},
            {"More2"},
            {"Now"},
            {"Next"},
            {"Title Screen"}
        };
        bc9.setStringLayout(warning5Layout);
        bc9.add("TikiMan", new JLabel("This is a picture of the rare Tiki Man that has been spotted lurking in the Jungle!"));
        bc9.add("TikiMan2", new JLabel("They are rare but if they see you they will attack"));
        bc9.add("Beware", new JLabel("BEWARE! These have been rumored to spit acid!"));
        bc9.add("Spear", new JLabel("The have enchanted spears that can be thrown forever! So rid of them fast!"));
        bc9.add("More1", new JLabel("Those are the only photographed dangers in this Jungle, but always keep an eye out for anything that looks dangerous"));
        bc9.add("More2", new JLabel("but always keep an eye out for anything that looks dangerous"));
        bc9.add("Now", new JLabel("Now to see what you are looking for, Click Next"));
        JButton jinfoNext7 = new JButton("Next");
        jinfoNext7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "Gem");
                bc10.requestFocus();
                Clock.start(10);
            }
        });
        bc9.add("Next", jinfoNext7);
        JButton jinfoHome6 = new JButton("Title Screen");
        jinfoHome6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "HomeScreen");
                bc1.requestFocus();
                Clock.start(10);
            }
        });
        bc9.add("Title Screen", jinfoHome6);
        Picture p5 = new Picture("TikiMan.png");
        Picture p5jr = p5.resize(.45);
        Image im5 = p5jr.getImage();
        ImageIcon ic5 = new ImageIcon(im5);
        JButton warning5 = new JButton(ic5);
        bc9.add(warning5);
        Picture p6 = new Picture("Spear.png");
        Picture p6jr = p6.resize(.45);
        Image im6 = p6jr.getImage();
        ImageIcon ic6 = new ImageIcon(im6);
        JButton warning6 = new JButton(ic6);
        bc9.add(warning6);
        String[][] GemLayout = {
            {"Gem"},
            {"Gem2"},
            {"Client"},
            {"Info"},
            {"More1"},
            {"More2"},
            {"Now"},
            {"Next"},
            {"Title Screen"}
        };
        bc10.setStringLayout(GemLayout);
        bc10.add("Gem", new JLabel("This is a picture of the rare Gem you will be searching for."));
        bc10.add("Gem2", new JLabel("It is found in the depths of the jungle!"));
        bc10.add("Client", new JLabel("You Client will remain anonymous, but will pay you well if you get the gem for them."));
        bc10.add("Info", new JLabel("Warning, the Gem is rumored to be defended by the Tiki Tribe."));
        bc10.add("More1", new JLabel("You will only have a centain amount of time to get rid of the tribe and collect the gem"));
        bc10.add("More2", new JLabel("before they take it away and hide it where you will never find it."));
        bc10.add("Now", new JLabel("Now we will be air dropping supplies, Click Next to see the supplies."));
        JButton jinfoNext8 = new JButton("Next");
        jinfoNext8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "GunInfo");
                bc11.requestFocus();
                Clock.start(10);
            }
        });
        bc10.add("Next", jinfoNext8);
        JButton jinfoHome7 = new JButton("Title Screen");
        jinfoHome7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "HomeScreen");
                bc1.requestFocus();
                Clock.start(10);
            }
        });
        bc10.add("Title Screen", jinfoHome7);
        Picture p7 = new Picture("Gems.png");
        Picture p7jr = p7.resize(.45);
        Image im7 = p7jr.getImage();
        ImageIcon ic7 = new ImageIcon(im7);
        JButton lookFor = new JButton(ic7);
        bc10.add(lookFor);
        String[][] GunLayout = {
            {"Gun"},
            {"Gun2"},
            {"Ammo"},
            {"Info"},
            {"More1"},
            {"Now"},
            {"Next"},
            {"Title Screen"}
        };
        bc11.setStringLayout(GunLayout);
        bc11.add("Gun", new JLabel("This is a picture of gun well will be air dropping you. The gun will only have six bullets at first."));
        bc11.add("Gun2", new JLabel("It is very important that you get the gun. If you do not, the mission will end and we will have to extract you.!"));
        bc11.add("Ammo", new JLabel("Ammo will also be air dropped to you"));
        bc11.add("Info", new JLabel("Each ammo pouch has 6 bullets in it"));
        bc11.add("More1", new JLabel("Make sure not to waste all your bullets, if the Tiki Men do exist then you will have to use it on them."));
        bc11.add("Now", new JLabel("The final picture you need to see is the extract boat. Click next to see it"));
        JButton jinfoNext9 = new JButton("Next");
        jinfoNext9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "BoatInfo");
                bc12.requestFocus();
                Clock.start(10);
            }
        });
        bc11.add("Next", jinfoNext9);
        JButton jinfoHome8 = new JButton("Title Screen");
        jinfoHome8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "HomeScreen");
                bc1.requestFocus();
                Clock.start(10);
            }
        });
        bc11.add("Title Screen", jinfoHome8);
        Picture p8 = new Picture("gun.png");
        Picture p8jr = p8.resize(.2);
        Image im8 = p8jr.getImage();
        ImageIcon ic8 = new ImageIcon(im8);
        JButton gunIm = new JButton(ic8);
        bc11.add(gunIm);
        Picture p9 = new Picture("ammo.png");
        Picture p9jr = p9.resize(.25);
        Image im9 = p9jr.getImage();
        ImageIcon ic9 = new ImageIcon(im9);
        JButton ammoIm = new JButton(ic9);
        bc11.add(ammoIm);
        String[][] BoatLayout = {
            {"Boat"},
            {"Boat2"},
            {"Warning"},
            {"Now"},
            {"Next"},
            {"Title Screen"}
        };
        bc12.setStringLayout(BoatLayout);
        bc12.add("Boat", new JLabel("This is a picture of the boat you will need to catch after getting the Gem."));
        bc12.add("Boat2", new JLabel("It is very important that you get on the boat as soon as it comes because it will only pass once!"));
        bc12.add("Warning", new JLabel("If you miss it you will be lost forever!"));
        bc12.add("Now", new JLabel("Click next to see the controls for your mission."));
        JButton jinfoNext10 = new JButton("Next");
        jinfoNext10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "Controls");
                bc13.requestFocus();
                Clock.start(10);
            }
        });
        bc12.add("Next", jinfoNext10);
        JButton jinfoHome9 = new JButton("Title Screen");
        jinfoHome9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "HomeScreen");
                bc1.requestFocus();
                Clock.start(10);
            }
        });
        bc12.add("Title Screen", jinfoHome9);
        Picture p10 = new Picture("ship.png");
        Picture p10jr = p10.resize(.60);
        Image im10 = p10jr.getImage();
        ImageIcon ic10 = new ImageIcon(im10);
        JButton boatIm = new JButton(ic10);
        bc12.add(boatIm);
        String[][] ControlLayout = {
            {"Controls"},
            {"Up/Down"},
            {"Left/Right"},
            {"Stop"},
            {"Shoot"},
            {"Final"},
            {"Next"},
            {"Title Screen"}
        };
        bc13.setStringLayout(ControlLayout);
        bc13.add("Controls", new JLabel("The controls for the mission are as follows:"));
        bc13.add("Up/Down", new JLabel("Use the Up and Down Arrow Keys to move up and down"));
        bc13.add("Left/Right", new JLabel("Use the Left and Right Arrow Keys to move left and right"));
        bc13.add("Stop", new JLabel("To stop moving hit the Space Bar"));
        bc13.add("Shoot", new JLabel("To Shoot hit the 'C' Key"));
        bc13.add("Final", new JLabel("Click next to head on your way!"));
        JButton jinfoNext11 = new JButton("Next");
        jinfoNext11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "GoodLuck");
                bc14.requestFocus();
                Clock.start(10);
            }
        });
        bc13.add("Next", jinfoNext11);
        JButton jinfoHome10 = new JButton("Title Screen");
        jinfoHome10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "HomeScreen");
                bc1.requestFocus();
                Clock.start(10);
            }
        });
        bc13.add("Title Screen", jinfoHome10);
        String[][] LuckLayout = {
            {"GoodLuck"},
            {"DieNo"},
            {"Click"},
            {"Then"},
            {"Title Screen"}
        };
        bc14.setStringLayout(LuckLayout);
        bc14.add("GoodLuck", new JLabel("Good Luck on your mission Adventurer!"));
        bc14.add("DieNo", new JLabel("Whatever you do just DO NOT die!"));
        bc14.add("Click", new JLabel("Hit the 'Title Screen' button"));
        bc14.add("Then", new JLabel("then hit the 'Begin Adventure Here' button to begin!"));
        JButton jinfoHome11 = new JButton("Title Screen");
        jinfoHome11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(content, "HomeScreen");
                bc1.requestFocus();
                Clock.start(10);
            }
        });
        bc14.add("Title Screen", jinfoHome11);
        bf.show();{
        for(int i = 0; i <= 50; i++){
            Fern fern = new Fern(sc);
        }
        final Explorer f = new Explorer(sc);
        exClip = true;
        final River r = new River(sc);
        Inventory inven = new Inventory(sc, ammo);
        final double INCRY = 1.95;
        final double INCRX = 2;
        bc2.addKeyListener(new KeyAdapter() {   
            @Override
            public void keyPressed(KeyEvent ke) {
                
                if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    direction = 1;
                    f.move(INCRX, direction);
                } else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    direction = 1;
                    f.move(-INCRX, direction);
                } else if(ke.getKeyCode() == KeyEvent.VK_UP) {
                    direction = 0;
                    f.move(-INCRY, direction);
                } else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
                    direction = 0;
                    f.move(INCRY, direction);
                } else if(ke.getKeyCode() == KeyEvent.VK_SPACE){
                    direction = -1;
                    f.move(0, direction);
                } else if(ke.getKeyCode() == KeyEvent.VK_C){
                    if(gunActive && ammo != 0){
                        Bullet bullet = new Bullet(sc);
                        Gun.clip2.play();
                        bullet.setVelX(3);
                        bullet.setVelY(f.getVelY()*2);
                        bullet.setCenterX(f.centerX());
                        bullet.setCenterY(f.centerY());
                        ammo--;
                        inven.setPicture(inven.newInventoryPicture(ammo));//This updates the ammo counter sprite in the top left
                    }
                }
                
            }
        });
        sc.addSpriteSpriteCollisionListener(Logs.class, Explorer.class, new SpriteSpriteCollisionListener<Logs, Explorer>() {
            @Override
            public void collision(Logs sp1, Explorer sp2) {
                Explorer.clip2.play();
                sp1.setActive(false);
                sp2.setActive(false);
                JOptionPane.showMessageDialog(sc, "You smacked it the head and crushed! Game Over!");
                System.exit(0);
            }
        });
        sc.addSpriteSpriteCollisionListener(Rocks.class, Explorer.class, new SpriteSpriteCollisionListener<Rocks, Explorer>() {
            @Override
            public void collision(Rocks sp1, Explorer sp2) {
                Explorer.clip2.play();
                sp1.setActive(false);
                sp2.setActive(false);
                JOptionPane.showMessageDialog(sc, "You smacked it the head and crushed! Game Over!");
                System.exit(0);
            }
        });
        sc.addSpriteSpriteCollisionListener(Logs.class, River.class, new SpriteSpriteCollisionListener<Logs, River>() {
            @Override
            public void collision(Logs sp1, River sp2) {
                if(logsClip){
                    Logs.clip.play();
                    logsClip = false;
                }
                sp1.setActive(false);
            }
        });
        sc.addSpriteSpriteCollisionListener(Gun.class, River.class, new SpriteSpriteCollisionListener<Gun, River>() {
            @Override
            public void collision(Gun sp1, River sp2) {
                sp1.setActive(false);
                Gun.clip.play();
                JOptionPane.showMessageDialog(sc, "You lost the gun! Getting extracted Now! Game Over!");
                System.exit(0);
            }
        });
        sc.addSpriteSpriteCollisionListener(Explorer.class, River.class, new SpriteSpriteCollisionListener<Explorer, River>() {
            @Override
            public void collision(Explorer sp1, River sp2) {
                if(exClip){
                    Explorer.clip.play();
                    exClip = false;
                }
                sp1.setActive(false);
                JOptionPane.showMessageDialog(sc, "You drowned! Game Over!");
                System.exit(0);
            }
        });
        sc.addSpriteSpriteCollisionListener(Explorer.class, TikiMan.class, new SpriteSpriteCollisionListener<Explorer, TikiMan>() {
            @Override
            public void collision(Explorer sp1, TikiMan sp2) {
                sp1.setActive(false);
                JOptionPane.showMessageDialog(sc, "You have been captured and are getting cooked alive! Game Over!");
                System.exit(0);
            }
        });
        sc.addSpriteSpriteCollisionListener(Explorer.class, TikiMan2.class, new SpriteSpriteCollisionListener<Explorer, TikiMan2>() {
            @Override
            public void collision(Explorer sp1, TikiMan2 sp2) {
                sp1.setActive(false);
                JOptionPane.showMessageDialog(sc, "You have been captured and are getting cooked alive! Game Over!");
                System.exit(0);
            }
        });
        sc.addSpriteSpriteCollisionListener(Explorer.class, TikiMan3.class, new SpriteSpriteCollisionListener<Explorer, TikiMan3>() {
            @Override
            public void collision(Explorer sp1, TikiMan3 sp2) {
                sp1.setActive(false);
                JOptionPane.showMessageDialog(sc, "You have been captured and are getting cooked alive! Game Over!");
                System.exit(0);
            }
        });
        sc.addSpriteSpriteCollisionListener(Explorer.class, TikiMan4.class, new SpriteSpriteCollisionListener<Explorer, TikiMan4>() {
            @Override
            public void collision(Explorer sp1, TikiMan4 sp2) {
                sp1.setActive(false);
                JOptionPane.showMessageDialog(sc, "You have been captured and are getting cooked alive! Game Over!");
                System.exit(0);
            }
        });
        sc.addSpriteSpriteCollisionListener(Explorer.class, TikiMan5.class, new SpriteSpriteCollisionListener<Explorer, TikiMan5>() {
            @Override
            public void collision(Explorer sp1, TikiMan5 sp2) {
                sp1.setActive(false);
                JOptionPane.showMessageDialog(sc, "You have been captured and are getting cooked alive! Game Over!");
                System.exit(0);
            }
        });
        sc.addSpriteSpriteCollisionListener(Explorer.class, TreeMonster.class, new SpriteSpriteCollisionListener<Explorer, TreeMonster>() {
            @Override
            public void collision(Explorer sp1, TreeMonster sp2) {
                Explorer.clip2.play();
                sp1.setActive(false);
                JOptionPane.showMessageDialog(sc, "You have been eaten! Game Over!");
                System.exit(0);
            }
        });
        sc.addSpriteSpriteCollisionListener(Explorer.class, Acid.class, new SpriteSpriteCollisionListener<Explorer, Acid>() {
            @Override
            public void collision(Explorer sp1, Acid sp2) {
                Acid.clip2.play();
                sp1.setActive(false);
                sp2.setActive(false);
                JOptionPane.showMessageDialog(sc, "You were burnt to a crisp! Game Over!");
                System.exit(0);
            }
        });
        sc.addSpriteSpriteCollisionListener(Explorer.class, Spear.class, new SpriteSpriteCollisionListener<Explorer, Spear>() {
            @Override
            public void collision(Explorer sp1, Spear sp2) {
                sp1.setActive(false);
                sp2.setActive(false);
                JOptionPane.showMessageDialog(sc, "You have been impailed! Game Over!");
                System.exit(0);
            }
        });
        sc.addSpriteSpriteCollisionListener(Rocks.class, River.class, new SpriteSpriteCollisionListener<Rocks, River>() {
            @Override
            public void collision(Rocks sp1, River sp2) {
                if(rocksClip){
                    Rocks.clip.play();
                    rocksClip = false;
                }
                sp1.setActive(false);
            }
        });
        sc.addSpriteSpriteCollisionListener(TreeMonster.class, River.class, new SpriteSpriteCollisionListener<TreeMonster, River>() {
            @Override
            public void collision(TreeMonster sp1, River sp2) {
                if(treeClip){
                   TreeMonster.clip.play(); 
                   treeClip = false;
                }
                sp1.setActive(false);
            }
        });
        sc.addSpriteSpriteCollisionListener(Explorer.class, Gun.class, new SpriteSpriteCollisionListener<Explorer, Gun>() {
            @Override
            public void collision(Explorer sp1, Gun sp2) {
                sp2.setActive(false);
                gunActive = true;
                ammo = 6;
                inven.setPicture(inven.newInventoryPicture(ammo));//This updates the ammo counter sprite in the top left
            }
        });
        sc.addSpriteSpriteCollisionListener(Explorer.class, Ammo.class, new SpriteSpriteCollisionListener<Explorer, Ammo>() {
            @Override
            public void collision(Explorer sp1, Ammo sp2) {
                sp2.setActive(false);
                ammo = ammo + 6;
                inven.setPicture(inven.newInventoryPicture(ammo));//This updates the ammo counter sprite in the top left
            }
        });
        sc.addSpriteSpriteCollisionListener(Bullet.class, Logs.class, new SpriteSpriteCollisionListener<Bullet, Logs>() {
            @Override
            public void collision(Bullet sp1, Logs sp2) {
                sp2.setActive(false);
                sp1.setActive(false);
            }
        });
        sc.addSpriteSpriteCollisionListener(Bullet.class, Rocks.class, new SpriteSpriteCollisionListener<Bullet, Rocks>() {
            @Override
            public void collision(Bullet sp1, Rocks sp2) {
                sp2.setActive(false);
                sp1.setActive(false);
            }
        });
        sc.addSpriteSpriteCollisionListener(Bullet.class, TreeMonster.class, new SpriteSpriteCollisionListener<Bullet, TreeMonster>() {
            @Override
            public void collision(Bullet sp1, TreeMonster sp2) {
                sp2.setActive(false);
                sp1.setActive(false);
            }
        });
        sc.addSpriteSpriteCollisionListener(Bullet.class, Acid.class, new SpriteSpriteCollisionListener<Bullet, Acid>() {
            @Override
            public void collision(Bullet sp1, Acid sp2) {
                sp2.setActive(false);
                sp1.setActive(false);
            }
        });
        sc.addSpriteSpriteCollisionListener(Bullet.class, Spear.class, new SpriteSpriteCollisionListener<Bullet, Spear>() {
            @Override
            public void collision(Bullet sp1, Spear sp2) {
                sp2.setActive(false);
                sp1.setActive(false);
            }
        });
        sc.addSpriteSpriteCollisionListener(Ammo.class, River.class, new SpriteSpriteCollisionListener<Ammo, River>() {
            @Override
            public void collision(Ammo sp1, River sp2) {
                Ammo.clip.play();
                sp1.setActive(false);
            }
        });
        sc.addSpriteSpriteCollisionListener(Acid.class, River.class, new SpriteSpriteCollisionListener<Acid, River>() {
            @Override
            public void collision(Acid sp1, River sp2) {
                if(acidClip){
                    Acid.clip.play();
                    acidClip = false;
                }
                sp1.setActive(false);
            }
        });
        sc.addSpriteSpriteCollisionListener(Spear.class, River.class, new SpriteSpriteCollisionListener<Spear, River>() {
            @Override
            public void collision(Spear sp1, River sp2) {
                if(spearClip){
                    Spear.clip.play();
                    spearClip = false;
                }
                sp1.setActive(false);
            }
        });
        sc.addSpriteSpriteCollisionListener(Bullet.class, TikiMan.class, new SpriteSpriteCollisionListener<Bullet, TikiMan>() {
            @Override
            public void collision(Bullet sp1, TikiMan sp2) {
                tikiA1 = false; 
                sp1.setActive(false);
                sp2.setActive(false);
                tikiCount--;
            }
        });
        sc.addSpriteSpriteCollisionListener(Bullet.class, TikiMan2.class, new SpriteSpriteCollisionListener<Bullet, TikiMan2>() {
            @Override
            public void collision(Bullet sp1, TikiMan2 sp2) {
                tikiA2 = false;
                sp1.setActive(false);
                sp2.setActive(false);
                tikiCount--;
            }
        });
        sc.addSpriteSpriteCollisionListener(Bullet.class, TikiMan3.class, new SpriteSpriteCollisionListener<Bullet, TikiMan3>() {
            @Override
            public void collision(Bullet sp1, TikiMan3 sp2) {
                tikiA3 = false;
                sp1.setActive(false);
                sp2.setActive(false);
                tikiCount--;
            }
        });
        sc.addSpriteSpriteCollisionListener(Bullet.class, TikiMan4.class, new SpriteSpriteCollisionListener<Bullet, TikiMan4>() {
            @Override
            public void collision(Bullet sp1, TikiMan4 sp2) {
                tikiA4 = false;
                sp1.setActive(false);
                sp2.setActive(false);
                tikiCount--;
            }
        });
        sc.addSpriteSpriteCollisionListener(Bullet.class, TikiMan5.class, new SpriteSpriteCollisionListener<Bullet, TikiMan5>() {
            @Override
            public void collision(Bullet sp1, TikiMan5 sp2) {
                tikiA5 = false;
                sp1.setActive(false);
                sp2.setActive(false);
                tikiCount--;
            }
        });
        sc.addSpriteSpriteCollisionListener(Explorer.class, Gem.class, new SpriteSpriteCollisionListener<Explorer, Gem>() {
            @Override
            public void collision(Explorer sp1, Gem sp2) {
                Gem.clip.play();
                sp2.setActive(false);
                gemGot = true;
                f.move(0, direction);
                JOptionPane.showMessageDialog(sc, "Get to the boat before it it leaves! ");
            }
        });
        sc.addSpriteSpriteCollisionListener(Explorer.class, Boat.class, new SpriteSpriteCollisionListener<Explorer, Boat>() {
            @Override
            public void collision(Explorer sp1, Boat sp2) {
                Boat.clip.play();
                sp1.setActive(false);
                JOptionPane.showMessageDialog(sc, "Awesome job! You have collected the rare gem and have completed this Aventure!");
                System.exit(0);
            }
        });
        Clock.addTask(sc.moveSprites());
    }}
    
    public static void main(String args[])throws IOException {
        BenH_FinalProject ad = new BenH_FinalProject();
        ad.run();
    }
}
