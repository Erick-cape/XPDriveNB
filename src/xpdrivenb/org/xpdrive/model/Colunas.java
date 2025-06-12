package xpdrivenb.org.xpdrive.model;

public enum Colunas {
    NOME,
    TIPO,
    VALOR,
    QUANTIDADE,
    INVALIDO;

    Colunas() {
    }

    public Colunas atributo(int escolha) {
        switch (escolha) {
            case 1:
                return NOME;
            case 2:
                return TIPO;
            case 3:
                return VALOR;
            case 4:
                return QUANTIDADE;
            default:
                return INVALIDO;
        }
    }
}
