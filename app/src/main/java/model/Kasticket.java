package model;/* Created by BertGoens */

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Kasticket implements Parcelable {
    private Date datum;
    private int pompNummer;
    private double bedrag;
    private PompType type;
    private int getankt;

    public Kasticket(Date datum, int pompNummer, double bedrag, PompType type, int getankt) {
        this.datum = datum;
        this.pompNummer = pompNummer;
        this.bedrag = bedrag;
        this.type = type;
        this.getankt = getankt;
    }

    @Override
    public String toString() {
        return "Kasticket{" +
                "datum=" + datum +
                ", pompNummer=" + pompNummer +
                ", bedrag=" + bedrag +
                ", type='" + type + '\'' +
                ", getankt=" + getankt +
                '}';
    }



    protected Kasticket(Parcel in) {
        long tmpDatum = in.readLong();
        datum = tmpDatum != -1 ? new Date(tmpDatum) : null;
        pompNummer = in.readInt();
        bedrag = in.readDouble();
        type = (PompType) in.readValue(PompType.class.getClassLoader());
        getankt = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(datum != null ? datum.getTime() : -1L);
        dest.writeInt(pompNummer);
        dest.writeDouble(bedrag);
        dest.writeValue(type);
        dest.writeInt(getankt);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Kasticket> CREATOR = new Parcelable.Creator<Kasticket>() {
        @Override
        public Kasticket createFromParcel(Parcel in) {
            return new Kasticket(in);
        }

        @Override
        public Kasticket[] newArray(int size) {
            return new Kasticket[size];
        }
    };
}
