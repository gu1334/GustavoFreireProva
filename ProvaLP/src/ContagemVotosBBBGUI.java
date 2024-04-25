import javax.swing.JOptionPane;
import java.util.ArrayList;



public class ContagemVotosBBBGUI {
    public static void main(String[] args) {
        ArrayList<Jogador> participantes = cadastrarParticipantes();

        while (true) {
            String votoEm = JOptionPane.showInputDialog("Em quem você vota?");
            if (votoEm == null || votoEm.equalsIgnoreCase("sair")) {
                break;
            }
            contabilizarVoto(participantes, votoEm);
        }

        Jogador eliminado = encontrarEliminado(participantes);
        if (eliminado != null) {
            String mensagemEliminacao = " pessoa que saiu: " + eliminado.getNome();
            JOptionPane.showMessageDialog(null, mensagemEliminacao);
        }
    }

    private static ArrayList<Jogador> cadastrarParticipantes() {
        ArrayList<Jogador> participantes = new ArrayList<>();
        String[] nomes = {
                "Alane Dias", "Beatriz Reis", "Davi Brito", "Deniziane Ferreira", "Fernanda Bande",
                "Giovanna Lima", "Giovanna Pitel", "Isabelle Nogueira", "Juninho", "Leidy Elin",
                "Lucas Henrique", "Lucas Luigi", "Lucas Pizane", "Marcus Vinicius", "Matteus Amaral",
                "Maycon Cosmer", "MC Bin Laden", "Michel Nogueira", "Nizam", "Raquele Cardozo",
                "Rodriguinho", "Thalyta Alves", "Vanessa Lopes", "Vinicius Rodrigues", "Wanessa Camargo",
                "Yasmin Brunet"
        };

        for (String nome : nomes) {
            participantes.add(new Jogador(nome));
        }

        return participantes;
    }

    private static void contabilizarVoto(ArrayList<Jogador> participantes, String nomeVotado) {
        for (Jogador jogador : participantes) {
            if (jogador.getNome().equalsIgnoreCase(nomeVotado)) {
                jogador.incrementaUmVoto();
                JOptionPane.showMessageDialog(null, "Voto para " + jogador.getNome());
                return;
            }
        }
    }

    private static Jogador encontrarEliminado(ArrayList<Jogador> participantes) {
        Jogador eliminado = null;
        int maxVotos = 0;

        for (Jogador jogador : participantes) {
            if (jogador.getVotos() > maxVotos) {
                maxVotos = jogador.getVotos();
                eliminado = jogador;
            }
        }

        return eliminado;
    }
}
