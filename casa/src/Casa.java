public class Casa {

        private String nombre;
        private Habitacion[] habitaciones;  // Composición: la casa crea sus habitaciones

        public Casa(String nombre, int cantidadHabitaciones) {
            this.nombre = nombre;

            // La casa misma crea las habitaciones (no se pasan desde fuera)
            habitaciones = new Habitacion[cantidadHabitaciones];
            for (int i = 0; i < cantidadHabitaciones; i++) {
                habitaciones[i] = new Habitacion("Habitación " + (i + 1));
            }
        }

        public void mostrarHabitaciones() {
            System.out.println("Nombre de la casa: " + nombre);
            System.out.println("Habitaciones:");
            for (Habitacion habitacion : habitaciones) {
                System.out.println(" - " + habitacion.getNombre());
            }
        }
    }

