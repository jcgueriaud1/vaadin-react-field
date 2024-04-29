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
