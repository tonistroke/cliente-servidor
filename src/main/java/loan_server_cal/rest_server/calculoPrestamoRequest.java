package loan_server_cal.rest_server;

import com.fasterxml.jackson.annotation.JsonProperty;

public class calculoPrestamoRequest {
    @JsonProperty("importePrestamo")
    private double importePrestamo;
    
    @JsonProperty("interestRate")
    private double interestRate;

    @JsonProperty("plazos")
    private int plazos;

    public double getImportePrestamo() {
        return importePrestamo;
    }

    public void setImportePrestamo(double importePrestamo) {
        this.importePrestamo = importePrestamo;
    }

    public double getInteres() {
        return interestRate;
    }

    public void setInteres(double interes) {
        this.interestRate = interes;
    }

    public int getPlazos() {
        return plazos;
    }

    public void setPlazos(int plazos) {
        this.plazos = plazos;
    }
}