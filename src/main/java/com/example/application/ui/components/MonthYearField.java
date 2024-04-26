package com.example.application.ui.components;

import java.time.YearMonth;

import com.vaadin.flow.component.AbstractCompositeField;

public class MonthYearField
        extends AbstractCompositeField<InternalMonthYear, MonthYearField, YearMonth> {

    public MonthYearField() {
        this(YearMonth.now());
    }
    /**
     * Creates a new field. The provided default value is used by
     * {@link #getEmptyValue()} and is also used as the initial value of this
     * instance.
     *
     * @param defaultValue the default value
     */
    public MonthYearField(YearMonth defaultValue) {
        super(defaultValue);
    }

    @Override
    protected InternalMonthYear initContent() {
        InternalMonthYear internalMonthYear = new InternalMonthYear();
        internalMonthYear.addYearMonthChangeListener(yearMonth -> setModelValue(yearMonth, true));
        return internalMonthYear;
    }

    @Override
    protected void setPresentationValue(YearMonth newPresentationValue) {
        System.out.println("START setPresentationValue");
        if (newPresentationValue != null) {
            System.out.println("setPresentationValue");
            getContent().setMonth(newPresentationValue.getMonthValue());
            getContent().setYear(newPresentationValue.getYear());
        }
    }

    @Override
    protected boolean valueEquals(YearMonth value1, YearMonth value2) {
        System.out.println("valueEquals");
        return super.valueEquals(value1, value2);
    }
}
