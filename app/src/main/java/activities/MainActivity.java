package activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import bert.bertgoens_benzinestation.R;
import broadcastreciever.KasticketReciever;
import fragments.PompFragment;

import model.DieselPomp;
import model.Kasticket;
import model.SuperPomp;

public class MainActivity extends AppCompatActivity implements PompFragment.AfrekenenListener {

    private List<Kasticket> _kasticketten = new ArrayList<>();
    private DieselPomp dieselPomp = new DieselPomp();
    private SuperPomp superPomp = new SuperPomp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PompFragment dieselFragment = new PompFragment();
        Bundle args1 = new Bundle();
        args1.putParcelable(PompFragment.Arguments.BENZINEPOMP, dieselPomp);
        dieselFragment.setArguments(args1);

        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        transaction1.replace(R.id.fragment_dieselpomp, dieselFragment);
        transaction1.addToBackStack(null);
        transaction1.commit();

        PompFragment superFragment = new PompFragment();
        Bundle args2 = new Bundle();
        args2.putParcelable(PompFragment.Arguments.BENZINEPOMP, superPomp);
        superFragment.setArguments(args2);

        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
        transaction2.replace(R.id.fragment_superpomp, superFragment );
        transaction2.addToBackStack(null);
        transaction2.commit();
    }

    @Override
    public void afrekenen(Kasticket kasticket) {
        _kasticketten.add(kasticket);

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, KasticketReciever.class);
        intent.putExtra(KasticketReciever.IntentExtras.KASTICKKET, kasticket);
        sendBroadcast(intent);
    }
}
