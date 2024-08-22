import { CustomField } from '@vaadin/react-components/CustomField.js';
import {ReactElement} from "react";
import { ReactAdapterElement, RenderHooks } from "./generated/flow/ReactAdapter";

class SimpleTest extends ReactAdapterElement {

    protected render(hooks: RenderHooks): ReactElement {
        const [svalue, setValue] = hooks.useState<string>("value");
        const [slabel, setLabel] = hooks.useState<string>("label", "");
        const [shelperText] = hooks.useState<string>("helperText", "");
        const [serrorMessage] = hooks.useState<string>("errorMessage", "");
        const [srequired] = hooks.useState<boolean>("required", false);
        const [sinvalid] = hooks.useState<boolean>("invalid", false);
    const serverButton = hooks.useContent('button');
        return <div className="month-year-custom">
            <CustomField
                label={slabel}
                helperText={shelperText}
                required={srequired}
                invalid={sinvalid}
                errorMessage={serrorMessage}
            >
                <input value={svalue} onChange={e => {
                    setValue(e.target.value);
                }}/>
                <button onClick={e => {
                    setValue("Client side change");
                }}>
                    Reset Value
                </button>
                {serverButton}
                <button onClick={e => {
                    (this as any).$server.clientCallableAction("test")
                }}>
                    Call server side
                </button>
                <button onClick={e => {
                    this.dispatchEvent(new CustomEvent('button-clicked', {
                        detail: {kicked: true},
                        cancelable: true
                    }));

                }}>
                    Send event
                </button>
                <button onClick={e => {
                    setLabel("Client side label");
                }}>
                    label
                </button>
            </CustomField>
        </div>
    }

}


customElements.define("simple-test", SimpleTest);