package xpdrivenb.org.xpdrive.control;

import xpdrivenb.org.xpdrive.model.Colunas;
import xpdrivenb.org.xpdrive.model.Produto;

public class XPDriverController {
    public void cadastrar(Produto produto) {
        Produto p = new Produto();
        p.inserir(produto);
    }

    public void alterar(int id, String atributo ,Colunas coluna) {
        Produto p = new Produto();
        p.alterar(id, atributo, coluna);
    }

    public void excluir(int id) {
        Produto p = new Produto();
        p.excluir(id);
    }

    public void listar() {
        Produto p = new Produto();
        p.listar();
    }
}