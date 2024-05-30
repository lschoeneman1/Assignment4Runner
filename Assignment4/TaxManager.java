package Assignment4;

public class TaxManager
{
    private final double ficaRate = 0.0765;
    private final double illinoisRate = 0.05;
    private final double wisconsinRate = 0.03;
    private final double indianaRate = 0.04;
    private final double defaultStateRate = 0.04;

    private final double taxRate1 = .10;
    private final double taxRate2 = .15;
    private final double taxRate3 = .20;
    private final double taxRate4 = .25;

    public	TaxPayment ComputeTaxPayment(String state, double grossPay)
    {
        double federalTax = computeFederalTax(grossPay);
        return new TaxPayment(federalTax, computeStateTax(state, grossPay, federalTax), computeFica(grossPay));
    }

    private double computeFederalTax(double grossPay)
    {
/*        a.	$0 – $10,000 ANNUALIZED salary based on gross  - 10% Tax Rate
        b.	$10,001 - $25,000 – ANNUALIZED salary based on gross – 15% Tax Rate
        c.	$25,000 - $50,000 ANNUALIZED salary based on gross -  20% Tax Rate
        d.	$50,000 and up ANNUALIZED salary based on gross – 25% Tax Rate
        Example: Employee Makes $1,442.31 PER WEEK
        Annual Salary: $74,948.12
        Tax Computation:
        10% - 10,000 = $1000
        15% - ($15000 * .15) = $2250
        20% - ($25000*.20) = $5000
        25% = ($74,948.12 - $50,000)*.25 = $6237.03
        Federal Tax: $14,487.03*/

        double annualizedSalary = grossPay * 52.0;

        if (annualizedSalary > 50000.00) {
            return ((annualizedSalary - 50000) * taxRate4 + 25000 * taxRate3 + 15000 * taxRate2 + 10000 * taxRate1)/52;
        }

        if (annualizedSalary > 25000)
        {
            return ((annualizedSalary - 25000) * taxRate3 + 15000 * taxRate2 + 10000 * taxRate1)/52;
        }

        if (annualizedSalary > 10000)
        {
            return ((annualizedSalary - 10000)  * taxRate2 + 10000 * taxRate1)/52;
        }
        return (annualizedSalary*taxRate1)/52;

    }

    private double computeStateTax(String state, double grossPay, double federalTax)
    {        
        if (state.equalsIgnoreCase("IL"))
        {
            return grossPay*illinoisRate;
        }
        else if (state.equalsIgnoreCase("WI"))
        {
            return grossPay*wisconsinRate;
        }
        else if (state.equalsIgnoreCase("IN"))
        {
            return (grossPay-federalTax)*indianaRate;

        }
        return grossPay*defaultStateRate;
    }

    private double computeFica(double grossPay)
    {
        return grossPay*ficaRate;
    }
}