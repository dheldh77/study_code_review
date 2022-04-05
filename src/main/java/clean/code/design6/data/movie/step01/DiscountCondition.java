package clean.code.design6.data.movie.step01;

import java.time.DayOfWeek;
import java.time.LocalTime;

//상태 값에 따라 분기되어 처리 -> 상태 패턴, 상속 다형성
//상태 패턴 -> 최초 생성된 객체의 상태가 종료시까지 유지가 되어여함

//실행중 상태 값이 변경되면 안됨
//실행 중 상태 값을 변경 하여 처리할 때는 전략 패턴을 사용해야 함

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
