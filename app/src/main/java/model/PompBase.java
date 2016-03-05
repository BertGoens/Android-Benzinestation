package model;
/* Created by BertGoens */

import android.os.Parcel;
import android.os.Parcelable;

public abstract class PompBase implements Pomp, Parcelable {

    private double _prijsPerLiter;
    private PompType _type;
    private int _tankNummer;
    private int _klantLitersGetankt;
    private Integer _imageId;

    public PompBase() {
        this._klantLitersGetankt = 0;
    }

    public PompBase(double prijs, PompType type, int tankNummer, Integer imageId) {
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


    /* PARCELABLE */
    protected PompBase(Parcel in) {
        _prijsPerLiter = in.readDouble();
        _type = (PompType) in.readValue(PompType.class.getClassLoader());
        _tankNummer = in.readInt();
        _klantLitersGetankt = in.readInt();
        _imageId = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(_prijsPerLiter);
        dest.writeValue(_type);
        dest.writeInt(_tankNummer);
        dest.writeInt(_klantLitersGetankt);
        if (_imageId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(_imageId);
        }
    }


}
