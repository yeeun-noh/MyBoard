package org.zerock.board.domain;

public enum UsersGradeLevel {

    Admin(1 << 0), User(1 << 1); // 01, 10 으로 표기

    private int value;

    UsersGradeLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UsersGradeLevel fromInteger(int i) throws IllegalAccessException {
        for(UsersGradeLevel usersGradeLevel : UsersGradeLevel.values()){
            if(usersGradeLevel.getValue() == i){
                return usersGradeLevel;
            }
        }
        throw new IllegalAccessException();
    }
}
