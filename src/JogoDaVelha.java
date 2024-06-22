import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String[][] tabuleiro = new String[3][3];
        int cont = 1, jogador = 1;
        boolean ganhador = false;

       // Inicializar o tabuleiro de 1 até 9 números;
        for(int i = 0; i < tabuleiro.length; i++) {        
            for(int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = String.valueOf(cont);
                cont++;
            }
           
            
        }
        while(!ganhador) {
            for(int i = 0; i < tabuleiro.length; i++) {        
                for(int j = 0; j < tabuleiro[i].length; j++) {
                    System.out.print(tabuleiro[i][j] + " | ");
                }
                System.out.println();
                
            }
            if(jogador % 2 == 1) {
                
                System.out.println("Vez do jogador (X). Escolha sua jogada");
            }
            else {
                System.out.println("Vez do jogador (O). Escolha sua jogada)");
            }
            int jogada = input.nextInt();
            int[] pos = obterPosicao(jogada);

            if(tabuleiro[pos[0]][pos[1]].equalsIgnoreCase("x") || tabuleiro[pos[0]][pos[1]].equalsIgnoreCase("o")) {
                jogador--;
                System.out.println("Posição já ocupada. Tente novamente!");
            }
                else {
                    if(jogador % 2 == 1) {
                    tabuleiro[pos[0]][pos[1]] = "X";
                }
                    else if(jogador % 2 == 0){
                    tabuleiro[pos[0]][pos[1]] = "O";
                }              
            }
            ganhador = verificarGanhador(tabuleiro);
            if(ganhador) {
                for(int i = 0; i < tabuleiro.length; i++) {        
                    for(int j = 0; j < tabuleiro[i].length; j++) {
                        System.out.print(tabuleiro[i][j] + " | ");
                    }
                    System.out.println();                 
                }

                if(jogador % 2 == 1) {
                    System.out.println("Jogador (X) venceu!");
                }
                else {
                System.out.println("Jogador (O) venceu!");
                }
                if(jogador == 9) {                   
                    System.out.println("Empate");
                    ganhador = true;
                }          
            }

                jogador++;           
}

    }

    public static int[] obterPosicao(int jogada) {
        int[] pos = new int[2];
        pos[0] = (jogada - 1) / 3;
        pos[1] = (jogada - 1) % 3;
        return pos;
    }

    public static boolean verificarGanhador(String[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0].equals(tabuleiro[i][1]) && tabuleiro[i][1].equals(tabuleiro[i][2])) {
                return true;
            }
            if (tabuleiro[0][i].equals(tabuleiro[1][i]) && tabuleiro[1][i].equals(tabuleiro[2][i])) {
                return true;
            }
        }
        if (tabuleiro[0][0].equals(tabuleiro[1][1]) && tabuleiro[1][1].equals(tabuleiro[2][2])) {
            return true;
        }
        if (tabuleiro[0][2].equals(tabuleiro[1][1]) && tabuleiro[1][1].equals(tabuleiro[2][0])) {
            return true;
        }
        return false;
    }

    }
