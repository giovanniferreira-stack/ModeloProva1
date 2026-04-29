package model;

/**
 *
 * @author m86390
 */
public class ControleJogoVelha extends ControleJogo {

    @Override
    public void iniciarPartida() {
        tabuleiro = "123456789".toCharArray();
        tempoInicio = System.currentTimeMillis();
        
    }
    
    @Override
    public void adicionarMovimento(Character letra, int pos) {
        tabuleiro[pos] = letra;
    }

    @Override
    public long getDuracaoPartida() {
        long agora = System.currentTimeMillis();
        return agora - tempoInicio;
    }

    @Override
    public char avaliarPartida() {
        int [][] combinacoes =  {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            
            {0,3,6},
            {1,4,7},
            {2,5,8},
            
            {0,4,8},
            {2,4,6}
        };
        
        for (int[] c : combinacoes) {

        if (tabuleiro[c[0]] != ' ' &&
            tabuleiro[c[0]] == tabuleiro[c[1]] &&
            tabuleiro[c[1]] == tabuleiro[c[2]]) {

            return tabuleiro[c[0]];
        }
        }
    boolean cheio = true;

        for (char c : tabuleiro){
        if (c == ' '){
            cheio = false;
            break;
        }
        }
        
        if (cheio){
            return 'E';
        }
        
        return 0;
    
    }
        
    public String getStatusPartida(){
        String ret ="";
        switch (avaliarPartida()) {
            case 'X':
                ret = "Jogador X Venceu";
                break;
            case 'O':
                ret = "Jogador O Venceu";
                break;
            case 'E':
                ret = "Partida Empatada";
                break;
            default:
                ret = "Partida em Andamento";
        }
        ret += String.format(" (%.2f segundos)", getDuracaoPartida()/1000.0);
        return ret;
    }
}
