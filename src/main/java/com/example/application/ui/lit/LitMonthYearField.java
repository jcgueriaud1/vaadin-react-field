package com.example.application.ui.lit;

import java.time.YearMonth;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.HasHelper;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.HasValidation;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@JsModule("./month-year/vcf-month-picker.ts")
@Tag("vcf-month-picker")
public class LitMonthYearField
        extends AbstractSinglePropertyField<LitMonthYearField, YearMonth> implements HasLabel, HasHelper, HasValidation {

    public LitMonthYearField() {
        super("value", null, String.class,
                (String p) -> {
            try {
                return YearMonth.parse(p);
            } catch (Exception e) {
                return null;
            }
                },
                (YearMonth ym) -> {
                    if (ym != null) {
                        return ym.toString();
                    } else {
                        return "";
                    }
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
        if (!invalid) {
            getElement().setProperty("errorMessage", "");
        }
    }

    @Override
    public boolean isInvalid() {
        return getElement().getProperty("invalid", false);
    }
}
