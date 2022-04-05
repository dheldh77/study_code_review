package clean.code.design6.data.movie.step01;

public class SequenceDiscountCondition implements DiscountCondition{
    private int sequence; //순번

    public SequenceDiscountCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return sequence == screening.getSequence();
    }

}
