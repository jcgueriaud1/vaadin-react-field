// @ts-ignore
import MonthYearPicker from "react-month-year-picker";
import { CustomField } from '@vaadin/react-components/CustomField.js';
import {ReactElement} from "react";
import { ReactAdapterElement, RenderHooks } from "./generated/flow/ReactAdapter";

function valueToYear(value: string): number | null {
    if (value && value.length) {
        const parts = value.split('-');
        return parseInt(parts[0], 10);
    }
    return null;
}
function valueToMonth(value: string): number | null {
    if (value && value.length) {
        const parts = value.split('-');
        return parseInt(parts[1], 10);
    }
    return null;
}

function yearMonthToValue( year:number | null, month:number | null): string {
    return `${year}-${`0${month}`.substr(-2)}`;
}


class MonthYear extends ReactAdapterElement {

    protected render(hooks: RenderHooks): ReactElement {
        const [svalue, setValue] = hooks.useState<string>("value");
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
                     selectedMonth={valueToMonth(svalue)}
                     selectedYear={valueToYear(svalue)}
                     minYear={2000}
                     maxYear={2030}
                     onChangeYear={(year:number) => this.updateYear(year, svalue, setValue)}
                     onChangeMonth={(month:number) => this.updateMonth(month, svalue, setValue)}
                 />
        </CustomField>
        </div>
    }

    private updateYear(year: number, svalue: string, setValue: (value: string) => void) {
        setValue(yearMonthToValue(year, valueToMonth(svalue)));
    }

    private updateMonth(month: number, svalue: string, setValue: (value: string) => void) {
        setValue(yearMonthToValue(valueToYear(svalue), month));
    }
}


customElements.define("react-month-year", MonthYear);