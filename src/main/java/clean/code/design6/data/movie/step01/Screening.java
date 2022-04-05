package clean.code.design6.data.movie.step01;

import clean.code.design6.money.Money;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public void setWhenScreened(LocalDateTime whenScreened) {
        this.whenScreened = whenScreened;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Money calculateFee(int audienceCount) {
        //해당 영화가 할인 가능한지 여부 확인
        return movie.calculateFee(this).times(audienceCount);
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        //예약 객체를 생성한다
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }
}
