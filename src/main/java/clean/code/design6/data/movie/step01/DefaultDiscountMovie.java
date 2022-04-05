package clean.code.design6.data.movie.step01;

import clean.code.design6.money.Money;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountMovie extends Movie {
    private List<DiscountCondition> discountConditions;

    public DefaultDiscountMovie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions){
        super(title, runningTime, fee);
        this.discountConditions = Arrays.asList(discountConditions);
    }

    private boolean isDiscountable(Screening screening) {
        //stream으로 변경 할 수 있음
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    @Override
    public Money calculateFee(Screening screening) {
        if (isDiscountable(screening)) {
            //할인가능하면 할인 금액 계산
            //template method pattern
            return super.getFee().minus(calculateDiscountAmount());
        }
        return super.getFee();// = this.fee;
    }

    //자식의 메소드를 호출하는 것이 목적
    protected abstract Money calculateDiscountAmount();
}
