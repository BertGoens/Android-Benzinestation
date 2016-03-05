package tasks;/* Created by BertGoens */

import android.widget.ProgressBar;
import android.widget.TextView;

import model.PompBase;

public class PompAsyncTaskParams {

    private PompBase benzinepomp;
    private ProgressBar _pgbLitersGetankt;
    private TextView _tvLitersGetankt;
    private TextView _tvTotalePrijs;

    //De parameters voor PompAsyncTask
    public PompAsyncTaskParams(PompBase benzinepomp,
                               ProgressBar pgbLitersGetankt,
                               TextView tvLitersGetankt,
                               TextView tvTotalePrijs)
    {
        this.benzinepomp = benzinepomp;
        this._pgbLitersGetankt = pgbLitersGetankt;
        this._tvLitersGetankt = tvLitersGetankt;
        this._tvTotalePrijs = tvTotalePrijs;
    }

    public PompBase getBenzinepomp() {
        return benzinepomp;
    }

    public ProgressBar getPgbLitersGetankt() {
        return _pgbLitersGetankt;
    }

    public TextView getTvLitersGetankt() {
        return _tvLitersGetankt;
    }

    public TextView getTvTotalePrijs() {
        return _tvTotalePrijs;
    }
}
