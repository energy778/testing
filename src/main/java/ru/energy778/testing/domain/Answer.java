package ru.energy778.testing.domain;

public class Answer {

    private String data;
    private Boolean correct;

    public Answer(String data, Boolean correct) {
        this.data = data;
        this.correct = correct;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean isCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

}
