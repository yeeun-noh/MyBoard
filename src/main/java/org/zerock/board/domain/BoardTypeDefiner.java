package org.zerock.board.domain;

public enum BoardTypeDefiner {

    Best(1), Announcement(2), Common(3); //게시판별 권한 주기

    private final int value;

    BoardTypeDefiner(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BoardTypeDefiner fromInteger(int i) throws IllegalAccessException {
        for(BoardTypeDefiner boardTypeDefiner : BoardTypeDefiner.values()) {
            if(boardTypeDefiner.getValue() == i) {
                return boardTypeDefiner;
            }
        }
        throw new IllegalAccessException("Invalid BoardTypeDefiner value===> " + i);
    }
}
