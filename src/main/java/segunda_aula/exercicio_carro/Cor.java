package segunda_aula.exercicio_carro;

enum Cor {
	VERMELHO(1,"Vermelho"), AZUL(2,"Azul"), AMARELO(3,"Amarelo"), VERDE(4,"Verde"), PRETO(5,"Preto"), BRANCO(6,"Branco");

	public String descricao;
	public int codigo;

	private Cor(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
}
