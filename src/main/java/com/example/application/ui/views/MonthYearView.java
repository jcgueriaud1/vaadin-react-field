package com.example.application.ui.views;

import java.time.YearMonth;

import com.example.application.ui.components.MonthYearField;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Month Year")
@Route(value = "month-year")
@Menu(title = "React integration")
public class MonthYearView extends VerticalLayout {

    private MonthYearField startMonthYear = new MonthYearField();
    private MonthYearField endMonthYear = new MonthYearField();

    private Binder<DataBean> binder = new Binder<>(DataBean.class);

    private Span span = new Span();

    public MonthYearView() {
        binder.forField(startMonthYear)
                .asRequired("Start Month Year is required")
                .withValidator(d -> {
                    return d.getYear() == 2024;
                }, "2024 is the only valid year").bind("startMonthYear");
        binder.forField(endMonthYear).bind("endMonthYear");
        binder.setBean(new DataBean());
        add(new HorizontalLayout(startMonthYear, endMonthYear), span);
        startMonthYear.setLabel("Start Date");
        startMonthYear.setHelperText("Helper text");
        endMonthYear.setLabel("End Date");
        startMonthYear.addValueChangeListener(e -> {
            if (e.isFromClient()) {
                Notification.show("Value updated from the client " + e.getValue().toString());
            } else {
                Notification.show("Value updated from the server " + e.getValue().toString());
            }
        });
        add(new HorizontalLayout(new Button("Commit changes", e -> {
            DataBean bean = new DataBean();
            if (binder.writeBeanIfValid(bean)) {
                span.setText("Start date: " + bean.getStartMonthYear() + " - End date: " + bean.getEndMonthYear());
            } else {
                span.setText("Invalid");
            }
        }), new Button("Update start year to 2020", e -> { startMonthYear.setValue(YearMonth.of(2020, startMonthYear.getValue().getMonthValue()));
        })));
    }

}
