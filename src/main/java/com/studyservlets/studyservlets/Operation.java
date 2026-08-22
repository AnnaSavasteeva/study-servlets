package com.studyservlets.studyservlets;

import java.util.UUID;

public class Operation {

    private UUID id;
    private Integer num1;
    private Integer num2;
    private Integer result;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", result=" + result +
                '}';
    }
}
