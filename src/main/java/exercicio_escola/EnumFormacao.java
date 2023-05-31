package exercicio_escola;

public enum EnumFormacao {
    GRADUACAO(1),
    ESPECIALIZACAO(2),
    POS_GRADUACAO(3);

    private final int valor;

    EnumFormacao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
