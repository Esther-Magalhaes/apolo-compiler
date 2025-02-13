import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ParseTree;

public class MyListener extends minhaGramaticaBaseListener {
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\033[34m";
    public static final String YELLOW = "\033[33m";
    public static final String RESET = "\u001B[0m";
    

    // Tabela de símbolos global
    private Map<String, String> tabelaSimbolos;

    // Pilha de escopos para gerenciar variáveis locais
    private Stack<Map<String, String>> escopos;

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

    @Override
    public void enterNInicio(minhaGramaticaParser.NInicioContext ctx) {
        // Inicializa a tabela de símbolos e a pilha de escopos
        tabelaSimbolos = new HashMap<>();
        escopos = new Stack<>();
        novoEscopo(); // Cria o escopo global

        // Exibe uma mensagem de log
        System.out.println(BLUE + "Entrou na regra: " + RESET + "NInicio\n" + "(" + ctx.getText() +")");
    }

    @Override
    public void exitNInicio(minhaGramaticaParser.NInicioContext ctx) {
        // Verifica se a função principal foi definida
        if (!tabelaSimbolos.containsKey("PRINCIPAL")) {
            throw new RuntimeException("\n" + YELLOW + "Erro: Função principal não definida." + RESET + "\n");
        }
    
        // Exibe uma mensagem de log
        System.out.println(RED + "Saiu da regra: " + RESET + "NInicio\n" + "(" + ctx.getText() +")");
    }

    // Verifica declarações de variáveis
    @Override
    public void enterNDeclaracaoValor(minhaGramaticaParser.NDeclaracaoValorContext ctx) {
        // Exibe uma mensagem de log indicando que entrou na regra
        System.out.println(BLUE + "Entrou na regra: " + RESET + "NDeclaracaoValor (" + ctx.getText() + ")");

        // Captura os tipos explicitamente
        List<String> tiposEncontrados = new ArrayList<>();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String token = ctx.getChild(i).getText();
            if (token.equals("int") || token.equals("float") || token.equals("bool") || token.equals("str") || token.equals("double")) {
                tiposEncontrados.add(token);
            }
        }

        // Verifica se há mais de um tipo na declaração
        if (tiposEncontrados.size() > 1) {
            String declaracao = ctx.getText();
            throw new RuntimeException("\n" + YELLOW + "Erro: Declaração inválida. Apenas um tipo deve ser especificado. Encontrado: '" 
                                    + declaracao + "'" + RESET + "\n");
        }
    }

    @Override
    public void exitNDeclaracaoValor(minhaGramaticaParser.NDeclaracaoValorContext ctx) {
        
        // Extrai o nome da variável e o tipo (se houver)
        
        String id = ctx.ID().getText();
        String tipoValor = ctx.TIPO() != null ? ctx.TIPO().getText() : "undefined";
        
    
        // Verifica se a variável já foi declarada no escopo atual
        if (escopos.peek().containsKey(id)) {
            throw new RuntimeException("\n" + YELLOW + "Erro: Declaração duplicada de variável '" + id + "'." + RESET + "\n");
        } else {
            String textoExpressao = ctx.expressao().getText();
            String tipoExpr;
            // Obtém o tipo da expressão atribuída. Se for uma chamada de função, 
            // verifica primeiro se a função existe na tabela de símbolos. 
            // Se existir, usa o tipo armazenado na tabela; caso contrário, 
            // determina o tipo da expressão normalmente.
            if (tabelaSimbolos.containsKey(textoExpressao.split("\\(")[0])) {
                tipoExpr = tabelaSimbolos.get(textoExpressao.split("\\(")[0]);
            } else if (textoExpressao.startsWith("\"") && textoExpressao.endsWith("\"") && textoExpressao.length() == 3 && tipoValor.contains("char")) {
                tipoExpr = "char"; // Definindo como tipo char
            }
            else {
                tipoExpr = getTipoDaExpressao(ctx.expressao());
                // literal.length() == 3 && literal.startsWith("'") && literal.endsWith("'")
            }
            // Verifica se o tipo da expressão é compatível com o tipo da variável
            if (!atribuicaoValida(tipoValor, tipoExpr, ctx.expressao())) {
                throw new RuntimeException("\n" + YELLOW + "Erro: A variável '" + id + "' é do tipo " + tipoValor +
                        " e não pode receber o valor do tipo " + tipoExpr + "." + RESET + "\n");
                        
            } else {
                // Se for válido, adiciona a variável ao escopo atual
                escopos.peek().put(id, tipoValor);
                tabelaSimbolos.put(id, tipoValor); // Armazena na tabela global
            }
        }
        System.out.println(RED + "Saiu da regra: " + RESET + "NDeclaracaoValor (" + ctx.getText() + ")");
    }

