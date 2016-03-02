package bert.bertgoens_benzinestation.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Date;

import bert.bertgoens_benzinestation.R;
import broadcastreciever.KasticketReciever;
import model.BenzinepompBase;
import model.DieselPomp;
import model.Kasticket;
import model.SuperPomp;
import tasks.BenzinepompAsyncTask;
import tasks.BenzinepompAsyncTaskParams;

public class MainActivity extends AppCompatActivity {

    private DieselPomp dieselPomp = new DieselPomp();
    private SuperPomp superPomp = new SuperPomp();

    private BenzinepompAsyncTask dieselPompTask;
    private BenzinepompAsyncTask superPompTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvDieselPrijs = (TextView) findViewById(R.id.tv_diesel_prijs);
        final TextView tvSuperPrijs = (TextView) findViewById(R.id.tv_super_prijs);

        final TextView tvDieselLiters = (TextView) findViewById(R.id.tv_diesel_liters);
        final TextView tvSuperLiters = (TextView) findViewById(R.id.tv_super_liters);

        final ProgressBar pgbDiesel = (ProgressBar) findViewById(R.id.pgb_diesel);
        final ProgressBar pgbSuper = (ProgressBar) findViewById(R.id.pgb_super);

        final Button btnDieselStart = (Button) findViewById(R.id.btn_diesel_start);
        final Button btnDieselStop = (Button) findViewById(R.id.btn_diesel_stop);
        final Button btnDieselAfrekenen = (Button) findViewById(R.id.btn_diesel_afrekenen);

        final Button btnSuperStart = (Button) findViewById(R.id.btn_super_start);
        final Button btnSuperStop = (Button) findViewById(R.id.btn_super_stop);
        final Button btnSuperAfrekeken = (Button) findViewById(R.id.btn_super_afrekenen);

        btnDieselStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dieselPompTask != null) {
                    dieselPompTask.cancel(true);
                    dieselPomp = new DieselPomp();
                }

                BenzinepompAsyncTaskParams params = new BenzinepompAsyncTaskParams(
                        dieselPomp,
                        pgbDiesel,
                        tvDieselLiters,
                        tvDieselPrijs);
                dieselPompTask = new BenzinepompAsyncTask();
                //Multi threaded
                dieselPompTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,params);
            }
        });

        btnDieselStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dieselPompTask != null) {
                    dieselPompTask.cancel(true);
                }
            }
        });

        btnDieselAfrekenen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printKasticket(dieselPomp);
            }
        });

        btnSuperStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (superPompTask != null) {
                    superPompTask.cancel(true);
                    superPomp = new SuperPomp();
                }

                BenzinepompAsyncTaskParams params = new BenzinepompAsyncTaskParams(
                        superPomp,
                        pgbSuper,
                        tvSuperLiters,
                        tvSuperPrijs
                );

                superPompTask = new BenzinepompAsyncTask();
                //Multi threaded
                superPompTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
            }
        });

        btnSuperStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (superPompTask != null) {
                    superPompTask.cancel(true);
                }
            }
        });

        btnSuperAfrekeken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printKasticket(superPomp);
            }
        });
    }

    private void printKasticket(BenzinepompBase pomp) {
        Kasticket kasticket = new Kasticket(new Date(), //Tank Datum
                pomp.getTankNummer(),
                pomp.getTotalePrijs(), //Bedrag
                pomp.getType(), //Diesel
                pomp.getKlantLitersGetankt());

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, KasticketReciever.class);
        intent.putExtra(KasticketReciever.IntentExtras.KASTICKKET, kasticket);
        sendBroadcast(intent);
    }
}
