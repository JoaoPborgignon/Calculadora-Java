import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GUI {
    int operation = 0;
    int valor1;
    private ArrayList<Integer> valores = new ArrayList<>();
    private JTextArea areaTexto;
    public static void main(String[] args) {
        // Executar a GUI em uma thread separada (boa prática para Swing)
        SwingUtilities.invokeLater(() -> {
            new GUI().criarJanela();
        });
    }

    // Método para criar a janela principal
    public void criarJanela() {
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(400, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout()); // Usando GridBagLayout

        adicionarBotoes(frame); // Método separado para adicionar os botões
        adicionarAreaTexto(frame); //metodo separado para adicionar o texto
        frame.setVisible(true);
    }

    // Método para adicionar os botões
    private void adicionarBotoes(JFrame frame) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Preencher a célula
        gbc.insets = new Insets(3, 3, 3, 3); // Margem ao redor dos botões
        gbc.weightx = 1; // Deixa os botões expansíveis horizontalmentec
        gbc.weighty = 1; // Deixa os botões expansíveis verticalmente

        // Botão 1
        JButton botao1 = new JButton("1");
        gbc.gridx = 0; 
        gbc.gridy = 3;
        frame.add(botao1, gbc);
        // Adiciona ação ao botão 1
        botao1.addActionListener(e -> {
            valores.add(1); 
            System.out.println("Vetor atual: " + valores);
            atualizarTexto();
        });

        // Botão 2
        JButton botao2 = new JButton("2");
        gbc.gridx = 1; 
        gbc.gridy = 3;
        frame.add(botao2, gbc);
        // Adiciona ação ao botão 2
        botao2.addActionListener(e -> {
            valores.add(2); 
            System.out.println("Vetor atual: " + valores);
            atualizarTexto();
        });

        // Botão 3
        JButton botao3 = new JButton("3");
        gbc.gridx = 2; 
        gbc.gridy = 3; 
        frame.add(botao3, gbc);
        // Adiciona ação ao botão 3
        botao3.addActionListener(e -> {
            valores.add(3); 
            System.out.println("Vetor atual: " + valores);
            atualizarTexto();
        });

        // Botão 4
        JButton botao4 = new JButton("4");
        gbc.gridx = 0; 
        gbc.gridy = 2;
        frame.add(botao4, gbc);
        // Adiciona ação ao botão 4
        botao4.addActionListener(e -> {
            valores.add(4); 
            System.out.println("Vetor atual: " + valores);
            atualizarTexto();
        });

        // Botão 5
        JButton botao5 = new JButton("5");
        gbc.gridx = 1; 
        gbc.gridy = 2;
        frame.add(botao5, gbc);
        botao5.addActionListener(e -> {
            valores.add(5); 
            System.out.println("Vetor atual: " + valores);
            atualizarTexto();
        });

        // Botão 6
        JButton botao6 = new JButton("6");
        gbc.gridx = 2; 
        gbc.gridy = 2; 
        frame.add(botao6, gbc);
        botao6.addActionListener(e -> {
            valores.add(6); 
            System.out.println("Vetor atual: " + valores);
            atualizarTexto();
        });

        // Botão 7
        JButton botao7 = new JButton("7");
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        frame.add(botao7, gbc);
        botao7.addActionListener(e -> {
            valores.add(7); 
            System.out.println("Vetor atual: " + valores);
            atualizarTexto();
        });

        // Botão 8
        JButton botao8 = new JButton("8");
        gbc.gridx = 1; 
        gbc.gridy = 1; 
        frame.add(botao8, gbc);
        botao8.addActionListener(e -> {
            valores.add(8); 
            System.out.println("Vetor atual: " + valores);
            atualizarTexto();
        });

        // Botão 9
        JButton botao9 = new JButton("9");
        gbc.gridx = 2; 
        gbc.gridy = 1; 
        frame.add(botao9, gbc); 
        botao9.addActionListener(e -> {
            valores.add(9); 
            System.out.println("Vetor atual: " + valores);
            atualizarTexto();
        });

        // Botão 0
        JButton botao0 = new JButton("0");
        gbc.gridx = 1; 
        gbc.gridy = 4; 
        frame.add(botao0, gbc); 
        botao0.addActionListener(e -> {
            valores.add(0); 
            System.out.println("Vetor atual: " + valores);
            atualizarTexto();
        });

        // Botão clear
        JButton botaoclear = new JButton("Clear");
        gbc.gridx = 0; 
        gbc.gridy = 4; 
        frame.add(botaoclear, gbc); 
        botaoclear.addActionListener(e -> {
            operation_control(" ");
            valores.clear();
            atualizarTexto();
        });     

        // Botão +
        JButton botao_soma = new JButton("+");
        gbc.gridx = 4; 
        gbc.gridy = 3; 
        frame.add(botao_soma, gbc); 
        botao_soma.addActionListener(e -> {
            operation_control("Soma");
            valor1 = concatenar(valores);
            valores.clear();
        });

        // Botão -
        JButton botao_subt = new JButton("-");
        gbc.gridx = 4; 
        gbc.gridy = 2; 
        frame.add(botao_subt, gbc); 
        botao_subt.addActionListener(e -> {
            operation_control("Subt");
            valor1 = concatenar(valores);
            valores.clear();
        });

        // Botão *
        JButton botao_mult = new JButton("*");
        gbc.gridx = 4; 
        gbc.gridy = 1; 
        frame.add(botao_mult, gbc); 
        botao_mult.addActionListener(e -> {
            operation_control("Mult");
            valor1 = concatenar(valores);
            valores.clear();
        });
                
         // Botão =
         JButton botao_igual = new JButton("=");
         gbc.gridx = 4; 
         gbc.gridy = 4; 
         frame.add(botao_igual, gbc); 
         botao_igual.addActionListener(e -> {
             int valor2 = concatenar(valores);
             int resultado;
             valores.clear();
             switch (operation) {
                case 1:
                    resultado = valor1 + valor2;
                    valores.add(resultado); 
                    break;
                case 2:
                    resultado = valor1 - valor2;
                    valores.add(resultado); 
                    break;
                case 3:
                resultado = valor1 * valor2;
                valores.add(resultado); 
                break;
                default:
                    break;
             }
             atualizarTexto();
         });       
    }

    private void adicionarAreaTexto(JFrame frame) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4; // Ocupa 4 colunas
        gbc.weightx = 1;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3, 3, 3, 3);
    
        areaTexto = new JTextArea();
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 24)); 
        areaTexto.setEditable(false);

        frame.add(areaTexto, gbc); // Adiciona diretamente ao frame
    }
    
    
    private void atualizarTexto() {
        StringBuilder sb = new StringBuilder(); // Cria um acumulador de texto
    
        for (int i = 0; i < valores.size(); i++) {
            sb.append(valores.get(i)).append("");
        }
        areaTexto.setText(sb.toString()); // Agora sim, define o texto completo
    }

    private int concatenar(ArrayList<Integer> vet){
        if (vet.isEmpty()) return 0;
        StringBuilder sb = new StringBuilder();
        for (int n : vet) {
            sb.append(n);  // Vai juntar tudo como texto
        }
        int numeroFinal = Integer.parseInt(sb.toString());
        return numeroFinal;
    }


    private void operation_control(String ope){
        operation = 0;
        switch (ope) {
            case "Soma":
                operation = 1;
                break;
            case "Subt":
                operation = 2;
                break;

            case "Mult":
            operation = 3;
            break; 
            default:
                operation = 1;
                break;
        }
    }
}