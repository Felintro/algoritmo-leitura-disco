package br.edu.feitep;

import br.edu.feitep.reader.Reader;

import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo!");
        System.out.println("Insira o tamanho do buffer:");
        int[] buffer = new int[scanner.nextInt()];

        System.out.println("Insira os números no buffer:");
        Reader reader = new Reader();

        for(int i=0; i<buffer.length; i++) {
            buffer[i] = scanner.nextInt();
        }

        System.out.println(reader.printBuffer(buffer));

        System.out.println("----------------------------");
        System.out.println("Algoritmo: FCFS");
        reader.setDistanceRead(0);
        reader.setBuffer(buffer);
        reader.firstComeFirstServed();

        System.out.println("----------------------------");
        System.out.println("Algoritmo: ELEVADOR");
        reader.setDistanceRead(0);
        reader.setBuffer(buffer);
        reader.elevator();

        System.out.println("----------------------------");
        System.out.println("Algoritmo: SSF");
        reader.setDistanceRead(0);
        reader.setBuffer(buffer);
        reader.shortestSeekFirst();

    }

}