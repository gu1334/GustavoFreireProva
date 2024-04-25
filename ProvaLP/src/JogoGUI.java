import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class JogoGUI extends JFrame {
    ArrayList<Jogador> participantes = Jogador.cadastrarParticipantes();
    private JPanel painel = new JPanel();
    private Button adicionar = new Button("votar");


    private Button confirmarButton;

    public JogoGUI(){
        this.setTitle("BBB");
        this.setSize(500,500);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 40));
        painel.setBackground(new Color(249, 251, 255));
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                adicionarConvidos(participantes);
            }
        });

        painel.add(adicionar);



        this.getContentPane().add(painel);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true); // Exibir janela
        confirmarButton.addMouseListener(new MouseAdapter() {
        });
    }
    private void adicionarConvidos(ArrayList<Jogador> listaDeConvidados) {

        String nome = JOptionPane.showInputDialog(null,"Nome do convidado (a) - Atenção : O NOME DEVE ESTAR COMPLETO");
        String tipoConvidado = JOptionPane.showInputDialog(null, "Tipo de convidado ( Familiar - Amigos - Madrinhas - Padrinhos");
        String telefone = JOptionPane.showInputDialog(null,"Número de telefone :");
        String endereco = JOptionPane.showInputDialog(null, "Endereço :");


        Pessoas objConvidados = new Pessoas(nome,tipoConvidado,telefone,endereco);
        participantes.add(objConvidados);

    }



    public static void main(String[] args) {
        new JogoGUI();
    }

}
