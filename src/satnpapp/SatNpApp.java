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
import java.io.FileNotFoundException;
import static java.lang.System.exit;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jhesk
 * The bigO
 */
public class SatNpApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AssignmentView view= new AssignmentView();

        File file = chooseExprLocation();

        try {
            CnfFormula formula;
            
                formula = loadCnfFormula(file);
            

            do {
                Assignment assignment = new Assignment(formula);
 
                view.setModel(assignment);
                view.setVisible(true);

                if (formula.verify(assignment)) {
                    JOptionPane.showMessageDialog(null, "Satisfied");
                } else {
                    JOptionPane.showMessageDialog(null, "Not Satisfied");
                }
                
                isSatisfiable(formula);
                
            } while (trueFalsePrompt("Test another input string?", "SatNP:"));
        exit(0);
        }catch (FileNotFoundException ex) {
                Logger.getLogger(SatNpApp.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private static File chooseExprLocation() {
        JFileChooser fc = new JFileChooser("Input");
        
        int returnVal = fc.showOpenDialog(null);
        
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            System.out.println("Opening: " + file.getName() + "." + "\n");
            return file;
        }else {
            System.out.println("Open file was cancelled by user. ");
            exit(1);
            return null;
        }   
    }

    private static CnfFormula loadCnfFormula(File file) throws FileNotFoundException {
        CnfFormula formula = new CnfFormula();
        
        // pull the line from the file and for further parsing
        Scanner in = new Scanner(file);
        String formulaStr = in.nextLine().trim();
        in.close();
        formula.setFormula(formulaStr);
      
        return formula.parseFormula(formulaStr.split(" \\^ "));      
    }

    private static boolean trueFalsePrompt(String msg, String header) {
        int returnVal = JOptionPane.showConfirmDialog(null, msg, header, JOptionPane.YES_NO_OPTION);
        if(returnVal == JOptionPane.YES_OPTION)return true;
        else return false;  
    }
   
    public static Assignment isSatisfiable(CnfFormula formula){
        Assignment assn = new Assignment(formula);
        String [] vars = formula.literals();
        boolean isSat = false;
        //test for all fase
        for (String var : vars){
            assn.setValue(var, true);
            isSat = formula.verify(assn);
        }
        if(isSat) return assn;
        // test for all true
        for (String var : vars){
            assn.setValue(var, true);
            isSat = formula.verify(assn);
        }
        if(isSat) return assn;
        
    }
    
}
