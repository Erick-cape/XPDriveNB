package xpdrivenb.org.xpdrive.model;

import xpdrivenb.org.xpdrive.dao.ProdutoDAO;

public class Produto {
    private int id;
    private String nome;
    private String tipo;
    private double valor;
    private int quantidade;

    public Produto() {
        this.id = 0;
        this.nome = " ";
        this.tipo = " ";
        this.valor = 0.0d;
        this.quantidade = 0;
    }

    public Produto(String nome, String tipo, double valor, int quantidade) {
        this.id = 0;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Produto(int id, String nome, String tipo, double valor, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantiade) {
        this.quantidade = quantiade;
    }

    public void inserir(Produto p) {
        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.inserir(p);
    }

    public void alterar(int id, String atributo, Colunas coluna) {
        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.alterar(id, atributo, coluna);
    }

    public void excluir(int id) {
        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.excluir(id);
    }

    public void listar() {
        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.listar();
    }
}
