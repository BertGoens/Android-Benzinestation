package model;
/* Created by BertGoens */

public interface Benzinepomp {
    double getPrijsPerLiter();
    PompType getType();
    int getTankNummer();
    int getKlantLitersGetankt();
    double getTotalePrijs();

    int MAXIMUM_LITERS = 50;
}
