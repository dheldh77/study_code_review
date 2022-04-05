package clean.code.design6.data.movie.step01;

import clean.code.design6.money.Money;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double discountPercent;

    public PercentDiscountPolicy(double discountPercent, DiscountCondition... discountConditions) {
        super(discountConditions);
        this.discountPercent = discountPercent;
    }

    @Override
    protected Money getDiscountAmount(Money fee) {
        return fee.times(discountPercent);
    }
}
