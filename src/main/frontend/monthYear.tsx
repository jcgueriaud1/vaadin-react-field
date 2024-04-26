// @ts-ignore
import MonthYearPicker from "react-month-year-picker";
import { CustomField } from '@vaadin/react-components/CustomField.js';
import {ReactElement, useState} from "react";
import { ReactAdapterElement, RenderHooks } from "./generated/flow/ReactAdapter";

class MonthYear extends ReactAdapterElement {

    protected render(hooks: RenderHooks): ReactElement {
        const [smonth, setMonth] = hooks.useState<number>("month");
        const [syear, setYear] = hooks.useState<number>("year");
        const [slabel] = hooks.useState<string>("label", "");
        const [shelperText] = hooks.useState<string>("helperText", "");
        const [serrorMessage] = hooks.useState<string>("errorMessage", "");
        const [srequired] = hooks.useState<boolean>("required", false);
        const [sinvalid] = hooks.useState<boolean>("invalid", false);
        return <div className="month-year-custom">
             <CustomField
            label={slabel}
            helperText={shelperText}
            required={srequired}
            invalid={sinvalid}
            errorMessage={serrorMessage}
        >
                 <MonthYearPicker
                     selectedMonth={smonth}
                     selectedYear={syear}
                     minYear={2000}
                     maxYear={2030}
                     onChangeYear={(year:number) => setYear(year)}
                     onChangeMonth={(month:number) => setMonth(month)}
                 />
        </CustomField>
        </div>
    }
}


customElements.define("month-year", MonthYear);