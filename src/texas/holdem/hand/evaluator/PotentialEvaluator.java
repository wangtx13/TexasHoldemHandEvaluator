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
public class PotentialEvaluator {
    
    /** The potential value of hand */
    private double potentialValue = 0;
    
    /** The number of cards for each rank */
    private int[] rankings = new int[Card.NO_OF_RANKS];
    
    /**
     * Constructor.
     *
     * @param  currentHand  The current hand.
     */
    public PotentialEvaluator(Hand currentHand) {
        Card[] currentCards = currentHand.getCards();
        
        //Calculate the number of cards for each rank
        for(int i = 0; i < Card.NO_OF_RANKS; ++i) {
            rankings[i] = 0;
            for(int j = 0; j < currentHand.size(); ++j) {
                if(i == currentCards[j].getRank()) {
                    ++rankings[i];
                }
            }
        }
        
        //Calculate the potential value of current hand
        for(int i = 0; i < Card.NO_OF_RANKS; ++i) {
            for(int j = 0; j < Card.NO_OF_SUITS; ++j) {
                if(rankings[i] == 0) {
                    potentialValue += calculateOnePotentialValue(currentHand,i ,j);
                } else {
                    for(int k = 0; k < currentHand.size(); ++k) {
                        if(currentCards[k].getRank() == i && currentCards[k].getSuit() != j) {
                            potentialValue += calculateOnePotentialValue(currentHand, i, j);
                        }
                    }
                }
            }
        }
        
    }
//    
//    private int calculateCurrentValue(Hand currentHand) { 
//        HandEvaluator evaluator = new HandEvaluator(currentHand);       
//        return evaluator.getValue();
//    }
//   
    
    /**
     * Returns the potential value as a double in one situation
     * 
     * This method should be used to calculate the potential value.
     *
     * @return  the potential value in one situation
     */
    private double calculateOnePotentialValue(Hand currentHand, int newRank, int newSuit) {
        Card newCard = new Card(newRank, newSuit);
        Hand newHand = new Hand(currentHand.toString() + ' ' + newCard.toString());
//        System.out.println(newHand.toString());
        HandEvaluator evaluator = new HandEvaluator(newHand);
        int cardValue = evaluator.getValue();
        int leftCardsNo = currentHand.size();
        double cardPotentialValue = cardValue * (1d/(52-leftCardsNo));
//        System.out.println(cardPotentialValue);
        return cardPotentialValue;
    }

    public double getPotentialValue() {
        return potentialValue;
    }
    
    
    
}
