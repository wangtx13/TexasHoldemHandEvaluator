/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texas.holdem.hand.evaluator;

/**
 *
 * @author wangtianxia1
 */
public class TexasHoldemHandEvaluator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        TexasHoldemHandEvaluate();     
       
    }
    
    public static void TexasHoldemHandEvaluate() {
        String currentCards = "";
        String currentHandCards = "As Qs";
        String currentTableCards = "Ks Js 2h 3h";
        currentCards = currentHandCards + ' ' + currentTableCards;
        PotentialEvaluator potEvaluator = new PotentialEvaluator(new Hand(currentCards));
        double potentialValue = potEvaluator.getPotentialValue();
        int currentValue = CurrentValue(currentCards);
        
        System.out.println("Potential Value: " + potentialValue);
        System.out.println("Current Value: " + currentValue);
    }
    
    public static int CurrentValue(String s) {
        int currentValue = 0;
        HandEvaluator evaluator = new HandEvaluator(new Hand(s));
        currentValue = evaluator.getValue();
        return currentValue;
    }

}
