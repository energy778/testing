package ru.energy778.testing.domain;

public class Question {

    private String data;
    private Boolean someAnswers;

    public Question(String data, Boolean someAnswers) {
        this.data = data;
        this.someAnswers = someAnswers;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean isSomeAnswers() {
        return someAnswers;
    }

    public void setSomeAnswers(Boolean someAnswers) {
        this.someAnswers = someAnswers;
    }

}
