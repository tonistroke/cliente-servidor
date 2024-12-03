@RestController
@RequestMapping("/api")
public class controladorCalculadoraPrestamo {

    @Autowired
    private servicioCalculoPrestamo servicioCalculoPrestamo;

    @PostMapping("/calcular")
    public calculoPrestamoResponse calculateLoan(@RequestBody calculoPrestamoRequest request) {
        return servicioCalculoPrestamo.calculateLoan(request);
    }
}

@Service
public class servicioCalculoPrestamo {
    public calculoPrestamoResponse calculateLoan(calculoPrestamoRequest request) {
        double interesMensual = request.getInteres() / 12 / 100;
        int numeroDePagos = request.getPlazos() * 12;
        double pagoMensual = request.getImportePrestamo() * interesMensual / (1 - Math.pow(1 + interesMensual, - numeroDePagos));

        calculoPrestamoResponse response = new calculoPrestamoResponse();
        response.setPagoMensual(pagoMensual);
        return response;
    }
}

public class calculoPrestamoRequest {
    private double importePrestamo;
    private double interes;
    private int plazos;
}


public class calculoPrestamoRequest {
    private double importePrestamo;
    private double interes;
    private int plazos;

    public double getImportePrestamo() {
        return importePrestamo;
    }

    public void setImportePrestamo(double importePrestamo) {
        this.importePrestamo = importePrestamo;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getPlazos() {
        return plazos;
    }

    public void setPlazos(int plazos) {
        this.plazos = plazos;
    }
}

public class calculoPrestamoResponse {
    private double pagoMensual;

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }
}