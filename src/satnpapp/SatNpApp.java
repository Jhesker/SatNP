/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satnpapp;

import assignment.Assignment;
import assignment.AssignmentView;
import cnfformula.CnfFormula;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author jhesk
 */
public class SatNpApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AssignmentView view= new AssignmentView();

        File file = chooseExprLocation();

        try {
            CnfFormula formula = loadCnfFormula(file);

            do {
                Assignment assignment = new Assignment(formula);
 
                view.setModel(assignment);
                view.setVisible(true);

                if (expr.verify(assignment)) {
                    JOptionPane.showMessageDialog(null, "Satisfied");
                } else {
                    JOptionPane.showMessageDialog(null, "Not Satisfied");
                }

                isSatisfiable(formula);

            } while (trueFalsePrompt("Test another input string?"));

        } catch(){
            
        }
    
    public boolean verify(Assignment assn){
        return true; // TO CHANGE
    }
    
    public Assignment satisfiable(){
        return null; // TO CHANGE
    }
}
