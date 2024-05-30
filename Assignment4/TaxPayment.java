package Assignment4;

public class TaxPayment
{
    private double federalRate = .15;
    private double stateRate = .05;
    private double ficaRate = .03;

    private double federalTax;
    private double stateTax;
    private double ficaTax;

    public TaxPayment()
    {
        this(0,0,0);
    }

    public TaxPayment(double federalTax, double stateTax, double ficaTax)
    {
        this.federalTax = federalTax;
        this.stateTax = stateTax;
        this.ficaTax = ficaTax;
    }

    public double getFederalTax()
    {
        return federalTax;
    }

    public void setFederalTax(double federalTax)
    {
        this.federalTax = federalTax;
    }

    public double getStateTax()
    {
        return stateTax;
    }

    public void setStateTax(double stateTax)
    {
        this.stateTax = stateTax;
    }

    public double getFicaTax()
    {
        return ficaTax;
    }

    public void setFicaTax(double ficaTax)
    {
        this.ficaTax = ficaTax;
    }
}
