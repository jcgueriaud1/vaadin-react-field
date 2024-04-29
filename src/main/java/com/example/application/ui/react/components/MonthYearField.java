package com.example.application.ui.react.components;

import java.time.YearMonth;

import com.vaadin.flow.component.AbstractCompositeField;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasHelper;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.HasValidation;

public class MonthYearField
        extends AbstractCompositeField<InternalMonthYear, MonthYearField, YearMonth> implements HasLabel, HasHelper, HasValidation {

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
        internalMonthYear.addValueChangeListener(yearMonth -> setModelValue(yearMonth, true));
        return internalMonthYear;
    }

    @Override
    protected void setPresentationValue(YearMonth newPresentationValue) {
        System.out.println("START setPresentationValue");
        if (newPresentationValue != null) {
            System.out.println("setPresentationValue");
            getContent().setValue(newPresentationValue.toString());
/*            getContent().setMonth(newPresentationValue.getMonthValue());
            getContent().setYear(newPresentationValue.getYear());*/
        }
    }

    @Override
    protected boolean valueEquals(YearMonth value1, YearMonth value2) {
        return super.valueEquals(value1, value2);
    }

    @Override
    public void setLabel(String label) {
        getContent().setLabel(label);
    }

    @Override
    public String getLabel() {
        return getContent().getLabel();
    }

    @Override
    public void setHelperComponent(Component component) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setHelperText(String helperText) {
        getContent().setHelperText(helperText);
    }

    @Override
    public String getHelperText() {
        return getContent().getHelperText();
    }

    @Override
    public void setErrorMessage(String errorMessage) {
        getContent().setErrorMessage(errorMessage);
    }

    @Override
    public String getErrorMessage() {
        return getContent().getErrorMessage();
    }

    @Override
    public void setInvalid(boolean invalid) {
        getContent().setInvalid(invalid);
    }

    @Override
    public boolean isInvalid() {
        return getContent().isInvalid();
    }

    @Override
    public void setRequiredIndicatorVisible(boolean requiredIndicatorVisible) {
        getContent().setRequiredIndicatorVisible(requiredIndicatorVisible);
    }
}
