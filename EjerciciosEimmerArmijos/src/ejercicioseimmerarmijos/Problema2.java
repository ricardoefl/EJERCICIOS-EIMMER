package ejercicioseimmerarmijos;
//Eimmer y Pablo
import java.util.Scanner;
public class Problema2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        final int MAX_PRODUCTOS = 100;
        final int NUM_ATRIBUTOS = 3;  // Nombre, Precio, Cantidad
        // Matriz para almacenar productos (nombre, precio, cantidad)
        String[][] inventario = new String[MAX_PRODUCTOS][NUM_ATRIBUTOS];
        // Número actual de productos en el inventario
        int numProductos = 0;
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE INVENTARIO ===");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Actualizar existencias");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar inventario");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();  // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    // Agregar nuevo producto
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
                    // Actualizar existencias
                    System.out.print("Ingrese el nombre del producto a actualizar: ");
                    String nombreActualizar = teclado.nextLine();
                    boolean encontradoActualizar = false;

                    for (int i = 0; i < numProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombreActualizar)) {
                            System.out.print("Ingrese la nueva cantidad en stock: ");
                            inventario[i][2] = teclado.nextLine();
                            encontradoActualizar = true;
                            System.out.println("Existencias actualizadas correctamente.");
                            break;
                        }
                    }

                    if (!encontradoActualizar) {
                        System.out.println("Producto no encontrado en el inventario.");
                    }
                    break;

                case 3:
                    // Buscar producto
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String nombreBuscar = teclado.nextLine();
                    boolean encontradoBuscar = false;

                    for (int i = 0; i < numProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombreBuscar)) {
                            System.out.println("Producto encontrado:");
                            System.out.println("Nombre: " + inventario[i][0]);
                            System.out.println("Precio: " + inventario[i][1]);
                            System.out.println("Cantidad en stock: " + inventario[i][2]);
                            encontradoBuscar = true;
                            break;
                        }
                    }

                    if (!encontradoBuscar) {
                        System.out.println("Producto no encontrado en el inventario.");
                    }
                    break;

                case 4:
                    // Eliminar producto
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String nombreEliminar = teclado.nextLine();
                    boolean encontradoEliminar = false;

                    for (int i = 0; i < numProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombreEliminar)) {
                            for (int j = i; j < numProductos - 1; j++) {
                                // Mover los productos siguientes una posición hacia arriba en la matriz
                                inventario[j][0] = inventario[j + 1][0];
                                inventario[j][1] = inventario[j + 1][1];
                                inventario[j][2] = inventario[j + 1][2];
                            }
                            numProductos--;
                            encontradoEliminar = true;
                            System.out.println("Producto eliminado correctamente.");
                            break;
                        }
                    }

                    if (!encontradoEliminar) {
                        System.out.println("Producto no encontrado en el inventario.");
                    }
                    break;

                case 5:
                    // Mostrar inventario
                    if (numProductos > 0) {
                        System.out.println("\n=== INVENTARIO ===");
                        for (int i = 0; i < numProductos; i++) {
                            System.out.println("Nombre: " + inventario[i][0]);
                            System.out.println("Precio: " + inventario[i][1]);
                            System.out.println("Cantidad en stock: " + inventario[i][2]);
                            System.out.println("-------------------");
                        }
                    } else {
                        System.out.println("El inventario está vacío.");
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