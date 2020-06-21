package cnfformula;

import assignment.Assignment;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 *
 * @author jhesk
 */
public class CnfFormula {
    private String formula;
    private ArrayList<Clause> clauses;

    public CnfFormula() {
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public ArrayList<Clause> getClauses() {
        return clauses;
    }

    public void setClauses(ArrayList<Clause> clauses) {
        this.clauses = clauses;
    }
    public String[] literals(){
        String tempString = formula.substring(1);
        String [] lit = tempString.split("[v\\^n\\()\\s]+");
        lit = new HashSet<String>(Arrays.asList(lit)).toArray(new String[0]);
        return lit;
    }
    public CnfFormula parseFormula(String[] formula){
        ArrayList<Clause> tempClauses = new ArrayList();
        
        for (String clauz : formula){
            Clause clause = new Clause();
            if(clauz.charAt(0) == '('){
                clauz = clauz.substring(1, clauz.length() - 1);   // remove ();
            }
            clauz.trim();
            clause.buildClause(clauz.split(" v "));
            tempClauses.add(clause);
        }
        this.clauses = tempClauses;
        return this;
    }    
    public boolean verify(Assignment assn){
        boolean sat = true;
        for (Clause clause : clauses){
            sat = clause.verify(assn);
            if(sat == false){  //one of the clauses has evaluated to false return no satisfiable.
                return false;
            }else continue;  //none of the clauses have returned false so continue looking.
        }
        return sat; //all clauses have been checked and none have been false return sat as true.
    }

}
