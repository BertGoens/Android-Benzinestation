package fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Date;

import bert.bertgoens_benzinestation.R;
import model.PompBase;
import model.DieselPomp;
import model.Kasticket;
import tasks.PompAsyncTask;
import tasks.PompAsyncTaskParams;

public class PompFragment extends Fragment {

    private PompBase _pomp;
    private PompAsyncTask _pompTask;
    private  AfrekenenListener _afrekenen;

    public interface Arguments {

        String BENZINEPOMP = "benzinepomp";
    }

    public interface AfrekenenListener {

        void afrekenen(Kasticket kasticket);
    }

    public PompFragment() {
        _pompTask = new PompAsyncTask();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_benzinepomp, container, false);

        _pomp = (PompBase) getArguments().get(Arguments.BENZINEPOMP);

        final TextView tvPrijs = (TextView) view.findViewById(R.id.tv_prijs);
        tvPrijs.setText(Double.toString(_pomp.getTotalePrijs()));

        final TextView tvLiters = (TextView) view.findViewById(R.id.tv_liters);
        tvLiters.setText(Integer.toString(_pomp.getKlantLitersGetankt()));

        final ImageView imgPomp = (ImageView) view.findViewById(R.id.img_pomp);
        if (_pomp.getImageId() != null) {
            imgPomp.setImageResource(_pomp.getImageId());
        }

        final ProgressBar pgbPomp = (ProgressBar) view.findViewById(R.id.pgb_pomp);
        pgbPomp.setProgress(_pomp.getKlantLitersGetankt());

        final Button btnStart = (Button) view.findViewById(R.id.btn_pomp_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_pompTask != null) {
                    _pompTask.cancel(true);
                    //_pomp = new DieselPomp();
                    _pomp.setKlantLitersGetankt(0);
                    pgbPomp.setProgress(0);
                    tvLiters.setText("0");
                    tvPrijs.setText("0");
                }

                PompAsyncTaskParams params = new PompAsyncTaskParams(
                        _pomp,
                        pgbPomp,
                        tvLiters,
                        tvPrijs);
                _pompTask = new PompAsyncTask();
                //Multi threaded
                _pompTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
            }
        });

        final Button btnStop = (Button) view.findViewById(R.id.btn_pomp_stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_pompTask != null) {
                    _pompTask.cancel(true);
                }
            }
        });

        final Button btnAfrekenen = (Button) view.findViewById(R.id.btn_pomp_afrekenen);
        btnAfrekenen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kasticket kasticket = new Kasticket(new Date(), //Tank Datum
                        _pomp.getTankNummer(),
                        _pomp.getTotalePrijs(), //Bedrag
                        _pomp.getType(), //Diesel
                        _pomp.getKlantLitersGetankt());

                if (_afrekenen != null) {
                    _afrekenen.afrekenen(kasticket);
                }
            }
        });

        return view;
    }

    private void refreshPomp() {


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            _afrekenen = (AfrekenenListener) context;
        } catch (ClassCastException e) {
            Log.w("PompFragment", "Please implement OnClickListener.afrekenenOnClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
