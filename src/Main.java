import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op; //opcion
        double monto;
        boolean estado = true;
        List<CuentaBancaria> lstBanco = new ArrayList<>(); //crear lista y luego instanciarla en una ArrayList
        //CuentaBancaria cl1 = new CuentaBancaria();
        do {
            System.out.println("""
                    1.Crear cliente.
                    2.mostrar todos los clientes.
                    3.mostrar info de cuenta.
                    4.depositar.
                    5.retirar.
                    6.Historial de transacciones por cuenta.
                    7.Salir.""");
            op = teclado.nextInt();
            switch (op) {
                case 1 -> { // crear cliente
                    System.out.println("ingrese titular");
                    String titular = teclado.next();
                    System.out.println("ingrese saldo cuenta ");
                    double saldo = teclado.nextDouble();
                    System.out.println("ingrese numero de cuenta");
                    String numcuenta = teclado.next();
                    lstBanco.add(new CuentaBancaria(titular, saldo, numcuenta)); // creo el objeto y  directamete lo guardo dentro de la lista sin  la necesidad de una variable pasajera.
                    //cl1 = new CuentaBancaria(cl1.getTitular(), cl1.getNumcuenta(), cl1.getNumcuenta()); // creaciojn  de una variable pasajera que solo contiene el address del objeto
                    // lstBanco.add(cl1);
                    //lstBanco.add(new CuentaBancaria.,CuentaBancaria.getSaldo(), CuentaBancaria.getNumcuenta());
                }
                case 2 -> { //mostrar todos los clientes
                    if (lstBanco.isEmpty()) { // cuando la lista no tiene ningun objeto
                        System.out.println(" no tiene clientes actualmente ");
                    } else {
                        for (CuentaBancaria cu : lstBanco) { // AQUI LLAMO LA LISTA DECLARANDO UNA VARIABLE DE TIPO LISTA USAR ESTE.
                            System.out.println(cu);
                        }
                    }
                }
                case 3 -> { //mostrar informacion de cuenta por medio del num de cuenta
                    System.out.println("ingrese su num de cuenta");
                    String nCuenta = teclado.next();
                    for (int i = 0; i < lstBanco.size(); i++) {
                        if (lstBanco.get(i).getNumcuenta().equalsIgnoreCase(nCuenta)) {
                            System.out.println("Bienvenid"+"  "+ lstBanco.get(i).getTitular()+"  "+"esta es tu información.");
                            System.out.println(lstBanco.get(i));
                        } else {
                            System.out.println("numero de cuenta incorrecto");
                        }
                    }
                }
                case 4 -> { //depositar
                    System.out.println("ingrese el numero de cuenta  ");
                    String nCuenta = teclado.next();
                    boolean find = false; // inicializo la variable el falso para que cambie su esado en la condicion de más adelante
                    for (int i = 0; i < lstBanco.size(); i++) {

                        if (lstBanco.get(i).getNumcuenta().equalsIgnoreCase(nCuenta)) {
                            find = true;// significa que si el ncuneta fue encontrado la variable find sera verdadera y seguira el codigo..
                            System.out.println("Bienvenido"+"  "+ lstBanco.get(i).getTitular());
                            do {
                                System.out.println("cuanto dinero desea depositar");
                                monto = teclado.nextDouble();
                                if (monto > 0) {

                                    lstBanco.get(i).depositarDinero(monto);
                                    System.out.println("tu saldo actual es de : $ " + lstBanco.get(i).getSaldo());
                                    lstBanco.get(i).registroHistorial("el deposito fue de : $ " + monto); // aqui gracias al metodo que creamos en la clase cuentabancaria entonces este registro se guarda automaticamente en la lista del historial.
                                    break; // esto es para que el bucle for no siga buscado las otras cuentas.
                                }
                            } while (monto <= 0);

                        }
                    }
                    if (!find) { // si find falsa porque no se encontro el n cuenta se arrojara este error
                        System.out.println("la cuenta no fue encontrada");

                    }
                }
                case 5 -> { // retirar
                    System.out.println("ingrese el numero de cuenta de la que desea retirar ");
                    String nCuenta = teclado.next();
                    boolean find = false;
                    for (int i = 0; i < lstBanco.size(); i++) {

                        if (lstBanco.get(i).getNumcuenta().equalsIgnoreCase(nCuenta)) {
                            find = true;
                            System.out.println("Bienvenido"+"  " +lstBanco.get(i).getTitular());

                            do {
                                System.out.println("cuanto dinero desea retirar");
                                monto = teclado.nextDouble();
                                if (monto > lstBanco.get(i).getSaldo()) { // una condicion que no permite retirar más dinero del que se tiene
                                    System.out.println("no es posible realizar esta trasacción porque su retiro excede su saldo actual.");
                                } else if (monto <= 0) {
                                    System.out.println(" su monto tiene que ser mayor que cero por favor digitar el monto correcto");
                                } else {
                                    lstBanco.get(i).retirarDinero(monto);
                                    System.out.println("tu saldo actual es de : $ " + lstBanco.get(i).getSaldo());
                                    lstBanco.get(i).registroHistorial(" el retiro fue de : $ " + monto);
                                    break;
                                }
                            } while (monto <= 0 || monto > lstBanco.get(i).getSaldo());
                            break;
                        }
                    }
                    if (!find) { // si no se encontro la cuenta despues de recorrer toda la lista.
                        System.out.println("la cuenta no fue encontrada ");


                    }
                }
                case 6 -> { //historial de transacciones de cada cliente
                    System.out.println("ingrese el numero de cuenta de la que desea retirar ");
                    String nCuenta = teclado.next();
                    for (int i = 0; i < lstBanco.size(); i++) {
                        if (lstBanco.get(i).getNumcuenta().equalsIgnoreCase(nCuenta)) {
                            System.out.println("Bienvenido"+"  "+lstBanco.get(i).getTitular()+"  "+"esta es la información de tus ultimas transacciones.");
                            System.out.println(lstBanco.get(i).getHistorial());
                        }
                    }
                }
                case 7 -> {
                    System.out.println("salir ");
                    estado = false;
                }
                default -> {
                    System.out.println(" esta opcion no sirve");
                }
            }
        } while (estado);
    }
}

