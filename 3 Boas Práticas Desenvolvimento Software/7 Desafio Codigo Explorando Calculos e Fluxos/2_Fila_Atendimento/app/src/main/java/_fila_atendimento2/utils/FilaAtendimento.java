package _fila_atendimento2.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FilaAtendimento {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Lê o número de clientes
            int n = scanner.nextInt();

            // TODO: Crie a lista para armazenar os clientes e suas prioridades
            List<int[]> fila = new ArrayList<>();
            
            // TODO: Leia os clientes e suas prioridades
            for(int i = 0; i < n; i++) {
                // ID do cliente
                int id = scanner.nextInt();
                
                // Prioridade do cliente
                int prioridade = scanner.nextInt();
                
                // Adiciona cliente à fila
                fila.add(new int[]{id, prioridade});
            }
            
            // TODO: Ordene a fila primeiro pela prioridade (decrescente), depois por ID (crescentemente)
            for(int i = fila.size()-1; i >= 0; i--) {

                for (int j = 0; j < i; j++) {
                    // Se as prioridades são diferentes
                    // Ordem decrescente                     
                    if (fila.get(j)[1] < fila.get(j+1)[1]) {
                        Collections.swap(fila, j, j+1);
                    }
                    // Se as prioridades são iguais
                    // Ordem crescente de ID 
                    if (fila.get(j)[1] == fila.get(j+1)[1] && fila.get(j)[0] > fila.get(j+1)[0]) {
                        Collections.swap(fila, j, j+1);
                    }                    

                    //System.out.print(fila.get(j)[0]);
                }

            }
                          

            // Imprime os IDs dos clientes na ordem de atendimento
            for (int[] cliente : fila) {
                System.out.print(cliente[0] + " ");
            }            
        }       
    }
    
}