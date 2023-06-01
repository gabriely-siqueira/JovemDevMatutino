package exercicio_farmacia;

import java.util.ArrayList;
import java.util.List;

public class Util {
    private  List<Produto> produtos = new ArrayList<>();
    private  List<Cliente> clientes = new ArrayList<>();

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public  void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public  List<Produto> getProdutos() {
        return produtos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public boolean realizarVenda(Cliente cliente, Produto produto, Integer quantidade, String nomeMedico) {
        if (!clientes.contains(cliente) || !produtos.contains(produto)) {
            return false;
        }

        if (produto instanceof Medicamento) {
            Medicamento medicamento = (Medicamento) produto;
            if (medicamento.isRetencaoReceita() && nomeMedico == null) {
                return false;
            }
        }

        if (!produto.venda(cliente, quantidade)) {
            return false;
        }

        return true;
    }
}
