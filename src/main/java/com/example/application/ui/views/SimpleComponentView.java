package com.example.application.ui.views;

import com.example.application.ui.plain.SimplePlainComponent;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Simple Test View")
@Route(value = "simple-component-view")
@Menu(title = "Simple-component")
public class SimpleComponentView extends VerticalLayout {

    private SimplePlainComponent simplePlainComponent = new SimplePlainComponent();

    public SimpleComponentView() {
        add(simplePlainComponent);
        add(new Button("Update config", e-> {
            simplePlainComponent.setConfig(new SimplePlainComponent.SimplePlainConfig("test config 1", "test config 2"));
        }));
        simplePlainComponent.addConfigurationUpdatedListener(e -> {
            Notification.show("Button clicked " + e.getConfig());
        });
    }

}
