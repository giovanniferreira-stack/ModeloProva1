package model;

public abstract class ControleJogo {

    protected long tempoInicio;//Inicia o contador de tempo de partida
    protected char[] tabuleiro;//Armazena as jogadas da partida

    public abstract void iniciarPartida();

    public abstract void adicionarMovimento(Character letra, int pos);

    public abstract long getDuracaoPartida();

    public abstract char avaliarPartida();
}
