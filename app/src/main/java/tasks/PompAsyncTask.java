package tasks;/* Created by BertGoens */

import android.os.AsyncTask;

import model.Pomp;

//Params Progress Result
public class PompAsyncTask extends AsyncTask<PompAsyncTaskParams, Void, Void> {

    PompAsyncTaskParams bp;

    @Override
    protected Void doInBackground(PompAsyncTaskParams... params) {
        bp = params[0];

        for (int i = 1; i < Pomp.MAXIMUM_LITERS +1; i++) {
            //Als thread cancelled(true) is moet je manueel uit je loop springen
            if(isCancelled()) break;

            bp.getBenzinepomp().setKlantLitersGetankt(i);

            publishProgress();
            sleep();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        //UPDATE PGB
        bp.getPgbLitersGetankt().setProgress(bp.getBenzinepomp().getKlantLitersGetankt());

        //UPDATE TOTALE PRIJS
        bp.getTvTotalePrijs().setText(String.valueOf(bp.getBenzinepomp().getTotalePrijs()));

        //UPDATE LITERS
        //Integer.toString() anders denk android dat het een resource id is
        bp.getTvLitersGetankt().setText(Integer.toString(bp.getBenzinepomp().getKlantLitersGetankt()));
    }

    private void sleep() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
        }
    }
}
