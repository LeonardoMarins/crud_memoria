package br.com.leonardo.app;

import br.com.leonardo.dao.ClienteMapDAO;
import br.com.leonardo.dao.IClienteDAO;
import br.com.leonardo.domain.Cliente;

import javax.swing.*;

public class App {

	private static IClienteDAO iclienteDAO;

	public static void main(String[] args) {
		iclienteDAO = new ClienteMapDAO();

		String opcao = JOptionPane.showInputDialog(null,
				"digite 1 para cadastro, 2 para consultar," + " 3 para exclusao, 4 para alteraçao ou 5 para sair",
				"Green dinner", JOptionPane.INFORMATION_MESSAGE);

		while (!isOpcaoValida(opcao)) {
			if ("".equals(opcao)) {
				sair();
			}

			opcao = JOptionPane.showInputDialog(null,
					"opcao invalida digite 1 para cadastro, 2 para consultar,"
							+ " 3 para exclusao, 4 para alteraçao ou 5 para sair",
					"Green dinner", JOptionPane.INFORMATION_MESSAGE);
		}

		while (isOpcaoValida(opcao)) {
			if (isOpcaoSair(opcao)) {
				sair();
			} else if (isCadastro(opcao)) {
				String dados = JOptionPane.showInputDialog(null, "digite os dados separados por ,"
						+ "EX: nome, cpf, tel, end, numero,\r\n" + "			cidade, estado", "cadastro",
						JOptionPane.INFORMATION_MESSAGE);
				cadastrar(dados);

			} else if (isConsulta(opcao)) {
				String dados = JOptionPane.showInputDialog(null, "Digite o CPF para consulta", "consulta",
						JOptionPane.INFORMATION_MESSAGE);
				consultar(dados);
			} else if (isExclusao(opcao)) {
				String dados = JOptionPane.showInputDialog(null, "Digite o CPF para exclusao", "consulta",
						JOptionPane.INFORMATION_MESSAGE);
				excluir(dados);
			}

			opcao = JOptionPane.showInputDialog(null,
					"digite 1 para cadastro, 2 para consultar," + " 3 para exclusao, 4 para alteraçao ou 5 para sair",
					"Green dinner", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private static void excluir(String dados) {
		Long cpf = Long.valueOf(dados.trim());

		iclienteDAO.excluir(cpf);
		JOptionPane.showMessageDialog(null, "o cpf: " + cpf + "foi excluido com sucesso");

	}

	private static boolean isExclusao(String opcao) {
		if ("3".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static void consultar(String dados) {
		Long cpf = Long.valueOf(dados.trim());

		JOptionPane.showMessageDialog(null, iclienteDAO.consultar(cpf));

	}

	private static boolean isConsulta(String opcao) {
		if ("2".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static void cadastrar(String dados) {
		String[] dadosSeparados = dados.split(",");

		if (dadosSeparados.length == 7) {

			Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3],
					dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);

			Boolean isCadastrado = iclienteDAO.cadastrar(cliente);
			if (isCadastrado) {
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
			} else {
				JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, forneça todos os dados necessários.");
		}
	}

	private static boolean isCadastro(String opcao) {
		if ("1".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static boolean isOpcaoSair(String opcao) {
		if ("5".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static void sair() {
		JOptionPane.showMessageDialog(null, "Até logo", "sair", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);

	}

	private static boolean isOpcaoValida(String opcao) {
		if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
			return true;
		}
		return false;
	}

	private static boolean isOpcaoCadastro(String opcao) {
		if ("1".equals(opcao)) {
			return true;
		}

		return false;
	}

}
