package model;

import java.util.ArrayList;
import java.util.List;

/* Created by Bert Goens */
public class KasticketDB {

    private static KasticketDB instance = new KasticketDB();
    private List<Kasticket> kastickets;

    private KasticketDB() {
        kastickets = new ArrayList<>();
    }

    private static class HoldInstance {
        private static final KasticketDB INSTANCE = new KasticketDB();
    }

    public static KasticketDB getInstance() {
        return HoldInstance.INSTANCE;
    }

    public List<Kasticket> getKastickets() {
        return kastickets;
    }

}
