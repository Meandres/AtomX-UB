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
public class Direction {
    private int x;
    private int y;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    //la gestion de la validité de la direction n'est pas nécessaire car elle sera uniquement
    //modifiée dans le programme et pas par l'utilisateur
    }
    public void setY(int y) {
        this.y = y;
    //idem pour y
    }

    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
        //également pas besoin de verifier au vu de comment sera utilisée la classe Direction
    }
    @Override
    public String toString() {
        return "D x: "+x+", y: "+y;
    }
    public boolean equals(Direction d){
        return this.getX()==d.getX()&&this.getY()==d.getY();
    }
    
    
    public void tourne(int q){//prends en parametre les quart de tour. La fonction gere le cas où ce nombre
        //est supérieur à 4 au cas où.
        //les quarts de tours sont dans le sens trigonometrique
        if (this.getX()!=0){
            if (q%2==0){
                if (q%4==2)
                    this.setX(-x);
                }
            else
                if (q%4==1){
                    this.setY(x);
                    this.setX(0);
                }
                else{//si q%4==3
                    this.setY(-x);
                    this.setX(0);
                }
        }
        else{//si y a une valeur differente de 0
            if (q%2==0){
                if (q%4==2)
                    this.setY(-y);
                }
            else
                if (q%4==1){
                    this.setX(-y);
                    this.setY(0);
                }
                else{//si q%4==3
                    this.setX(y);
                    this.setY(0);
                }
            }
        }
    
    
}
