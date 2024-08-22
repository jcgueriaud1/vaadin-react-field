package com.example.application.ui.plain;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.function.SerializableConsumer;
import com.vaadin.flow.internal.JsonUtils;
import com.vaadin.flow.shared.Registration;

@JsModule("./simplePlainComponent.js")
public class SimplePlainComponent extends Div {


    public SimplePlainComponent() {
        initConnector(new SimplePlainConfig());
    }

    private void initConnector(SimplePlainConfig config) {
        runBeforeClientResponse(ui -> ui.getPage().executeJs(
                "window.Vaadin.Flow.simplePlainConnector.initLazy($0, $1)", JsonUtils.writeValue(config),
                getElement()));
    }

    private void runBeforeClientResponse(SerializableConsumer<UI> command) {
        getElement().getNode().runWhenAttached(ui -> ui
                .beforeClientResponse(this, context -> command.accept(ui)));
    }

    public void setConfig(SimplePlainConfig config) {
        runBeforeClientResponse(ui -> getElement()
                .callJsFunction("$connector.setConfig", JsonUtils.writeValue(config)));
    }

    @ClientCallable
    public void clientCallableAction(String name) {
        Notification.show("Hello " + name);
    }

    public Registration addConfigurationUpdatedListener(ComponentEventListener<ConfigurationUpdateEvent> listener) {
        return addListener(ConfigurationUpdateEvent.class, listener);
    }

    @DomEvent("configuration-updated")
    public static class ConfigurationUpdateEvent extends ComponentEvent<SimplePlainComponent> {

        private final String config;

        public ConfigurationUpdateEvent(SimplePlainComponent source,
                                        boolean fromClient,
                                        @EventData("event.detail.value") String config) {
            super(source, fromClient);
            this.config = config;
        }

        public String getConfig() {
            return config;
        }
    }

    public static class SimplePlainConfig {
        private String config1 = "configValue1";
        private String config2 = "configValue2";

        public SimplePlainConfig() {
        }

        public SimplePlainConfig(String config1, String config2) {
            this.config1 = config1;
            this.config2 = config2;
        }

        public String getConfig1() {
            return config1;
        }

        public void setConfig1(String config1) {
            this.config1 = config1;
        }

        public String getConfig2() {
            return config2;
        }

        public void setConfig2(String config2) {
            this.config2 = config2;
        }
    }
}
