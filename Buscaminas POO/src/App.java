import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        final int NIVEL_UNO = 1;
        final int NIVEL_DOS = 2;
        final int NIVEL_TRES = 3;
        boolean condJugar = true;
        boolean condInicio = true;
        int probabilidad = 0;
        int elegir = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la longitud");
        int longitud = sc.nextInt();
        while(longitud < 5) {
            condJugar = false;
            System.out.println("Las celdas no puedes ser menores a 5x5");
            System.out.println("Ingrese la longitud");
            longitud = sc.nextInt();
        }
        System.out.println("Ingrese el nivel de la celdad");
        elegir = sc.nextInt();
        switch (elegir) {
            case NIVEL_UNO:
                probabilidad = 20;
                break;
            case NIVEL_DOS:
                probabilidad = 35;
                break;
            case NIVEL_TRES:
                probabilidad = 50;
                break;
        }
        Celda[][] matriz = new Celda[longitud][longitud];
        matriz = Jugar.crearCelda(matriz, probabilidad);
        int pos1 = 0;
        int pos2 = 0;
        if (condJugar) {
            Jugar.mostrarCelda(matriz);
            System.out.println("Ingrese las posiciones a cavar");
            System.out.print("x:");
            pos2 = sc.nextInt() - 1;
            System.out.print("y:");
            pos1 = sc.nextInt() - 1;
            while (pos1 < 0 || pos1 > matriz.length || pos2 < 0 | pos2 > matriz.length) {
                System.out.println("!Posiciones erroneas¡");
                System.out.println("Ingrese las posiciones a cavar");
                System.out.print("x:");
                pos2 = sc.nextInt() - 1;
                System.out.print("y:");
                pos1 = sc.nextInt() - 1;
            }
            if (matriz[pos1][pos2].mina) {
                matriz[pos1][pos2].mina = false;
                Jugar.cantidad--;
            }
            System.out.println(Jugar.cantidad);
            Jugar.comprobar(matriz);
        }
        while (condJugar) {
            if (condInicio) {
                Jugar.primerJuego(matriz, pos1, pos2);
                Jugar.mostrarCelda(matriz);
                condInicio = false;
            }
            if (matriz[pos1][pos2].mina) {
                System.out.println("Perdiste");
                Jugar.mostrarNumero(matriz, pos1, pos2);
                condJugar = false;
            } else {
                if (!matriz[pos1][pos2].mostrar) {
                    matriz[pos1][pos2].setMostrar();
                    Jugar.contar();
                    if(matriz[pos1][pos2].valor==0){
                        Jugar.mostrarCeros(matriz);
                    }
                }
                Jugar.mostrarCelda(matriz);
            }
            if (Jugar.cantidadGanar == Jugar.cantidad) {
                System.out.println("Ganaste :)");
                Jugar.mostrarNumero(matriz, pos1, pos2);
                condJugar = false;
            }
            if (condJugar) {
                System.out.println("Ingrese las posiciones a cavar");
                System.out.print("x:");
                pos2 = sc.nextInt() - 1;
                System.out.print("y:");
                pos1 = sc.nextInt() - 1;
                while (pos1 < 0 || pos1 > matriz.length || pos2 < 0 | pos2 > matriz.length) {
                    System.out.println("!Posiciones erroneas¡");
                    System.out.println("Ingrese las posiciones a cavar");
                    System.out.print("x:");
                    pos2 = sc.nextInt() - 1;
                    System.out.print("y:");
                    pos1 = sc.nextInt() - 1;
                }
            }
        }
        sc.close();
    }
}
