package model.pomp;

import bert.bertgoens_benzinestation.R;
import util.Constants;

/* Created by Bert Goens */
public class SuperStrategy implements PompStrategy {

    @Override
    public double getPrijs() {
        return Constants.SuperPrijs;
    }

    @Override
    public PompType getPompType() {
        return PompType.Super;
    }

    @Override
    public Integer getImageId() {
        return R.drawable.rechts;
    }
}
