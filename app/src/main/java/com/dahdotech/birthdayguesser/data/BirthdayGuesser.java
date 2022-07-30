package com.dahdotech.birthdayguesser.data;

public class BirthdayGuesser {
    private String askingText;
    private String dateView;

    public BirthdayGuesser(){

    }
    public BirthdayGuesser(String askingText, String dateView) {
        this.askingText = askingText;
        this.dateView = dateView;
    }

    public String getAskingText() {
        return askingText;
    }

    public void setAskingText(String askingText) {
        this.askingText = askingText;
    }

    public String getDateView() {
        return dateView;
    }

    public void setDateView(String dateView) {
        this.dateView = dateView;
    }
}
