// import antlr.GramaticaLexer;
// import antlr.GramaticaParser;
import java.io.IOException;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class AnalisadorSemantico {
    public static void main(String[] args) {
        // Parsing do arquivo de entrada
        minhaGramaticaParser parser = getParser("Codigo.txt");
        
        if (parser != null) {
            // Obter a árvore sintática
            ParseTree ast = parser.programa();

            System.out.println(ast.toStringTree(parser));
            
            // Iniciar o listener para análise semântica
            MyListener listener = new MyListener();

            ParseTreeWalker walker = new ParseTreeWalker();

            
            //percorre a ast com a nossa implementação do listener
            walker.walk(listener, ast);
            
            // Imprimir a tabela de símbolos
            System.out.println(listener.getTabelaSimbolos().toString());
        }
    }

    // Método para executar o lexer e o parser sobre o arquivo de entrada
    private static minhaGramaticaParser getParser(String fileName) {
        minhaGramaticaParser parser = null;
        try {
            CharStream input = CharStreams.fromFileName(fileName);
            minhaGramaticaLexer lexer = new minhaGramaticaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new minhaGramaticaParser(tokens);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parser;
    }
}
