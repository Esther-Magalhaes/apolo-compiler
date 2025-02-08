grammar minhaGramatica;


//Regras do parser
programa       : funcao* principal EOF #NInicio;
principal      : FUNCAO TIPO 'PRINCIPAL' ABRIR_PAR parametros? FECHAR_PAR ABRIR_CH declaracoes comandos FECHAR_CH DELIMITADOR? #NPrincipal;
funcao         : FUNCAO TIPO ID ABRIR_PAR parametros? FECHAR_PAR ABRIR_CH declaracoes comandos FECHAR_CH DELIMITADOR? #NFuncao;
parametros     : parametro (',' parametro)* #NParametros;
parametro      : TIPO ID #NParametro;
declaracoes    : (declaracao_var DELIMITADOR)* #NDeclaracoes;
declaracao_var : TIPO ID OP_ATRIB expressao #NDeclaracaoVar;
comandos       : comando* #NComandos;
comando        : atribuicao DELIMITADOR #NComandoAtribuicao
               | declaracao_var DELIMITADOR #NComandoDeclaracaoVar
               | condicional #NComandoCondicional
               | loop #NComandoLoop
               | chamada_funcao DELIMITADOR #NComandoChamadaFuncao
               | retorno DELIMITADOR #NComandoRetorno
               | saida DELIMITADOR #NComandoSaida;
atribuicao     : ID OP_ATRIB expressao #NAtribuicao;
condicional    : SE ABRIR_PAR expressao FECHAR_PAR ABRIR_CH comandos FECHAR_CH
               (SENAO_SE ABRIR_PAR expressao FECHAR_PAR ABRIR_CH comandos FECHAR_CH)* 
               (SENAO ABRIR_CH comandos FECHAR_CH)? #NCondicional;
loop           : ENQUANTO ABRIR_PAR expressao FECHAR_PAR ABRIR_CH comandos FECHAR_CH DELIMITADOR #NLoopEnquanto
               | PARA ABRIR_PAR inicializacao? DELIMITADOR expressao? DELIMITADOR atualizacao? FECHAR_PAR ABRIR_CH comandos FECHAR_CH DELIMITADOR #NLoopPara;
inicializacao  : declaracao_var #NInicializacaoDeclaracaoVar
               | atribuicao #NInicializacaoAtribuicao;
atualizacao    : atribuicao #NAtualizacao;
chamada_funcao : ID ABRIR_PAR argumentos? FECHAR_PAR #NChamadaFuncao;
retorno        : RETORNAR expressao #NRetorno;
argumentos     : expressao (',' expressao)* #NArgumentos;
expressao      : termo ((OP_ARIT | OP_CONCAT | OP_BOOL) termo)* #NExpressao;
termo          : fator (OP_REL fator)* #NTermo;
fator          : OP_BOOL_NEG fator #NFatorNegacao
               | ID #NFatorID
               | NUM #NFatorNumero
               | VALOR_BOOL #NFatorValorBool
               | STRING_LITERAL #NFatorString
               | ABRIR_PAR expressao FECHAR_PAR #NFatorExpressao
               | chamada_funcao #NFatorChamadaFuncao;
saida          : SAIDA ABRIR_PAR expressao FECHAR_PAR ;

// Tokens específicos (Palavras-chave, Operadores, Delimitadores)

// Palavras-chave
ENQUANTO: 'while';     // Palavra-chave de loop
PARA: 'for';           // Palavra-chave de loop
SE: 'if';              // Palavra-chave condicional
SENAO: 'else';         // Palavra-chave condicional
SENAO_SE: 'elf';       // Se-Então-Senão
RETORNAR: 'return';    // Comando de retorno
FUNCAO: 'func';        // Palavra-chave de função
ENTRADA: 'input';      // Comando de entrada (removidos os parênteses)
SAIDA: 'print';        // Comando de saída (removidos os parênteses)
NULL: '_';             // Valor nulo          
PRINCIPAL: 'PRINCIPAL';// Palavra-chave de função principal

// Tipos de Dados
TIPO: 'int' | 'float' | 'double' | 'char' | 'str' | 'bool' | 'void'; 

// Operadores Aritméticos
OP_ARIT: '+' | '-' | '*' | '/' | '^' | '%'; 

// Operadores Relacionais
OP_REL: '=' | '!=' | '<=' | '>=' | '>' | '<';

// Operadores Booleanos
OP_BOOL: '&&' | '||';     
OP_BOOL_NEG: '!';      

// Operador de Atribuição
OP_ATRIB: '<-';           // Atribuição

// Operador de Concatenação de Cadeias de Caracteres
OP_CONCAT: '++';          // Concatenação de strings

// Delimitadores
ABRIR_CH: '{';         // Delimitador de abertura
FECHAR_CH: '}';        // Delimitador de fechamento
ABRIR_PAR: '(';        // Delimitador de abertura de parênteses
FECHAR_PAR: ')';       // Delimitador de fechamento de parênteses
DELIMITADOR: '.';      // Delimitador de instruções

// Identificadores (nomes de variáveis, funções, etc.)
ID: LETRA (DIGITO | LETRA)*;

// Números inteiros ou decimais
NUM: ('-'? DIGITO+ (',' DIGITO+)?);

// Literais booleanos
VALOR_BOOL: 'true' | 'false'; // Literais booleanos

// Reconhecedor de strings
STRING_LITERAL: '"' (~["\\] | '\\' .)* '"';

// Fragmentos
fragment LETRA: [a-zA-Z];
fragment DIGITO: [0-9];

// Ignorar espaços em branco
WS: [ \r\t\n]+ -> skip; // Ignorar espaços em branco

// Reconhecedor de comentários
COMENT: '#' ~[\r\n]* -> skip;

// Qualquer caractere que não tenha sido reconhecido
ErrorChar: . ;
