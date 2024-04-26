package com.example.application.ui.views;

import java.time.YearMonth;

public class DataBean {
    private YearMonth startMonthYear = YearMonth.now();
    private YearMonth endMonthYear = YearMonth.now();

    public YearMonth getStartMonthYear() {
        return startMonthYear;
    }

    public void setStartMonthYear(YearMonth startMonthYear) {
        this.startMonthYear = startMonthYear;
    }

    public YearMonth getEndMonthYear() {
        return endMonthYear;
    }

    public void setEndMonthYear(YearMonth endMonthYear) {
        this.endMonthYear = endMonthYear;
    }
}
