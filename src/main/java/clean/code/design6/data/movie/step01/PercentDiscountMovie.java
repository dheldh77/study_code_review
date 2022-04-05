package clean.code.design6.data.movie.step01;

import clean.code.design6.money.Money;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PercentDiscountMovie extends  Movie {
    private double discountPercent;

    public PercentDiscountMovie(String title, Duration runningTime, Money fee, double discountPercent, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.discountPercent = discountPercent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(discountPercent);
    }
}

