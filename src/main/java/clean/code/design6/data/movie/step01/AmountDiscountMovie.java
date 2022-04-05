package clean.code.design6.data.movie.step01;

import clean.code.design6.money.Money;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AmountDiscountMovie extends Movie {
    private Money discountAmount;

    public AmountDiscountMovie(String title, Duration runningTime, Money fee, Money discountAmount, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return this.discountAmount;
    }

}

