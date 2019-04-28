/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import javax.swing.*;
public class PanneauImage extends JPanel
{
    private Image img;
    
    public PanneauImage()
    {
        super();
        this.img=null;
    }
    public PanneauImage(Image im)
    {
        super();
        this.img=im;
    }
    
    public Image getImage()
    {return this.img;}
    
    public void setImage(Image im)
    {
        this.img=im;
        this.repaint();
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        if(img!=null)
            g.drawImage(img,0,0, this.getWidth(), this.getHeight(), this);
    }
}
