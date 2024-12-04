package loan_server_cal.rest_server;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin(origins = "http://localhost:5500") // para cliente iniciado con live server puerto 5500
@RequestMapping("/api")
public class controladorCalculadoraPrestamo {

    @Autowired
    private servicioCalculoPrestamo servicioCalculoPrestamo;

    @PostMapping("/calcular")
    public calculoPrestamoResponse calculateLoan(@RequestBody calculoPrestamoRequest request) {
        return servicioCalculoPrestamo.calculateLoan(request);
    }
}


