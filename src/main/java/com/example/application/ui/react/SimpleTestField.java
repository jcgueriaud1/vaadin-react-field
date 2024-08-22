package com.example.application.ui.react;

import com.example.application.ui.react.prototype.IReactAdapterComponent;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.HasHelper;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.HasValidation;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@JsModule("./SimpleTest.tsx")
@Tag("simple-test")
public class SimpleTestField
        extends AbstractSinglePropertyField<SimpleTestField, String>
        implements HasLabel, HasHelper, HasValidation, IReactAdapterComponent {

    private Button serverButton = new Button("Server", e-> Notification.show("Server called"));

    public SimpleTestField() {
        super("value", null, true);
        getContentElement("button").appendChild(serverButton.getElement());

        addStateChangeListener("value", String.class, val -> {
            Notification.show("Value changed: " + val);
        });
        addStateChangeListener("label", String.class, val -> {
            Notification.show("Label changed: " + val);
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

    @ClientCallable
    public void clientCallableAction(String name) {
        Notification.show("Hello " + name);
    }


    public Registration addButtonClickListener(ComponentEventListener<MyButtonClickEvent> listener) {
        return addListener(MyButtonClickEvent.class, listener);
    }

    @DomEvent("button-clicked")
    public static class MyButtonClickEvent extends ComponentEvent<SimpleTestField> {

        private final boolean kicked;

        public MyButtonClickEvent(SimpleTestField source,
                                  boolean fromClient,
                @EventData("event.detail.kicked") boolean kicked) {
            super(source, fromClient);
            this.kicked = kicked;
        }

        public boolean isKicked() {
            return kicked;
        }
    }
    public Registration addLabelChangedListener(ComponentEventListener<LabelChangeEvent> listener) {
        return addListener(LabelChangeEvent.class, listener);
    }

    @DomEvent("label-changed")
    public static class LabelChangeEvent extends ComponentEvent<SimpleTestField> {

        private final String label;

        public LabelChangeEvent(SimpleTestField source,
                                  boolean fromClient,
                                  @EventData("event.detail.value") String label) {
            super(source, fromClient);
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}
