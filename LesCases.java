/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomx;
import java.util.ArrayList;
/**
 *
 * @author nous
 */
public class LesCases {
    private ArrayList<Case> cases;

    public ArrayList<Case> getCases() {
        return cases;
    }
    public void setCases(Case c) {
        getCases().add(c);
    }

    public LesCases() {
        this.cases = new ArrayList<Case>();
    }
    
    
    
    
}
