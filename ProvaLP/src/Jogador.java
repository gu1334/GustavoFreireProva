import java.util.ArrayList;
import java.util.Scanner;



public class Jogador extends Pessoas {


    public Jogador(String nome) {
        super(nome);
    }

    public static void main(String[] args) {
        ArrayList<Jogador> participantes = cadastrarParticipantes();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Em quem você vota?");

        while (true) {
            String voto = scanner.nextLine();
            if (voto.equalsIgnoreCase("sair")) {
                break;
            }
            contabilizarVoto(participantes, voto);
        }

        scanner.close();

        Pessoas eliminado = encontrarEliminado(participantes);
        if (eliminado != null) {

            System.out.println(" pessoa que saiu " + eliminado.getNome());
        }
    }

    static ArrayList<Jogador> cadastrarParticipantes() {
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
        for (Pessoas pessoas : participantes) {
            if (pessoas.getNome().equalsIgnoreCase(nomeVotado)) {
                pessoas.incrementaUmVoto();
                System.out.println("Voto " + pessoas.getNome());
                return;
            }
        }

    }

    private static Pessoas encontrarEliminado(ArrayList<Jogador> participantes) {
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
