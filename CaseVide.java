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
public class CaseVide extends Case {
    /*Cette classe ne sera instanciée qu'une seule fois. Son instance correspondra sera referencée par toutes les cases externes du "tableau".
    La methode action redéfinie 
    */
    private CaseVide fPlus;
    private CaseVide fMoins;
    private CaseNonVide lien;

    public void setfPlus(CaseVide fPlus) {
        this.fPlus = fPlus;
    }
    public void setfMoins(CaseVide fMoins) {
        this.fMoins = fMoins;
    }
    public void setLien(CaseNonVide lien) {
        this.lien = lien;
    }
    public CaseVide getfPlus() {
        return fPlus;
    }
    public CaseVide getfMoins() {
        return fMoins;
    }
    public CaseNonVide getLien() {
        return lien;
    }
    public CaseVide(CaseNonVide lien) {
        this.lien = lien;
    }
    
    @Override
    public void action(){
        Position p=this.getContenu().getPos();
        if (p.equals(getLien().getPos())){
            getLien().setContenu(this.getContenu());
            this.setContenu(null);
            }
        else{
            if(p.estPlusGrandeQue(this.getLien().getPos())){
                this.getfPlus().action();
            }
            else
                this.getfMoins().action();
            }
        }

    @Override
    public String toString() {
        return "CaseVide{" + "fPlus=" + fPlus + ", fMoins=" + fMoins + ", lien=" + lien + '}';
    }
    
}
    
