package view;

import model.Cliente;
import model.Cuenta;
import service.BankService;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private BankService service = new BankService();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== BANCO - MENU PRINCIPAL ===");
            System.out.println("1) Ingresar como Administrador");
            System.out.println("2) Ingresar como Cliente");
            System.out.println("3) Registrar Cliente");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String opt = sc.nextLine().trim();
            try {
                switch (opt) {
                    case "1": loginAdmin(); break;
                    case "2": loginCliente(); break;
                    case "3": registrarCliente(); break;
                    case "0": running = false; break;
                    default: System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Saliendo...");
    }

    private void loginAdmin() throws Exception {
        System.out.print("Email admin: ");
        String email = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();
        if (service.validarAdmin(email, pass)) {
            menuAdmin();
        } else {
            System.out.println("Credenciales inválidas");
        }
    }

    private void menuAdmin() throws Exception {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Menu Administrador ---");
            System.out.println("1) Listar clientes");
            System.out.println("2) Listar todas las cuentas");
            System.out.println("0) Volver");
            System.out.print("Opción: ");
            String op = sc.nextLine();
            switch (op) {
                case "1":
                    List<Cliente> clientes = service.listarClientes();
                    clientes.forEach(System.out::println);
                    break;
                case "2":
                    List<Cuenta> cuentas = service.cuentasDeCliente(0); // stub no lista global
                    // Mejor usar service.buscarCuenta o DAO directo — para simplicidad listamos por clientes
                    for (Cliente c : service.listarClientes()) {
                        System.out.println("Cuentas de " + c.getNombreCompleto());
                        List<Cuenta> ctas = service.cuentasDeCliente(c.getId());
                        ctas.forEach(System.out::println);
                    }
                    break;
                case "0": back = true; break;
                default: System.out.println("Opción inválida");
            }
        }
    }

    private void loginCliente() throws Exception {
        System.out.print("Email cliente: ");
        String email = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();
        Cliente c = service.loginCliente(email, pass);
        if (c != null) {
            menuCliente(c);
        } else {
            System.out.println("Credenciales inválidas");
        }
    }

    private void menuCliente(Cliente cliente) throws Exception {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menu Cliente (" + cliente.getNombreCompleto() + ") ---");
            System.out.println("1) Ver cuentas");
            System.out.println("2) Crear cuenta");
            System.out.println("3) Depositar");
            System.out.println("4) Retirar / Usar crédito");
            System.out.println("5) Abonar crédito");
            System.out.println("6) Generar intereses (si aplica)");
            System.out.println("0) Cerrar sesión");
            System.out.print("Opción: ");
            String op = sc.nextLine();
            switch (op) {
                case "1":
                    List<Cuenta> cuentas = service.cuentasDeCliente(cliente.getId());
                    cuentas.forEach(System.out::println);
                    break;
                case "2":
                    crearCuentaCliente(cliente);
                    break;
                case "3":
                    System.out.print("Número cuenta: "); String nc = sc.nextLine();
                    System.out.print("Monto depositar: "); double mdep = Double.parseDouble(sc.nextLine());
                    service.depositar(nc, mdep);
                    System.out.println("Depositado.");
                    break;
                case "4":
                    System.out.print("Número cuenta: "); String nr = sc.nextLine();
                    System.out.print("Monto retirar: "); double mret = Double.parseDouble(sc.nextLine());
                    service.retirar(nr, mret);
                    System.out.println("Retiro procesado.");
                    break;
                case "5":
                    System.out.print("Número cuenta crédito: "); String ncab = sc.nextLine();
                    System.out.print("Monto abonar: "); double mab = Double.parseDouble(sc.nextLine());
                    service.abonarCredito(ncab, mab);
                    System.out.println("Abono procesado.");
                    break;
                case "6":
                    System.out.print("Número cuenta: "); String ni = sc.nextLine();
                    service.generarIntereses(ni);
                    System.out.println("Intereses aplicados si correspondía.");
                    break;
                case "0": salir = true; break;
                default: System.out.println("Opción inválida");
            }
        }
    }

    private void crearCuentaCliente(Cliente cliente) throws Exception {
        System.out.println("Tipo de cuenta (AHORRO / DEBITO / CREDITO): ");
        String tipo = sc.nextLine().toUpperCase().trim();
        System.out.print("Número de cuenta: ");
        String numero = sc.nextLine();
        double saldoInicial = 0.0;
        Double porcentaje = null;
        Double limite = null;
        String tipoCredito = null;

        switch (tipo) {
            case "AHORRO":
                System.out.print("Saldo inicial (>=100): ");
                saldoInicial = Double.parseDouble(sc.nextLine());
                System.out.print("Porcentaje interés (ej. 0.02): ");
                porcentaje = Double.parseDouble(sc.nextLine());
                break;
            case "DEBITO":
                System.out.print("Saldo inicial (>=0): ");
                saldoInicial = Double.parseDouble(sc.nextLine());
                System.out.print("Porcentaje interés (ej. 0.01): ");
                porcentaje = Double.parseDouble(sc.nextLine());
                break;
            case "CREDITO":
                System.out.print("Límite de crédito (ej. 2000): ");
                limite = Double.parseDouble(sc.nextLine());
                System.out.print("Tipo crédito (ej. Cashback): ");
                tipoCredito = sc.nextLine();
                saldoInicial = 0.0;
                break;
            default:
                System.out.println("Tipo inválido");
                return;
        }

        Cuenta c = new Cuenta(0, numero, tipo, saldoInicial, true, cliente.getId(), porcentaje, limite, tipoCredito);
        service.crearCuenta(c);
        System.out.println("Cuenta creada con éxito.");
    }

    private void registrarCliente() throws Exception {
        System.out.println("Registrar cliente:");
        System.out.print("Nombre completo: "); String nombre = sc.nextLine();
        System.out.print("Cédula: "); String cedula = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Contraseña: "); String pass = sc.nextLine();
        System.out.print("Sexo: "); String sexo = sc.nextLine();
        System.out.print("Profesión: "); String prof = sc.nextLine();
        System.out.print("Dirección: "); String dir = sc.nextLine();

        Cliente c = new Cliente(0, nombre, cedula, email, pass, sexo, prof, dir);
        service.registrarCliente(c);
        System.out.println("Cliente registrado. ID: " + c.getId());
    }
}