    // Verifica atribuições de variáveis
    @Override
    public void enterNAtribuicao(minhaGramaticaParser.NAtribuicaoContext ctx) {
        System.out.println(BLUE + "Entrou na regra: " + RESET + "NAtribuicao (" + ctx.getText() + ")");

        // Obtém o nome da variável que está recebendo a atribuição
        String nomeVar = ctx.ID().getText();
    
        // Verifica se a variável foi declarada
        if (!varNoEscopo(nomeVar)) {
            throw new RuntimeException("\n" + YELLOW + "Erro: Variável '" + nomeVar + "' não declarada." + RESET + "\n");
        }
    
        // Obtém o tipo da variável
        String tipoValor = getTipoDaVariavel(nomeVar);
    
        // Obtém o tipo da expressão que está sendo atribuída
        String tipoExpr = getTipoDaExpressao(ctx.expressao());
    
        // Verifica se a atribuição é válida
        if (tipoExpr.equals("undefined")) {
            throw new RuntimeException("\n" + YELLOW + "Erro: Tipo da expressão é undefined." + RESET + "\n");
        } else if (!atribuicaoValida(tipoValor, tipoExpr, ctx.expressao())) {
            throw new RuntimeException("\n" + YELLOW + "Erro: A variável '" + nomeVar + "' é do tipo " + tipoValor +
                    " e não pode receber o valor do tipo " + tipoExpr + "." + RESET + "\n");
        } 
    }

