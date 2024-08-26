package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RedesController {

    // método para identificar o sistema operacional
    private String os() {
        return System.getProperty("os.name");
    }

    // método para configurar ip
    public void ip() {
        String sistemaOperacional = os();
        String comando = "";

        if (sistemaOperacional.contains("Windows")) {
            comando = "ipconfig";
        } else if (sistemaOperacional.contains("Linux")) {
            comando = "ifconfig"; // ou "ip addr"
        }

        try {
            @SuppressWarnings("deprecation")
			Process processo = Runtime.getRuntime().exec(comando);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;

            while ((linha = leitor.readLine()) != null) {
                if (linha.contains("IPv4")) {
                    // nome do adaptador de rede e o IPv4
                    System.out.println(linha);
                }
            }
            leitor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // método para ping 
    public void ping() {
        String sistemaOperacional = os();
        String comando = "";

        if (sistemaOperacional.contains("Windows")) {
            comando = "ping -4 -n 10 www.google.com.br";
        } else if (sistemaOperacional.contains("Linux")) {
            comando = "ping -4 -c 10 www.google.com.br";
        }

        try {
            @SuppressWarnings("deprecation")
			Process processo = Runtime.getRuntime().exec(comando);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            String tempoMedio = "";

            while ((linha = leitor.readLine()) != null) {
                if (linha.contains("Média") || linha.contains("avg")) {
                    // tempo médio do ping
                    tempoMedio = linha;
                }
            }
            leitor.close();

            if (!tempoMedio.isEmpty()) {
                System.out.println("Tempo médio do ping: " + tempoMedio);
            } else {
                System.out.println("Não foi possível determinar o tempo médio do ping.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}