import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MyListener extends minhaGramaticaBaseListener {

    // Tabela de símbolos global
    private Map<String, String> tabelaSimbolos = new HashMap<>();
    // Pilha de escopos para gerenciar variáveis locais
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
        if (!escopos.isEmpty()) {
            escopos.pop();
        }
    }

    // Verifica se uma variável está declarada no escopo atual ou superior
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

    // Obtém o tipo de uma expressão
// Método para obter o tipo de uma expressão
private String getTipoDaExpressao(minhaGramaticaParser.ExpressaoContext ctx) {
    if (ctx instanceof minhaGramaticaParser.NExpressaoContext) {
        minhaGramaticaParser.NExpressaoContext nExpr = (minhaGramaticaParser.NExpressaoContext) ctx;
        
        // Verifica se a expressão é composta por termos
        if (nExpr.termo() != null && !nExpr.termo().isEmpty()) {
            return getTipoDaExpressao(nExpr.termo(0));
        }
    }
    return "undefined"; // Caso não seja possível determinar o tipo
}

// Método para obter o tipo de um termo
private String getTipoDaExpressao(minhaGramaticaParser.TermoContext ctx) {
    if (ctx.fator() != null && !ctx.fator().isEmpty()) {
        return getTipoDaExpressao(ctx.fator(0));
    }
    return "undefined";
}

// Método para obter o tipo de um fator
private String getTipoDaExpressao(minhaGramaticaParser.FatorContext ctx) {
    if (ctx.NUM() != null) {
        String num = ctx.NUM().getText();
        return num.contains(",") ? "float" : "int"; // Determina se é float ou int
    }
    if (ctx.VALOR_BOOL() != null) return "bool";
    if (ctx.STRING_LITERAL() != null) return "str";
    if (ctx.ID() != null) return getTipoDaVariavel(ctx.ID().getText());
    return "undefined";
}


    // Verifica declarações de variáveis
    @Override
    public void exitNDeclaracaoVar(minhaGramaticaParser.NDeclaracaoVarContext ctx) {
        String id = ctx.ID().getText();
        String tipo = ctx.TIPO() != null ? ctx.TIPO().getText() : "undefined";

        if (escopos.peek().containsKey(id)) {
            System.out.println("Erro: Declaração duplicada de variável '" + id + "'.");
        } else {
            escopos.peek().put(id, tipo);
            tabelaSimbolos.put(id, tipo); // Armazena na tabela global
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
        novoEscopo();
    }

    // Gerenciamento de escopo ao sair de uma função
    @Override
    public void exitFuncao(minhaGramaticaParser.FuncaoContext ctx) {
        fecharEscopo();
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
