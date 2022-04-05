package clean.code.design6.data.movie.step01;

import clean.code.design6.money.Money;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    //    private int movieType; //0,1,2, 논리오류 발생 -> 3,4,5,6
    private MovieType movieType; //상속, 다형성으로 해결 할 수 있음, 할인정책(금액, 퍼센트, 없음)
    private Money discountAmount;
    private double discountPercent;

    public Movie(String title, Duration runningTime, Money fee, double discountPercent, DiscountCondition... discountConditions) {
        this(MovieType.PERCENT_DISCOUNT, title, runningTime, fee, Money.ZERO, discountPercent, discountConditions);
    }

    public Movie(String title, Duration runningTime, Money fee, Money discountAmount, DiscountCondition... discountConditions) {
        this(MovieType.AMOUNT_DISCOUNT, title, runningTime, fee, discountAmount, 0, discountConditions);
    }

    public Movie(String title, Duration runningTime, Money fee) {
        this(MovieType.NONE_DISCOUNT, title, runningTime, fee, Money.ZERO, 0);
    }

    private Movie(MovieType movieType, String title, Duration runningTime, Money fee, Money discountAmount, double discountPercent,
                  DiscountCondition... discountConditions) {
        this.movieType = movieType;
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountAmount = discountAmount;
        this.discountPercent = discountPercent;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return Collections.unmodifiableList(discountConditions);
    }

    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public boolean isDiscountable(Screening screening) {
        //stream으로 변경 할 수 있음

        return discountConditions.stream().anyMatch(condition -> condition.isDiscountable(screening));
    }

    public Money calculateFee(Screening screening) {
        //해당 영화가 할인 가능한지 여부 확인
        boolean discountable = isDiscountable(screening);

        Money fee;
        if (discountable) {
            //할인 가능하면
            Money discountAmount = Money.ZERO;
            //할인 정책에 따른 요금 계산
            switch(movieType) {
                case AMOUNT_DISCOUNT:
                    //금액으로 할인 금액 계산
                    discountAmount = this.discountAmount;
                    break;
                case PERCENT_DISCOUNT:
                    //퍼센트로 할인 금액 계산
                    discountAmount = this.fee.times(discountPercent);
                    break;
                case NONE_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
            }
            //영화비에서 할인 금액만큼 빼고 예약자수 만큼 곱하여 요금계산 한다
            fee = this.fee.minus(discountAmount);
        } else {
            //영화비를 예약자수 만큼 곱하여 요금계산 한다
            fee = this.fee;
        }
        return fee;
    }

}
