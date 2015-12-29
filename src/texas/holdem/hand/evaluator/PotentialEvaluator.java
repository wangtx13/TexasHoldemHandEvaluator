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
        double weight = 0;
        
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
        if(currentHand.size() == 6) {
            weight = (1d/(52-6));
            potentialValue = calTotalPotValueBeforeRiver(currentHand) * weight;
        } else if(currentHand.size() == 5) {
            weight = 1d/((52-5) * (52-6));
            potentialValue = calTotalPotValueBeforeTurn(currentHand) * weight;
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
    private double calculateOnePotentialValue(Hand newHand) {
//        System.out.println(newHand.toString());
        HandEvaluator evaluator = new HandEvaluator(newHand);
        int cardValue = evaluator.getValue();
//        double cardPotentialValue = cardValue * weight;
//        System.out.println(cardPotentialValue);
        return cardValue;
    }
    
    private double calTotalPotValueBeforeRiver(Hand currentHand) {
        double totalValue = 0;
        Card[] currentCards = currentHand.getCards();
                
        for(int i = 0; i < Card.NO_OF_RANKS; ++i) {
            for(int j = 0; j < Card.NO_OF_SUITS; ++j) {
                if(rankings[i] == 0) {
                    Card newCard = new Card(i, j);
                    Hand newHand = new Hand(currentHand.toString() + ' ' + newCard.toString());
                    totalValue += calculateOnePotentialValue(newHand);
                } else {
                    for(int k = 0; k < 6; ++k) {
                        if(currentCards[k].getRank() == i && currentCards[k].getSuit() != j) {
                            Card newCard = new Card(i, j);
                            Hand newHand = new Hand(currentHand.toString() + ' ' + newCard.toString());
                            totalValue += calculateOnePotentialValue(newHand);
                        }
                    }
                }
            }
        }
        
        return totalValue;
    }

    private double calTotalPotValueBeforeTurn(Hand currentHand) {
        double totalValue = 0;
        Card[] currentCards = currentHand.getCards();
                
        for(int i = 0; i < Card.NO_OF_RANKS; ++i) {
            for(int j = 0; j < Card.NO_OF_SUITS; ++j) {
                if(rankings[i] == 0) {
                    Card newCard = new Card(i, j);
                    Hand newHand = new Hand(currentHand.toString() + ' ' + newCard.toString());
                    totalValue += calTotalPotValueBeforeRiver(newHand);
                } else {
                    for(int k = 0; k < 5; ++k) {
                        if(currentCards[k].getRank() == i && currentCards[k].getSuit() != j) {
                            Card newCard = new Card(i, j);
                            Hand newHand = new Hand(currentHand.toString() + ' ' + newCard.toString());
                            totalValue += calTotalPotValueBeforeRiver(newHand);
                        }
                    }
                }
            }
        }
        
        return totalValue;
    }

    public double getPotentialValue() {
        return potentialValue;
    }
    
    
    
}
