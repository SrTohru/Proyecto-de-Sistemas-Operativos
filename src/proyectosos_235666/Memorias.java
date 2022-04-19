package proyectosos_235666;

public class Memorias {

    int bloque, tamaño, nProceso, tProceso, FragInt;
    
    boolean eMemoria = false;

    public Memorias(int bloque, int tTamaño) {
        this.bloque = bloque;
        this.tamaño = tTamaño;
    }

    public Memorias(Tareas tareas, int proceso, int tTiempo, boolean eMemoria) {
        this.nProceso = proceso;
        this.tProceso = tTiempo;
        this.FragInt = this.tamaño - tareas.getTamaño();
        this.eMemoria = eMemoria;
    }

    public boolean iseMemoria() {
        return eMemoria;
    }

     public String eMemoria() {
        if(eMemoria){
            return "En uso";
        }else {
            return "Sin uso";
        }
    }
    
    public void seteMemoria(boolean eMemoria) {
        this.eMemoria = eMemoria;
    }

    public int getnProceso() {
        return nProceso;
    }

    public void setnProceso(int nProceso) {
        this.nProceso = nProceso;
    }

    public int gettProceso() {
        return tProceso;
    }

    public void settProceso(int tProceso) {
        this.tProceso = tProceso;
    }

    public int getFragInt() {
        return FragInt;
    }

    public void setFragInt(int memoria1, int memoria2) {
        this.FragInt = memoria1 - memoria2;
    }

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public void removeAllData() {
        this.nProceso = 0;
        this.tProceso = 0;
        this.FragInt = 0;
        this.eMemoria = false;
    }

    public int getNumeroDefault() {
       
        if(nProceso-1 == -1){
            return 0;
        }
            return nProceso - 1;
    }

    @Override
    public String toString() {
        return "Bloque: " + bloque + ", Tamaño: " + tamaño + ", Proceso: " + nProceso + ", Tiempo: " + tProceso;
    }

}
