package cnfformula;

import assignment.Assignment;
import java.util.ArrayList;

/**
 *
 * @author jhesk
 */
public class Clause {
    ArrayList<Literal> literals;

    //constructor
    public Clause() {
        
    }

    public ArrayList<Literal> getLiterals() {
        return literals;
    }

    public void buildClause(String[] literals) {
        ArrayList<Literal> lits = new ArrayList();
        for(String literal : literals){
            Literal lit = new Literal();
            if(literal.charAt(0) == 'n'){
                lit.setName(literal.substring(1));
                lit.setIsNegated(true);
            }else {
                lit.setName(literal);
                lit.setIsNegated(false);
            }
            lits.add(lit);
        }
        this.literals = lits;
    }
   
    /**
     * @return literals
     */
    public String[] literals(){
        
        ArrayList<String> tempLiterals = new ArrayList();
        for(Literal lit : this.literals){
            tempLiterals.add(lit.getName());
        }
        return tempLiterals.toArray(new String[0]);
        
    }
    /**
     *
     * @param assn
     * @return 
     */
    public boolean verify(Assignment assn){
        boolean isTrue = false;
        String val = null;
        for (Literal literal : literals)
        {
            isTrue = literal.verify(assn);
            if(isTrue) return isTrue;  //at least one literal has returned true so the clause is true.
            else continue; //literal is false loof for more literals.
        }
        return false; //this is only reached if non of the leterals return true.
            
    }
    
}
