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
    
    private int currentValue;
    private double potentialValue;

    public TexasHoldemHandEvaluator(Hand currentHand) {
        currentValue = getCurrentValue(currentHand);
        potentialValue = getPotentialValue(currentHand);
    }
    
    public TexasHoldemHandEvaluator(String currentHandCards) {
        currentValue = getCurrentValue(new Hand(currentHandCards));
        potentialValue = getPotentialValue(new Hand(currentHandCards));
    }
     
    private int getCurrentValue(Hand currentHand) {
        HandEvaluator evaluator = new HandEvaluator(currentHand);
        int value = evaluator.getValue();
        return value;
    }
  
    private double getPotentialValue(Hand currentHand) {       
        PotentialEvaluator potEvaluator = new PotentialEvaluator(currentHand);
        double value = potEvaluator.getPotentialValue();
       
        return value;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public double getPotentialValue() {
        return potentialValue;
    }

}
