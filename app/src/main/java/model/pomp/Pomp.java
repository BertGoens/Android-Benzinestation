package model.pomp;
/* Created by BertGoens */

import android.os.Parcel;
import android.os.Parcelable;

import util.RoundToDouble;

public class Pomp implements Parcelable {

    private PompStrategy _pompStrategy;
    private static int _tankNummer;
    private int _dezeTankNummer;
    private int _klantLitersGetankt;

    public Pomp() {
        this._klantLitersGetankt = 0;
    }

    public Pomp(PompStrategy pompStrategy) {
        this._pompStrategy = pompStrategy;
        _tankNummer++;
        _dezeTankNummer = _tankNummer;
    }

    public double getPrijsPerLiter() {
        return _pompStrategy.getPrijs();
    }

    public PompType getType() {
        return _pompStrategy.getPompType();
    }

    public int getTankNummer() {
        return _dezeTankNummer;
    }

    public int getKlantLitersGetankt() {
        return _klantLitersGetankt;
    }

    public Integer getImageId() {
        return _pompStrategy.getImageId();
    }

    public double getTotalePrijs() {
        double prijs = getPrijsPerLiter() * getKlantLitersGetankt();
        return RoundToDouble.roundToDouble(prijs);
    }

    public void setKlantLitersGetankt(int klantLitersGetankt) {
        this._klantLitersGetankt = klantLitersGetankt;
    }

    protected Pomp(Parcel in) {
        _pompStrategy = (PompStrategy) in.readValue(PompStrategy.class.getClassLoader());
        _dezeTankNummer = in.readInt();
        _klantLitersGetankt = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_pompStrategy);
        dest.writeInt(_dezeTankNummer);
        dest.writeInt(_klantLitersGetankt);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Pomp> CREATOR = new Parcelable.Creator<Pomp>() {
        @Override
        public Pomp createFromParcel(Parcel in) {
            return new Pomp(in);
        }

        @Override
        public Pomp[] newArray(int size) {
            return new Pomp[size];
        }
    };
}
