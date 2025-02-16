package thomasdev.demoapi.services;

public class StockData {

    private String company;
    private double value;

    // Constructor, getters, setters
    public StockData(String company, double value) {
        this.company = company;
        this.value = value;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

