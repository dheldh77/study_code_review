package clean.code.design6.data.movie.step01;

import clean.code.design6.money.Money;

import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy extends DiscountPolicy{
    private List<DiscountCondition> discountConditions;

    public DefaultDiscountPolicy(DiscountCondition... discountConditions) {
        this.discountConditions = Arrays.asList(discountConditions);
    }

    private boolean isDiscountable(Screening screening) {
        //stream으로 변경 할 수 있음
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    @Override
    //할인 금액을 계산하여 리턴한다
    public Money calculateDiscountAmount(Screening screening) {
        if (isDiscountable(screening)) {
            //할인가능하면 할인 금액 계산
            //template method pattern
            return getDiscountAmount(screening.getMovieFee());
        }
        return Money.ZERO;
    }

    protected abstract Money getDiscountAmount(Money fee);
}