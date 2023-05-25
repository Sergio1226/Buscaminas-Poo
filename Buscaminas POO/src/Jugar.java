
public class Jugar {
    public static int cantidadGanar = 0;
    public static int cantidad = 0;
    public final int NIVEL_UNO = 1;
    public final int NIVEL_DOS = 2;
    public final int NIVEL_TRES = 3;

    public static void contar() {
        cantidadGanar++;
    }

    public static Celda[][] crearCelda(Celda[][] matriz, int elegir) {
        for (int j = 0; j < matriz.length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                int random = (int) (Math.random() * 99) + 1;
                if (random <= elegir) {
                    matriz[j][i] = new Celda(true);
                } else {
                    matriz[j][i] = new Celda(false);
                }
                if (!matriz[j][i].mina) {
                    cantidad++;
                }
            }
        }
        return matriz;
    }

    public static void mostrarCelda(Celda[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("__");
        }
        System.out.println("");
        for (int i = 0; i < matriz.length; i++) {
                System.out.print((i + 1) + "|");
        }
        System.out.println("");
        for (int j = 0; j < matriz.length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                if (matriz[j][i].mostrar) {
                    System.out.print(matriz[j][i].valor + " ");
                } else {
                    System.out.print("[]");
                }
            }
            System.out.println("|" + (j + 1));
        }
    }

    public static void mostrarNumero(Celda[][] matriz, int pos1, int pos2) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print((i + 1) + "|");
        }
        System.out.println("");
        for (int j = 0; j < matriz.length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                if (j == pos1 && i == pos2 && matriz[pos1][pos2].mina) {
                    System.out.print("X ");
                } else if (matriz[j][i].mina) {
                    System.out.print("* ");
                } else {
                    System.out.print(matriz[j][i].valor + " ");
                }
            }
            System.out.println("|" + (j + 1));
        }
    }
    public static void comprobar(Celda[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int x = 0; x < matriz.length; x++) {
                if (!matriz[i][x].mina) {
                    for(int j=-1;j<2;j++){
                        for(int k=-1;k<2;k++){
                            if(!(j==0&&k==0)){
                                if (i+j>=0&&i+j<matriz.length&&x+k>=0&&x+k<matriz.length) {
                                    if (matriz[i+j][x+k].mina) {
                                        matriz[i][x].setValor();
                                    }
                                }
                            }
                        }
                    }
                    
                }
            }
        }
    }

    public static void primerJuego(Celda[][] matriz, int i, int x) {
            for(int j=-1;j<2;j++){
                for(int k=-1;k<2;k++){
                    if(!(j==0&&k==0)){
                        if (i+j>=0&&i+j<matriz.length&&x+k>=0&&x+k<matriz.length) {
                            if (!matriz[i+j][x+k].mina) {
                                if(!matriz[i+j][x+k].mostrar){
                                    matriz[i+j][x+k].setMostrar();
                                    cantidadGanar++;
                                }
                            }
                        }
                    }
                }
            }
        mostrarCeros(matriz);
    }
    public static void mostrarCeros(Celda[][] matriz){
        for(int j=0;j<matriz.length;j++){
        for(int i=0;i<matriz.length;i++){
            for(int x=0;x<matriz.length;x++){
                if(matriz[i][x].mostrar&&matriz[i][x].valor==0){
                    for(int l=-1;l<2;l++){
                        for(int k=-1;k<2;k++){
                            if(!(j==0&&k==0)){
                                if (i+l>=0&&i+l<matriz.length&&x+k>=0&&x+k<matriz.length) {
                                    if(!matriz[i+l][x+k].mostrar){
                                        matriz[i+l][x+k].setMostrar();
                                        cantidadGanar++;
                                    }                                  
                                }
                            }
                        }
                    }   
            }
            }
            }
        }
    }
}