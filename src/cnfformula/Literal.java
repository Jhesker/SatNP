/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnfformula;

import assignment.Assignment;

/**
 *
 * @author jhesk
 */
public class Literal {
    private String name;
    private boolean isNegated;

    // constructor 

    public Literal() {
    }

    public Literal(String name, boolean isNegated) {
        this.name = name;
        this.isNegated = isNegated;
    }
    
    
    //Getters and setters
    public void setName(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
    public void setIsNegated(boolean isNegated){
        this.isNegated = isNegated;
    }
    public boolean isNegated() {
        return isNegated;
    }

    boolean verify(Assignment assn) {
        boolean isTrue = assn.getValue(name);
        if(isNegated){
            return !isTrue;
        } else return isTrue;
    }
}
