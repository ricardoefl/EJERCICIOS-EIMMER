package ejercicioseimmerarmijos;
//Eimmer y Pablo
import java.util.Scanner;
public class Problema3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        final int MAX_PRODUCTOS = 100;
        final int NUM_ATRIBUTOS = 3;  // Nombre, Precio, Cantidad
        String[][] inventario = new String[MAX_PRODUCTOS][NUM_ATRIBUTOS];

        // Número actual de productos en el inventario
        int numProductos = 0;

        // Inicializar factura
        String[][] factura = new String[MAX_PRODUCTOS][4];  // Código, Nombre, Precio, Cantidad
        int numItemsFactura = 0;
        double totalFactura = 0;

        int opcion;
        do {
            // Menú de opciones
            System.out.println("\n=== GESTIÓN DE INVENTARIO Y FACTURACIÓN ===");
            System.out.println("1. Agregar nuevo producto al inventario");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Facturar producto");
            System.out.println("4. Mostrar factura");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();  // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    // Agregar nuevo producto al inventario
                    if (numProductos < MAX_PRODUCTOS) {
                        System.out.print("Ingrese el nombre del producto: ");
                        inventario[numProductos][0] = teclado.nextLine();
                        System.out.print("Ingrese el precio del producto: ");
                        inventario[numProductos][1] = teclado.nextLine();
                        System.out.print("Ingrese la cantidad en stock: ");
                        inventario[numProductos][2] = teclado.nextLine();
                        numProductos++;
                        System.out.println("Producto agregado correctamente.");
                    } else {
                        System.out.println("No se pueden agregar más productos. Inventario lleno.");
                    }
                    break;

                case 2:
                    // Mostrar inventario
                    if (numProductos > 0) {
                        System.out.println("\n=== INVENTARIO ===");
                        for (int i = 0; i < numProductos; i++) {
                            System.out.println("Código: " + i);
                            System.out.println("Nombre: " + inventario[i][0]);
                            System.out.println("Precio: " + inventario[i][1]);
                            System.out.println("Cantidad en stock: " + inventario[i][2]);
                            System.out.println("-------------------");
                        }
                    } else {
                        System.out.println("El inventario está vacío.");
                    }
                    break;

                case 3:
                    // Facturar producto
                    System.out.print("Ingrese el código del producto a facturar: ");
                    int codigoFacturar = teclado.nextInt();

                    if (codigoFacturar >= 0 && codigoFacturar < numProductos) {
                        System.out.print("Ingrese la cantidad a facturar: ");
                        int cantidadFacturar = teclado.nextInt();

                        if (cantidadFacturar > 0 && cantidadFacturar <= Integer.parseInt(inventario[codigoFacturar][2])) {
                            // Actualizar inventario
                            inventario[codigoFacturar][2] = String.valueOf(Integer.parseInt(inventario[codigoFacturar][2]) - cantidadFacturar);

                            // Agregar a la factura
                            factura[numItemsFactura][0] = String.valueOf(codigoFacturar);
                            factura[numItemsFactura][1] = inventario[codigoFacturar][0];
                            factura[numItemsFactura][2] = inventario[codigoFacturar][1];
                            factura[numItemsFactura][3] = String.valueOf(cantidadFacturar);

                            // Actualizar total de la factura
                            totalFactura += (Double.parseDouble(inventario[codigoFacturar][1]) * cantidadFacturar);
                            numItemsFactura++;

                            System.out.println("Producto facturado correctamente.");
                        } else {
                            System.out.println("La cantidad ingresada es inválida o excede el stock disponible.");
                        }
                    } else {
                        System.out.println("Código de producto inválido.");
                    }
                    break;

                case 4:
                    // Mostrar factura
                    if (numItemsFactura > 0) {
                        System.out.println("\n=== FACTURA ===");
                        for (int i = 0; i < numItemsFactura; i++) {
                            System.out.println("Código: " + factura[i][0]);
                            System.out.println("Nombre: " + factura[i][1]);
                            System.out.println("Precio unitario: " + factura[i][2]);
                            System.out.println("Cantidad: " + factura[i][3]);
                            System.out.println("-------------------");
                        }

                        double iva = totalFactura * 0.12;
                        double totalConIVA = totalFactura + iva;

                        // Aplicar descuento si la compra supera los $100
                        if (totalConIVA > 100) {
                            totalConIVA *= 0.9;  // Aplicar descuento del 10%
                        }

                        System.out.println("Total sin IVA: " + totalFactura);
                        System.out.println("IVA (12%): " + iva);
                        System.out.println("Total con IVA: " + totalConIVA);
                    } else {
                        System.out.println("La factura está vacía.");
                    }
                    break;

                case 0:
                    // Salir del programa
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }
}