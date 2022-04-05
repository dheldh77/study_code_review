package clean.code.design6.data.movie.step01;

import clean.code.design6.money.Money;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class NoneDiscountMovie extends Movie {

    public NoneDiscountMovie(String title, Duration runningTime, Money fee) {
        super(title, runningTime, fee);
    }

    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }

}

