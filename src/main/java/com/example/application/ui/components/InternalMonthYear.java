package com.example.application.ui.components;

import java.time.YearMonth;
import java.util.function.Consumer;

import com.vaadin.flow.component.HasHelper;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.HasPlaceholder;
import com.vaadin.flow.component.HasValidation;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.react.ReactAdapterComponent;

@CssImport("./monthYear.css")
@JsModule("./monthYear.tsx")
@Tag("month-year")
public class InternalMonthYear extends ReactAdapterComponent implements HasLabel, HasHelper, HasValidation {
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
            changeListener.accept(YearMonth.of(getYear(), month));
        });
    }
    public void setRequiredIndicatorVisible(boolean requiredIndicatorVisible) {
        getElement().setProperty("required", requiredIndicatorVisible);
    }

    public boolean isRequiredIndicatorVisible() {
        return getElement().getProperty("required", false);
    }
    @Override
    public void setErrorMessage(String errorMessage) {
        getElement().setProperty("errorMessage", errorMessage);
    }

    @Override
    public String getErrorMessage() {
        return getElement().getProperty("errorMessage", "");
    }

    @Override
    public void setInvalid(boolean invalid) {
        getElement().setProperty("invalid", invalid);
    }

    @Override
    public boolean isInvalid() {
        return getElement().getProperty("invalid", false);
    }
}
