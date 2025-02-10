import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MyListener extends minhaGramaticaBaseListener {

    // Tabela de símbolos para armazenar variáveis e seus tipos
    private Map<String, String> tabelaSimbolos = new HashMap<>();
    // Pilha de escopos para gerenciar variáveis em diferentes escopos
    private Stack<Map<String, String>> escopos = new Stack<>();

    // Construtor: Inicializa a pilha de escopos com o escopo global
    public MyListener() {
        novoEscopo(); // Cria o escopo global
    }

    // Adiciona um novo escopo à pilha
    private void novoEscopo() {
        escopos.push(new HashMap<>());
    }

    // Remove o escopo atual da pilha
    private void fecharEscopo() {
        escopos.pop();
    }

    // Verifica se uma variável está declarada no escopo atual ou em escopos superiores
    private boolean varNoEscopo(String id) {
        for (Map<String, String> escopo : escopos) {
            if (escopo.containsKey(id)) {
                return true;
            }
        }
        return false;
    }

    // Obtém o tipo de uma variável
    private String getTipoDaVariavel(String id) {
        for (Map<String, String> escopo : escopos) {
            if (escopo.containsKey(id)) {
                return escopo.get(id);
            }
        }
        return "undefined"; // Retorna "undefined" se a variável não for encontrada
    }

    // Método para obter o tipo de uma expressão
    private String getTipoDaExpressao(minhaGramaticaParser.NExpressaoContext ctx) {
        // Verifica se a expressão contém um número
        if (ctx.NUM() != null) {
            String num = ctx.NUM().getText();
            // Verifica se o número é inteiro ou decimal
            if (num.contains(",")) {
                return "float"; // Número decimal
            } else {
                return "int"; // Número inteiro
            }
        }
        // Verifica se a expressão contém um valor booleano
        if (ctx.VALOR_BOOL() != null) {
            return "bool";
        }
        // Verifica se a expressão contém uma string
        if (ctx.STRING_LITERAL() != null) {
            return "str";
        }
        // Verifica se a expressão contém uma variável
        if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            return getTipoDaVariavel(id);
        }
        // Verifica se a expressão contém uma operação
        if (ctx.termo() != null && ctx.termo().size() > 1) {
            // Verifica os tipos dos operandos
            String tipoEsquerdo = getTipoDaExpressao(ctx.termo(0).fator(0));
            String tipoDireito = getTipoDaExpressao(ctx.termo(1).fator(0));
            if (!tipoEsquerdo.equals(tipoDireito)) {
                System.out.println("Erro: Tipos incompatíveis na operação.");
            }
            return tipoEsquerdo; // Retorna o tipo do operando esquerdo
        }
        return "undefined"; // Tipo não determinado
    }

    // Verifica declarações duplicadas de variáveis
    @Override
    public void exitNDeclaracaoVar(minhaGramaticaParser.NDeclaracaoVarContext ctx) {
        String id = ctx.ID().getText();
        if (escopos.peek().containsKey(id)) {
            System.out.println("Erro: Declaração duplicada de variável '" + id + "'.");
        } else {
            escopos.peek().put(id, ctx.TIPO().getText()); // Armazena a variável no escopo atual
        }
    }

    // Verifica atribuições de variáveis
    @Override
    public void exitNAtribuicao(minhaGramaticaParser.NAtribuicaoContext ctx) {
        String id = ctx.ID().getText();
        if (!varNoEscopo(id)) {
            System.out.println("Erro: Variável '" + id + "' não declarada.");
        } else {
            String tipoVar = getTipoDaVariavel(id);
            String tipoExpr = getTipoDaExpressao(ctx.expressao());
            if (!tipoVar.equals(tipoExpr)) {
                System.out.println("Erro: Tipos incompatíveis na atribuição de '" + id + "'.");
            }
        }
    }

    // Gerenciamento de escopo ao entrar em uma função
    @Override
    public void enterFuncao(minhaGramaticaParser.FuncaoContext ctx) {
        novoEscopo(); // Cria um novo escopo para a função
    }

    // Gerenciamento de escopo ao sair de uma função
    @Override
    public void exitFuncao(minhaGramaticaParser.FuncaoContext ctx) {
        fecharEscopo(); // Remove o escopo da função
    }

    // Verifica chamadas de função
    @Override
    public void exitChamada_funcao(minhaGramaticaParser.Chamada_funcaoContext ctx) {
        String funcao = ctx.ID().getText();
        if (!varNoEscopo(funcao)) {
            System.out.println("Erro: Função '" + funcao + "' não declarada.");
        }
    }

    // Retorna a tabela de símbolos
    public Map<String, String> getTabelaSimbolos() {
        return tabelaSimbolos;
    }
}