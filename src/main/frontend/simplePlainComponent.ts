interface SimpleConfig {
    config1: string;
    config2: string;
}
interface ServerComponent {
    clientCallableAction: (config1:string) => void;
}
interface FlowComponent {
    $connector: {
        setConfig : (config: SimpleConfig)  => void;
    };
    $server: ServerComponent;
}

(window.Vaadin as any).Flow.simplePlainConnector = {
    // attach the connector to the element "c"
    initLazy: function (customConfig: SimpleConfig, c: FlowComponent & HTMLElement) {
        // Check whether the connector was already initialized
        if (c.$connector) {
            return;
        }

        c.$connector = {
            //// functions to communicate from server to client
            setConfig : function(config: SimpleConfig) {
                console.error(`Configuration updated ${config.config1} ${config.config2}`);
                // Communication from client to server
                // use direct function
                c.$server.clientCallableAction(config.config1);
                // send an event
                c.dispatchEvent(new CustomEvent('configuration-updated', {
                    detail: {value: config.config2},
                    cancelable: true
                }));
            },
        };

        console.error(`Configuration created ${customConfig}`);
        // initialize the component if needed
    }
}