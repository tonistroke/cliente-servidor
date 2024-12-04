package loan_server_cal.rest_server;

import org.springframework.stereotype.Service;


@Service
public class servicioCalculoPrestamo {
    public calculoPrestamoResponse calculateLoan(calculoPrestamoRequest request) {
        double interesMensual = request.getInteres() / 12 / 100;
        int numeroDePagos = request.getPlazos() * 12;
        System.out.println("interesMensual is: ");
        System.out.println(interesMensual);

        System.out.println("numeroDePagos is: ");
        System.out.println(numeroDePagos);


        double denominador = 1 - Math.pow(1 + interesMensual, -numeroDePagos);
        //if (denominador == 0) {
        //    throw new IllegalArgumentException("Calculo invalido, denominador es igual a 0.");
        //}
        // Calculo pago mensual
        System.out.println("Denominator is: ");
        System.out.println(denominador);
        double pagoMensual = (request.getImportePrestamo() * interesMensual) / denominador;
        

        calculoPrestamoResponse response = new calculoPrestamoResponse();
        response.setPagoMensual(pagoMensual);
        return response;
    }
}
