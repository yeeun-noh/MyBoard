package org.zerock.board.domain;

public enum ActivityHistoryTypes {

    View(1), Like(2), Dislike(3);

    private final int value;

    ActivityHistoryTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
