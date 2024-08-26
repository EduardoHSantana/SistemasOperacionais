package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {
    public static void main(String[] args) {
        RedesController redesController = new RedesController();

        String[] opcoes = {"Configuração de IP", "Ping", "Sair"};
        int escolha;

        do {
            escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu de Rede",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0: // Configuração de IP
                    redesController.ip();
                    break;
                case 1: // Ping
                    redesController.ping();
                    break;
                case 2: // Sair
                    JOptionPane.showMessageDialog(null, "Saindo do programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }

        } while (escolha != 2);
    }
}