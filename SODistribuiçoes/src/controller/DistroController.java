package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DistroController {

    // Método privado para identificar o sistema operacional
    private String os() {
        return System.getProperty("os.name");
    }

    // método distribuição linux
    public void exibeDistro() {
        String sistemaOperacional = os();

        if (sistemaOperacional.contains("Linux")) {
            String comando = "cat /etc/os-release";

            try {
                @SuppressWarnings("deprecation")
				Process processo = Runtime.getRuntime().exec(comando);
                BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
                String linha;
                String nomeDistro = "";
                String versaoDistro = "";

                while ((linha = leitor.readLine()) != null) {
                    if (linha.startsWith("NAME=")) {
                        nomeDistro = linha.split("=")[1].replace("\"", ""); // nome da distro
                    } else if (linha.startsWith("VERSION=")) {
                        versaoDistro = linha.split("=")[1].replace("\"", ""); // versão da distro
                    }
                }
                leitor.close();

                System.out.println("Distribuição Linux: " + nomeDistro);
                System.out.println("Versão: " + versaoDistro);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O sistema operacional não é Linux.");
        }
    }
}