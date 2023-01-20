package edu.learn.hr.ubs; 
  
import java.util.HashMap;
import java.util.Map;

public class CoderFinderHackerRank {

    public static void main(String[] args) {
        String erica = "EHH";
        String bod = "EME";
        winner(erica, bod);
    }

    public static String winner(String erica, String bob) {
        char[] ericaAttempts = erica.toCharArray();
        char[] bobAttempts = bob.toCharArray();
        Map<String, Long> rankings = new HashMap<>();

        rankings.putAll(calculateRanking("Erica", ericaAttempts));
        rankings.putAll(calculateRanking("Bob", bobAttempts));

        String winner = "";
        Long winnerScore = 0l;

        Long ericaRank = rankings.get("Erica");
        Long bobRank = rankings.get("Bob");

        if(ericaRank > bobRank){
            winner = "Erica";
        } else if(ericaRank < bobRank){
            winner = "Bob";
        } else if(ericaRank.equals(bobRank)){
            winner = "Tie";
        }

        return winner;
    }

    public static Map<String, Long> calculateRanking(String name, char[] questionsRankings){
        int easyRanking = 1;
        int mediumRanking = 3;
        int hardRanking = 5;
        long total = 0;
        for(int i = 0; i < questionsRankings.length; i++){
            if(questionsRankings[i] == 'E'){
                total += easyRanking;
            } else if(questionsRankings[i] == 'M'){
                total += mediumRanking;
            } else if(questionsRankings[i] == 'H'){
                total += hardRanking;
            }
        }

        return Map.of(name, total);
    }
}
