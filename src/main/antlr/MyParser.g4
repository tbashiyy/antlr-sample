parser grammar MyParser;

options { tokenVocab=MyLexer; }

exp: NUM | LR_BRACKET exp RR_BRACKET | exp DIVISION exp | exp MULTIPLE exp | exp PLUS exp | exp MINUS exp;