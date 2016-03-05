package model;
/* Created by BertGoens */

import android.os.Parcel;
import android.os.Parcelable;

import bert.bertgoens_benzinestation.R;

public class SuperPomp extends PompBase {

    public SuperPomp() {
        super(1.1, PompType.Super, 2, R.drawable.rechts);
    }

    protected SuperPomp(Parcel in) {
        super(in);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SuperPomp> CREATOR = new Parcelable.Creator<SuperPomp>() {
        @Override
        public SuperPomp createFromParcel(Parcel in) {
            return new SuperPomp(in);
        }

        @Override
        public SuperPomp[] newArray(int size) {
            return new SuperPomp[size];
        }
    };
}
