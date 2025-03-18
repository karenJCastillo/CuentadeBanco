import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private String titular;
    private double saldo;
    private String numcuenta;
    private List<String> historial = new ArrayList<>(); // creo e innicializo una lista para ver el historial

    public CuentaBancaria() {

    }

    public CuentaBancaria(String titular, double saldo, String numcuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numcuenta = numcuenta;
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumcuenta() {
        return numcuenta;
    }

    public void setNumcuenta(String numcuenta) {
        this.numcuenta = numcuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public List<String> getHistorial() { // para  poder visualizar la lista enb el main utilizo el metodo getter
        return historial;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", numcuenta='" + numcuenta + '\'' +
                '}';
    }

    public void depositarDinero(double monto) {
        saldo += monto;
    }

    public void retirarDinero(double monto) {
        saldo -= monto;
    }

    public void registroHistorial(String registro) { // un metodo para poder registrar las transacciones
        if (registro != null && !registro.isEmpty()) { // condicion que no permite almacenar algo vacio
            historial.add(registro);
        } else {
            System.out.println(" el registro es invalido");

        }
    }

    public void mostrarInformacion() {
        System.out.println("el nombre del titular es " + this.titular);
        System.out.println("el saldo de la cuenta es" + this.saldo);
        System.out.println("el numeor de cuenta es " + this.numcuenta); //identiifcar que es atributo de clase
    }

}
