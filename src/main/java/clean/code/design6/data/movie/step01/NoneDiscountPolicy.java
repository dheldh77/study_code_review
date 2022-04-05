package clean.code.design6.data.movie.step01;

import clean.code.design6.money.Money;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class NoneDiscountPolicy extends DiscountPolicy {

    public NoneDiscountPolicy() {
        super(null);
    }

    protected Money getDiscountAmount(Money fee) {
        return Money.ZERO;
    }

}


/*
NoneDiscountMovie 는 페이지 34
현재 NoneDiscountMovie를 구현시 불필요한 부모의 멤버 변수를 discountConditions를 사용함
그래서 NoneDiscountMovie 객체의 경우 discountConditions을 사용하지 않고 처리할 수 있게 코드를 수정 해야 한다

Movie와 DefaultDiscountMovie를 분리하여 처리할 수 있게 구현

페이지 36
현재 NoneDiscountPolicy를 구현시 불필요한 부모의 멤버 변수를 discountConditions를 사용함
그래서 NoneDiscountPolicy 객체의 경우 discountConditions을 사용하지 않고 처리할 수 있게 코드를 수정 해야 한다
Movie와 DefaultDiscountPolicy를 분리하여 처리할 수 있게 구현

 * */