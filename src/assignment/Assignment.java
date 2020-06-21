/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;


import cnfformula.CnfFormula;
import java.util.HashMap;

/**
 *
 * @author jhesk
 */
public class Assignment {
    HashMap<String, Boolean> assignment;
    CnfFormula formula;

    public Assignment(CnfFormula formula) {
        this.formula = formula;
        assignment = new HashMap();
    }
   
    
    // returns the list of variables to build the variable options in the Assignment view.
    public String[] variables() {
       return formula.literals();
    }
    
    
    public boolean getValue(String var){
        return assignment.get(var);
    }
    
    
    public void setValue(String var, boolean val) {
        assignment.put(var, val);
    }
    
}
