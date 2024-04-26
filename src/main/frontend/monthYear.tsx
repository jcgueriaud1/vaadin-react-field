// @ts-ignore
import MonthYearPicker from "react-month-year-picker";
import {ReactElement, useState} from "react";
import { ReactAdapterElement, RenderHooks } from "./generated/flow/ReactAdapter";

class MonthYear extends ReactAdapterElement {

    protected render(hooks: RenderHooks): ReactElement {
        const [smonth, setMonth] = hooks.useState("month");
        const [syear, setYear] = hooks.useState("year");
        return <div className="App">
            <MonthYearPicker
                selectedMonth={smonth}
                selectedYear={syear}
                minYear={2000}
                maxYear={2030}
                onChangeYear={(year:number) => setYear(year)}
                onChangeMonth={(month:number) => setMonth(month)}
            />
        </div>
    }
}


customElements.define("month-year", MonthYear);