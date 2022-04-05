package clean.code.design6.data.movie.step01;

import clean.code.design6.money.Money;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    public Movie(String title, Duration runningTime, Money fee) {
        this(title, runningTime, fee, null);
    }

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        if (discountConditions != null)
            this.discountConditions = Arrays.asList(discountConditions);
    }

    public Money getFee() {
        return fee;
    }

    public boolean isDiscountable(Screening screening) {
        //stream으로 변경 할 수 있음
        if (discountConditions != null)
            return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
        return false;
    }

    public Money calculateFee(Screening screening) {
        if (isDiscountable(screening)) {
            //할인가능하면 할인 금액 계산
            //template method pattern
            return fee.minus(calculateDiscountAmount());
        }
        return fee;// = this.fee;
    }

    //자식의 메소드를 호출하는 것이 목적
    protected abstract Money calculateDiscountAmount();
}

