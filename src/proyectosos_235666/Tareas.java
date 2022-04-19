package proyectosos_235666;

public class Tareas {

    int numero = 0, tiempo = 0, tamaño = 0, bloqueMemoria = 0;
    
    
    String estado;

    public Tareas() {
    }

    public Tareas(int numero, int tiempo, int tamaño, String estado) {
        this.numero = numero;
        this.tiempo = tiempo;
        this.tamaño = tamaño;
        this.estado = estado;
    }

    public int getBloqueMemoria() {

        return bloqueMemoria;
    }

    public int getBloqueMemoriaDefault() {

        if (bloqueMemoria - 1 == -1) {
            return 0;
        }

        return bloqueMemoria - 1;
    }

    public void setBloqueMemoria(int bloqueMemoria) {
        this.bloqueMemoria = bloqueMemoria;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "N. Proceso: " + numero + ", Tiempo del Proceso: " + tiempo + ", Tamaño del Proceso: " + tamaño + ", Estado del proceso: " + estado;
    }

}
