package clean.code.design6.data.movie.step01;

import clean.code.design6.money.Money;

import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    public abstract Money calculateDiscountAmount(Screening screening);
}