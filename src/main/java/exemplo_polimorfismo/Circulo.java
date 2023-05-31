package exemplo_polimorfismo;

public class Circulo extends Forma {

	public Circulo() {
		super("Circulo");
	
	}
	@Override
	public String desenhar() {
		// TODO Auto-generated method stub
		return "Sou um círculo e tenho meu próprio desenho";
	}
	public String calculaArea() {
		return "minha área pode ser calculada";
	}
}
