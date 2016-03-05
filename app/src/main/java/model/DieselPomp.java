package model;/* Created by BertGoens */

import android.os.Parcel;
import android.os.Parcelable;

import bert.bertgoens_benzinestation.R;

public class DieselPomp extends PompBase {

    public DieselPomp() {
        super(0.7,PompType.Diesel, 1, R.drawable.links);
    }

    protected DieselPomp(Parcel in) {
        super(in);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DieselPomp> CREATOR = new Parcelable.Creator<DieselPomp>() {
        @Override
        public DieselPomp createFromParcel(Parcel in) {
            return new DieselPomp(in);
        }

        @Override
        public DieselPomp[] newArray(int size) {
            return new DieselPomp[size];
        }
    };
}
