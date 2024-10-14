import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class ExemploLexer {
    // Código de escape ANSI para texto vermelho
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m"; // Resetar para a cor padrão

    public static void main(String[] args) {
        String filename = "Codigo.txt";
        try {
            CharStream input = CharStreams.fromFileName(filename);
            minhaGramaticaLexer lexer = new minhaGramaticaLexer(input);
            Token token;
            int contadorErros = 0;

            while (!lexer._hitEOF) {
                token = lexer.nextToken();

                // Checa se o token é do tipo 'ErrorChar'
                if (token.getType() == minhaGramaticaLexer.ErrorChar) { 
                    System.out.println(RED + "Erro! Lexema inválido: " + token.getText() + "\nLinha: " + token.getLine() + "\n" + RESET);
                    contadorErros++;
                } else {
                    System.out.println("Token: " + token.toString());
                    System.out.println("   Lexema: " + token.getText());
                    System.out.println("   Tipo: " + lexer.getVocabulary().getDisplayName(token.getType()) + "\n");
                }
            }

            // Imprime o total de erros encontrados
            System.out.println("\n----- TOTAL DE ERROS ENCONTRADOS: " + contadorErros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

