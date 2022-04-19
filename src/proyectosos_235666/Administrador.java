package proyectosos_235666;

import java.util.Scanner;

public class Administrador {

    public static Tareas tareas[] = new Tareas[25];

    public static Memorias[] memorias = new Memorias[10];

    public static Scanner scanner = new Scanner(System.in);

    public static boolean eMemorias = false;

    public static int nMemorias = 0;
    public static int cProcesos = 0;

    public static int mTotal = 50000;

    public static void main(String[] args) {

        tareas[0] = new Tareas(1, 5, 5760, "Inactivo");
        tareas[1] = new Tareas(2, 38, 4190, "Inactivo");
        tareas[2] = new Tareas(3, 38, 3290, "Inactivo");
        tareas[3] = new Tareas(4, 36, 2030, "Inactivo");
        tareas[4] = new Tareas(5, 41, 2550, "Inactivo");
        tareas[5] = new Tareas(6, 46, 6990, "Inactivo");
        tareas[6] = new Tareas(7, 38, 8940, "Inactivo");
        tareas[7] = new Tareas(8, 40, 740, "Inactivo");
        tareas[8] = new Tareas(9, 37, 3930, "Inactivo");
        tareas[9] = new Tareas(10, 36, 6890, "Inactivo");
        tareas[10] = new Tareas(11, 35, 6580, "Inactivo");
        tareas[11] = new Tareas(12, 38, 3820, "Inactivo");
        tareas[12] = new Tareas(13, 39, 9140, "Inactivo");
        tareas[13] = new Tareas(14, 40, 420, "Inactivo");
        tareas[14] = new Tareas(15, 40, 220, "Inactivo");
        tareas[15] = new Tareas(16, 23, 7540, "Inactivo");
        tareas[16] = new Tareas(17, 53, 3210, "Inactivo");
        tareas[17] = new Tareas(18, 41, 1380, "Inactivo");
        tareas[18] = new Tareas(19, 39, 9350, "Inactivo");
        tareas[19] = new Tareas(20, 35, 3610, "Inactivo");
        tareas[20] = new Tareas(21, 47, 7540, "Inactivo");
        tareas[21] = new Tareas(22, 42, 2710, "Inactivo");
        tareas[22] = new Tareas(23, 38, 8390, "Inactivo");
        tareas[23] = new Tareas(24, 49, 5950, "Inactivo");
        tareas[24] = new Tareas(25, 40, 760, "Inactivo");

        
        memorias[0] = new Memorias(1, 9500);
        memorias[1] = new Memorias(2, 7000);
        memorias[2] = new Memorias(3, 4500);
        memorias[3] = new Memorias(4, 8500);
        memorias[4] = new Memorias(5, 3000);
        memorias[5] = new Memorias(6, 9000);
        memorias[6] = new Memorias(7, 1000);
        memorias[7] = new Memorias(8, 5500);
        memorias[8] = new Memorias(9, 1500);
        memorias[9] = new Memorias(10, 500);

        sendMessage();

        pFor();
    }

