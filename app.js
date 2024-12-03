const express = require('express');
const cors = require('cors');

class CalculoPrestamo {
    constructor(importePrestamo, interestRate, term) {
        this.importePrestamo = importePrestamo;
        this.interestRate = interestRate / 100 / 12; // Calculo interes mensual
        this.term = term * 12; // Años a meses
    }

    calculoPagoMensual() {
        const interesMensual = this.interestRate;
        const cantidadPagos = this.term;
        const presentValue = this.importePrestamo;

        const pagoMesual = (presentValue * interesMensual) / (1 - Math.pow(1 + interesMensual, - cantidadPagos));
        return pagoMesual;
    }
}

const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());

app.post('/calcular', (req, res) => {
    const { importePrestamo, interestRate, term } = req.body;
    const calculator = new CalculoPrestamo(importePrestamo, interestRate, term);
    const pagoMesual = calculator.calculoPagoMensual();
    res.json({ pagoMesual });
});

app.listen(port, () => {
    console.log(`Servidor escuchando en POT: ${port}`);
});