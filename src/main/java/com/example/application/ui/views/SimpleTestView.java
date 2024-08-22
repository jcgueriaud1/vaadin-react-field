package com.example.application.ui.views;

import java.time.YearMonth;

import com.example.application.ui.react.SimpleTestField;
import com.example.application.ui.react.prototype.ReactMonthYearField;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Simple Test View")
@Route(value = "simple-test-view")
@Menu(title = "React simple-test")
public class SimpleTestView extends VerticalLayout {

    private SimpleTestField simpleTestField = new SimpleTestField();

    private Span span = new Span();

    public SimpleTestView() {
        add(simpleTestField);
        add(new Button("Reset value", e-> {
            simpleTestField.setValue("Reset value");
        }));
        simpleTestField.addValueChangeListener(e -> span.setText(e.getValue()));
        simpleTestField.addLabelChangedListener(e -> Notification.show("Label changed Event" + e.getLabel()));
        simpleTestField.addButtonClickListener(e -> {
            Notification.show("Button clicked");
        });

        add(new Button("Set Label", e-> {
            simpleTestField.setLabel("New Label");
        }));
        add(span);
    }

}
