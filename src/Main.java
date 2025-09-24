//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        cliente cliente1 = new cliente("Danny", "Arias", "119680562", 'M', "Desamparados") {
        };
        cliente cliente2 = new cliente("Ana", "Lucia", "119780562", "Desamparados") {
        };
        cliente cliente3 = new cliente() {

        };

        Sus C = new Sus("zafiro", 10, 1) {
        };
        Sus T = new Sus("Oro", 295, 3) {
        };
        Sus R = new Sus("Platino", 550, 6) {
        };


        cliente1.suscribirse(C);
        cliente2.suscribirse(T);
        cliente3.suscribirse(new Sus("platino", 550, 6));



        System.out.println(R);
        System.out.println(cliente2);
        System.out.println(cliente1.equals(cliente2));
        System.out.println(C.equals(T));
    }



    //public [variable] [Nvariable]{} metodos
    //return nombreAtributo; getter

    //private [variable] [Nvariable]{} atributos
    //nombreAtributo = nuevoValorAtributo; setter

    // public boolean equalsif( [atributo]== [variable] ){print true else print false}

}

