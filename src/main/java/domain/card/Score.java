package domain.card;

import java.util.Objects;

public final class Score {

    private static final int BONUS_SCORE = 10;
    private static final int MAX_SCORE = 21;

    private final int score;


    public Score(final int score) {
        this.score = score;
    }

    public static Score from(final int score) {
        return new Score(score);
    }

    public boolean isUnderThan(final int compare) {
        return score < compare;
    }

    public boolean isUnderMaxScore() {
        return score <= MAX_SCORE;
    }

    public boolean canAddBonusScore() {
        return this.score <= MAX_SCORE - BONUS_SCORE;
    }

    public Score getScore() {
        return this;
    }

    public Score getScoreWithBonusScore() {
        return Score.from(score + BONUS_SCORE);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Score score1 = (Score) o;
        return score == score1.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
