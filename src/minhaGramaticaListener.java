// Generated from minhaGramatica.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link minhaGramaticaParser}.
 */
public interface minhaGramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code NInicio}
	 * labeled alternative in {@link minhaGramaticaParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterNInicio(minhaGramaticaParser.NInicioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NInicio}
	 * labeled alternative in {@link minhaGramaticaParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitNInicio(minhaGramaticaParser.NInicioContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#principal}.
	 * @param ctx the parse tree
	 */
	void enterPrincipal(minhaGramaticaParser.PrincipalContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#principal}.
	 * @param ctx the parse tree
	 */
	void exitPrincipal(minhaGramaticaParser.PrincipalContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#funcao}.
	 * @param ctx the parse tree
	 */
	void enterFuncao(minhaGramaticaParser.FuncaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#funcao}.
	 * @param ctx the parse tree
	 */
	void exitFuncao(minhaGramaticaParser.FuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(minhaGramaticaParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(minhaGramaticaParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(minhaGramaticaParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(minhaGramaticaParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(minhaGramaticaParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(minhaGramaticaParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NDeclaracaoVar}
	 * labeled alternative in {@link minhaGramaticaParser#declaracao_var}.
	 * @param ctx the parse tree
	 */
	void enterNDeclaracaoVar(minhaGramaticaParser.NDeclaracaoVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NDeclaracaoVar}
	 * labeled alternative in {@link minhaGramaticaParser#declaracao_var}.
	 * @param ctx the parse tree
	 */
	void exitNDeclaracaoVar(minhaGramaticaParser.NDeclaracaoVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NComandos}
	 * labeled alternative in {@link minhaGramaticaParser#comandos}.
	 * @param ctx the parse tree
	 */
	void enterNComandos(minhaGramaticaParser.NComandosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NComandos}
	 * labeled alternative in {@link minhaGramaticaParser#comandos}.
	 * @param ctx the parse tree
	 */
	void exitNComandos(minhaGramaticaParser.NComandosContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(minhaGramaticaParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(minhaGramaticaParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NAtribuicao}
	 * labeled alternative in {@link minhaGramaticaParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterNAtribuicao(minhaGramaticaParser.NAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NAtribuicao}
	 * labeled alternative in {@link minhaGramaticaParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitNAtribuicao(minhaGramaticaParser.NAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#condicional}.
	 * @param ctx the parse tree
	 */
	void enterCondicional(minhaGramaticaParser.CondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#condicional}.
	 * @param ctx the parse tree
	 */
	void exitCondicional(minhaGramaticaParser.CondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(minhaGramaticaParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(minhaGramaticaParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void enterInicializacao(minhaGramaticaParser.InicializacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void exitInicializacao(minhaGramaticaParser.InicializacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#atualizacao}.
	 * @param ctx the parse tree
	 */
	void enterAtualizacao(minhaGramaticaParser.AtualizacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#atualizacao}.
	 * @param ctx the parse tree
	 */
	void exitAtualizacao(minhaGramaticaParser.AtualizacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#chamada_funcao}.
	 * @param ctx the parse tree
	 */
	void enterChamada_funcao(minhaGramaticaParser.Chamada_funcaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#chamada_funcao}.
	 * @param ctx the parse tree
	 */
	void exitChamada_funcao(minhaGramaticaParser.Chamada_funcaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#retorno}.
	 * @param ctx the parse tree
	 */
	void enterRetorno(minhaGramaticaParser.RetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#retorno}.
	 * @param ctx the parse tree
	 */
	void exitRetorno(minhaGramaticaParser.RetornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(minhaGramaticaParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(minhaGramaticaParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NExpressao}
	 * labeled alternative in {@link minhaGramaticaParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterNExpressao(minhaGramaticaParser.NExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NExpressao}
	 * labeled alternative in {@link minhaGramaticaParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitNExpressao(minhaGramaticaParser.NExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(minhaGramaticaParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(minhaGramaticaParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(minhaGramaticaParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(minhaGramaticaParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link minhaGramaticaParser#saida}.
	 * @param ctx the parse tree
	 */
	void enterSaida(minhaGramaticaParser.SaidaContext ctx);
	/**
	 * Exit a parse tree produced by {@link minhaGramaticaParser#saida}.
	 * @param ctx the parse tree
	 */
	void exitSaida(minhaGramaticaParser.SaidaContext ctx);
}