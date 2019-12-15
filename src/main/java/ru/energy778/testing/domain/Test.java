package ru.energy778.testing.domain;

import java.util.List;

public class Test {

    private Question question;
    private List<Answer> answers;

    public Test() {
    }

    public Test(Question question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
