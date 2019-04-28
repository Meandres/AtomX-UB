
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class Lot 
{
    private String description;
    private int niveau;
    private Image image;

    public Lot()
    {}
    
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    public Lot(String description, int niveau)
    {
        this.description = description;
        this.niveau = niveau;
    }
    
    public int getNiveau(){return this.niveau;}
    public String getDescription(){return this.description;}
    
    public void setNiveau(int n)
    {
        this.niveau = n;
    }
    public void setDescription(String descr)
    {
        this.description = descr;
    }
    
    public String toString()
    {
        return "Lot: "+getDescription()+" de niveau "+getNiveau()+"\n";
    }
   
}
