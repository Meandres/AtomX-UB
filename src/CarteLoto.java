
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gb346159
 */
public class CarteLoto 
{
    private int tab[][];
    private int jetons[][];
    private int nbCol;
    private int nbLig;
    private int nbNumeros;
    private double prix;
    private final int valMax=90;
    
    public CarteLoto()
    {
        this.nbNumeros=15;
        this.nbCol=9;
        this.nbLig=3;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        this.prix=5;
        initValeursCarte();
    }
    public CarteLoto(int nbc, int nbVal)
    {
        this.nbNumeros=nbVal;
        this.nbCol=nbc;
        this.nbLig=3;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        this.prix=5;
        initValeursCarte();
    }
    public double getPrix()
    {
        return this.prix;
    }
    public String toString()
    {
        String res="";
        for(int i=0; i<this.nbLig; i++)
        {
            for(int j=0; j<this.nbCol;j++)
            {
                res+=" "+tab[i][j];
                 if(tab[i][j]<10)
                    res+="  ";     
            }
            res+="\n";
        }
        return res;
    }
    public boolean estDans(int val)
    {
        boolean res=false;
        for(int i=0; i<this.nbLig; i++)
        {
            for(int j=0; j<this.nbCol; j++)
            {
                if(tab[i][j]==val)
                    res=true;
            }
        }
        return res;
    }
    public void placePion(int val)
    {
        for(int i=0; i<this.nbLig; i++)
        {
            for(int j=0; j<this.nbCol; j++)
            {
                if(tab[i][j]==val)
                {
                    jetons[i][j]=val;
                }
            }
        }
    }
    public boolean estLignePleine(int lig)
    {
        boolean res=true;
        for(int j=0; j<this.nbCol; j++)
        {
            if(jetons[lig][j]!=tab[lig][j])
                   res=false;
        }
        return res;
    }
    public boolean cartonGagnant(int option)
    {
        boolean res=false;
        switch(option)
        {
            case 1: res=getNbLignesPleines()==1;break;
            case 2: res=getNbLignesPleines()==2;break;
            case 3: res=getNbLignesPleines()==3;break;
        }
        return res;
    }
    public void initValeursCarte()
    {
        int g; int n;
        for(int i=0; i<this.nbLig; i++)
        {
            for(int j=0; j<this.nbCol; j++)
            {
                tab[i][j]=0;
                jetons[i][j]=0;
            }
        }
        int i=0;
        for(int h=0; h<this.nbNumeros;h++)
        {
            do{
                g=(int)(Math.random()*this.nbCol-1);
            }while(tab[i][g]!=0);
            do{
                n=(int)(Math.random()*this.valMax+1);
            }while(estDans(n));
            tab[i][g]=n;
            i=(i+1)%this.nbLig;
        }
    }
    public int getNbLignesPleines()
    {
        int ligP=0;
        for(int n=0; n<this.nbLig; n++)
        {
            if(estLignePleine(n))
                ligP++;
        }
        return ligP;
    }
    public int getNum()
    {
        return this.nbNumeros;
    }
    public int getCol()
    {
        return this.nbCol;
    }
    public int getLig()
    {
        return this.nbLig;
    }
    public int getVal(int i, int j)
    {
        if(i>this.nbLig-1||j>this.nbCol-1||i<0||j<0)
            return -1;
        else
            return tab[i][j];
    }
    public void setNum(int num)
    {
        if(num >= 3 || num<=this.nbCol*this.nbLig)
            this.nbNumeros =num;
    }
    public void initMaCarte()
    {
        int n, i, j;
        for(int t=0; t<5; t++)
        {
            do{
                System.out.println("Choisissez votre valeur (comprise entre 1 et 90): ");
                n = Lire.i();
            }while(n<1 || n>90);
            do{
                System.out.println("Choisissez la ligne et la colonne où vous voulez placer cette valeur: ");
                i = Lire.i();
                j= Lire.i();
            }while((i>this.nbLig||i<0)||(j>this.nbCol||j<0)||tab[i][j]!=0);
            tab[i][j]=n;
        }
    }
    
    public void dessineCarte(JPanel jp, Color coul)
    {
        jp.removeAll();
        jp.setLayout(new GridLayout(getLig(), getCol()));
        for(int i=0; i<getLig(); i++)
        {
            for(int j=0; j<getCol(); j++)
            {
                int val = tab[i][j];
                JButton bouton = new JButton();
                bouton.setText(""+val);
                if(jetons[i][j]!=0)
                    bouton.setBackground(Color.white);
                else
                    bouton.setBackground(coul);
                jp.add(bouton);
            }
        }
    }
   /* public void initAutreCarte()
    {
        int n, i, j;
        for(int t=0; t<5; t++)
        {
            do{
                System.out.println("Choisissez votre valeur (comprise entre 1 et 90): ");
                n = Lire.i();
            }while(n<1 && n>90);
            do{
                i = Lire.i();
                j= Lire.i();
            }while((i>this.nbLig||i<0)||(j>this.nbCol||j<0));
            tab[i][j]=n;
        }
    }*/
}
