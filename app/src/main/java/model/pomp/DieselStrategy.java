package model.pomp;

import bert.bertgoens_benzinestation.R;
import util.Constants;

/* Created by Bert Goens */
public class DieselStrategy implements PompStrategy {

    @Override
    public double getPrijs() {
        return Constants.DieselPrijs;
    }

    @Override
    public PompType getPompType() {
        return PompType.Diesel;
    }

    @Override
    public Integer getImageId() {
        return R.drawable.links;
    }
}
