package clean.code.design6.data.movie.step01;

import clean.code.design6.money.Money;

/*
페이지 36
현재 NoneDiscountPolicy를 구현시 불필요한 부모의 멤버 변수를 discountConditions를 사용함
그래서 NoneDiscountPolicy 객체의 경우 discountConditions을 사용하지 않고 처리할 수 있게 코드를 수정 해야 한다
Movie와 DefaultDiscountPolicy를 분리하여 처리할 수 있게 구현
 * */

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}