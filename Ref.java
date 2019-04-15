/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx;

/**
 *
 * @author nous
 */
public class Ref {
    /*cette classe n'aura qu'une seule instance. On peut donc stocker en variable de classe
    l'adresse de l'instance que l'on va créer.
    */
    private static Ref ref;
    private CaseVide xNul;
    private CaseVide yNul;
    private CaseVide xMax;
    private CaseVide yMax;

    public static void setRef(Ref ref) {
        Ref.ref = ref;
    }
    public void setxNul(CaseVide xNul) {
        this.xNul = xNul;
    }
    public void setyNul(CaseVide yNul) {
        this.yNul = yNul;
    }
    public void setxMax(CaseVide xMax) {
        this.xMax = xMax;
    }
    public void setyMax(CaseVide yMax) {
        this.yMax = yMax;
    }
    public static Ref getRef() {
        return ref;
    }
    public CaseVide getxNul() {
        return xNul;
    }
    public CaseVide getyNul() {
        return yNul;
    }
    public CaseVide getxMax() {
        return xMax;
    }
    public CaseVide getyMax() {
        return yMax;
    }
    
    
}
