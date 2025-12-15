package _ordenacao_produtos.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendasProdutos {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();  
            
            List<String[]> produtos = new ArrayList<>();
            
            // TODO: Leia os produtos com a quantidade vendida e o preço
            String nome = "";
            int quantidade = 0;
            double preco = 0.0d;
            for(int i = 0; i < n; i++) {
                // Lê a linha inteira
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Lê a linha de entrada
                // Divide a linha em partes                                
                //StringTokenizer st = new StringTokenizer(br.readLine()); 

                // Nome do produto
                //nome = st.nextToken();
                nome = scanner.next();

                // Quantidade vendida
                //quantidade = Integer.parseInt(st.nextToken());
                quantidade = scanner.nextInt();

                // Preço do produto
                //preco = Double.parseDouble(st.nextToken());
                preco = scanner.nextDouble();
                
                produtos.add(new String[]{nome, String.valueOf(quantidade), String.valueOf(preco)});
            }         
            
            // Ordena os produtos pela quantidade vendida (decrescente), 
            // e caso as quantidades sejam iguais, pelo preço (decrescente)
            produtos.sort((a, b) -> {
                int q1 = Integer.parseInt(a[1]);
                int q2 = Integer.parseInt(b[1]);
                double p1 = Double.parseDouble(a[2]);
                double p2 = Double.parseDouble(b[2]);
                // TODO: Organize pela quantidade vendida (decrescente):
                if (q1 < q2) {                
                    // TODO: A maior quantidade vem primeiro
                    return 1;
                } else if (q1 > q2) {
                    return -1;
                } else {            
                    // Caso as quantidades sejam iguais, compara pelo preço (decrescente)
                    // Preço maior vem primeiro
                    if (p1 < p2) {
                        return 1;
                    } else if (p1 > p2) {
                        return -1;
                    }
                    return 0;
                }
            });
            
            // Imprime os produtos na ordem correta
            for (String[] produto : produtos) {
                System.out.print(produto[0] + " "); 
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}