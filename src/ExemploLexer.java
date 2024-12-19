import java.io.IOException;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;
import javax.swing.*;
import java.util.Arrays;
import java.awt.BorderLayout;


public class ExemploLexer {
    public static void main(String[] args) {
        String filename = "Codigo.txt";
        try {
            // Lê o arquivo de entrada
            CharStream input = CharStreams.fromFileName(filename);

            // Cria o lexer e o parser
            minhaGramaticaLexer lexer = new minhaGramaticaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            minhaGramaticaParser parser = new minhaGramaticaParser(tokens);

            // Chama a regra principal da gramática
            ParseTree ast = parser.programa();

            // Exibir a árvore em uma interface gráfica
            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), ast);
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(viewer, BorderLayout.CENTER);

            // Adiciona a barra de rolagem
            JScrollPane scrollPane = new JScrollPane(panel);

            // Cria o JFrame para exibir a árvore
            JFrame frame = new JFrame("Árvore Sintática");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(scrollPane);
            frame.setSize(700, 600);
            frame.setVisible(true);


            // Imprime a árvore sintática no terminal
            // System.out.println(ast.toStringTree(parser));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