    public static void sFor(int numero) {

        for (int j = 0; j < memorias.length; j++) {
            if (memoriesStatus()) {
                if (nMemorias > memorias.length - 1) {
                    nMemorias = 0;
                }

                if (memorias[nMemorias] == null) {
                    continue;
                } else if (tareas[memorias[nMemorias].getNumeroDefault()] == null) {
                    continue;
                } else {
                    tareas[memorias[nMemorias].getNumeroDefault()].setEstado("Terminado");
                    memorias[nMemorias].removeAllData();
                    nMemorias += 1;
                }
            }

            if (!(memorias[j].iseMemoria())) {
                for (int k = 0; k < tareas.length; k++) {

                    if (tareas[k] == null) {
                        return;
                    }

                    if (tareas[k].getEstado().equalsIgnoreCase("Espera")) {
                        if (memorias[j].getTamaño() >= tareas[k].getTamaño()) {

                            memorias[j].setFragInt(memorias[j].getTamaño(), tareas[k].getTamaño());
                            memorias[j].setnProceso(tareas[k].getNumero());
                            memorias[j].settProceso(tareas[k].getTiempo());
                            memorias[j].seteMemoria(true);
                            tareas[k].setBloqueMemoria(j);
                            tareas[k].setEstado("Ejecutando");
                            mTotal = mTotal - tareas[k].getTamaño();
                            System.out.println("");

                            sendMessage();
                            return;
                        } else {
                            for (int i = 0; i < memorias.length - 1; i++) {
                                if (memorias[i].getTamaño() >= tareas[k].getTamaño()) {
                                    tareas[k].setEstado("Terminado");
                                     mTotal =  mTotal + tareas[k].getTamaño();
                                    memorias[i].removeAllData();
                                }
                            }

                        }

                        return;
                    } else if (!(tareas[numero].getEstado().equalsIgnoreCase("Terminado"))) {

                        if (memorias[j].getTamaño() >= tareas[numero].getTamaño()) {

                            memorias[j].setFragInt(memorias[j].getTamaño(), tareas[numero].getTamaño());
                            memorias[j].setnProceso(tareas[numero].getNumero());
                            memorias[j].settProceso(tareas[numero].getTiempo());
                            memorias[j].seteMemoria(true);
                            tareas[numero].setBloqueMemoria(j);
                            tareas[numero].setEstado("Ejecutando");
                                   mTotal = mTotal - tareas[k].getTamaño();

                            sendMessage();
                            return;
                        } else {
                            if (!(tareas[numero].getEstado().equalsIgnoreCase("Terminado")) && !(tareas[numero].getEstado().equalsIgnoreCase("Ejecutando"))) {
                                tareas[numero].setEstado("Espera");
                                mTotal =  mTotal + tareas[k].getTamaño();
                                sendMessage();
                                return;
                            }
                        }
                    }
                }

            }

        }
    }

    public static void pFor() {

        for (int i = 0; i <= tareas.length - 1; i++) {
            if (tareas[i] == null || tareas[i].getEstado().equalsIgnoreCase("Terminado")) {
                continue;
            } else if (!tareas[i].getEstado().equalsIgnoreCase("Terminado")) {
                sFor(i);
            }
        }

        System.out.println("");
        sendMessage();

        for (int i = 0; i < tareas.length - 1; i++) {
            if (tareas[i].getEstado().equalsIgnoreCase("Ejecutando")) {
                tareas[i].setEstado("Terminado");
                memorias[tareas[i].getBloqueMemoriaDefault()].removeAllData();
            } else if (!tareas[i].getEstado().equalsIgnoreCase("Terminado")) {
                pFor();
            }
        }

        for (int i = 0; i < tareas.length - 1; i++) {
            if (tareas[i].getEstado().equalsIgnoreCase("Terminado")) {
                cProcesos++;
            }
        }

        if (cProcesos >= 24) {
            for (int i = 0; i < memorias.length; i++) {
                memorias[i].removeAllData();
            }
            sendMessage();
            System.out.println("");
            System.out.println("* LA EJECUCION TERMINO *");
            System.exit(0);
        }

        cProcesos = 0;
    }

    public static void sendMessage() {

        for (int i = 0; i < memorias.length; i++) {
            System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s %n", "Estado del proceso:", "Numumero:", "Tamaño:", "Tiempo:", "Estado del bloq:", "Tamaño de Memoria:", "Proceso que contiene:", "Fragmentacion:");
            System.out.printf("%9s %13d %13d %13d %13s %13d %18d %22d %n", tareas[i].getEstado(), tareas[i].getNumero(), tareas[i].getTamaño(), tareas[i].getTiempo(), memorias[i].eMemoria(), memorias[i].getTamaño(), memorias[i].getnProceso(), memorias[i].getFragInt());
        }

        for (int i = memorias.length; i < tareas.length; i++) {
            System.out.printf("%9s %9s %9s %9s  %n", "Estado del proceso:", "Numumero:", "Tamaño:", "Tiempo:");
            System.out.printf("%10s %13d %12d %13d %n", tareas[i].getEstado(), tareas[i].getNumero(), tareas[i].getTamaño(), tareas[i].getTiempo());
        }

        System.out.println("Memorial total: " + mTotal);

        System.out.println("Presione *Enter*, para continuar.");
        scanner.nextLine();

    }

    public static boolean memoriesStatus() {
        int j = 0;

        for (Memorias memoria : memorias) {
            if (memoria.iseMemoria()) {
                j++;
            }
            if (j >= memorias.length) {
                return true;
            }
        }

        return false;
    }

}
