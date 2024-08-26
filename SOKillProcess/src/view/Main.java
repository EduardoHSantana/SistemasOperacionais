package view;

import javax.swing.JOptionPane;
import controller.KillController;

public class Main {
    public static void main(String[] args) {
        KillController killController = new KillController();

        String[] opcoes = {"Listar Processos", "Matar por PID", "Matar por Nome", "Sair"};
        int escolha;

        do {
            escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Gerenciador de Processos",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0: // Listar Processos
                    killController.listaProcessos();
                    break;
                case 1: // Matar processo por PID
                    String pidStr = JOptionPane.showInputDialog("Informe o PID do processo a ser finalizado:");
                    if (pidStr != null && !pidStr.isEmpty()) {
                        int pid = Integer.parseInt(pidStr);
                        killController.mataPid(pid);
                    }
                    break;
                case 2: // Matar processo por Nome
                    String nome = JOptionPane.showInputDialog("Informe o nome do processo a ser finalizado:");
                    if (nome != null && !nome.isEmpty()) {
                        killController.mataNome(nome);
                    }
                    break;
                case 3: // Sair
                    JOptionPane.showMessageDialog(null, "Saindo do programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }

        } while (escolha != 3);
    }
}