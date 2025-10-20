
    class Circulo extends Figura {
        private double radio;

        // Constructor
        public Circulo(double radio) {
            this.radio = radio;
        }

        // Implementaciones específicas
        @Override
        public double calcularArea() {
            return Math.PI * Math.pow(radio, 2);
        }

        @Override
        public double calcularPerimetro() {
            return 2 * Math.PI * radio;
        }
    }

