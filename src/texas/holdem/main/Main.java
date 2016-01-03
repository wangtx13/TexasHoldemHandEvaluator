/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texas.holdem.main;
import texas.holdem.hand.evaluator.Hand;
import texas.holdem.hand.evaluator.HandEvaluator;
import texas.holdem.hand.evaluator.PotentialEvaluator;
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

        String currentHand = "As Qs";
        HandEvaluator handEvaluator = new HandEvaluator(new Hand(currentHand));
        PotentialEvaluator potEvaluator = new PotentialEvaluator(new Hand(currentHand));
//        TexasHoldemHandEvaluator evaluator = new TexasHoldemHandEvaluator(currentHand);
        
        int currentValue = handEvaluator.getValue();
        double potentialValue = potEvaluator.getPotentialValue();
        
        double aboveRoyalFlushWeight = potEvaluator.getAboveRoyalFlushWeight();
        double aboveStraightFlushWeight = potEvaluator.getAboveStraightFlushWeight();
        double aboveFourOfAKindWeight = potEvaluator.getAboveFourOfAKindWeight();
        double aboveFullHouseWeight = potEvaluator.getAboveFullHouseWeight();
        double aboveFlushWeight = potEvaluator.getAboveFlushWeight();
        double aboveStraightWeight = potEvaluator.getAboveStraightWeight();
        double aboveThreeOfAKindWeight = potEvaluator.getAboveThreeOfAKindWeight();
        double aboveTwoPairWeight = potEvaluator.getAboveTwoPairWeight();
        double aboveOnePairWeight = potEvaluator.getAboveOnePairWeight();
        double aboveHighCardWeight = potEvaluator.getAboveHighCardWeight();
        
        System.out.println("Current Value: " + currentValue);
        System.out.println("Potential Value: " + potentialValue);
        System.out.println("aboveRoyalFlushWeight: " + aboveRoyalFlushWeight);
        System.out.println("aboveStraightFlushWeight: " + aboveStraightFlushWeight);
        System.out.println("aboveFourOfAKindWeight: " + aboveFourOfAKindWeight);
        System.out.println("aboveFullHouseWeight: " + aboveFullHouseWeight);
        System.out.println("aboveFlushWeight: " + aboveFlushWeight);
        System.out.println("aboveStraightWeight: " + aboveStraightWeight);
        System.out.println("aboveThreeOfAKindWeight: " + aboveThreeOfAKindWeight);
        System.out.println("aboveTwoPairWeight: " + aboveTwoPairWeight);
        System.out.println("aboveOnePairWeight: " + aboveOnePairWeight);
        System.out.println("aboveHighCardWeight: " + aboveHighCardWeight);
       
    }
}
