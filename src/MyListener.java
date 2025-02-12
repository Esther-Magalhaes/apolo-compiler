import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MyListener extends minhaGramaticaBaseListener {
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\033[34m";
    public static final String YELLOW = "\033[33m";
    public static final String RESET = "\u001B[0m";

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

    // Verifica declarações de variáveis
    @Override
    public void exitNDeclaracaoVar(minhaGramaticaParser.NDeclaracaoVarContext ctx) {
        String id = ctx.ID().getText();
        String tipoVar = ctx.TIPO() != null ? ctx.TIPO().getText() : "undefined";

        // Verifica se a variável já foi declarada no escopo atual
        if (escopos.peek().containsKey(id)) {
            System.out.println("\n" + YELLOW + "Erro: Declaração duplicada de variável '" + id + "'." + RESET + "\n");
        } else {
            // Obtém o tipo da expressão atribuída
            String tipoExpr = getTipoDaExpressao(ctx.expressao());

            // Verifica se o tipo da expressão é compatível com o tipo da variável
            if (!atribuicaoValida(tipoVar, tipoExpr, ctx.expressao())) {
                System.out.println("\n" + YELLOW + "Erro: A variável '" + id + "' é do tipo " + tipoVar +
                        " e não pode receber o valor do tipo " + tipoExpr + "." + RESET + "\n");
            } else {
                // Se for válido, adiciona a variável ao escopo atual
                escopos.peek().put(id, tipoVar);
                tabelaSimbolos.put(id, tipoVar); // Armazena na tabela global
            }
        }
        System.out.println(RED + "Saiu da regra: " + RESET + "NDeclaracaoVar (" + ctx.getText() + ")");
    }

    // Verifica atribuições de variáveis
    @Override
    public void exitNAtribuicao(minhaGramaticaParser.NAtribuicaoContext ctx) {
        String id = ctx.ID().getText();
        if (!varNoEscopo(id)) {
            System.out.println("\n" + YELLOW + "Erro: Variável '" + id + "' não declarada." + RESET + "\n");
        } else {
            String tipoVar = getTipoDaVariavel(id); // Obtém o tipo da variável no escopo
            String tipoExpr = getTipoDaExpressao(ctx.expressao()); // Obtém o tipo da expressão atribuída

            // Verifica se a atribuição é válida de acordo com as regras da linguagem
            if (!atribuicaoValida(tipoVar, tipoExpr, ctx.expressao())) {
                System.out.println("\n" + YELLOW + "Erro: A variável '" + id + "' é do tipo " + tipoVar +
                        " e não pode receber o valor do tipo " + tipoExpr + "." + RESET + "\n");
            }
        }
        System.out.println(RED + "Saiu da regra: " + RESET + "NAtribuicao (" + ctx.getText() + ")");
    }

    // Método para validar se a atribuição é permitida
    private boolean atribuicaoValida(String tipoVar, String tipoExpr, minhaGramaticaParser.ExpressaoContext ctx) {
        switch (tipoVar) {
            case "int":
                // int só pode receber valores inteiros
                return tipoExpr.equals("int");
            case "float":
                // float pode receber int ou float
                return tipoExpr.equals("int") || tipoExpr.equals("float");
            case "double":
                // double pode receber int, float ou double
                return tipoExpr.equals("int") || tipoExpr.equals("float") || tipoExpr.equals("double");
            case "bool":
                // bool só pode receber true ou false
                return tipoExpr.equals("bool");
            case "char":
                // char só pode receber literais de char (exemplo: 'a')
                return tipoExpr.equals("char");
            case "str":
                // str só pode receber literais de string (exemplo: "texto")
                return tipoExpr.equals("str");
            case "void":
                // void não pode receber nenhum valor
                return false;
            default:
                // Tipo desconhecido
                return false;
        }
    }


    // Método para obter o tipo da expressão
    private String getTipoDaExpressao(minhaGramaticaParser.ExpressaoContext ctx) {
        if (ctx instanceof minhaGramaticaParser.NExpressaoContext) {
            minhaGramaticaParser.NExpressaoContext nExpr = (minhaGramaticaParser.NExpressaoContext) ctx;
            if (nExpr.termo() != null && !nExpr.termo().isEmpty()) {
                return getTipoDaExpressao(nExpr.termo(0));
            }
        }
        return "undefined";
    }

    // Método para obter o tipo de um termo
    private String getTipoDaExpressao(minhaGramaticaParser.TermoContext ctx) {
        if (ctx.fator() != null && !ctx.fator().isEmpty()) {
            return getTipoDaExpressao(ctx.fator(0));
        }
        return "undefined";
    }
private String getTipoDaExpressao(minhaGramaticaParser.FatorContext ctx) {
    System.out.println("AENTROU1 ");
    
    if (ctx.NUM() != null) {
        String num = ctx.NUM().getText();
        System.out.println("AENTROU2 - NUM: " + num);
        return num.contains(",") ? "float" : "int"; // Determina se é float ou int com base no formato
    }
    System.out.println("AHOOIIIIIIIIII: " + ctx );
    
    if (ctx.VALOR_BOOL() != null) {
        System.out.println("AENTROU3 - VALOR_BOOL: " + ctx.VALOR_BOOL().getText());
        String valor = ctx.VALOR_BOOL().getText();
        if (valor.equals("true") || valor.equals("false")) {
            return "bool";
        }
    } // Se for um valor booleano

    System.out.println("AENTROU4 - SEM MATCH");
    if (ctx.STRING_LITERAL() != null) return "str"; // Se for uma string literal
    
    System.out.println("AENTROU5 - SEM MATCH");
    if (ctx.ID() != null) return getTipoDaVariavel(ctx.ID().getText()); // Se for uma variável, obtém o tipo dela
    
    System.out.println("AENTROU6 - RETORNANDO UNDEFINED");
    return "undefined"; // Caso contrário
}


    // Gerenciamento de escopo ao entrar em uma função
    @Override
    public void enterFuncao(minhaGramaticaParser.FuncaoContext ctx) {
        String nomeFuncao = ctx.ID().getText();
        String tipoRetorno = ctx.TIPO() != null ? ctx.TIPO().getText() : "void";

        // Verifica se a função já foi declarada
        if (tabelaSimbolos.containsKey(nomeFuncao)) {
            System.out.println("\n" + YELLOW + "Erro: Função '" + nomeFuncao + "' já declarada." + RESET + "\n");
        } else {
            // Adiciona a função à tabela de símbolos
            tabelaSimbolos.put(nomeFuncao, tipoRetorno);
        }

        // Cria um novo escopo para os parâmetros da função
        novoEscopo();

        // Adiciona os parâmetros ao escopo da função
        if (ctx.parametros() != null) {
            for (minhaGramaticaParser.ParametroContext param : ctx.parametros().parametro()) {
                String nomeParametro = param.ID().getText();
                String tipoParametro = param.TIPO().getText();
                escopos.peek().put(nomeParametro, tipoParametro);
            }
        }

        System.out.println(BLUE + "Entrou na regra: " + RESET + "enterFuncao (" + ctx.ID().getText() + ")");
    }

    // Gerenciamento de escopo ao sair de uma função
    @Override
    public void exitFuncao(minhaGramaticaParser.FuncaoContext ctx) {
        fecharEscopo();
        System.out.println(RED + "Saiu da regra: " + RESET + "exitFuncao (" + ctx.ID().getText() + ")");
    }

    // Verifica chamadas de função
    @Override
    public void exitChamada_funcao(minhaGramaticaParser.Chamada_funcaoContext ctx) {
        String funcao = ctx.ID().getText();

        // Verifica se a função foi declarada
        if (!tabelaSimbolos.containsKey(funcao)) {
            System.out.println("\n" + YELLOW + "Erro: Função '" + funcao + "' não declarada." + RESET + "\n");
        }
        System.out.println(RED + "Saiu da regra: " + RESET + "exitChamada_funcao (" + ctx.getText() + ")");
    }

    @Override
    public void enterChamada_funcao(minhaGramaticaParser.Chamada_funcaoContext ctx) {
        System.out.println(BLUE + "Entrou na regra: " + RESET + "enterChamada_funcao (" + ctx.getText() + ")");
    }

    // Retorna a tabela de símbolos
    public Map<String, String> getTabelaSimbolos() {
        return tabelaSimbolos;
    }
}