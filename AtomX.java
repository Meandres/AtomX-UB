/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx_1_0;

/**
 *
 * @author nous
 */
public class AtomX {
    public static void main(String args[]){
        byte parametre=1;
        Jeu j=new Jeu(parametre);
        do{
            j.tour();
        }while(!j.isFini());
    }
    
}
