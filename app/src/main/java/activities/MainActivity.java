package activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import bert.bertgoens_benzinestation.R;
import broadcastreciever.KasticketReciever;
import fragments.PompFragment;

import model.Kasticket;
import model.pomp.DieselStrategy;
import model.pomp.Pomp;
import model.pomp.SuperStrategy;

public class MainActivity extends AppCompatActivity implements PompFragment.AfrekenenListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PompFragment dieselFragment = new PompFragment();
        Bundle args1 = new Bundle();
        args1.putParcelable(PompFragment.Arguments.BENZINEPOMP, new Pomp(new DieselStrategy()));
        dieselFragment.setArguments(args1);

        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        transaction1.replace(R.id.fragment_dieselpomp, dieselFragment);
        transaction1.addToBackStack(null);
        transaction1.commit();

        PompFragment superFragment = new PompFragment();
        Bundle args2 = new Bundle();
        args2.putParcelable(PompFragment.Arguments.BENZINEPOMP, new Pomp(new SuperStrategy()));
        superFragment.setArguments(args2);

        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
        transaction2.replace(R.id.fragment_superpomp, superFragment );
        transaction2.addToBackStack(null);
        transaction2.commit();
    }

    @Override
    public void afrekenen(Kasticket kasticket) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, KasticketReciever.class);
        intent.putExtra(KasticketReciever.IntentExtras.KASTICKKET, kasticket);
        sendBroadcast(intent);
    }
}
