package model;
/* Created by BertGoens */

public interface Pomp {
    double getPrijsPerLiter();
    PompType getType();
    int getTankNummer();
    int getKlantLitersGetankt();
    Integer getImageId();
    double getTotalePrijs();

    int MAXIMUM_LITERS = 50;
}