    @Override
    public void exitNAtribuicao(minhaGramaticaParser.NAtribuicaoContext ctx) {
        // Exibe uma mensagem de log indicando que saiu da regra
        System.out.println(RED + "Saiu da regra: " + RESET + "NAtribuicao (" + ctx.getText() + ")");
    }

    
    // Método para validar se a atribuição é permitida
    private boolean atribuicaoValida(String tipoValor, String tipoExpr, minhaGramaticaParser.ExpressaoContext ctx) {
        switch (tipoValor) {
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

    // Método enterNExpressao para verificar o ID
    @Override
    public void enterNExpressao(minhaGramaticaParser.NExpressaoContext ctx) {
        // Percorre todos os nós da expressão para encontrar IDs
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
    
            // Verifica se o filho é um TermoContext
            if (child instanceof minhaGramaticaParser.TermoContext) {
                minhaGramaticaParser.TermoContext termo = (minhaGramaticaParser.TermoContext) child;
    
                // Percorre os filhos do TermoContext
                for (int j = 0; j < termo.getChildCount(); j++) {
                    ParseTree termoChild = termo.getChild(j);
    
                    // Verifica se o filho é um FatorContext
                    if (termoChild instanceof minhaGramaticaParser.FatorContext) {
                        minhaGramaticaParser.FatorContext fator = (minhaGramaticaParser.FatorContext) termoChild;
    
                        // Percorre os filhos do FatorContext
                        for (int k = 0; k < fator.getChildCount(); k++) {
                            ParseTree fatorChild = fator.getChild(k);
    
                            // Verifica se o filho é um ID
                            if (fatorChild instanceof TerminalNode) {
                                TerminalNode terminalNode = (TerminalNode) fatorChild;
    
                                if (terminalNode.getSymbol().getType() == minhaGramaticaParser.ID) {
                                    String id = terminalNode.getText();
    
                                    // Verifica se o ID está no escopo
                                    if (!varNoEscopo(id)) {
                                        System.out.println(BLUE + "Entrou na regra: " + RESET + "enterNExpressao (" + ctx.getText() + ")");
                                        throw new RuntimeException("\n" + YELLOW + "Erro: Variável '" + id + "' não declarada." + RESET + "\n");
                                    } 
                                }
                            }
                        }
                    }
                }
            }
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
    if (ctx.NUM() != null) {
        String num = ctx.NUM().getText();
        return num.contains(",") ? "float" : "int"; // Determina se é float ou int com base no formato
    }
    
    if (ctx.VALOR_BOOL() != null) {
        String valor = ctx.VALOR_BOOL().getText();
        if (valor.equals("true") || valor.equals("false")) {
            return "bool";
        }
    } // Se for um valor booleano

    if (ctx.STRING_LITERAL() != null) return "str"; // Se for uma string literal
    
    if (ctx.ID() != null) return getTipoDaVariavel(ctx.ID().getText()); // Se for uma variável, obtém o tipo dela
    
    return "undefined"; // Caso contrário
}


    // Gerenciamento de escopo ao entrar em uma função
    @Override
    public void enterNFuncao(minhaGramaticaParser.NFuncaoContext ctx) {
        String nomeFuncao = ctx.ID().getText();
        String tipoRetorno = ctx.TIPO() != null ? ctx.TIPO().getText() : "void";
    
        // Verifica se a função já foi declarada
        if (tabelaSimbolos.containsKey(nomeFuncao)) {
            throw new RuntimeException("\n" + YELLOW + "Erro: Função '" + nomeFuncao + "' já declarada." + RESET + "\n");
        } else {
            // Adiciona a função à tabela de símbolos com seu tipo de retorno
            tabelaSimbolos.put(nomeFuncao, tipoRetorno);
        }
    
        // Cria um novo escopo para os parâmetros da função
        novoEscopo();
    
        // Adiciona os parâmetros ao escopo da função
        if (ctx.parametros() != null) {
            for (minhaGramaticaParser.ParametroContext param : ctx.parametros().parametro()) {
                String nomeParametro = param.ID().getText();
                String tipoParametro = param.TIPO().getText();
    
                // Verifica se o parâmetro já foi declarado
                if (escopos.peek().containsKey(nomeParametro)) {
                    throw new RuntimeException("\n" + YELLOW + "Erro: Parâmetro '" + nomeParametro + "' já declarado." + RESET + "\n");
                } else {
                    // Adiciona o parâmetro ao escopo atual
                    escopos.peek().put(nomeParametro, tipoParametro);
                }
            }
        }
    
        System.out.println(BLUE + "Entrou na regra: " + RESET + "enterNFuncao (" + nomeFuncao + ")");
    }
    

    // Gerenciamento de escopo ao sair de uma função
    @Override
    public void exitNFuncao(minhaGramaticaParser.NFuncaoContext ctx) {
        fecharEscopo();
        System.out.println(RED + "Saiu da regra: " + RESET + "exitNFuncao (" + ctx.ID().getText() + ")");
    }

    // Verifica chamadas de função
    @Override
    public void exitNChamada_funcao(minhaGramaticaParser.NChamada_funcaoContext ctx) {
        String funcao = ctx.ID().getText();

        // Verifica se a função foi declarada
        if (!tabelaSimbolos.containsKey(funcao)) {
            throw new RuntimeException("\n" + YELLOW + "Erro: Função '" + funcao + "' não declarada." + RESET + "\n");
        }
        System.out.println(RED + "Saiu da regra: " + RESET + "exitNChamada_funcao (" + ctx.getText() + ")");
    }

    @Override
    public void enterNChamada_funcao(minhaGramaticaParser.NChamada_funcaoContext ctx) {
        System.out.println(BLUE + "Entrou na regra: " + RESET + "enterNChamada_funcao (" + ctx.getText() + ")");
    }

    @Override
    public void enterNPrincipal(minhaGramaticaParser.NPrincipalContext ctx) {
        // Obtém o nome da função (deve ser "PRINCIPAL")
        String nomeFuncao = ctx.PRINCIPAL().getText();

        // Obtém o tipo de retorno da função
        String tipoRetorno = ctx.TIPO().getText();

        // Adiciona a função principal à tabela de símbolos
        tabelaSimbolos.put(nomeFuncao, tipoRetorno);

        // Cria um novo escopo para a função principal
        novoEscopo();

        // Adiciona os parâmetros ao escopo atual (se houver)
        if (ctx.parametros() != null) {
            for (minhaGramaticaParser.ParametroContext param : ctx.parametros().parametro()) {
                String nomeParametro = param.ID().getText();
                String tipoParametro = param.TIPO().getText();

                // Adiciona o parâmetro ao escopo atual
                escopos.peek().put(nomeParametro, tipoParametro);
            }
        }

        // Exibe uma mensagem de log
        System.out.println(BLUE + "Entrou na regra: " + RESET + "NPrincipal (" + ctx.getText() + ")");
    }


    @Override
    public void exitNPrincipal(minhaGramaticaParser.NPrincipalContext ctx) {
        // Fecha o escopo da função principal
        fecharEscopo();

        // Exibe uma mensagem de log
        System.out.println(RED + "Saiu da regra: " + RESET + "NPrincipal (" + ctx.getText() + ")");
    }

    // Retorna a tabela de símbolos
    public Map<String, String> getTabelaSimbolos() {
        return tabelaSimbolos;
    }
}