/* CuentaBancaria cuenta = new CuentaBancaria(500, "francisco", "abc123");
        CuentaBancaria cuenta2 = new CuentaBancaria(500, "eduardo", "abc321");
        CuentaBancaria cuenta3 = new CuentaBancaria(500, "maia", "abc333");
        lstBanco.add(cuenta); // METODO add. agregar objeetos a la lista
        lstBanco.add(cuenta2);
        lstBanco.add(cuenta3);
        */
// lstBanco.remove(0); para remover OTRO MEOTOD PARA BORRAR ALGO DE LA LISTA





        /* PARA PONER TDO EN COMENATIO
        do {
            System.out.println("""
                    1. depositar."
                    2. reirar."
                    3. mostrar datos de la cuenta
                    4. mostrar clientes
                    5. salir""");
            op = teclado.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.println("depositar");
                    do {
                        System.out.println("cuanto dinero desea depositar");
                        monto = teclado.nextDouble();
                    }while(monto<=0);
                    cuenta.depositarDinero(monto);
                }
                case 2 -> {
                    System.out.println("retirar");
                    do {
                        System.out.println("cuanto dinero desea retirar");
                        monto = teclado.nextDouble();
                    }while(monto<0);
                    cuenta.retirarDinero(monto);
                }
                case 3 -> {
                    System.out.println("mostrar datos de cuenta ");
                    cuenta.mostrarInformacion();
                }
                case 4 ->{
                    System.out.println("mostrar datos de la cuenta de la lista");
                   // System.out.println(lstBanco.toString()); // AQUI LA LLAMO PERO APARECE DIFENRETE Y NOD ECLARO VARIABLE
                    for(CuentaBancaria cu : lstBanco){ // AQUI LLAMO LA LISTA DECLARANDO UNA VARIABLE DE TIPO LISTA USAR ESTE.
                        System.out.println(cu);
                    }
                }
                case 5 ->  {
                    System.out.println("salir ");
                    estado  = false;
                }
                default -> {
                    System.out.println("no existe esta opción ");
                }
            }
        } while (estado);

         */