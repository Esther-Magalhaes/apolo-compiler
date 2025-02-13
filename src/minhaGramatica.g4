grammar minhaGramatica;


//Regras do parser
programa       : funcao* principal EOF #NInicio;
principal      : FUNCAO TIPO 'PRINCIPAL' ABRIR_PAR parametros? FECHAR_PAR ABRIR_CH declaracoes comandos FECHAR_CH DELIMITADOR? #NPrincipal; 
funcao         : FUNCAO TIPO ID ABRIR_PAR parametros? FECHAR_PAR ABRIR_CH declaracoes comandos FECHAR_CH DELIMITADOR? #NFuncao;
parametros     : parametro (',' parametro)* ;
parametro      : TIPO ID ;
declaracoes    : (declaracao_var DELIMITADOR)* ;
declaracao_var : TIPO ID OP_ATRIB expressao #NDeclaracaoValor;
comandos       : comando*;
comando        : atribuicao DELIMITADOR
               | declaracao_var DELIMITADOR
               | condicional
               | loop
               | chamada_funcao DELIMITADOR 
               | retorno DELIMITADOR 
               | saida DELIMITADOR ;
atribuicao     : ID OP_ATRIB expressao #NAtribuicao;
condicional : SE ABRIR_PAR expressao FECHAR_PAR ABRIR_CH comandos FECHAR_CH
              (SENAO_SE ABRIR_PAR expressao FECHAR_PAR ABRIR_CH comandos FECHAR_CH)*
              (SENAO ABRIR_CH comandos FECHAR_CH)?;
loop           : ENQUANTO ABRIR_PAR expressao FECHAR_PAR ABRIR_CH comandos FECHAR_CH DELIMITADOR
               | PARA ABRIR_PAR inicializacao? DELIMITADOR expressao? DELIMITADOR atualizacao? FECHAR_PAR ABRIR_CH comandos FECHAR_CH DELIMITADOR ;
inicializacao  : declaracao_var
               | atribuicao ;
atualizacao    : atribuicao ;
chamada_funcao : ID ABRIR_PAR argumentos? FECHAR_PAR #NChamada_funcao;
retorno        : RETORNAR expressao ;
argumentos     : expressao (',' expressao)* ;
expressao      : termo ((OP_ARIT | OP_CONCAT | OP_BOOL) termo)* #NExpressao;
termo          : fator (OP_REL fator)* ;
fator          : OP_BOOL_NEG fator 
               | ID 
               | NUM
               | VALOR_BOOL
               | STRING_LITERAL
               | ABRIR_PAR expressao FECHAR_PAR 
               | chamada_funcao ;
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


// Números inteiros ou decimais
NUM: ('-'? DIGITO+ (',' DIGITO+)?);

// Literais booleanos
VALOR_BOOL: 'true' | 'false'; // Literais booleanos

// Reconhecedor de strings
STRING_LITERAL: '"' (~["\\] | '\\' .)* '"';

// Identificadores (nomes de variáveis, funções, etc.)
ID: LETRA (DIGITO | LETRA)*;

// Fragmentos
fragment LETRA: [a-zA-Z];
fragment DIGITO: [0-9];

// Ignorar espaços em branco
WS: [ \r\t\n]+ -> skip; // Ignorar espaços em branco

// Reconhecedor de comentários
COMENT: '#' ~[\r\n]* -> skip;

// Qualquer caractere que não tenha sido reconhecido
ErrorChar: . ;