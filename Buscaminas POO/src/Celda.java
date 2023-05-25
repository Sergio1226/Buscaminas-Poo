public class Celda {
    int valor;
    boolean mina;
    boolean mostrar;
    
    public Celda(boolean mina) {
        this.mina = mina;
        this.mostrar = false;
    }

    public void setValor() {
        this.valor++;
    }

    public void setMostrar() {
        this.mostrar = true;
    }

}
