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
        //영화 정보 얻기
        Movie movie = screening.getMovie(); //ok
        //movie 접근은(X)

        //해당 영화가 할인 가능한지 여부 확인
        boolean discountable = movie.isDiscountable(screening);

        Money fee;
        if (discountable) {
            //할인 가능하면
            Money discountAmount = Money.ZERO;
            //할인 정책에 따른 요금 계산
            switch(movie.getMovieType()) {
                case AMOUNT_DISCOUNT:
                    //금액으로 할인 금액 계산
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    //퍼센트로 할인 금액 계산
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NONE_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
            }
            //영화비에서 할인 금액만큼 빼고 예약자수 만큼 곱하여 요금계산 한다
            fee = movie.getFee().minus(discountAmount).times(audienceCount);
        } else {
            //영화비를 예약자수 만큼 곱하여 요금계산 한다
            fee = movie.getFee().times(audienceCount);
        }
        //예약 객체를 생성한다
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
