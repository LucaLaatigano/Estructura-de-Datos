public class punto7 {


    public static class Auto {
        private int patente;

        public Auto(int patente) {
            this.patente = patente;
        }

        public int getPatente() {
            return this.patente;
        }

        @Override
        public String toString() {
            return "Auto con patente " + patente;
        }
    }


    public static class Estacionamiento {


        private clsPilaLinkedList carril_principal;
        private clsPilaLinkedList calle_auxiliar;
        private int capacidad;
        private int autosEstacionados;


        public Estacionamiento(int capacidad) {
            this.capacidad = capacidad;
            this.carril_principal = new clsPilaLinkedList();
            this.calle_auxiliar = new clsPilaLinkedList();
            this.autosEstacionados = 0;
        }



        public void llegada(int patente) {
            if (this.autosEstacionados < this.capacidad) {
                Auto nuevoAuto = new Auto(patente);
                carril_principal.meter(nuevoAuto);
                this.autosEstacionados++;
                System.out.println(" Llegada: El " + nuevoAuto + " ha estacionado.");
            } else {
                System.out.println(" Llegada: El auto con patente " + patente + " no pudo estacionar. ¡Lleno!");
            }
        }

        public void salida(int patente_a_buscar) {
            if (carril_principal.pilaVacia()) {
                System.out.println("ℹ Partida: El estacionamiento está vacío.");
                return;
            }

            int autos_movidos = 0;
            boolean auto_encontrado = false;

            while (!carril_principal.pilaVacia() && !auto_encontrado) {
                Auto auto_actual = (Auto) carril_principal.verTope();
                if (auto_actual.getPatente() == patente_a_buscar) {
                    carril_principal.sacar();
                    auto_encontrado = true;
                    this.autosEstacionados--;
                } else {
                    calle_auxiliar.meter(carril_principal.sacar());
                    autos_movidos++;
                }
            }

            while (!calle_auxiliar.pilaVacia()) {
                carril_principal.meter(calle_auxiliar.sacar());
            }

            if (auto_encontrado) {
                System.out.println(" Partida: Salió el auto con patente " + patente_a_buscar + ". Se movieron " + autos_movidos + " autos.");
            } else {
                System.out.println(" Partida: El auto " + patente_a_buscar + " no se encuentra.");
            }
        }
    }


    public static void main(String[] args) {

        System.out.println("--- Prueba del Estacionamiento ---");
        Estacionamiento miEstacionamiento = new Estacionamiento(3); // Capacidad para 3 autos

        miEstacionamiento.llegada(111);
        miEstacionamiento.llegada(222);
        miEstacionamiento.llegada(333);
        miEstacionamiento.llegada(444); // Debería fallar (lleno)

        miEstacionamiento.salida(111); // Debería mover 2 autos
        miEstacionamiento.salida(333); // Debería mover 0 autos
        miEstacionamiento.salida(999); // No debería encontrarlo
    }
}
