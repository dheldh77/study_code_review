package clean.code.design6.data.movie.step01;

import java.time.DayOfWeek;
import java.time.LocalTime;

//클래스명 또는 객체명 : 명사
//메서드 : 동사, 동사 + 명사

public class PeriodDiscountCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek; //기간
    private LocalTime startTime; //기간 시작시간
    private LocalTime endTime;   //기간 종료시간

    public PeriodDiscountCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return (dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0);
    }

}