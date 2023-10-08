lexer grammar MyLexer;

NUM: [0-9]+;

PLUS: '+';
MINUS: '-';

MULTIPLE: '*';
DIVISION: '/';


LR_BRACKET: '(';
RR_BRACKET: ')';


/**
 * 空白は読み飛ばす
 */
SPACE: ' ' -> skip;