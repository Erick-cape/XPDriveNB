package xpdrivenb.org.xpdrive.dao;

import xpdrivenb.org.xpdrive.conexão.Conexao;
import xpdrivenb.org.xpdrive.model.Colunas;
import xpdrivenb.org.xpdrive.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ProdutoDAO {


    public void inserir(Produto p) {
        String sql = "INSERT INTO produtos (nome, tipo, valor, quantidade) VALUES (?, ?, ?, ?)";

        try (
                //.
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTipo());
            stmt.setDouble(3, p.getValor());
            stmt.setInt(4, p.getQuantidade()); //.
            stmt.executeUpdate();
            System.out.println("Registro incluido com sucesso!!!");
        } catch (SQLException exception) {
            System.out.println("Erro ao inserir veiculo: " + exception.getMessage());
        }
    }

    public void listar() {
        ArrayList<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try {
            //.
            Connection conn = Conexao.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("tipo"),
                        rs.getDouble("valor"),
                        rs.getInt("quantidade"));
                lista.add(p);
            }
        } catch (SQLException exception) {
            System.out.println("Um erro ocorreu: " + exception.getMessage());
        }
        System.out.println("CODIGO - NOME - TIPO - VALOR - QUANTIDADE");
        for (Produto p : lista) {
            System.out.println(p.getId() + "    " +  p.getNome() + "    " + p.getTipo() + "    " + p.getValor() + "    " + p.getQuantidade());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM produtos WHERE id=?";
        try (

                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Erro ao excluir o produto: " + exception.getMessage());
        }
        System.out.println("Registro exluído com sucesso!!!");
    }

    public void alterar(int id, String atributo, Colunas coluna) {
        switch (coluna) {
            case NOME:
                String sql = "UPDATE produtos SET nome=? WHERE id=?";

                try (
                        Connection conn = Conexao.conectar();
                        PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setString(1, atributo);
                    stmt.setInt(2, id);
                    stmt.executeUpdate();

                    System.out.println("Produto alterado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Um erro ocorreu: " + e.getMessage());
                }
                break;

            case TIPO:
                sql = "UPDATE produtos SET tipo=? WHERE id=?";

                try (
                        Connection conn = Conexao.conectar();
                        PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setString(1, atributo);
                    stmt.setInt(2, id);
                    stmt.executeUpdate();

                    System.out.println("Produto alterado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Um erro ocorreu: " + e.getMessage());
                }
                break;

            case VALOR:
                sql = "UPDATE produtos SET valor=? WHERE id=?";

                try (
                        Connection conn = Conexao.conectar();
                        PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setDouble(1, Double.parseDouble(atributo));
                    stmt.setInt(2, id);
                    stmt.executeUpdate();

                    System.out.println("Produto alterado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Um erro ocorreu: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Atributo deve ser um número!");
                }
                break;

            case QUANTIDADE:
                sql = "UPDATE produtos SET quantidade=? WHERE id=?";

                try (
                    Connection conn = Conexao.conectar();
                    PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setInt(1, Integer.parseInt(atributo));
                    stmt.setInt(2, id);
                    stmt.executeUpdate();

                    System.out.println("Produto alterado com sucesso!");
                } catch (SQLException e) {
                    System.out.println("Um erro ocorreu: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Atributo deve ser um número!");
                }
                break;

            default:
                break;
        }
    }
}
