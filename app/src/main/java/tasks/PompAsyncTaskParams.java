package tasks;
/* Created by BertGoens */

import android.widget.ProgressBar;
import android.widget.TextView;

import model.pomp.Pomp;

public class PompAsyncTaskParams {

    private Pomp benzinepomp;
    private ProgressBar _pgbLitersGetankt;
    private TextView _tvLitersGetankt;
    private TextView _tvTotalePrijs;

    //De parameters voor PompAsyncTask
    public PompAsyncTaskParams(Pomp benzinepomp,
                               ProgressBar pgbLitersGetankt,
                               TextView tvLitersGetankt,
                               TextView tvTotalePrijs)
    {
        this.benzinepomp = benzinepomp;
        this._pgbLitersGetankt = pgbLitersGetankt;
        this._tvLitersGetankt = tvLitersGetankt;
        this._tvTotalePrijs = tvTotalePrijs;
    }

    public Pomp getBenzinepomp() {
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
