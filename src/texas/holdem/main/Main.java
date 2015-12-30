/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texas.holdem.main;
import texas.holdem.hand.evaluator.TexasHoldemHandEvaluator;
/**
 *
 * @author wangtianxia1
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here

        String currentHand = "As Qs Js Ts 2h";
        TexasHoldemHandEvaluator evaluator = new TexasHoldemHandEvaluator(currentHand);
        
        int currentValue = evaluator.getCurrentValue();
        double potentialValue = evaluator.getPotentialValue();
        System.out.println("Current Value: " + currentValue);
        System.out.println("Potential Value: " + potentialValue);
       
    }
}
