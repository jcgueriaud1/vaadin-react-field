package com.example.application.ui.react.prototype;

import java.time.YearMonth;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.HasHelper;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.HasValidation;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;

@CssImport("./monthYear.css")
@JsModule("./monthYear.tsx")
@Tag("react-month-year")
public class ReactMonthYearField
        extends AbstractSinglePropertyField<ReactMonthYearField, YearMonth>
        implements HasLabel, HasHelper, HasValidation, IReactAdapterComponent {

    public ReactMonthYearField() {
        super("value", null, String.class,
                (String p) -> YearMonth.parse(p),
                (YearMonth ym) -> ym.toString());
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
