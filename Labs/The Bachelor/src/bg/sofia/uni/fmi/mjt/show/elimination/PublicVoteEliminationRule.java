package bg.sofia.uni.fmi.mjt.show.elimination;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

public class PublicVoteEliminationRule implements EliminationRule{

    private String[] votes;

    public PublicVoteEliminationRule(String[] votes){
        this.votes = votes;
    }

    @Override
    public Ergenka[] eliminateErgenkas(Ergenka[] ergenkas) {
        String candidate = boyerMoore();
        if(candidate.isEmpty()){
            return ergenkas;
        }

        int indexToRemove = findCandidateIndex(ergenkas, candidate);
        if(indexToRemove == -1){
            return ergenkas;
        }
        return getRemainingErgenkas(ergenkas, indexToRemove);
    }

     Ergenka[] getRemainingErgenkas(Ergenka[] ergenkas, int indexToRemove) {
        int newLength = ergenkas.length - 1;
        int newIndex = 0;

        Ergenka[] newErgenkas = new Ergenka[newLength];
        for (int i = 0; i < ergenkas.length; i++) {
            if(i == indexToRemove){
                continue;
            }
            newErgenkas[newIndex] = ergenkas[i];
            newIndex++;
        }
        return newErgenkas;
    }

    int findCandidateIndex(Ergenka[] ergenkas, String candidate){
        for (int i = 0; i < ergenkas.length; i++) {
            if(candidate.equals(ergenkas[i].getName())){
                return i;
            }
        }
        return -1;
    }

    String boyerMoore(){
        String candidate = "";
        int count = 0;
        for(int i = 0; i < votes.length; i++){
            if(count == 0){
                candidate = votes[i];
                count = 1;
            }
            else{
                if(candidate.equals(votes[i])){
                    count++;
                }
                else{
                    count--;
                }
            }
        }

        count = 0;
        for(int i = 0; i < votes.length; i++){
            if(candidate.equals(votes[i])){
                count++;
            }
        }

        if(count >= (votes.length / 2) + 1){
            return candidate;
        }
        return "";
    }

}
