/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsimple;

/**
 *
 * @author nous
 */
public class AtomX {
    public static void main(String args[]){
        Jeu j=new Jeu(10);
        do{
            j.tour();
        }while(!j.isFini());
    }
    
}
