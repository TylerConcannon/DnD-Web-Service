/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.diceRoller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hanli
 */
public class DiceRoller {
   
    public Roll rollDice(List<List<Integer>> clientRolls)
    {
        Roll roll = new Roll();
        List<List<Integer>> serverRolls = new ArrayList<>();
        int total = 0;

        for (List<Integer> userCombination : clientRolls)
        {
            List<Integer> serverRoll = new ArrayList<>();
            int dieRoll = 0;

            for(int i = 0; i < userCombination.get(1); i++)
            {
                dieRoll = (int) (Math.random() * ((userCombination.get(0) - 1) + 1)) + 1;
                total += dieRoll;
                serverRoll.add(dieRoll);
            }
            serverRolls.add(serverRoll);
        }
        roll.setTotal(total);
        roll.setRolls(serverRolls);
        
        int[] minMax = getMinMax(roll);
        roll.setMin(minMax[0]);
        roll.setMax(minMax[1]);
        
        return roll;
    }
    
    public int[] getMinMax(Roll roll)
    {

        List<List<Integer>> rolls = roll.getRolls();
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        for (List<Integer> list : rolls)
        {
            for (Integer i : list)
            {
                if (i > max)
                {
                    max = i;
                }
                if (i < min)
                {
                    min = i;
                }
            }
        }
        return new int[] {min, max};
    }
    
//    public Roll maxRoll(List<List<Integer>> clientRolls)
//    {
//        Roll roll = new Roll();
//        List<List<Integer>> serverRolls = new ArrayList<>();
//        for (List<Integer> userCombination : clientRolls)
//        {
//            List<Integer> serverRoll = new ArrayList<>();
//            int total = 0;
//            int dieRoll = 0;
//
//            for(int i = 0; i < userCombination.get(1); i++)
//            {
//                dieRoll = (int) (Math.random() * ((userCombination.get(0) - 1) + 1)) + 1;
//                if(dieRoll>total)
//                    total= dieRoll;
//                serverRoll.add(dieRoll);
//            }
//            roll.setTotal(total);
//            roll.setRolls(serverRolls);        
//        }
//        return roll;
//    }
//    
//    public Roll minRoll(List<List<Integer>> clientRolls)
//    {
//        Roll roll = new Roll();
//        List<List<Integer>> serverRolls = new ArrayList<>();
//        for (List<Integer> userCombination : clientRolls)
//        {
//            List<Integer> serverRoll = new ArrayList<>();
//            int total = Integer.MAX_VALUE;
//            int dieRoll = 0;
//
//            for(int i = 0; i < userCombination.get(1); i++)
//            {
//                dieRoll = (int) (Math.random() * ((userCombination.get(0) - 1) + 1)) + 1;
//                if(dieRoll<total)
//                    total= dieRoll;
//                serverRoll.add(dieRoll);
//            }
//            roll.setTotal(total);
//            roll.setRolls(serverRolls);        
//        }
//        return roll;
//    }
    
    public Roll averageRoll(List<List<Integer>> clientRolls)
    {
        Roll roll = new Roll();
        List<List<Integer>> serverRolls = new ArrayList<>();
        for (List<Integer> userCombination : clientRolls)
        {
            List<Integer> serverRoll = new ArrayList<>();
            int total = Integer.MAX_VALUE;
            int dieRoll = 0;

            for(int i = 0; i < userCombination.get(1); i++)
            {
                dieRoll = (int) (Math.random() * ((userCombination.get(0) - 1) + 1)) + 1;
                total += dieRoll;
                serverRoll.add(dieRoll);
            }
            
            total = total/userCombination.get(1);
            roll.setTotal(total);
            roll.setRolls(serverRolls);        
        }
        return roll;
    }
    
    public List<Integer> AbilityScoreRoll(){
        List<Integer> abilityRolls = new ArrayList<>();       
        int dieRoll = 0;
        
        for(int i = 0; i < 6; i++){            
            List<Integer> rolls = new ArrayList<>();
            
            for(int j = 0; j < 4; j++ ){
                dieRoll = (int) (Math.random() * ((6 - 1) + 1)) + 1; //roll 4 d6 pick 3 highest
                rolls.add(dieRoll);
            }
            
            Collections.sort(rolls, Collections.reverseOrder()); // sort list to get highest 3
            int total = rolls.get(0) + rolls.get(1) + rolls.get(2);
            abilityRolls.add(total);
        }
        
        Collections.sort(abilityRolls, Collections.reverseOrder());
        return abilityRolls;
    }
   
}
