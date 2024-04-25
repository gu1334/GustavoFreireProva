import java.util.ArrayList;
import java.util.Scanner;

// Classe para representar um jogador/participante


public class Jogador extends Pessoas {


    public Jogador(String nome) {
        super(nome);
    }

    public static void main(String[] args) {
        ArrayList<Jogador> participantes = cadastrarParticipantes();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite 'sair' para encerrar a votação.");
        System.out.println("Em quem você vota para sair da casa?");

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
            System.out.println("Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami,");
            System.out.println("se eu conseguir domar o sol, se eu conseguir fazer o mar virar sertão,");
            System.out.println("e o sertão virar mar, se eu conseguir dizer o que eu nunca vou conseguir dizer,");
            System.out.println("aí terá chegado o dia em que eu vou conseguir te eliminar com alegria.");
            System.out.println("Com " + eliminado.getVotos() + " votos, é você quem sai " + eliminado.getNome());
        }
    }

    // Método para cadastrar os participantes
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

    // Método para contabilizar um voto para um jogador específico
    private static void contabilizarVoto(ArrayList<Jogador> participantes, String nomeVotado) {
        for (Pessoas pessoas : participantes) {
            if (pessoas.getNome().equalsIgnoreCase(nomeVotado)) {
                pessoas.incrementaUmVoto();
                System.out.println("Voto computado para " + pessoas.getNome());
                return;
            }
        }
        System.out.println("Participante não encontrado.");
    }

    // Método para encontrar o jogador mais votado
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
