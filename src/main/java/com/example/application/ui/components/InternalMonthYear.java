package com.example.application.ui.components;

import java.time.YearMonth;
import java.util.function.Consumer;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.react.ReactAdapterComponent;

@JsModule("./monthYear.tsx")
@Tag("month-year")
public class InternalMonthYear extends ReactAdapterComponent {
    public InternalMonthYear() {
        YearMonth now = YearMonth.now();
        setYear(now.getYear());
        setMonth(now.getMonthValue());
    }

    public void setYear(int year) {
        setState("year", year);
    }
    public void setMonth(int month) {
        setState("month", month);
    }

    public int getYear() {
        return getState("year", Integer.class);
    }

    public int getMonth() {
        return getState("month", Integer.class);
    }

    public void addYearMonthChangeListener(Consumer<YearMonth> changeListener) {
        addStateChangeListener("year", Integer.class, year -> {
            changeListener.accept(YearMonth.of(year, getMonth()));
        });
        addStateChangeListener("month", Integer.class, month -> {
            System.out.println("Month changed");
            changeListener.accept(YearMonth.of(getYear(), month));
        });
    }
}
