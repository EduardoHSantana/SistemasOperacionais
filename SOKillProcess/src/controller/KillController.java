package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KillController {

    // Método privado para identificar o sistema operacional
    private String os() {
        return System.getProperty("os.name");
    }

    // Método para listar os processos ativos
    public void listaProcessos() {
        String sistemaOperacional = os();
        String comando = "";

        if (sistemaOperacional.contains("Windows")) {
            comando = "TASKLIST /FO TABLE";
        } else if (sistemaOperacional.contains("Linux")) {
            comando = "ps -ef";
        }

        try {
            @SuppressWarnings("deprecation")
			Process processo = Runtime.getRuntime().exec(comando);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;

            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
            leitor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // método para matar processo pelo pid
    @SuppressWarnings("deprecation")
	public void mataPid(int pid) {
        String sistemaOperacional = os();
        String comando = "";

        if (sistemaOperacional.contains("Windows")) {
            comando = "TASKKILL /PID " + pid;
        } else if (sistemaOperacional.contains("Linux")) {
            comando = "kill -9 " + pid;
        }

        try {
            Runtime.getRuntime().exec(comando);
            System.out.println("Processo " + pid + " finalizado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // método para matar processo pelo nome
    @SuppressWarnings("deprecation")
	public void mataNome(String nome) {
        String sistemaOperacional = os();
        String comando = "";

        if (sistemaOperacional.contains("Windows")) {
            comando = "TASKKILL /IM " + nome;
        } else if (sistemaOperacional.contains("Linux")) {
            comando = "pkill -f " + nome;
        }

        try {
            Runtime.getRuntime().exec(comando);
            System.out.println("Processo " + nome + " finalizado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}