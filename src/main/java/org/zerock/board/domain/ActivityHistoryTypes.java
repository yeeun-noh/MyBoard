package org.zerock.board.domain;

public enum ActivityHistoryTypes {

    View(1), Like(2), Dislike(3);

    private final int valiue;

    ActivityHistoryTypes(int valiue) {
        this.valiue = valiue;
    }

    public int getValiue() {
        return valiue;
    }
}
