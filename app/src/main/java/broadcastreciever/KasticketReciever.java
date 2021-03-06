package broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import model.Kasticket;
import model.KasticketDB;

public class KasticketReciever extends BroadcastReceiver {

    public interface IntentExtras {
        String KASTICKKET = "kasticket";
    }

    public KasticketReciever() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //Parameters opvragen
        Bundle params = intent.getExtras();

        Kasticket kasticket = (Kasticket) params.get(IntentExtras.KASTICKKET);

        //Bijhouden
        KasticketDB.getInstance().getKastickets().add(kasticket);

        //Output
        Log.i("Kasticket", kasticket.toString());
    }
}
