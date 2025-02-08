// import antlr.GramaticaBaseListener;
// import antlr.GramaticaParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class MyListener extends minhaGramaticaBaseListener {

    private Map<String,String> tabelaSimbolos = new HashMap<String,String>();

    public Map<String, String> getTabelaSimbolos() {
        return tabelaSimbolos;
    }
}
