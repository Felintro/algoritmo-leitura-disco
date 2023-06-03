package br.edu.feitep.reader;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reader {

    private int[] buffer;
    private int distanceRead;
    private int pivot;

    public void firstComeFirstServed() {
        for(int i=0; i<buffer.length; i++){
            if(i != buffer.length - 1) {
                distanceRead += Math.abs(buffer[i] - buffer[i+1]);
            }
            read(buffer[i]);
        }
        report();
    }

    public void shortestSeekFirst() {
        int[] sequenciaLeitura = new int[buffer.length];
        int indiceMenorValor = 0, distancia, menorDistancia = 4000;

        for (int i = 0; i < buffer.length; i++) {
            if (i == 0) {
                sequenciaLeitura[0] = buffer[0];
                buffer[0] = 5000;
                continue;
            }
            
            for (int j = 0; j < buffer.length; j++) {
                distancia = Math.abs(sequenciaLeitura[i-1] - buffer[j]);
                if (distancia < menorDistancia) {
                    indiceMenorValor = j;
                    menorDistancia = distancia;
                }
            }

            menorDistancia = 4000;
            sequenciaLeitura[i] = buffer[indiceMenorValor];
            buffer[indiceMenorValor] = 5000;

        }

        for(int k = 0; k < sequenciaLeitura.length; k++){
            read(sequenciaLeitura[k]);
            if(k != sequenciaLeitura.length - 1) {
                distanceRead += Math.abs(sequenciaLeitura[k] - sequenciaLeitura[k+1]);
            }
        }

        report();

    }

    public void elevator() {
        int i;
        this.pivot = (int) buffer.length / 2;

        for(i=pivot; i<buffer.length; i++){
            if(i != buffer.length - 1) {
                distanceRead += Math.abs(buffer[i] - buffer[i+1]);
            }
            read(buffer[i]);
        }

        for(i=pivot-1; i>=0; i--){
            if(i != 0) {
                distanceRead += Math.abs(buffer[i] - buffer[i-1]);
            }
            read(buffer[i]);
        }

        report();
    }

    private void read(int value) {
        System.out.println("Leitura feita: |" + value + "|");
    }

    private void report() {
        System.out.println("----------------------------");
        System.out.println("Leitura concluída!");
        System.out.println("Distância percorrida: |" + distanceRead + "|");
        System.out.println("----------------------------");
        distanceRead = 0;
    }

    public String printBuffer(int[] buffer) {
        StringBuilder bufferToString = new StringBuilder("Buffer: { ");
        for(int i : buffer) {
            bufferToString.append(i + " ");
        }
        bufferToString.append("}");
        return bufferToString.toString();
    }

}