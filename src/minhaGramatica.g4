grammar minhaGramatica;

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

// Tipos de Dados
TIPO: 'int' | 'float' | 'double' | 'char' | 'str' | 'bool' | 'void'; 

// Operadores Aritméticos
OP_ARIT: '+' | '-' | '*' | '/' | '^' | '%'; 

// Operadores Relacionais
OP_REL: '=' | '!=' | '<=' | '>=' | '>' | '<';

// Operadores Lógicos
NEG: '!';              // Negação
E: '&&';               // E
OU: '||';              // OU

// Operador de Atribuição
ATRIB: '<-';           // Atribuição

// Operador de Concatenação de Cadeias de Caracteres
CONCAT: '++';          // Concatenação de strings

// Delimitadores
ABRIR_CH: '{';         // Delimitador de abertura
FECHAR_CH: '}';        // Delimitador de fechamento
ABRIR_PAR: '(';        // Delimitador de abertura de parênteses
FECHAR_PAR: ')';       // Delimitador de fechamento de parênteses
QUEBRA_DE_LINHA: '.';       // Quebra de linha

// Identificadores (nomes de variáveis, funções, etc.)
ID: LETRA (DIGITO | LETRA)*;

// Números inteiros ou decimais
NUM: DIGITO+ (',' DIGITO+)?;

// Literais booleanos
VALOR_BOOL: 'true' | 'false'; // Literais booleanos

// Reconhecedor de strings
STRING_LITERAL: '"' (~["\\] | '\\' .)* '"';

// Fragmentos
fragment LETRA: [a-zA-Z];
fragment DIGITO: [0-9];

// Ignorar espaços em branco
WS: [ \r\t\n]+ -> skip; // Ignorar espaços em branco

// Qualquer caractere que não tenha sido reconhecido
ErrorChar: . ;
