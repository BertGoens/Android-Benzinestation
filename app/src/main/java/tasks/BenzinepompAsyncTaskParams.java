package tasks;/* Created by BertGoens */

import android.widget.ProgressBar;
import android.widget.TextView;

import model.BenzinepompBase;

public class BenzinepompAsyncTaskParams {

    private BenzinepompBase benzinepomp;
    private ProgressBar _pgbLitersGetankt;
    private TextView _tvLitersGetankt;
    private TextView _tvTotalePrijs;

    //De parameters voor BenzinepompAsyncTask
    public BenzinepompAsyncTaskParams(BenzinepompBase benzinepomp,
                                      ProgressBar pgbLitersGetankt,
                                      TextView tvLitersGetankt,
                                      TextView tvTotalePrijs)
    {
        this.benzinepomp = benzinepomp;
        this._pgbLitersGetankt = pgbLitersGetankt;
        this._tvLitersGetankt = tvLitersGetankt;
        this._tvTotalePrijs = tvTotalePrijs;
    }

    public BenzinepompBase getBenzinepomp() {
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
