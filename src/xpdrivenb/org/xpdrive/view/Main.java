package xpdrivenb.org.xpdrive.view;

import xpdrivenb.org.xpdrive.control.XPDriverController;
import xpdrivenb.org.xpdrive.model.Colunas;
import xpdrivenb.org.xpdrive.model.Produto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner cs = new Scanner(System.in);

    public static void main(String[] args) {
        XPDriverController controller = new XPDriverController();
        int opcao = 0;

        do {
            exibirMenu();
            opcao = cs.nextInt();
            limparBuffer();

            switch (opcao) {

                case 1:
                    System.out.println("Insira o nome do produto:");
                    String nome = cs.nextLine();
                    System.out.println("Insira o tipo do produto:");
                    String tipo = cs.nextLine();
                    System.out.println("Informe o valor do produto:");
                    String valor = cs.nextLine();
                    System.out.println("Informe a quantidade desejada:");
                    String quantidade = cs.nextLine();

                    try {
                        Produto p = new Produto(nome, tipo, Double.parseDouble(valor), Integer.parseInt(quantidade));
                        controller.cadastrar(p);
                    } catch (NumberFormatException e) {
                        System.out.println("Um ou mais atributos invalidos!");
                    }
                    break;

                case 2:
                    System.out.println("Insira o codigo do produto a alterar:");
                    String id = cs.nextLine();

                    System.out.println("Selecione qual atributo quer alterar");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Tipo");
                    System.out.println("3 - Valor");
                    System.out.println("4 - Quantiadade");
                    int alterarEscolha = 0;
                    Colunas coluna = Colunas.INVALIDO;

                    try {
                        alterarEscolha = cs.nextInt();
                        limparBuffer();
                    } catch (InputMismatchException e) {
                        System.out.println("Atributo deve ser um dos números acima.");
                        limparBuffer();
                    }

                    coluna = coluna.atributo(alterarEscolha);

                    if (coluna != Colunas.INVALIDO) {
                        System.out.println("Novo valor do atributo:");
                        String atributo = cs.nextLine();
                        try {
                            controller.alterar(Integer.parseInt(id), atributo, coluna);
                        } catch (NumberFormatException e) {
                            System.out.println("Codigo deve ser um número válido!");
                        }

                    } else {
                        System.out.println("Atributo escolhido é invalido.");
                    }
                    break;


                case 3:
                    System.out.println("Informe o codigo do produto a excluir: \n");
                    id = cs.nextLine();
                    try {
                        controller.excluir(Integer.parseInt(id));
                    } catch (NumberFormatException e) {
                        System.out.println("Codigo deve ser um numero valido!");
                    }

                    break;


                case 4:
                    System.out.println("Lista de produtos: \n");
                    controller.listar();
                    break;

                case 5:
                    System.out.println("Saindo... \n");
                    break;

                default:
                    System.out.println("Invalido! \n");
            }
        } while (opcao != 5);
        cs.close();
    }

    public static void exibirMenu() {
        System.out.println("\n =-=-=-=-=Menu=-=-=-=--=");
        System.out.println("1- Cadastrar produto");
        System.out.println("2- Alterar");
        System.out.println("3- Excluir produto");
        System.out.println("4- Listar");
        System.out.println("5- Sair");
    }

    public static void limparBuffer() {
        cs.nextLine();
    }
}

