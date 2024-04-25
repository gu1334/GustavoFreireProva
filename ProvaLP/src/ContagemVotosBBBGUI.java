import javax.swing.JOptionPane;
import java.util.ArrayList;



public class ContagemVotosBBBGUI {
    public static void main(String[] args) {
        ArrayList<Jogador> participantes = cadastrarParticipantes();

        // Loop para receber os votos em uma interface gráfica
        while (true) {
            String votoEm = JOptionPane.showInputDialog("Em quem você vota para sair da casa?");
            if (votoEm == null || votoEm.equalsIgnoreCase("sair")) {
                break;
            }
            contabilizarVoto(participantes, votoEm);
        }

        // Apuração da pessoa eliminada
        Jogador eliminado = encontrarEliminado(participantes);
        if (eliminado != null) {
            String mensagemEliminacao = "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami,\n"
                    + "se eu conseguir domar o sol, se eu conseguir fazer o mar virar sertão,\n"
                    + "e o sertão virar mar, se eu conseguir dizer o que eu nunca vou conseguir dizer,\n"
                    + "aí terá chegado o dia em que eu vou conseguir te eliminar com alegria.\n"
                    + "Com " + eliminado.getVotos() + " votos, é você quem sai " + eliminado.getNome();
            JOptionPane.showMessageDialog(null, mensagemEliminacao);
        }
    }

    // Método para cadastrar os participantes
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

    // Método para contabilizar um voto para um jogador específico
    private static void contabilizarVoto(ArrayList<Jogador> participantes, String nomeVotado) {
        for (Jogador jogador : participantes) {
            if (jogador.getNome().equalsIgnoreCase(nomeVotado)) {
                jogador.incrementaUmVoto();
                JOptionPane.showMessageDialog(null, "Voto computado para " + jogador.getNome());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Participante não encontrado. Voto não computado.");
    }

    // Método para encontrar o jogador mais votado
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
