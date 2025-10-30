package bg.sofia.uni.fmi.mjt.show.elimination;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

import java.util.Arrays;

public class LowAttributeSumEliminationRule implements EliminationRule{
    private int threshold;

    public LowAttributeSumEliminationRule(int threshold){
        this.threshold = threshold;
    }

    @Override
    public Ergenka[] eliminateErgenkas(Ergenka[] ergenkas) {
        int remainingCount = getRemainingErgenkasCount(ergenkas);

        Ergenka[] remainingErgenkas = new Ergenka[remainingCount];
        int newIndex = 0;
        for (Ergenka e : ergenkas) {
            if (e.getHumorLevel() + e.getRomanceLevel() >= threshold) {
                remainingErgenkas[newIndex++] = e;
            }
        }

        return remainingErgenkas;
    }

    int getRemainingErgenkasCount(Ergenka[] ergenkas){
        int remainingCount = 0;
        for (Ergenka e : ergenkas) {
            if (e.getHumorLevel() + e.getRomanceLevel() >= threshold) {
                remainingCount++;
            }
        }
        return remainingCount;
    }

}
