// Generated from c:/Users/esthe/OneDrive/Área de Trabalho/2024/Materias 2024.1/Compiladores/apolo-compiler/src/minhaGramatica.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class minhaGramaticaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ENQUANTO=2, PARA=3, SE=4, SENAO=5, SENAO_SE=6, RETORNAR=7, FUNCAO=8, 
		ENTRADA=9, SAIDA=10, NULL=11, PRINCIPAL=12, TIPO=13, OP_ARIT=14, OP_REL=15, 
		OP_BOOL=16, OP_BOOL_NEG=17, OP_ATRIB=18, OP_CONCAT=19, ABRIR_CH=20, FECHAR_CH=21, 
		ABRIR_PAR=22, FECHAR_PAR=23, DELIMITADOR=24, ID=25, NUM=26, VALOR_BOOL=27, 
		STRING_LITERAL=28, WS=29, COMENT=30, ErrorChar=31;
	public static final int
		RULE_programa = 0, RULE_principal = 1, RULE_funcao = 2, RULE_parametros = 3, 
		RULE_parametro = 4, RULE_declaracoes = 5, RULE_declaracao_var = 6, RULE_comandos = 7, 
		RULE_comando = 8, RULE_atribuicao = 9, RULE_condicional = 10, RULE_loop = 11, 
		RULE_inicializacao = 12, RULE_atualizacao = 13, RULE_chamada_funcao = 14, 
		RULE_retorno = 15, RULE_argumentos = 16, RULE_expressao = 17, RULE_termo = 18, 
		RULE_fator = 19, RULE_saida = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "principal", "funcao", "parametros", "parametro", "declaracoes", 
			"declaracao_var", "comandos", "comando", "atribuicao", "condicional", 
			"loop", "inicializacao", "atualizacao", "chamada_funcao", "retorno", 
			"argumentos", "expressao", "termo", "fator", "saida"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'while'", "'for'", "'if'", "'else'", "'elf'", "'return'", 
			"'func'", "'input'", "'print'", "'_'", "'PRINCIPAL'", null, null, null, 
			null, "'!'", "'<-'", "'++'", "'{'", "'}'", "'('", "')'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "ENQUANTO", "PARA", "SE", "SENAO", "SENAO_SE", "RETORNAR", 
			"FUNCAO", "ENTRADA", "SAIDA", "NULL", "PRINCIPAL", "TIPO", "OP_ARIT", 
			"OP_REL", "OP_BOOL", "OP_BOOL_NEG", "OP_ATRIB", "OP_CONCAT", "ABRIR_CH", 
			"FECHAR_CH", "ABRIR_PAR", "FECHAR_PAR", "DELIMITADOR", "ID", "NUM", "VALOR_BOOL", 
			"STRING_LITERAL", "WS", "COMENT", "ErrorChar"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "minhaGramatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public minhaGramaticaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public PrincipalContext principal() {
			return getRuleContext(PrincipalContext.class,0);
		}
		public TerminalNode EOF() { return getToken(minhaGramaticaParser.EOF, 0); }
		public List<FuncaoContext> funcao() {
			return getRuleContexts(FuncaoContext.class);
		}
		public FuncaoContext funcao(int i) {
			return getRuleContext(FuncaoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(42);
					funcao();
					}
					} 
				}
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(48);
			principal();
			setState(49);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrincipalContext extends ParserRuleContext {
		public TerminalNode FUNCAO() { return getToken(minhaGramaticaParser.FUNCAO, 0); }
		public TerminalNode TIPO() { return getToken(minhaGramaticaParser.TIPO, 0); }
		public TerminalNode PRINCIPAL() { return getToken(minhaGramaticaParser.PRINCIPAL, 0); }
		public TerminalNode ABRIR_PAR() { return getToken(minhaGramaticaParser.ABRIR_PAR, 0); }
		public TerminalNode FECHAR_PAR() { return getToken(minhaGramaticaParser.FECHAR_PAR, 0); }
		public TerminalNode ABRIR_CH() { return getToken(minhaGramaticaParser.ABRIR_CH, 0); }
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public TerminalNode FECHAR_CH() { return getToken(minhaGramaticaParser.FECHAR_CH, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public TerminalNode DELIMITADOR() { return getToken(minhaGramaticaParser.DELIMITADOR, 0); }
		public PrincipalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_principal; }
	}

	public final PrincipalContext principal() throws RecognitionException {
		PrincipalContext _localctx = new PrincipalContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_principal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(FUNCAO);
			setState(52);
			match(TIPO);
			setState(53);
			match(PRINCIPAL);
			setState(54);
			match(ABRIR_PAR);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIPO) {
				{
				setState(55);
				parametros();
				}
			}

			setState(58);
			match(FECHAR_PAR);
			setState(59);
			match(ABRIR_CH);
			setState(60);
			declaracoes();
			setState(61);
			comandos();
			setState(62);
			match(FECHAR_CH);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DELIMITADOR) {
				{
				setState(63);
				match(DELIMITADOR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncaoContext extends ParserRuleContext {
		public TerminalNode FUNCAO() { return getToken(minhaGramaticaParser.FUNCAO, 0); }
		public TerminalNode TIPO() { return getToken(minhaGramaticaParser.TIPO, 0); }
		public TerminalNode ID() { return getToken(minhaGramaticaParser.ID, 0); }
		public TerminalNode ABRIR_PAR() { return getToken(minhaGramaticaParser.ABRIR_PAR, 0); }
		public TerminalNode FECHAR_PAR() { return getToken(minhaGramaticaParser.FECHAR_PAR, 0); }
		public TerminalNode ABRIR_CH() { return getToken(minhaGramaticaParser.ABRIR_CH, 0); }
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public TerminalNode FECHAR_CH() { return getToken(minhaGramaticaParser.FECHAR_CH, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public TerminalNode DELIMITADOR() { return getToken(minhaGramaticaParser.DELIMITADOR, 0); }
		public FuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcao; }
	}

	public final FuncaoContext funcao() throws RecognitionException {
		FuncaoContext _localctx = new FuncaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(FUNCAO);
			setState(67);
			match(TIPO);
			setState(68);
			match(ID);
			setState(69);
			match(ABRIR_PAR);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIPO) {
				{
				setState(70);
				parametros();
				}
			}

			setState(73);
			match(FECHAR_PAR);
			setState(74);
			match(ABRIR_CH);
			setState(75);
			declaracoes();
			setState(76);
			comandos();
			setState(77);
			match(FECHAR_CH);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DELIMITADOR) {
				{
				setState(78);
				match(DELIMITADOR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			parametro();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(82);
				match(T__0);
				setState(83);
				parametro();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametroContext extends ParserRuleContext {
		public TerminalNode TIPO() { return getToken(minhaGramaticaParser.TIPO, 0); }
		public TerminalNode ID() { return getToken(minhaGramaticaParser.ID, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(TIPO);
			setState(90);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracoesContext extends ParserRuleContext {
		public List<Declaracao_varContext> declaracao_var() {
			return getRuleContexts(Declaracao_varContext.class);
		}
		public Declaracao_varContext declaracao_var(int i) {
			return getRuleContext(Declaracao_varContext.class,i);
		}
		public List<TerminalNode> DELIMITADOR() { return getTokens(minhaGramaticaParser.DELIMITADOR); }
		public TerminalNode DELIMITADOR(int i) {
			return getToken(minhaGramaticaParser.DELIMITADOR, i);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaracoes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(92);
					declaracao_var();
					setState(93);
					match(DELIMITADOR);
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaracao_varContext extends ParserRuleContext {
		public TerminalNode TIPO() { return getToken(minhaGramaticaParser.TIPO, 0); }
		public TerminalNode ID() { return getToken(minhaGramaticaParser.ID, 0); }
		public TerminalNode OP_ATRIB() { return getToken(minhaGramaticaParser.OP_ATRIB, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Declaracao_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_var; }
	}

	public final Declaracao_varContext declaracao_var() throws RecognitionException {
		Declaracao_varContext _localctx = new Declaracao_varContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaracao_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(TIPO);
			setState(101);
			match(ID);
			setState(102);
			match(OP_ATRIB);
			setState(103);
			expressao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandosContext extends ParserRuleContext {
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandos; }
	}

	public final ComandosContext comandos() throws RecognitionException {
		ComandosContext _localctx = new ComandosContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33563804L) != 0)) {
				{
				{
				setState(105);
				comando();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoContext extends ParserRuleContext {
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public TerminalNode DELIMITADOR() { return getToken(minhaGramaticaParser.DELIMITADOR, 0); }
		public Declaracao_varContext declaracao_var() {
			return getRuleContext(Declaracao_varContext.class,0);
		}
		public CondicionalContext condicional() {
			return getRuleContext(CondicionalContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public Chamada_funcaoContext chamada_funcao() {
			return getRuleContext(Chamada_funcaoContext.class,0);
		}
		public RetornoContext retorno() {
			return getRuleContext(RetornoContext.class,0);
		}
		public SaidaContext saida() {
			return getRuleContext(SaidaContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comando);
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				atribuicao();
				setState(112);
				match(DELIMITADOR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				declaracao_var();
				setState(115);
				match(DELIMITADOR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				condicional();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				loop();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(119);
				chamada_funcao();
				setState(120);
				match(DELIMITADOR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(122);
				retorno();
				setState(123);
				match(DELIMITADOR);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(125);
				saida();
				setState(126);
				match(DELIMITADOR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtribuicaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(minhaGramaticaParser.ID, 0); }
		public TerminalNode OP_ATRIB() { return getToken(minhaGramaticaParser.OP_ATRIB, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(ID);
			setState(131);
			match(OP_ATRIB);
			setState(132);
			expressao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CondicionalContext extends ParserRuleContext {
		public TerminalNode SE() { return getToken(minhaGramaticaParser.SE, 0); }
		public List<TerminalNode> ABRIR_PAR() { return getTokens(minhaGramaticaParser.ABRIR_PAR); }
		public TerminalNode ABRIR_PAR(int i) {
			return getToken(minhaGramaticaParser.ABRIR_PAR, i);
		}
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<TerminalNode> FECHAR_PAR() { return getTokens(minhaGramaticaParser.FECHAR_PAR); }
		public TerminalNode FECHAR_PAR(int i) {
			return getToken(minhaGramaticaParser.FECHAR_PAR, i);
		}
		public List<TerminalNode> ABRIR_CH() { return getTokens(minhaGramaticaParser.ABRIR_CH); }
		public TerminalNode ABRIR_CH(int i) {
			return getToken(minhaGramaticaParser.ABRIR_CH, i);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public List<TerminalNode> FECHAR_CH() { return getTokens(minhaGramaticaParser.FECHAR_CH); }
		public TerminalNode FECHAR_CH(int i) {
			return getToken(minhaGramaticaParser.FECHAR_CH, i);
		}
		public List<TerminalNode> SENAO_SE() { return getTokens(minhaGramaticaParser.SENAO_SE); }
		public TerminalNode SENAO_SE(int i) {
			return getToken(minhaGramaticaParser.SENAO_SE, i);
		}
		public TerminalNode SENAO() { return getToken(minhaGramaticaParser.SENAO, 0); }
		public CondicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicional; }
	}

	public final CondicionalContext condicional() throws RecognitionException {
		CondicionalContext _localctx = new CondicionalContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_condicional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(SE);
			setState(135);
			match(ABRIR_PAR);
			setState(136);
			expressao();
			setState(137);
			match(FECHAR_PAR);
			setState(138);
			match(ABRIR_CH);
			setState(139);
			comandos();
			setState(140);
			match(FECHAR_CH);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SENAO_SE) {
				{
				{
				setState(141);
				match(SENAO_SE);
				setState(142);
				match(ABRIR_PAR);
				setState(143);
				expressao();
				setState(144);
				match(FECHAR_PAR);
				setState(145);
				match(ABRIR_CH);
				setState(146);
				comandos();
				setState(147);
				match(FECHAR_CH);
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(154);
				match(SENAO);
				setState(155);
				match(ABRIR_CH);
				setState(156);
				comandos();
				setState(157);
				match(FECHAR_CH);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopContext extends ParserRuleContext {
		public TerminalNode ENQUANTO() { return getToken(minhaGramaticaParser.ENQUANTO, 0); }
		public TerminalNode ABRIR_PAR() { return getToken(minhaGramaticaParser.ABRIR_PAR, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHAR_PAR() { return getToken(minhaGramaticaParser.FECHAR_PAR, 0); }
		public TerminalNode ABRIR_CH() { return getToken(minhaGramaticaParser.ABRIR_CH, 0); }
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public TerminalNode FECHAR_CH() { return getToken(minhaGramaticaParser.FECHAR_CH, 0); }
		public List<TerminalNode> DELIMITADOR() { return getTokens(minhaGramaticaParser.DELIMITADOR); }
		public TerminalNode DELIMITADOR(int i) {
			return getToken(minhaGramaticaParser.DELIMITADOR, i);
		}
		public TerminalNode PARA() { return getToken(minhaGramaticaParser.PARA, 0); }
		public InicializacaoContext inicializacao() {
			return getRuleContext(InicializacaoContext.class,0);
		}
		public AtualizacaoContext atualizacao() {
			return getRuleContext(AtualizacaoContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_loop);
		int _la;
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENQUANTO:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(ENQUANTO);
				setState(162);
				match(ABRIR_PAR);
				setState(163);
				expressao();
				setState(164);
				match(FECHAR_PAR);
				setState(165);
				match(ABRIR_CH);
				setState(166);
				comandos();
				setState(167);
				match(FECHAR_CH);
				setState(168);
				match(DELIMITADOR);
				}
				break;
			case PARA:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(PARA);
				setState(171);
				match(ABRIR_PAR);
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TIPO || _la==ID) {
					{
					setState(172);
					inicializacao();
					}
				}

				setState(175);
				match(DELIMITADOR);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 507641856L) != 0)) {
					{
					setState(176);
					expressao();
					}
				}

				setState(179);
				match(DELIMITADOR);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(180);
					atualizacao();
					}
				}

				setState(183);
				match(FECHAR_PAR);
				setState(184);
				match(ABRIR_CH);
				setState(185);
				comandos();
				setState(186);
				match(FECHAR_CH);
				setState(187);
				match(DELIMITADOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InicializacaoContext extends ParserRuleContext {
		public Declaracao_varContext declaracao_var() {
			return getRuleContext(Declaracao_varContext.class,0);
		}
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public InicializacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializacao; }
	}

	public final InicializacaoContext inicializacao() throws RecognitionException {
		InicializacaoContext _localctx = new InicializacaoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_inicializacao);
		try {
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIPO:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				declaracao_var();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				atribuicao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtualizacaoContext extends ParserRuleContext {
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public AtualizacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atualizacao; }
	}

	public final AtualizacaoContext atualizacao() throws RecognitionException {
		AtualizacaoContext _localctx = new AtualizacaoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_atualizacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			atribuicao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Chamada_funcaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(minhaGramaticaParser.ID, 0); }
		public TerminalNode ABRIR_PAR() { return getToken(minhaGramaticaParser.ABRIR_PAR, 0); }
		public TerminalNode FECHAR_PAR() { return getToken(minhaGramaticaParser.FECHAR_PAR, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public Chamada_funcaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamada_funcao; }
	}

	public final Chamada_funcaoContext chamada_funcao() throws RecognitionException {
		Chamada_funcaoContext _localctx = new Chamada_funcaoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_chamada_funcao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(ID);
			setState(198);
			match(ABRIR_PAR);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 507641856L) != 0)) {
				{
				setState(199);
				argumentos();
				}
			}

			setState(202);
			match(FECHAR_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RetornoContext extends ParserRuleContext {
		public TerminalNode RETORNAR() { return getToken(minhaGramaticaParser.RETORNAR, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public RetornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retorno; }
	}

	public final RetornoContext retorno() throws RecognitionException {
		RetornoContext _localctx = new RetornoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_retorno);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(RETORNAR);
			setState(205);
			expressao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			expressao();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(208);
				match(T__0);
				setState(209);
				expressao();
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP_ARIT() { return getTokens(minhaGramaticaParser.OP_ARIT); }
		public TerminalNode OP_ARIT(int i) {
			return getToken(minhaGramaticaParser.OP_ARIT, i);
		}
		public List<TerminalNode> OP_CONCAT() { return getTokens(minhaGramaticaParser.OP_CONCAT); }
		public TerminalNode OP_CONCAT(int i) {
			return getToken(minhaGramaticaParser.OP_CONCAT, i);
		}
		public List<TerminalNode> OP_BOOL() { return getTokens(minhaGramaticaParser.OP_BOOL); }
		public TerminalNode OP_BOOL(int i) {
			return getToken(minhaGramaticaParser.OP_BOOL, i);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			termo();
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 606208L) != 0)) {
				{
				{
				setState(216);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 606208L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(217);
				termo();
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<TerminalNode> OP_REL() { return getTokens(minhaGramaticaParser.OP_REL); }
		public TerminalNode OP_REL(int i) {
			return getToken(minhaGramaticaParser.OP_REL, i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			fator();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_REL) {
				{
				{
				setState(224);
				match(OP_REL);
				setState(225);
				fator();
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FatorContext extends ParserRuleContext {
		public TerminalNode OP_BOOL_NEG() { return getToken(minhaGramaticaParser.OP_BOOL_NEG, 0); }
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TerminalNode ID() { return getToken(minhaGramaticaParser.ID, 0); }
		public TerminalNode NUM() { return getToken(minhaGramaticaParser.NUM, 0); }
		public TerminalNode VALOR_BOOL() { return getToken(minhaGramaticaParser.VALOR_BOOL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(minhaGramaticaParser.STRING_LITERAL, 0); }
		public TerminalNode ABRIR_PAR() { return getToken(minhaGramaticaParser.ABRIR_PAR, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHAR_PAR() { return getToken(minhaGramaticaParser.FECHAR_PAR, 0); }
		public Chamada_funcaoContext chamada_funcao() {
			return getRuleContext(Chamada_funcaoContext.class,0);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fator);
		try {
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				match(OP_BOOL_NEG);
				setState(232);
				fator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
				match(NUM);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
				match(VALOR_BOOL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(236);
				match(STRING_LITERAL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(237);
				match(ABRIR_PAR);
				setState(238);
				expressao();
				setState(239);
				match(FECHAR_PAR);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(241);
				chamada_funcao();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SaidaContext extends ParserRuleContext {
		public TerminalNode SAIDA() { return getToken(minhaGramaticaParser.SAIDA, 0); }
		public TerminalNode ABRIR_PAR() { return getToken(minhaGramaticaParser.ABRIR_PAR, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHAR_PAR() { return getToken(minhaGramaticaParser.FECHAR_PAR, 0); }
		public SaidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_saida; }
	}

	public final SaidaContext saida() throws RecognitionException {
		SaidaContext _localctx = new SaidaContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_saida);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(SAIDA);
			setState(245);
			match(ABRIR_PAR);
			setState(246);
			expressao();
			setState(247);
			match(FECHAR_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00fa\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0005"+
		"\u0000,\b\u0000\n\u0000\f\u0000/\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u00019\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001A\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002H\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002P\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003U\b\u0003\n\u0003"+
		"\f\u0003X\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005`\b\u0005\n\u0005\f\u0005c\t\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0005"+
		"\u0007k\b\u0007\n\u0007\f\u0007n\t\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0081\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0096"+
		"\b\n\n\n\f\n\u0099\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n"+
		"\u00a0\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00ae\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00b2\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00b6\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00be\b\u000b\u0001\f\u0001\f\u0003\f\u00c2\b\f\u0001\r\u0001\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00c9\b\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u00d3\b\u0010\n\u0010\f\u0010\u00d6\t\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00db\b\u0011\n\u0011\f\u0011"+
		"\u00de\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00e3\b"+
		"\u0012\n\u0012\f\u0012\u00e6\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u00f3\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0000\u0000\u0015\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(\u0000\u0001\u0003\u0000\u000e\u000e\u0010\u0010\u0013\u0013"+
		"\u0103\u0000-\u0001\u0000\u0000\u0000\u00023\u0001\u0000\u0000\u0000\u0004"+
		"B\u0001\u0000\u0000\u0000\u0006Q\u0001\u0000\u0000\u0000\bY\u0001\u0000"+
		"\u0000\u0000\na\u0001\u0000\u0000\u0000\fd\u0001\u0000\u0000\u0000\u000e"+
		"l\u0001\u0000\u0000\u0000\u0010\u0080\u0001\u0000\u0000\u0000\u0012\u0082"+
		"\u0001\u0000\u0000\u0000\u0014\u0086\u0001\u0000\u0000\u0000\u0016\u00bd"+
		"\u0001\u0000\u0000\u0000\u0018\u00c1\u0001\u0000\u0000\u0000\u001a\u00c3"+
		"\u0001\u0000\u0000\u0000\u001c\u00c5\u0001\u0000\u0000\u0000\u001e\u00cc"+
		"\u0001\u0000\u0000\u0000 \u00cf\u0001\u0000\u0000\u0000\"\u00d7\u0001"+
		"\u0000\u0000\u0000$\u00df\u0001\u0000\u0000\u0000&\u00f2\u0001\u0000\u0000"+
		"\u0000(\u00f4\u0001\u0000\u0000\u0000*,\u0003\u0004\u0002\u0000+*\u0001"+
		"\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000"+
		"-.\u0001\u0000\u0000\u0000.0\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000"+
		"\u000001\u0003\u0002\u0001\u000012\u0005\u0000\u0000\u00012\u0001\u0001"+
		"\u0000\u0000\u000034\u0005\b\u0000\u000045\u0005\r\u0000\u000056\u0005"+
		"\f\u0000\u000068\u0005\u0016\u0000\u000079\u0003\u0006\u0003\u000087\u0001"+
		"\u0000\u0000\u000089\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000"+
		":;\u0005\u0017\u0000\u0000;<\u0005\u0014\u0000\u0000<=\u0003\n\u0005\u0000"+
		"=>\u0003\u000e\u0007\u0000>@\u0005\u0015\u0000\u0000?A\u0005\u0018\u0000"+
		"\u0000@?\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A\u0003\u0001"+
		"\u0000\u0000\u0000BC\u0005\b\u0000\u0000CD\u0005\r\u0000\u0000DE\u0005"+
		"\u0019\u0000\u0000EG\u0005\u0016\u0000\u0000FH\u0003\u0006\u0003\u0000"+
		"GF\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000"+
		"\u0000IJ\u0005\u0017\u0000\u0000JK\u0005\u0014\u0000\u0000KL\u0003\n\u0005"+
		"\u0000LM\u0003\u000e\u0007\u0000MO\u0005\u0015\u0000\u0000NP\u0005\u0018"+
		"\u0000\u0000ON\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\u0005"+
		"\u0001\u0000\u0000\u0000QV\u0003\b\u0004\u0000RS\u0005\u0001\u0000\u0000"+
		"SU\u0003\b\u0004\u0000TR\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000"+
		"VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000W\u0007\u0001\u0000"+
		"\u0000\u0000XV\u0001\u0000\u0000\u0000YZ\u0005\r\u0000\u0000Z[\u0005\u0019"+
		"\u0000\u0000[\t\u0001\u0000\u0000\u0000\\]\u0003\f\u0006\u0000]^\u0005"+
		"\u0018\u0000\u0000^`\u0001\u0000\u0000\u0000_\\\u0001\u0000\u0000\u0000"+
		"`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000b\u000b\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000de\u0005"+
		"\r\u0000\u0000ef\u0005\u0019\u0000\u0000fg\u0005\u0012\u0000\u0000gh\u0003"+
		"\"\u0011\u0000h\r\u0001\u0000\u0000\u0000ik\u0003\u0010\b\u0000ji\u0001"+
		"\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000"+
		"lm\u0001\u0000\u0000\u0000m\u000f\u0001\u0000\u0000\u0000nl\u0001\u0000"+
		"\u0000\u0000op\u0003\u0012\t\u0000pq\u0005\u0018\u0000\u0000q\u0081\u0001"+
		"\u0000\u0000\u0000rs\u0003\f\u0006\u0000st\u0005\u0018\u0000\u0000t\u0081"+
		"\u0001\u0000\u0000\u0000u\u0081\u0003\u0014\n\u0000v\u0081\u0003\u0016"+
		"\u000b\u0000wx\u0003\u001c\u000e\u0000xy\u0005\u0018\u0000\u0000y\u0081"+
		"\u0001\u0000\u0000\u0000z{\u0003\u001e\u000f\u0000{|\u0005\u0018\u0000"+
		"\u0000|\u0081\u0001\u0000\u0000\u0000}~\u0003(\u0014\u0000~\u007f\u0005"+
		"\u0018\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080o\u0001\u0000"+
		"\u0000\u0000\u0080r\u0001\u0000\u0000\u0000\u0080u\u0001\u0000\u0000\u0000"+
		"\u0080v\u0001\u0000\u0000\u0000\u0080w\u0001\u0000\u0000\u0000\u0080z"+
		"\u0001\u0000\u0000\u0000\u0080}\u0001\u0000\u0000\u0000\u0081\u0011\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0005\u0019\u0000\u0000\u0083\u0084\u0005"+
		"\u0012\u0000\u0000\u0084\u0085\u0003\"\u0011\u0000\u0085\u0013\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0005\u0004\u0000\u0000\u0087\u0088\u0005\u0016"+
		"\u0000\u0000\u0088\u0089\u0003\"\u0011\u0000\u0089\u008a\u0005\u0017\u0000"+
		"\u0000\u008a\u008b\u0005\u0014\u0000\u0000\u008b\u008c\u0003\u000e\u0007"+
		"\u0000\u008c\u0097\u0005\u0015\u0000\u0000\u008d\u008e\u0005\u0006\u0000"+
		"\u0000\u008e\u008f\u0005\u0016\u0000\u0000\u008f\u0090\u0003\"\u0011\u0000"+
		"\u0090\u0091\u0005\u0017\u0000\u0000\u0091\u0092\u0005\u0014\u0000\u0000"+
		"\u0092\u0093\u0003\u000e\u0007\u0000\u0093\u0094\u0005\u0015\u0000\u0000"+
		"\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u008d\u0001\u0000\u0000\u0000"+
		"\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u009f\u0001\u0000\u0000\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0005\u0000\u0000"+
		"\u009b\u009c\u0005\u0014\u0000\u0000\u009c\u009d\u0003\u000e\u0007\u0000"+
		"\u009d\u009e\u0005\u0015\u0000\u0000\u009e\u00a0\u0001\u0000\u0000\u0000"+
		"\u009f\u009a\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a0\u0015\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005\u0002\u0000\u0000"+
		"\u00a2\u00a3\u0005\u0016\u0000\u0000\u00a3\u00a4\u0003\"\u0011\u0000\u00a4"+
		"\u00a5\u0005\u0017\u0000\u0000\u00a5\u00a6\u0005\u0014\u0000\u0000\u00a6"+
		"\u00a7\u0003\u000e\u0007\u0000\u00a7\u00a8\u0005\u0015\u0000\u0000\u00a8"+
		"\u00a9\u0005\u0018\u0000\u0000\u00a9\u00be\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0005\u0003\u0000\u0000\u00ab\u00ad\u0005\u0016\u0000\u0000\u00ac"+
		"\u00ae\u0003\u0018\f\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b1"+
		"\u0005\u0018\u0000\u0000\u00b0\u00b2\u0003\"\u0011\u0000\u00b1\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b5\u0005\u0018\u0000\u0000\u00b4\u00b6\u0003"+
		"\u001a\r\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u0017"+
		"\u0000\u0000\u00b8\u00b9\u0005\u0014\u0000\u0000\u00b9\u00ba\u0003\u000e"+
		"\u0007\u0000\u00ba\u00bb\u0005\u0015\u0000\u0000\u00bb\u00bc\u0005\u0018"+
		"\u0000\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00a1\u0001\u0000"+
		"\u0000\u0000\u00bd\u00aa\u0001\u0000\u0000\u0000\u00be\u0017\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c2\u0003\f\u0006\u0000\u00c0\u00c2\u0003\u0012\t"+
		"\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c2\u0019\u0001\u0000\u0000\u0000\u00c3\u00c4\u0003\u0012\t\u0000"+
		"\u00c4\u001b\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005\u0019\u0000\u0000"+
		"\u00c6\u00c8\u0005\u0016\u0000\u0000\u00c7\u00c9\u0003 \u0010\u0000\u00c8"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005\u0017\u0000\u0000\u00cb"+
		"\u001d\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\u0007\u0000\u0000\u00cd"+
		"\u00ce\u0003\"\u0011\u0000\u00ce\u001f\u0001\u0000\u0000\u0000\u00cf\u00d4"+
		"\u0003\"\u0011\u0000\u00d0\u00d1\u0005\u0001\u0000\u0000\u00d1\u00d3\u0003"+
		"\"\u0011\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d5!\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d7\u00dc\u0003$\u0012\u0000\u00d8\u00d9\u0007\u0000\u0000\u0000"+
		"\u00d9\u00db\u0003$\u0012\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db"+
		"\u00de\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0001\u0000\u0000\u0000\u00dd#\u0001\u0000\u0000\u0000\u00de\u00dc"+
		"\u0001\u0000\u0000\u0000\u00df\u00e4\u0003&\u0013\u0000\u00e0\u00e1\u0005"+
		"\u000f\u0000\u0000\u00e1\u00e3\u0003&\u0013\u0000\u00e2\u00e0\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e6\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5%\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e7\u00e8\u0005\u0011\u0000"+
		"\u0000\u00e8\u00f3\u0003&\u0013\u0000\u00e9\u00f3\u0005\u0019\u0000\u0000"+
		"\u00ea\u00f3\u0005\u001a\u0000\u0000\u00eb\u00f3\u0005\u001b\u0000\u0000"+
		"\u00ec\u00f3\u0005\u001c\u0000\u0000\u00ed\u00ee\u0005\u0016\u0000\u0000"+
		"\u00ee\u00ef\u0003\"\u0011\u0000\u00ef\u00f0\u0005\u0017\u0000\u0000\u00f0"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f1\u00f3\u0003\u001c\u000e\u0000\u00f2"+
		"\u00e7\u0001\u0000\u0000\u0000\u00f2\u00e9\u0001\u0000\u0000\u0000\u00f2"+
		"\u00ea\u0001\u0000\u0000\u0000\u00f2\u00eb\u0001\u0000\u0000\u0000\u00f2"+
		"\u00ec\u0001\u0000\u0000\u0000\u00f2\u00ed\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f3\'\u0001\u0000\u0000\u0000\u00f4\u00f5"+
		"\u0005\n\u0000\u0000\u00f5\u00f6\u0005\u0016\u0000\u0000\u00f6\u00f7\u0003"+
		"\"\u0011\u0000\u00f7\u00f8\u0005\u0017\u0000\u0000\u00f8)\u0001\u0000"+
		"\u0000\u0000\u0015-8@GOVal\u0080\u0097\u009f\u00ad\u00b1\u00b5\u00bd\u00c1"+
		"\u00c8\u00d4\u00dc\u00e4\u00f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}