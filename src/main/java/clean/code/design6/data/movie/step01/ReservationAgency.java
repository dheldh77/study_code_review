package clean.code.design6.data.movie.step01;

import clean.code.design6.money.Money;

public class ReservationAgency {

//    public Reservation reserve(Screening screening, Customer customer,
//                                      int audienceCount) {
//        //멤버 변수와 매개변수만 사용해야 함
//        return Reservation();
//    }

    //매개변수만 사용해야 함
    static public Reservation reserve(Screening screening, Customer customer,
                                      int audienceCount) {
        //예약 객체를 생성한다
        return new Reservation(customer, screening, screening.calculateFee(audienceCount), audienceCount);
    }
}
