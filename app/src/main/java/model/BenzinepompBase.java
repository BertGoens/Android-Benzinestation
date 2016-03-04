package model;
/* Created by BertGoens */

public abstract class BenzinepompBase implements Benzinepomp {

    private double _prijsPerLiter;
    private PompType _type;
    private int _tankNummer;
    private int _klantLitersGetankt;
    private Integer _imageId;

    public BenzinepompBase() {
        this._klantLitersGetankt = 0;
    }

    public BenzinepompBase(double prijs, PompType type, int tankNummer, Integer imageId) {
        this._prijsPerLiter = prijs;
        this._type = type;
        this._tankNummer = tankNummer;
        this._imageId = imageId;
    }

    @Override
    public double getPrijsPerLiter() {
        return _prijsPerLiter;
    }

    @Override
    public PompType getType() {
        return _type;
    }

    @Override
    public int getTankNummer() {
        return _tankNummer;
    }

    @Override
    public int getKlantLitersGetankt() {
        return _klantLitersGetankt;
    }

    @Override
    public Integer getImageId() {
        return _imageId;
    }

    @Override
    public double getTotalePrijs() {
        double prijs = getPrijsPerLiter() * getKlantLitersGetankt();
        double roundOff = (double) Math.round(prijs * 100) / 100;
        return roundOff;
    }

    public void setKlantLitersGetankt(int klantLitersGetankt) {
        this._klantLitersGetankt = klantLitersGetankt;
    }
}
