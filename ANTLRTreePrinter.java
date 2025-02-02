package org.antlr.tool;

import antlr.MismatchedTokenException;
import antlr.NoViableAltException;
import antlr.RecognitionException;
import antlr.Token;
import antlr.TreeParser;
import antlr.collections.AST;
import java.util.StringTokenizer;
/* loaded from: /storage/emulated/0/MT2/apks/Dixes/classes.dex */
public class ANTLRTreePrinter extends TreeParser implements ANTLRTreePrinterTokenTypes {
    public static final String[] _tokenNames = {"<0>", "EOF", "<2>", "NULL_TREE_LOOKAHEAD", "\"options\"", "\"tokens\"", "\"parser\"", "LEXER", "RULE", "BLOCK", "OPTIONAL", "CLOSURE", "POSITIVE_CLOSURE", "SYNPRED", "RANGE", "CHAR_RANGE", "EPSILON", "ALT", "EOR", "EOB", "EOA", "ID", "ARG", "ARGLIST", "RET", "LEXER_GRAMMAR", "PARSER_GRAMMAR", "TREE_GRAMMAR", "COMBINED_GRAMMAR", "INITACTION", "FORCED_ACTION", "LABEL", "TEMPLATE", "\"scope\"", "\"import\"", "GATED_SEMPRED", "SYN_SEMPRED", "BACKTRACK_SEMPRED", "\"fragment\"", "DOT", "ACTION", "DOC_COMMENT", "SEMI", "\"lexer\"", "\"tree\"", "\"grammar\"", "AMPERSAND", "COLON", "RCURLY", "ASSIGN", "STRING_LITERAL", "CHAR_LITERAL", "INT", "STAR", "COMMA", "TOKEN_REF", "\"protected\"", "\"public\"", "\"private\"", "BANG", "ARG_ACTION", "\"returns\"", "\"throws\"", "LPAREN", "OR", "RPAREN", "\"catch\"", "\"finally\"", "PLUS_ASSIGN", "SEMPRED", "IMPLIES", "ROOT", "WILDCARD", "RULE_REF", "NOT", "TREE_BEGIN", "QUESTION", "PLUS", "OPEN_ELEMENT_OPTION", "CLOSE_ELEMENT_OPTION", "REWRITE", "ETC", "DOLLAR", "DOUBLE_QUOTE_STRING_LITERAL", "DOUBLE_ANGLE_STRING_LITERAL", "WS", "COMMENT", "SL_COMMENT", "ML_COMMENT", "STRAY_BRACKET", "ESC", "DIGIT", "XDIGIT", "NESTED_ARG_ACTION", "NESTED_ACTION", "ACTION_CHAR_LITERAL", "ACTION_STRING_LITERAL", "ACTION_ESC", "WS_LOOP", "INTERNAL_RULE_REF", "WS_OPT", "SRC"};
    protected StringBuffer buf = new StringBuffer((int) Grammar.INITIAL_DECISION_LIST_SIZE);
    protected Grammar grammar;
    protected boolean showActions;

    public void out(String str) {
        this.buf.append(str);
    }

    public void reportError(RecognitionException recognitionException) {
        Token token;
        if (recognitionException instanceof MismatchedTokenException) {
            token = ((MismatchedTokenException) recognitionException).token;
        } else if (recognitionException instanceof NoViableAltException) {
            token = ((NoViableAltException) recognitionException).token;
        } else {
            token = null;
        }
        Grammar grammar = this.grammar;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("antlr.print: ");
        stringBuffer.append(recognitionException.toString());
        ErrorManager.syntaxError(100, grammar, token, stringBuffer.toString(), recognitionException);
    }

    public static String normalize(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ", false);
        StringBuffer stringBuffer = new StringBuffer();
        while (stringTokenizer.hasMoreTokens()) {
            stringBuffer.append(stringTokenizer.nextToken());
            stringBuffer.append(" ");
        }
        return stringBuffer.toString().trim();
    }

    public ANTLRTreePrinter() {
        this.tokenNames = _tokenNames;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:27:0x0058
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public final java.lang.String toString(antlr.collections.AST r3, org.antlr.tool.Grammar r4, boolean r5) throws antlr.RecognitionException {
        /*
            r2 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL
            if (r3 != r0) goto L_0x0006
            goto L_0x0009
        L_0x0006:
            r0 = r3
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0009:
            r2.grammar = r4
            r2.showActions = r5
            r4 = 0
            if (r3 != 0) goto L_0x0016
            antlr.ASTNULLType r5 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x0014
            r3 = r5
            goto L_0x0016
        L_0x0014:
            r5 = move-exception
            goto L_0x007b
        L_0x0016:
            int r5 = r3.getType()     // Catch: RecognitionException -> 0x0014
            switch(r5) {
                case 8: goto L_0x0069;
                case 9: goto L_0x0063;
                case 10: goto L_0x0063;
                case 11: goto L_0x0063;
                case 12: goto L_0x0063;
                case 13: goto L_0x0063;
                case 14: goto L_0x0063;
                case 15: goto L_0x0063;
                case 16: goto L_0x0063;
                case 17: goto L_0x005d;
                case 18: goto L_0x0047;
                default: goto L_0x001d;
            }     // Catch: RecognitionException -> 0x0014
        L_0x001d:
            switch(r5) {
                case 25: goto L_0x0041;
                case 26: goto L_0x0041;
                case 27: goto L_0x0041;
                case 28: goto L_0x0041;
                default: goto L_0x0020;
            }     // Catch: RecognitionException -> 0x0014
        L_0x0020:
            switch(r5) {
                case 30: goto L_0x0063;
                case 31: goto L_0x0063;
                default: goto L_0x0023;
            }     // Catch: RecognitionException -> 0x0014
        L_0x0023:
            switch(r5) {
                case 35: goto L_0x0063;
                case 36: goto L_0x0063;
                case 37: goto L_0x0063;
                default: goto L_0x0026;
            }     // Catch: RecognitionException -> 0x0014
        L_0x0026:
            switch(r5) {
                case 39: goto L_0x0063;
                case 40: goto L_0x0063;
                default: goto L_0x0029;
            }     // Catch: RecognitionException -> 0x0014
        L_0x0029:
            switch(r5) {
                case 49: goto L_0x0063;
                case 50: goto L_0x0063;
                case 51: goto L_0x0063;
                default: goto L_0x002c;
            }     // Catch: RecognitionException -> 0x0014
        L_0x002c:
            switch(r5) {
                case 68: goto L_0x0063;
                case 69: goto L_0x0063;
                default: goto L_0x002f;
            }     // Catch: RecognitionException -> 0x0014
        L_0x002f:
            switch(r5) {
                case 71: goto L_0x0063;
                case 72: goto L_0x0063;
                case 73: goto L_0x0063;
                case 74: goto L_0x0063;
                case 75: goto L_0x0063;
                default: goto L_0x0032;
            }     // Catch: RecognitionException -> 0x0014
        L_0x0032:
            switch(r5) {
                case 55: goto L_0x0063;
                case 59: goto L_0x0063;
                case 80: goto L_0x003b;
                default: goto L_0x0035;
            }     // Catch: RecognitionException -> 0x0014
        L_0x0035:
            antlr.NoViableAltException r5 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x0014
            r5.<init>(r3)     // Catch: RecognitionException -> 0x0014
            throw r5     // Catch: RecognitionException -> 0x0014
        L_0x003b:
            r2.single_rewrite(r3)     // Catch: RecognitionException -> 0x0014
            antlr.collections.AST r5 = r2._retTree     // Catch: RecognitionException -> 0x0014
            goto L_0x006f
        L_0x0041:
            r2.grammar(r3)     // Catch: RecognitionException -> 0x0014
            antlr.collections.AST r5 = r2._retTree     // Catch: RecognitionException -> 0x0014
            goto L_0x006f
        L_0x0047:
            r5 = r3
            org.antlr.tool.GrammarAST r5 = (org.antlr.tool.GrammarAST) r5     // Catch: RecognitionException -> 0x0014
            r5 = 18
            r2.match(r3, r5)     // Catch: RecognitionException -> 0x0014
            antlr.collections.AST r5 = r3.getNextSibling()     // Catch: RecognitionException -> 0x0014
            java.lang.String r3 = "EOR"
            r4 = r3
            goto L_0x006f
        L_0x0058:
            r3 = move-exception
            r1 = r5
            r5 = r3
            r3 = r1
            goto L_0x007b
        L_0x005d:
            r2.alternative(r3)     // Catch: RecognitionException -> 0x0014
            antlr.collections.AST r5 = r2._retTree     // Catch: RecognitionException -> 0x0014
            goto L_0x006f
        L_0x0063:
            r2.element(r3)     // Catch: RecognitionException -> 0x0014
            antlr.collections.AST r5 = r2._retTree     // Catch: RecognitionException -> 0x0014
            goto L_0x006f
        L_0x0069:
            r2.rule(r3)     // Catch: RecognitionException -> 0x0014
            antlr.collections.AST r5 = r2._retTree     // Catch: RecognitionException -> 0x0014
        L_0x006f:
            r3 = r5
            java.lang.StringBuffer r5 = r2.buf     // Catch: RecognitionException -> 0x0014
            java.lang.String r5 = r5.toString()     // Catch: RecognitionException -> 0x0014
            java.lang.String r5 = normalize(r5)     // Catch: RecognitionException -> 0x0014
            return r5
        L_0x007b:
            r2.reportError(r5)
            if (r3 == 0) goto L_0x0085
            antlr.collections.AST r3 = r3.getNextSibling()
        L_0x0085:
            r2._retTree = r3
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.toString(antlr.collections.AST, org.antlr.tool.Grammar, boolean):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void grammar(antlr.collections.AST r4) throws antlr.RecognitionException {
        /*
            r3 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL
            if (r4 != r0) goto L_0x0005
            goto L_0x0008
        L_0x0005:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0008:
            if (r4 != 0) goto L_0x0011
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x000e
            r4 = r0
            goto L_0x0011
        L_0x000e:
            r0 = move-exception
            goto L_0x008f
        L_0x0011:
            int r0 = r4.getType()     // Catch: RecognitionException -> 0x000e
            switch(r0) {
                case 25: goto L_0x006b;
                case 26: goto L_0x0051;
                case 27: goto L_0x0036;
                case 28: goto L_0x001c;
                default: goto L_0x0018;
            }     // Catch: RecognitionException -> 0x000e
        L_0x0018:
            antlr.NoViableAltException r0 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x000e
            goto L_0x008b
        L_0x001c:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r0 = 28
            r3.match(r4, r0)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r4.getFirstChild()     // Catch: RecognitionException -> 0x000e
            java.lang.String r1 = ""
            r3.grammarSpec(r0, r1)     // Catch: RecognitionException -> 0x0086
            antlr.collections.AST r1 = r3._retTree     // Catch: RecognitionException -> 0x0086
            antlr.collections.AST r0 = r4.getNextSibling()     // Catch: RecognitionException -> 0x000e
            goto L_0x0085
        L_0x0036:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r0 = 27
            r3.match(r4, r0)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r4.getFirstChild()     // Catch: RecognitionException -> 0x000e
            java.lang.String r1 = "tree "
            r3.grammarSpec(r0, r1)     // Catch: RecognitionException -> 0x0086
            antlr.collections.AST r1 = r3._retTree     // Catch: RecognitionException -> 0x0086
            antlr.collections.AST r0 = r4.getNextSibling()     // Catch: RecognitionException -> 0x000e
            goto L_0x0085
        L_0x0051:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r0 = 26
            r3.match(r4, r0)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r4.getFirstChild()     // Catch: RecognitionException -> 0x000e
            java.lang.String r1 = "parser "
            r3.grammarSpec(r0, r1)     // Catch: RecognitionException -> 0x0086
            antlr.collections.AST r1 = r3._retTree     // Catch: RecognitionException -> 0x0086
            antlr.collections.AST r0 = r4.getNextSibling()     // Catch: RecognitionException -> 0x000e
            goto L_0x0085
        L_0x006b:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r0 = 25
            r3.match(r4, r0)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r4.getFirstChild()     // Catch: RecognitionException -> 0x000e
            java.lang.String r1 = "lexer "
            r3.grammarSpec(r0, r1)     // Catch: RecognitionException -> 0x0086
            antlr.collections.AST r1 = r3._retTree     // Catch: RecognitionException -> 0x0086
            antlr.collections.AST r0 = r4.getNextSibling()     // Catch: RecognitionException -> 0x000e
        L_0x0085:
            goto L_0x009b
        L_0x0086:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L_0x008f
        L_0x008b:
            r0.<init>(r4)     // Catch: RecognitionException -> 0x000e
            throw r0     // Catch: RecognitionException -> 0x000e
        L_0x008f:
            r3.reportError(r0)
            if (r4 == 0) goto L_0x009a
            antlr.collections.AST r0 = r4.getNextSibling()
            goto L_0x009b
        L_0x009a:
            r0 = r4
        L_0x009b:
            r3._retTree = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.grammar(antlr.collections.AST):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0144 A[Catch: RecognitionException -> 0x019b, TryCatch #1 {RecognitionException -> 0x019b, blocks: (B:6:0x0019, B:12:0x002f, B:16:0x003b, B:17:0x003e, B:18:0x0043, B:19:0x0044, B:20:0x004d, B:34:0x00a8, B:37:0x00bb, B:38:0x00be, B:41:0x00c6, B:42:0x00cb, B:43:0x00cc, B:49:0x0100, B:50:0x0103, B:55:0x0116, B:56:0x011b, B:58:0x011d, B:60:0x0126, B:61:0x0129, B:65:0x0133, B:66:0x0138, B:67:0x0139, B:70:0x0144, B:71:0x0147, B:73:0x014d, B:74:0x0153, B:77:0x015d, B:78:0x0160, B:82:0x016c, B:84:0x0174, B:85:0x0177, B:86:0x017c, B:87:0x017d, B:88:0x0186), top: B:101:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014d A[Catch: RecognitionException -> 0x019b, TryCatch #1 {RecognitionException -> 0x019b, blocks: (B:6:0x0019, B:12:0x002f, B:16:0x003b, B:17:0x003e, B:18:0x0043, B:19:0x0044, B:20:0x004d, B:34:0x00a8, B:37:0x00bb, B:38:0x00be, B:41:0x00c6, B:42:0x00cb, B:43:0x00cc, B:49:0x0100, B:50:0x0103, B:55:0x0116, B:56:0x011b, B:58:0x011d, B:60:0x0126, B:61:0x0129, B:65:0x0133, B:66:0x0138, B:67:0x0139, B:70:0x0144, B:71:0x0147, B:73:0x014d, B:74:0x0153, B:77:0x015d, B:78:0x0160, B:82:0x016c, B:84:0x0174, B:85:0x0177, B:86:0x017c, B:87:0x017d, B:88:0x0186), top: B:101:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0153 A[Catch: RecognitionException -> 0x019b, TryCatch #1 {RecognitionException -> 0x019b, blocks: (B:6:0x0019, B:12:0x002f, B:16:0x003b, B:17:0x003e, B:18:0x0043, B:19:0x0044, B:20:0x004d, B:34:0x00a8, B:37:0x00bb, B:38:0x00be, B:41:0x00c6, B:42:0x00cb, B:43:0x00cc, B:49:0x0100, B:50:0x0103, B:55:0x0116, B:56:0x011b, B:58:0x011d, B:60:0x0126, B:61:0x0129, B:65:0x0133, B:66:0x0138, B:67:0x0139, B:70:0x0144, B:71:0x0147, B:73:0x014d, B:74:0x0153, B:77:0x015d, B:78:0x0160, B:82:0x016c, B:84:0x0174, B:85:0x0177, B:86:0x017c, B:87:0x017d, B:88:0x0186), top: B:101:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a6  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void rule(antlr.collections.AST r9) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 448
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.rule(antlr.collections.AST):void");
    }

    public final void alternative(AST ast) throws RecognitionException {
        GrammarAST grammarAST;
        RecognitionException e;
        int i;
        if (ast != ASTNULL) {
            GrammarAST grammarAST2 = (GrammarAST) ast;
        }
        try {
            GrammarAST grammarAST3 = (GrammarAST) ast;
            match(ast, 17);
            grammarAST = ast.getFirstChild();
            i = 0;
            while (true) {
                if (grammarAST == null) {
                    try {
                        grammarAST = ASTNULL;
                    } catch (RecognitionException e2) {
                        e = e2;
                        reportError(e);
                        if (grammarAST != null) {
                            grammarAST = grammarAST.getNextSibling();
                        }
                        this._retTree = grammarAST;
                        return;
                    }
                }
                if (!(grammarAST.getType() == 9 || grammarAST.getType() == 10 || grammarAST.getType() == 11 || grammarAST.getType() == 12 || grammarAST.getType() == 13 || grammarAST.getType() == 14 || grammarAST.getType() == 15 || grammarAST.getType() == 16 || grammarAST.getType() == 30 || grammarAST.getType() == 31 || grammarAST.getType() == 35 || grammarAST.getType() == 36 || grammarAST.getType() == 37 || grammarAST.getType() == 39 || grammarAST.getType() == 40 || grammarAST.getType() == 49 || grammarAST.getType() == 50 || grammarAST.getType() == 51 || grammarAST.getType() == 55 || grammarAST.getType() == 59 || grammarAST.getType() == 68 || grammarAST.getType() == 69 || grammarAST.getType() == 71 || grammarAST.getType() == 72 || grammarAST.getType() == 73 || grammarAST.getType() == 74 || grammarAST.getType() == 75)) {
                    break;
                }
                element(grammarAST);
                i++;
                grammarAST = this._retTree;
            }
        } catch (RecognitionException e3) {
            e = e3;
            grammarAST = ast;
        }
        if (i >= 1) {
            GrammarAST grammarAST4 = grammarAST;
            match(grammarAST, 20);
            grammarAST.getNextSibling();
            grammarAST = ast.getNextSibling();
            this._retTree = grammarAST;
            return;
        }
        throw new NoViableAltException(grammarAST);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0262 A[Catch: RecognitionException -> 0x0015, FALL_THROUGH, TRY_LEAVE, TryCatch #2 {RecognitionException -> 0x0015, blocks: (B:6:0x0011, B:9:0x0018, B:14:0x0025, B:15:0x0028, B:16:0x002b, B:17:0x002e, B:19:0x0033, B:20:0x0036, B:21:0x0039, B:22:0x003c, B:23:0x0041, B:24:0x0042, B:25:0x0049, B:27:0x0062, B:28:0x0068, B:30:0x007b, B:31:0x0081, B:36:0x00af, B:39:0x00e3, B:40:0x00e9, B:43:0x011e, B:44:0x0124, B:48:0x0149, B:49:0x0157, B:54:0x017d, B:59:0x01a8, B:66:0x01d2, B:67:0x01e0, B:70:0x01fd, B:71:0x0202, B:74:0x021f, B:75:0x0224, B:77:0x0237, B:81:0x0246, B:82:0x024c, B:84:0x025d, B:85:0x0262), top: B:95:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0274  */
    /* JADX WARN: Type inference failed for: r0v100 */
    /* JADX WARN: Type inference failed for: r0v101 */
    /* JADX WARN: Type inference failed for: r0v3, types: [antlr.collections.AST] */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v88 */
    /* JADX WARN: Type inference failed for: r0v89 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r0v90 */
    /* JADX WARN: Type inference failed for: r0v91 */
    /* JADX WARN: Type inference failed for: r0v92 */
    /* JADX WARN: Type inference failed for: r0v93 */
    /* JADX WARN: Type inference failed for: r0v94 */
    /* JADX WARN: Type inference failed for: r0v95 */
    /* JADX WARN: Type inference failed for: r0v96 */
    /* JADX WARN: Type inference failed for: r0v97 */
    /* JADX WARN: Type inference failed for: r0v98 */
    /* JADX WARN: Type inference failed for: r0v99 */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void element(antlr.collections.AST r5) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 710
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.element(antlr.collections.AST):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void single_rewrite(antlr.collections.AST r10) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 231
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.single_rewrite(antlr.collections.AST):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0071 A[Catch: RecognitionException -> 0x0112, TRY_ENTER, TryCatch #2 {RecognitionException -> 0x0112, blocks: (B:5:0x000a, B:10:0x0037, B:11:0x003b, B:12:0x003e, B:13:0x0042, B:19:0x0071, B:20:0x0074, B:21:0x0078, B:22:0x007b, B:24:0x0080, B:25:0x0087, B:27:0x008e, B:28:0x0091, B:32:0x00a0, B:33:0x00a3, B:34:0x00a8, B:35:0x00a9, B:37:0x00b4, B:38:0x00b7, B:43:0x00c5, B:44:0x00ca, B:46:0x00cc, B:49:0x00d5, B:50:0x00d8, B:52:0x00de, B:54:0x00e6, B:55:0x00e9, B:58:0x00f1, B:59:0x00f6, B:60:0x00f7, B:61:0x0100, B:62:0x0106, B:63:0x0109, B:64:0x010a, B:65:0x010d), top: B:79:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b A[Catch: RecognitionException -> 0x0112, TryCatch #2 {RecognitionException -> 0x0112, blocks: (B:5:0x000a, B:10:0x0037, B:11:0x003b, B:12:0x003e, B:13:0x0042, B:19:0x0071, B:20:0x0074, B:21:0x0078, B:22:0x007b, B:24:0x0080, B:25:0x0087, B:27:0x008e, B:28:0x0091, B:32:0x00a0, B:33:0x00a3, B:34:0x00a8, B:35:0x00a9, B:37:0x00b4, B:38:0x00b7, B:43:0x00c5, B:44:0x00ca, B:46:0x00cc, B:49:0x00d5, B:50:0x00d8, B:52:0x00de, B:54:0x00e6, B:55:0x00e9, B:58:0x00f1, B:59:0x00f6, B:60:0x00f7, B:61:0x0100, B:62:0x0106, B:63:0x0109, B:64:0x010a, B:65:0x010d), top: B:79:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080 A[Catch: RecognitionException -> 0x0112, TryCatch #2 {RecognitionException -> 0x0112, blocks: (B:5:0x000a, B:10:0x0037, B:11:0x003b, B:12:0x003e, B:13:0x0042, B:19:0x0071, B:20:0x0074, B:21:0x0078, B:22:0x007b, B:24:0x0080, B:25:0x0087, B:27:0x008e, B:28:0x0091, B:32:0x00a0, B:33:0x00a3, B:34:0x00a8, B:35:0x00a9, B:37:0x00b4, B:38:0x00b7, B:43:0x00c5, B:44:0x00ca, B:46:0x00cc, B:49:0x00d5, B:50:0x00d8, B:52:0x00de, B:54:0x00e6, B:55:0x00e9, B:58:0x00f1, B:59:0x00f6, B:60:0x00f7, B:61:0x0100, B:62:0x0106, B:63:0x0109, B:64:0x010a, B:65:0x010d), top: B:79:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008e A[Catch: RecognitionException -> 0x0112, TryCatch #2 {RecognitionException -> 0x0112, blocks: (B:5:0x000a, B:10:0x0037, B:11:0x003b, B:12:0x003e, B:13:0x0042, B:19:0x0071, B:20:0x0074, B:21:0x0078, B:22:0x007b, B:24:0x0080, B:25:0x0087, B:27:0x008e, B:28:0x0091, B:32:0x00a0, B:33:0x00a3, B:34:0x00a8, B:35:0x00a9, B:37:0x00b4, B:38:0x00b7, B:43:0x00c5, B:44:0x00ca, B:46:0x00cc, B:49:0x00d5, B:50:0x00d8, B:52:0x00de, B:54:0x00e6, B:55:0x00e9, B:58:0x00f1, B:59:0x00f6, B:60:0x00f7, B:61:0x0100, B:62:0x0106, B:63:0x0109, B:64:0x010a, B:65:0x010d), top: B:79:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a3 A[Catch: RecognitionException -> 0x0112, TryCatch #2 {RecognitionException -> 0x0112, blocks: (B:5:0x000a, B:10:0x0037, B:11:0x003b, B:12:0x003e, B:13:0x0042, B:19:0x0071, B:20:0x0074, B:21:0x0078, B:22:0x007b, B:24:0x0080, B:25:0x0087, B:27:0x008e, B:28:0x0091, B:32:0x00a0, B:33:0x00a3, B:34:0x00a8, B:35:0x00a9, B:37:0x00b4, B:38:0x00b7, B:43:0x00c5, B:44:0x00ca, B:46:0x00cc, B:49:0x00d5, B:50:0x00d8, B:52:0x00de, B:54:0x00e6, B:55:0x00e9, B:58:0x00f1, B:59:0x00f6, B:60:0x00f7, B:61:0x0100, B:62:0x0106, B:63:0x0109, B:64:0x010a, B:65:0x010d), top: B:79:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9 A[Catch: RecognitionException -> 0x0112, FALL_THROUGH, TryCatch #2 {RecognitionException -> 0x0112, blocks: (B:5:0x000a, B:10:0x0037, B:11:0x003b, B:12:0x003e, B:13:0x0042, B:19:0x0071, B:20:0x0074, B:21:0x0078, B:22:0x007b, B:24:0x0080, B:25:0x0087, B:27:0x008e, B:28:0x0091, B:32:0x00a0, B:33:0x00a3, B:34:0x00a8, B:35:0x00a9, B:37:0x00b4, B:38:0x00b7, B:43:0x00c5, B:44:0x00ca, B:46:0x00cc, B:49:0x00d5, B:50:0x00d8, B:52:0x00de, B:54:0x00e6, B:55:0x00e9, B:58:0x00f1, B:59:0x00f6, B:60:0x00f7, B:61:0x0100, B:62:0x0106, B:63:0x0109, B:64:0x010a, B:65:0x010d), top: B:79:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b4 A[Catch: RecognitionException -> 0x0112, TryCatch #2 {RecognitionException -> 0x0112, blocks: (B:5:0x000a, B:10:0x0037, B:11:0x003b, B:12:0x003e, B:13:0x0042, B:19:0x0071, B:20:0x0074, B:21:0x0078, B:22:0x007b, B:24:0x0080, B:25:0x0087, B:27:0x008e, B:28:0x0091, B:32:0x00a0, B:33:0x00a3, B:34:0x00a8, B:35:0x00a9, B:37:0x00b4, B:38:0x00b7, B:43:0x00c5, B:44:0x00ca, B:46:0x00cc, B:49:0x00d5, B:50:0x00d8, B:52:0x00de, B:54:0x00e6, B:55:0x00e9, B:58:0x00f1, B:59:0x00f6, B:60:0x00f7, B:61:0x0100, B:62:0x0106, B:63:0x0109, B:64:0x010a, B:65:0x010d), top: B:79:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cc A[Catch: RecognitionException -> 0x0112, TryCatch #2 {RecognitionException -> 0x0112, blocks: (B:5:0x000a, B:10:0x0037, B:11:0x003b, B:12:0x003e, B:13:0x0042, B:19:0x0071, B:20:0x0074, B:21:0x0078, B:22:0x007b, B:24:0x0080, B:25:0x0087, B:27:0x008e, B:28:0x0091, B:32:0x00a0, B:33:0x00a3, B:34:0x00a8, B:35:0x00a9, B:37:0x00b4, B:38:0x00b7, B:43:0x00c5, B:44:0x00ca, B:46:0x00cc, B:49:0x00d5, B:50:0x00d8, B:52:0x00de, B:54:0x00e6, B:55:0x00e9, B:58:0x00f1, B:59:0x00f6, B:60:0x00f7, B:61:0x0100, B:62:0x0106, B:63:0x0109, B:64:0x010a, B:65:0x010d), top: B:79:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d5 A[Catch: RecognitionException -> 0x0112, TryCatch #2 {RecognitionException -> 0x0112, blocks: (B:5:0x000a, B:10:0x0037, B:11:0x003b, B:12:0x003e, B:13:0x0042, B:19:0x0071, B:20:0x0074, B:21:0x0078, B:22:0x007b, B:24:0x0080, B:25:0x0087, B:27:0x008e, B:28:0x0091, B:32:0x00a0, B:33:0x00a3, B:34:0x00a8, B:35:0x00a9, B:37:0x00b4, B:38:0x00b7, B:43:0x00c5, B:44:0x00ca, B:46:0x00cc, B:49:0x00d5, B:50:0x00d8, B:52:0x00de, B:54:0x00e6, B:55:0x00e9, B:58:0x00f1, B:59:0x00f6, B:60:0x00f7, B:61:0x0100, B:62:0x0106, B:63:0x0109, B:64:0x010a, B:65:0x010d), top: B:79:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00de A[Catch: RecognitionException -> 0x0112, TryCatch #2 {RecognitionException -> 0x0112, blocks: (B:5:0x000a, B:10:0x0037, B:11:0x003b, B:12:0x003e, B:13:0x0042, B:19:0x0071, B:20:0x0074, B:21:0x0078, B:22:0x007b, B:24:0x0080, B:25:0x0087, B:27:0x008e, B:28:0x0091, B:32:0x00a0, B:33:0x00a3, B:34:0x00a8, B:35:0x00a9, B:37:0x00b4, B:38:0x00b7, B:43:0x00c5, B:44:0x00ca, B:46:0x00cc, B:49:0x00d5, B:50:0x00d8, B:52:0x00de, B:54:0x00e6, B:55:0x00e9, B:58:0x00f1, B:59:0x00f6, B:60:0x00f7, B:61:0x0100, B:62:0x0106, B:63:0x0109, B:64:0x010a, B:65:0x010d), top: B:79:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void grammarSpec(antlr.collections.AST r5, java.lang.String r6) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 354
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.grammarSpec(antlr.collections.AST, java.lang.String):void");
    }

    public final void attrScope(AST ast) throws RecognitionException {
        AST ast2;
        RecognitionException e;
        GrammarAST nextSibling;
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        try {
            GrammarAST grammarAST2 = (GrammarAST) ast;
            match(ast, 33);
            GrammarAST firstChild = ast.getFirstChild();
            try {
                GrammarAST grammarAST3 = firstChild;
                match(firstChild, 21);
                nextSibling = firstChild.getNextSibling();
            } catch (RecognitionException e2) {
                e = e2;
                ast = firstChild;
            }
        } catch (RecognitionException e3) {
            e = e3;
        }
        try {
            GrammarAST grammarAST4 = nextSibling;
            match(nextSibling, 40);
            nextSibling.getNextSibling();
            ast2 = ast.getNextSibling();
        } catch (RecognitionException e4) {
            e = e4;
            ast = nextSibling;
            reportError(e);
            if (ast != null) {
                ast2 = ast.getNextSibling();
            } else {
                ast2 = ast;
            }
            this._retTree = ast2;
        }
        this._retTree = ast2;
    }

    public final void optionsSpec(AST ast) throws RecognitionException {
        AST ast2;
        RecognitionException e;
        int i;
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        try {
            GrammarAST grammarAST2 = (GrammarAST) ast;
            match(ast, 4);
            ast2 = ast.getFirstChild();
            try {
                out(" options {");
                i = 0;
                while (true) {
                    if (ast2 == null) {
                        ast2 = ASTNULL;
                    }
                    if (ast2.getType() != 49) {
                        break;
                    }
                    option(ast2);
                    AST ast3 = this._retTree;
                    try {
                        out("; ");
                        i++;
                        ast2 = ast3;
                    } catch (RecognitionException e2) {
                        e = e2;
                        ast2 = ast3;
                        reportError(e);
                        if (ast2 != null) {
                            ast2 = ast2.getNextSibling();
                        }
                        this._retTree = ast2;
                        return;
                    }
                }
            } catch (RecognitionException e3) {
                e = e3;
            }
        } catch (RecognitionException e4) {
            e = e4;
            ast2 = ast;
        }
        if (i >= 1) {
            out("} ");
            ast2 = ast.getNextSibling();
            this._retTree = ast2;
            return;
        }
        throw new NoViableAltException(ast2);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void delegateGrammars(antlr.collections.AST r7) throws antlr.RecognitionException {
        /*
            r6 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL
            if (r7 != r0) goto L_0x0005
            goto L_0x0008
        L_0x0005:
            r0 = r7
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0008:
            r0 = r7
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x0072
            r0 = 34
            r6.match(r7, r0)     // Catch: RecognitionException -> 0x0072
            antlr.collections.AST r0 = r7.getFirstChild()     // Catch: RecognitionException -> 0x0072
            r1 = 0
        L_0x0016:
            if (r0 != 0) goto L_0x001e
            antlr.ASTNULLType r2 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x001c
            r0 = r2
            goto L_0x001e
        L_0x001c:
            r7 = move-exception
            goto L_0x0076
        L_0x001e:
            int r2 = r0.getType()     // Catch: RecognitionException -> 0x001c
            r3 = 21
            if (r2 == r3) goto L_0x0063
            r4 = 49
            if (r2 == r4) goto L_0x0039
            r2 = 1
            if (r1 < r2) goto L_0x0033
            antlr.collections.AST r0 = r7.getNextSibling()     // Catch: RecognitionException -> 0x0072
            goto L_0x007f
        L_0x0033:
            antlr.NoViableAltException r7 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x001c
            r7.<init>(r0)     // Catch: RecognitionException -> 0x001c
            throw r7     // Catch: RecognitionException -> 0x001c
        L_0x0039:
            r2 = r0
            org.antlr.tool.GrammarAST r2 = (org.antlr.tool.GrammarAST) r2     // Catch: RecognitionException -> 0x001c
            r6.match(r0, r4)     // Catch: RecognitionException -> 0x001c
            antlr.collections.AST r2 = r0.getFirstChild()     // Catch: RecognitionException -> 0x001c
            r4 = r2
            org.antlr.tool.GrammarAST r4 = (org.antlr.tool.GrammarAST) r4     // Catch: RecognitionException -> 0x0060
            r6.match(r2, r3)     // Catch: RecognitionException -> 0x0060
            antlr.collections.AST r4 = r2.getNextSibling()     // Catch: RecognitionException -> 0x0060
            r2 = r4
            org.antlr.tool.GrammarAST r2 = (org.antlr.tool.GrammarAST) r2     // Catch: RecognitionException -> 0x005d
            r6.match(r4, r3)     // Catch: RecognitionException -> 0x005d
            r4.getNextSibling()     // Catch: RecognitionException -> 0x005d
            antlr.collections.AST r2 = r0.getNextSibling()     // Catch: RecognitionException -> 0x001c
            goto L_0x006e
        L_0x005d:
            r7 = move-exception
            r0 = r4
            goto L_0x0076
        L_0x0060:
            r7 = move-exception
            r0 = r2
            goto L_0x0076
        L_0x0063:
            r2 = r0
            org.antlr.tool.GrammarAST r2 = (org.antlr.tool.GrammarAST) r2     // Catch: RecognitionException -> 0x001c
            r6.match(r0, r3)     // Catch: RecognitionException -> 0x001c
            antlr.collections.AST r2 = r0.getNextSibling()     // Catch: RecognitionException -> 0x001c
        L_0x006e:
            r0 = r2
            int r1 = r1 + 1
            goto L_0x0016
        L_0x0072:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L_0x0076:
            r6.reportError(r7)
            if (r0 == 0) goto L_0x007f
            antlr.collections.AST r0 = r0.getNextSibling()
        L_0x007f:
            r6._retTree = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.delegateGrammars(antlr.collections.AST):void");
    }

    public final void tokensSpec(AST ast) throws RecognitionException {
        AST ast2;
        RecognitionException e;
        int i;
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        try {
            GrammarAST grammarAST2 = (GrammarAST) ast;
            match(ast, 5);
            ast2 = ast.getFirstChild();
            i = 0;
            while (true) {
                if (ast2 == null) {
                    try {
                        ast2 = ASTNULL;
                    } catch (RecognitionException e2) {
                        e = e2;
                        reportError(e);
                        if (ast2 != null) {
                            ast2 = ast2.getNextSibling();
                        }
                        this._retTree = ast2;
                        return;
                    }
                }
                if (ast2.getType() != 49 && ast2.getType() != 55) {
                    break;
                }
                tokenSpec(ast2);
                i++;
                ast2 = this._retTree;
            }
        } catch (RecognitionException e3) {
            e = e3;
            ast2 = ast;
        }
        if (i >= 1) {
            ast2 = ast.getNextSibling();
            this._retTree = ast2;
            return;
        }
        throw new NoViableAltException(ast2);
    }

    public final void actions(AST ast) throws RecognitionException {
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        int i = 0;
        while (true) {
            if (ast == null) {
                try {
                    ast = ASTNULL;
                } catch (RecognitionException e) {
                    reportError(e);
                    if (ast != null) {
                        ast = ast.getNextSibling();
                    }
                }
            }
            if (ast.getType() != 46) {
                break;
            }
            action(ast);
            i++;
            ast = this._retTree;
        }
        if (i >= 1) {
            this._retTree = ast;
            return;
        }
        throw new NoViableAltException(ast);
    }

    public final void rules(AST ast) throws RecognitionException {
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        int i = 0;
        while (true) {
            if (ast == null) {
                try {
                    ast = ASTNULL;
                } catch (RecognitionException e) {
                    reportError(e);
                    if (ast != null) {
                        ast = ast.getNextSibling();
                    }
                }
            }
            if (ast.getType() != 8) {
                break;
            }
            rule(ast);
            i++;
            ast = this._retTree;
        }
        if (i >= 1) {
            this._retTree = ast;
            return;
        }
        throw new NoViableAltException(ast);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void action(antlr.collections.AST r7) throws antlr.RecognitionException {
        /*
            r6 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL
            if (r7 != r0) goto L_0x0005
            goto L_0x0008
        L_0x0005:
            r0 = r7
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0008:
            r0 = r7
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x00b8
            r0 = 46
            r6.match(r7, r0)     // Catch: RecognitionException -> 0x00b8
            antlr.collections.AST r0 = r7.getFirstChild()     // Catch: RecognitionException -> 0x00b8
            r1 = r0
            org.antlr.tool.GrammarAST r1 = (org.antlr.tool.GrammarAST) r1     // Catch: RecognitionException -> 0x00b5
            r2 = 21
            r6.match(r0, r2)     // Catch: RecognitionException -> 0x00b5
            antlr.collections.AST r3 = r0.getNextSibling()     // Catch: RecognitionException -> 0x00b5
            if (r3 != 0) goto L_0x002f
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x002c
            goto L_0x0030
        L_0x002c:
            r7 = move-exception
            goto L_0x00bb
        L_0x002f:
            r0 = r3
        L_0x0030:
            int r3 = r0.getType()     // Catch: RecognitionException -> 0x00b5
            r4 = 40
            if (r3 == r2) goto L_0x0054
            if (r3 == r4) goto L_0x0040
            antlr.NoViableAltException r7 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x00b5
            r7.<init>(r0)     // Catch: RecognitionException -> 0x00b5
            throw r7     // Catch: RecognitionException -> 0x00b5
        L_0x0040:
            r2 = r0
            org.antlr.tool.GrammarAST r2 = (org.antlr.tool.GrammarAST) r2     // Catch: RecognitionException -> 0x00b5
            r6.match(r0, r4)     // Catch: RecognitionException -> 0x00b5
            antlr.collections.AST r3 = r0.getNextSibling()     // Catch: RecognitionException -> 0x00b5
            r0 = 0
            java.lang.String r1 = r1.getText()     // Catch: RecognitionException -> 0x002c
            java.lang.String r2 = r2.getText()     // Catch: RecognitionException -> 0x002c
            goto L_0x0079
        L_0x0054:
            r3 = r0
            org.antlr.tool.GrammarAST r3 = (org.antlr.tool.GrammarAST) r3     // Catch: RecognitionException -> 0x00b5
            r6.match(r0, r2)     // Catch: RecognitionException -> 0x00b5
            antlr.collections.AST r2 = r0.getNextSibling()     // Catch: RecognitionException -> 0x00b5
            r0 = r2
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x00b2
            r6.match(r2, r4)     // Catch: RecognitionException -> 0x00b2
            antlr.collections.AST r3 = r2.getNextSibling()     // Catch: RecognitionException -> 0x00b2
            java.lang.String r1 = r1.getText()     // Catch: RecognitionException -> 0x002c
            java.lang.String r2 = r0.getText()     // Catch: RecognitionException -> 0x002c
            java.lang.String r0 = r0.getText()     // Catch: RecognitionException -> 0x002c
            r5 = r2
            r2 = r0
            r0 = r1
            r1 = r5
        L_0x0079:
            antlr.collections.AST r3 = r7.getNextSibling()     // Catch: RecognitionException -> 0x00b8
            boolean r7 = r6.showActions     // Catch: RecognitionException -> 0x002c
            if (r7 == 0) goto L_0x00b1
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch: RecognitionException -> 0x002c
            r7.<init>()     // Catch: RecognitionException -> 0x002c
            java.lang.String r4 = "@"
            r7.append(r4)     // Catch: RecognitionException -> 0x002c
            if (r0 == 0) goto L_0x009f
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch: RecognitionException -> 0x002c
            r4.<init>()     // Catch: RecognitionException -> 0x002c
            r4.append(r0)     // Catch: RecognitionException -> 0x002c
            java.lang.String r0 = "::"
            r4.append(r0)     // Catch: RecognitionException -> 0x002c
            java.lang.String r0 = r4.toString()     // Catch: RecognitionException -> 0x002c
            goto L_0x00a1
        L_0x009f:
            java.lang.String r0 = ""
        L_0x00a1:
            r7.append(r0)     // Catch: RecognitionException -> 0x002c
            r7.append(r1)     // Catch: RecognitionException -> 0x002c
            r7.append(r2)     // Catch: RecognitionException -> 0x002c
            java.lang.String r7 = r7.toString()     // Catch: RecognitionException -> 0x002c
            r6.out(r7)     // Catch: RecognitionException -> 0x002c
        L_0x00b1:
            goto L_0x00c4
        L_0x00b2:
            r7 = move-exception
            r3 = r2
            goto L_0x00bb
        L_0x00b5:
            r7 = move-exception
            r3 = r0
            goto L_0x00bb
        L_0x00b8:
            r0 = move-exception
            r3 = r7
            r7 = r0
        L_0x00bb:
            r6.reportError(r7)
            if (r3 == 0) goto L_0x00c4
            antlr.collections.AST r3 = r3.getNextSibling()
        L_0x00c4:
            r6._retTree = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.action(antlr.collections.AST):void");
    }

    public final void option(AST ast) throws RecognitionException {
        AST ast2;
        GrammarAST grammarAST;
        RecognitionException e;
        GrammarAST grammarAST2;
        if (ast != ASTNULL) {
            GrammarAST grammarAST3 = (GrammarAST) ast;
        }
        try {
            GrammarAST grammarAST4 = (GrammarAST) ast;
            match(ast, 49);
            GrammarAST firstChild = ast.getFirstChild();
            try {
                grammarAST2 = firstChild;
                match(firstChild, 21);
                grammarAST = firstChild.getNextSibling();
            } catch (RecognitionException e2) {
                e = e2;
                grammarAST = firstChild;
            }
        } catch (RecognitionException e3) {
            e = e3;
            grammarAST = ast;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(grammarAST2.getText());
            stringBuffer.append("=");
            out(stringBuffer.toString());
            optionValue(grammarAST);
            AST ast3 = this._retTree;
            ast2 = ast.getNextSibling();
        } catch (RecognitionException e4) {
            e = e4;
            reportError(e);
            if (grammarAST != null) {
                ast2 = grammarAST.getNextSibling();
            } else {
                ast2 = grammarAST;
            }
            this._retTree = ast2;
        }
        this._retTree = ast2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Type inference failed for: r1v1, types: [antlr.collections.AST] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void optionValue(antlr.collections.AST r3) throws antlr.RecognitionException {
        /*
            r2 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL
            if (r3 != r0) goto L_0x0005
            goto L_0x0008
        L_0x0005:
            r0 = r3
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0008:
            if (r3 != 0) goto L_0x0015
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x0012
            r3 = r0
            goto L_0x0015
        L_0x0012:
            r0 = move-exception
            r1 = r3
            goto L_0x0076
        L_0x0015:
            int r0 = r3.getType()     // Catch: RecognitionException -> 0x0012
            r1 = 21
            if (r0 == r1) goto L_0x0062
            switch(r0) {
                case 50: goto L_0x004e;
                case 51: goto L_0x003a;
                case 52: goto L_0x0026;
                default: goto L_0x0020;
            }     // Catch: RecognitionException -> 0x0012
        L_0x0020:
            antlr.NoViableAltException r0 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x0012
            r0.<init>(r3)     // Catch: RecognitionException -> 0x0012
            throw r0     // Catch: RecognitionException -> 0x0012
        L_0x0026:
            r0 = r3
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x0012
            r1 = 52
            r2.match(r3, r1)     // Catch: RecognitionException -> 0x0012
            antlr.collections.AST r1 = r3.getNextSibling()     // Catch: RecognitionException -> 0x0012
            java.lang.String r3 = r0.getText()     // Catch: RecognitionException -> 0x0075
            r2.out(r3)     // Catch: RecognitionException -> 0x0075
            goto L_0x0074
        L_0x003a:
            r0 = r3
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x0012
            r1 = 51
            r2.match(r3, r1)     // Catch: RecognitionException -> 0x0012
            antlr.collections.AST r1 = r3.getNextSibling()     // Catch: RecognitionException -> 0x0012
            java.lang.String r3 = r0.getText()     // Catch: RecognitionException -> 0x0075
            r2.out(r3)     // Catch: RecognitionException -> 0x0075
            goto L_0x0074
        L_0x004e:
            r0 = r3
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x0012
            r1 = 50
            r2.match(r3, r1)     // Catch: RecognitionException -> 0x0012
            antlr.collections.AST r1 = r3.getNextSibling()     // Catch: RecognitionException -> 0x0012
            java.lang.String r3 = r0.getText()     // Catch: RecognitionException -> 0x0075
            r2.out(r3)     // Catch: RecognitionException -> 0x0075
            goto L_0x0074
        L_0x0062:
            r0 = r3
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x0012
            r2.match(r3, r1)     // Catch: RecognitionException -> 0x0012
            antlr.collections.AST r1 = r3.getNextSibling()     // Catch: RecognitionException -> 0x0012
            java.lang.String r3 = r0.getText()     // Catch: RecognitionException -> 0x0075
            r2.out(r3)     // Catch: RecognitionException -> 0x0075
        L_0x0074:
            goto L_0x007f
        L_0x0075:
            r0 = move-exception
        L_0x0076:
            r2.reportError(r0)
            if (r1 == 0) goto L_0x007f
            antlr.collections.AST r1 = r1.getNextSibling()
        L_0x007f:
            r2._retTree = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.optionValue(antlr.collections.AST):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void tokenSpec(antlr.collections.AST r5) throws antlr.RecognitionException {
        /*
            r4 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL
            if (r5 != r0) goto L_0x0005
            goto L_0x0008
        L_0x0005:
            r0 = r5
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0008:
            if (r5 != 0) goto L_0x0014
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x000e
            r5 = r0
            goto L_0x0014
        L_0x000e:
            r0 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
            goto L_0x007e
        L_0x0014:
            int r0 = r5.getType()     // Catch: RecognitionException -> 0x000e
            r1 = 49
            r2 = 55
            if (r0 == r1) goto L_0x0031
            if (r0 == r2) goto L_0x0026
            antlr.NoViableAltException r0 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x000e
            r0.<init>(r5)     // Catch: RecognitionException -> 0x000e
            throw r0     // Catch: RecognitionException -> 0x000e
        L_0x0026:
            r0 = r5
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r4.match(r5, r2)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r5.getNextSibling()     // Catch: RecognitionException -> 0x000e
            goto L_0x0078
        L_0x0031:
            r0 = r5
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r4.match(r5, r1)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r5.getFirstChild()     // Catch: RecognitionException -> 0x000e
            r1 = r0
            org.antlr.tool.GrammarAST r1 = (org.antlr.tool.GrammarAST) r1     // Catch: RecognitionException -> 0x007d
            r4.match(r0, r2)     // Catch: RecognitionException -> 0x007d
            antlr.collections.AST r1 = r0.getNextSibling()     // Catch: RecognitionException -> 0x007d
            if (r1 != 0) goto L_0x004f
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x004b
            goto L_0x0050
        L_0x004b:
            r0 = move-exception
            r5 = r0
            r0 = r1
            goto L_0x007e
        L_0x004f:
            r0 = r1
        L_0x0050:
            int r1 = r0.getType()     // Catch: RecognitionException -> 0x007d
            switch(r1) {
                case 50: goto L_0x0066;
                case 51: goto L_0x005a;
                default: goto L_0x0057;
            }     // Catch: RecognitionException -> 0x007d
        L_0x0057:
            antlr.NoViableAltException r5 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x007d
            goto L_0x0079
        L_0x005a:
            r1 = r0
            org.antlr.tool.GrammarAST r1 = (org.antlr.tool.GrammarAST) r1     // Catch: RecognitionException -> 0x007d
            r1 = 51
            r4.match(r0, r1)     // Catch: RecognitionException -> 0x007d
            r0.getNextSibling()     // Catch: RecognitionException -> 0x007d
            goto L_0x0072
        L_0x0066:
            r1 = r0
            org.antlr.tool.GrammarAST r1 = (org.antlr.tool.GrammarAST) r1     // Catch: RecognitionException -> 0x007d
            r1 = 50
            r4.match(r0, r1)     // Catch: RecognitionException -> 0x007d
            r0.getNextSibling()     // Catch: RecognitionException -> 0x007d
        L_0x0072:
            antlr.collections.AST r0 = r5.getNextSibling()     // Catch: RecognitionException -> 0x000e
        L_0x0078:
            goto L_0x0087
        L_0x0079:
            r5.<init>(r0)     // Catch: RecognitionException -> 0x007d
            throw r5     // Catch: RecognitionException -> 0x007d
        L_0x007d:
            r5 = move-exception
        L_0x007e:
            r4.reportError(r5)
            if (r0 == 0) goto L_0x0087
            antlr.collections.AST r0 = r0.getNextSibling()
        L_0x0087:
            r4._retTree = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.tokenSpec(antlr.collections.AST):void");
    }

    public final void modifier(AST ast) throws RecognitionException {
        AST ast2;
        out((ast == ASTNULL ? null : (GrammarAST) ast).getText());
        out(" ");
        if (ast == null) {
            try {
                ast = ASTNULL;
            } catch (RecognitionException e) {
                reportError(e);
                if (ast != null) {
                    ast2 = ast.getNextSibling();
                } else {
                    ast2 = ast;
                }
            }
        }
        int type = ast.getType();
        if (type != 38) {
            switch (type) {
                case 56:
                    GrammarAST grammarAST = (GrammarAST) ast;
                    match(ast, 56);
                    ast2 = ast.getNextSibling();
                    break;
                case 57:
                    GrammarAST grammarAST2 = (GrammarAST) ast;
                    match(ast, 57);
                    ast2 = ast.getNextSibling();
                    break;
                case 58:
                    GrammarAST grammarAST3 = (GrammarAST) ast;
                    match(ast, 58);
                    ast2 = ast.getNextSibling();
                    break;
                default:
                    throw new NoViableAltException(ast);
            }
        } else {
            GrammarAST grammarAST4 = (GrammarAST) ast;
            match(ast, 38);
            ast2 = ast.getNextSibling();
        }
        this._retTree = ast2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042 A[Catch: RecognitionException -> 0x001b, TryCatch #1 {RecognitionException -> 0x001b, blocks: (B:7:0x0017, B:10:0x001d, B:15:0x002c, B:16:0x0031, B:17:0x0032, B:20:0x0042, B:21:0x0045, B:23:0x004b), top: B:34:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004b A[Catch: RecognitionException -> 0x001b, TRY_LEAVE, TryCatch #1 {RecognitionException -> 0x001b, blocks: (B:7:0x0017, B:10:0x001d, B:15:0x002c, B:16:0x0031, B:17:0x0032, B:20:0x0042, B:21:0x0045, B:23:0x004b), top: B:34:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057 A[Catch: RecognitionException -> 0x005c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {RecognitionException -> 0x005c, blocks: (B:5:0x0009, B:24:0x0057), top: B:32:0x0009 }] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void ruleScopeSpec(antlr.collections.AST r6) throws antlr.RecognitionException {
        /*
            r5 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL
            if (r6 != r0) goto L_0x0005
            goto L_0x0008
        L_0x0005:
            r0 = r6
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0008:
            r0 = r6
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x005c
            r0 = 33
            r5.match(r6, r0)     // Catch: RecognitionException -> 0x005c
            antlr.collections.AST r0 = r6.getFirstChild()     // Catch: RecognitionException -> 0x005c
            if (r0 != 0) goto L_0x001d
            antlr.ASTNULLType r1 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x001b
            r0 = r1
            goto L_0x001d
        L_0x001b:
            r6 = move-exception
            goto L_0x0060
        L_0x001d:
            int r1 = r0.getType()     // Catch: RecognitionException -> 0x001b
            r2 = 3
            r3 = 21
            if (r1 == r2) goto L_0x003f
            if (r1 == r3) goto L_0x003f
            r2 = 40
            if (r1 == r2) goto L_0x0032
            antlr.NoViableAltException r6 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x001b
            r6.<init>(r0)     // Catch: RecognitionException -> 0x001b
            throw r6     // Catch: RecognitionException -> 0x001b
        L_0x0032:
            r1 = r0
            org.antlr.tool.GrammarAST r1 = (org.antlr.tool.GrammarAST) r1     // Catch: RecognitionException -> 0x001b
            r5.match(r0, r2)     // Catch: RecognitionException -> 0x001b
            antlr.collections.AST r1 = r0.getNextSibling()     // Catch: RecognitionException -> 0x001b
        L_0x003d:
            r0 = r1
            goto L_0x0040
        L_0x003f:
        L_0x0040:
            if (r0 != 0) goto L_0x0045
            antlr.ASTNULLType r1 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x001b
            r0 = r1
        L_0x0045:
            int r1 = r0.getType()     // Catch: RecognitionException -> 0x001b
            if (r1 != r3) goto L_0x0056
            r1 = r0
            org.antlr.tool.GrammarAST r1 = (org.antlr.tool.GrammarAST) r1     // Catch: RecognitionException -> 0x001b
            r5.match(r0, r3)     // Catch: RecognitionException -> 0x001b
            antlr.collections.AST r1 = r0.getNextSibling()     // Catch: RecognitionException -> 0x001b
            goto L_0x003d
        L_0x0056:
            antlr.collections.AST r0 = r6.getNextSibling()     // Catch: RecognitionException -> 0x005c
            goto L_0x0069
        L_0x005c:
            r0 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x0060:
            r5.reportError(r6)
            if (r0 == 0) goto L_0x0069
            antlr.collections.AST r0 = r0.getNextSibling()
        L_0x0069:
            r5._retTree = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.ruleScopeSpec(antlr.collections.AST):void");
    }

    public final void ruleAction(AST ast) throws RecognitionException {
        GrammarAST grammarAST;
        RecognitionException e;
        GrammarAST grammarAST2;
        GrammarAST nextSibling;
        if (ast != ASTNULL) {
            GrammarAST grammarAST3 = (GrammarAST) ast;
        }
        try {
            GrammarAST grammarAST4 = (GrammarAST) ast;
            match(ast, 46);
            GrammarAST firstChild = ast.getFirstChild();
            try {
                grammarAST2 = firstChild;
                match(firstChild, 21);
                nextSibling = firstChild.getNextSibling();
            } catch (RecognitionException e2) {
                e = e2;
                grammarAST = firstChild;
            }
        } catch (RecognitionException e3) {
            e = e3;
            grammarAST = ast;
        }
        try {
            GrammarAST grammarAST5 = nextSibling;
            match(nextSibling, 40);
            nextSibling.getNextSibling();
            grammarAST = ast.getNextSibling();
            if (this.showActions) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("@");
                stringBuffer.append(grammarAST2.getText());
                stringBuffer.append("{");
                stringBuffer.append(grammarAST5.getText());
                stringBuffer.append("}");
                out(stringBuffer.toString());
            }
        } catch (RecognitionException e4) {
            e = e4;
            reportError(e);
            if (grammarAST != null) {
                grammarAST = grammarAST.getNextSibling();
            }
            this._retTree = grammarAST;
        }
        this._retTree = grammarAST;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void block(antlr.collections.AST r8, boolean r9) throws antlr.RecognitionException {
        /*
            r7 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL
            if (r8 != r0) goto L_0x0006
            r0 = 0
            goto L_0x0009
        L_0x0006:
            r0 = r8
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0009:
            int r0 = r7.countAltsForBlock(r0)
            r1 = r8
            org.antlr.tool.GrammarAST r1 = (org.antlr.tool.GrammarAST) r1     // Catch: RecognitionException -> 0x008d
            r1 = 9
            r7.match(r8, r1)     // Catch: RecognitionException -> 0x008d
            antlr.collections.AST r1 = r8.getFirstChild()     // Catch: RecognitionException -> 0x008d
            r2 = 1
            if (r9 != 0) goto L_0x001f
            if (r0 <= r2) goto L_0x0024
        L_0x001f:
            java.lang.String r3 = " ("
            r7.out(r3)     // Catch: RecognitionException -> 0x008a
        L_0x0024:
            if (r1 != 0) goto L_0x0029
            antlr.ASTNULLType r3 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x008a
            r1 = r3
        L_0x0029:
            int r3 = r1.getType()     // Catch: RecognitionException -> 0x008a
            r4 = 4
            r5 = 17
            if (r3 == r4) goto L_0x003b
            if (r3 == r5) goto L_0x003a
            antlr.NoViableAltException r8 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x008a
            r8.<init>(r1)     // Catch: RecognitionException -> 0x008a
            throw r8     // Catch: RecognitionException -> 0x008a
        L_0x003a:
            goto L_0x0047
        L_0x003b:
            r7.optionsSpec(r1)     // Catch: RecognitionException -> 0x008a
            antlr.collections.AST r3 = r7._retTree     // Catch: RecognitionException -> 0x008a
            java.lang.String r1 = " : "
            r7.out(r1)     // Catch: RecognitionException -> 0x0087
            r1 = r3
        L_0x0047:
            r7.alternative(r1)     // Catch: RecognitionException -> 0x008a
            antlr.collections.AST r3 = r7._retTree     // Catch: RecognitionException -> 0x008a
            r7.rewrite(r3)     // Catch: RecognitionException -> 0x0087
            antlr.collections.AST r1 = r7._retTree     // Catch: RecognitionException -> 0x0087
        L_0x0051:
            if (r1 != 0) goto L_0x0056
            antlr.ASTNULLType r3 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x008a
            r1 = r3
        L_0x0056:
            int r3 = r1.getType()     // Catch: RecognitionException -> 0x008a
            if (r3 != r5) goto L_0x006c
            java.lang.String r3 = " | "
            r7.out(r3)     // Catch: RecognitionException -> 0x008a
            r7.alternative(r1)     // Catch: RecognitionException -> 0x008a
            antlr.collections.AST r3 = r7._retTree     // Catch: RecognitionException -> 0x008a
            r7.rewrite(r3)     // Catch: RecognitionException -> 0x0087
            antlr.collections.AST r1 = r7._retTree     // Catch: RecognitionException -> 0x0087
            goto L_0x0051
        L_0x006c:
            r3 = r1
            org.antlr.tool.GrammarAST r3 = (org.antlr.tool.GrammarAST) r3     // Catch: RecognitionException -> 0x008a
            r3 = 19
            r7.match(r1, r3)     // Catch: RecognitionException -> 0x008a
            antlr.collections.AST r3 = r1.getNextSibling()     // Catch: RecognitionException -> 0x008a
            if (r9 != 0) goto L_0x007c
            if (r0 <= r2) goto L_0x0081
        L_0x007c:
            java.lang.String r9 = ")"
            r7.out(r9)     // Catch: RecognitionException -> 0x0087
        L_0x0081:
            antlr.collections.AST r9 = r8.getNextSibling()     // Catch: RecognitionException -> 0x008d
            goto L_0x009a
        L_0x0087:
            r8 = move-exception
            r9 = r3
            goto L_0x0091
        L_0x008a:
            r8 = move-exception
            r9 = r1
            goto L_0x0091
        L_0x008d:
            r9 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x0091:
            r7.reportError(r8)
            if (r9 == 0) goto L_0x009a
            antlr.collections.AST r9 = r9.getNextSibling()
        L_0x009a:
            r7._retTree = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.block(antlr.collections.AST, boolean):void");
    }

    public final void exceptionGroup(AST ast) throws RecognitionException {
        AST ast2;
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        if (ast == null) {
            try {
                ast = ASTNULL;
            } catch (RecognitionException e) {
                reportError(e);
                if (ast != null) {
                    ast2 = ast.getNextSibling();
                } else {
                    ast2 = ast;
                }
            }
        }
        switch (ast.getType()) {
            case 66:
                int i = 0;
                while (true) {
                    if (ast == null) {
                        ast = ASTNULL;
                    }
                    if (ast.getType() == 66) {
                        exceptionHandler(ast);
                        i++;
                        ast = this._retTree;
                    } else if (i >= 1) {
                        if (ast == null) {
                            ast = ASTNULL;
                        }
                        int type = ast.getType();
                        if (type != 18) {
                            if (type == 67) {
                                finallyClause(ast);
                                ast2 = this._retTree;
                                break;
                            } else {
                                throw new NoViableAltException(ast);
                            }
                        } else {
                            ast2 = ast;
                            break;
                        }
                    } else {
                        throw new NoViableAltException(ast);
                    }
                }
            case 67:
                finallyClause(ast);
                ast2 = this._retTree;
                break;
            default:
                throw new NoViableAltException(ast);
        }
        this._retTree = ast2;
    }

    public final void rewrite(AST ast) throws RecognitionException {
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        while (true) {
            if (ast == null) {
                try {
                    ast = ASTNULL;
                } catch (RecognitionException e) {
                    reportError(e);
                    if (ast != null) {
                        ast = ast.getNextSibling();
                    }
                }
            }
            if (ast.getType() != 80) {
                break;
            }
            single_rewrite(ast);
            ast = this._retTree;
        }
        this._retTree = ast;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final int countAltsForBlock(antlr.collections.AST r8) throws antlr.RecognitionException {
        /*
            r7 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL
            if (r8 != r0) goto L_0x0006
            goto L_0x0009
        L_0x0006:
            r0 = r8
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0009:
            r0 = 0
            r1 = r8
            org.antlr.tool.GrammarAST r1 = (org.antlr.tool.GrammarAST) r1     // Catch: RecognitionException -> 0x009a
            r1 = 9
            r7.match(r8, r1)     // Catch: RecognitionException -> 0x009a
            antlr.collections.AST r1 = r8.getFirstChild()     // Catch: RecognitionException -> 0x009a
            if (r1 != 0) goto L_0x0021
            antlr.ASTNULLType r2 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x001d
            r1 = r2
            goto L_0x0021
        L_0x001d:
            r8 = move-exception
            r0 = r1
            goto L_0x009d
        L_0x0021:
            int r2 = r1.getType()     // Catch: RecognitionException -> 0x001d
            r3 = 4
            r4 = 17
            if (r2 == r3) goto L_0x0033
            if (r2 == r4) goto L_0x0032
            antlr.NoViableAltException r8 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x001d
            r8.<init>(r1)     // Catch: RecognitionException -> 0x001d
            throw r8     // Catch: RecognitionException -> 0x001d
        L_0x0032:
            goto L_0x003f
        L_0x0033:
            r2 = r1
            org.antlr.tool.GrammarAST r2 = (org.antlr.tool.GrammarAST) r2     // Catch: RecognitionException -> 0x001d
            r7.match(r1, r3)     // Catch: RecognitionException -> 0x001d
            antlr.collections.AST r2 = r1.getNextSibling()     // Catch: RecognitionException -> 0x001d
            r1 = r2
        L_0x003f:
            r2 = 0
        L_0x0040:
            if (r1 != 0) goto L_0x0049
            antlr.ASTNULLType r3 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x0046
            r1 = r3
            goto L_0x0049
        L_0x0046:
            r8 = move-exception
            r0 = r1
            goto L_0x009e
        L_0x0049:
            int r3 = r1.getType()     // Catch: RecognitionException -> 0x0046
            if (r3 != r4) goto L_0x007b
            r3 = r1
            org.antlr.tool.GrammarAST r3 = (org.antlr.tool.GrammarAST) r3     // Catch: RecognitionException -> 0x0046
            r7.match(r1, r4)     // Catch: RecognitionException -> 0x0046
            antlr.collections.AST r3 = r1.getNextSibling()     // Catch: RecognitionException -> 0x0046
        L_0x0059:
            if (r3 != 0) goto L_0x0061
            antlr.ASTNULLType r1 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x005e
            goto L_0x0062
        L_0x005e:
            r8 = move-exception
            r0 = r3
            goto L_0x009e
        L_0x0061:
            r1 = r3
        L_0x0062:
            int r3 = r1.getType()     // Catch: RecognitionException -> 0x0046
            r5 = 80
            if (r3 != r5) goto L_0x0075
            r3 = r1
            org.antlr.tool.GrammarAST r3 = (org.antlr.tool.GrammarAST) r3     // Catch: RecognitionException -> 0x0046
            r7.match(r1, r5)     // Catch: RecognitionException -> 0x0046
            antlr.collections.AST r3 = r1.getNextSibling()     // Catch: RecognitionException -> 0x0046
            goto L_0x0059
        L_0x0075:
            int r2 = r2 + 1
            int r0 = r0 + 1
            goto L_0x0040
        L_0x007b:
            r3 = 1
            if (r0 < r3) goto L_0x0094
            r0 = r1
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x0046
            r0 = 19
            r7.match(r1, r0)     // Catch: RecognitionException -> 0x0046
            r1.getNextSibling()     // Catch: RecognitionException -> 0x0046
            antlr.collections.AST r0 = r8.getNextSibling()     // Catch: RecognitionException -> 0x008f
            goto L_0x00a7
        L_0x008f:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
            goto L_0x009e
        L_0x0094:
            antlr.NoViableAltException r8 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x0046
            r8.<init>(r1)     // Catch: RecognitionException -> 0x0046
            throw r8     // Catch: RecognitionException -> 0x0046
        L_0x009a:
            r1 = move-exception
            r0 = r8
            r8 = r1
        L_0x009d:
            r2 = 0
        L_0x009e:
            r7.reportError(r8)
            if (r0 == 0) goto L_0x00a7
            antlr.collections.AST r0 = r0.getNextSibling()
        L_0x00a7:
            r7._retTree = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.countAltsForBlock(antlr.collections.AST):int");
    }

    public final void exceptionHandler(AST ast) throws RecognitionException {
        AST ast2;
        RecognitionException e;
        GrammarAST nextSibling;
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        try {
            GrammarAST grammarAST2 = (GrammarAST) ast;
            match(ast, 66);
            GrammarAST firstChild = ast.getFirstChild();
            try {
                GrammarAST grammarAST3 = firstChild;
                match(firstChild, 60);
                nextSibling = firstChild.getNextSibling();
            } catch (RecognitionException e2) {
                e = e2;
                ast = firstChild;
            }
        } catch (RecognitionException e3) {
            e = e3;
        }
        try {
            GrammarAST grammarAST4 = nextSibling;
            match(nextSibling, 40);
            nextSibling.getNextSibling();
            ast2 = ast.getNextSibling();
        } catch (RecognitionException e4) {
            e = e4;
            ast = nextSibling;
            reportError(e);
            if (ast != null) {
                ast2 = ast.getNextSibling();
            } else {
                ast2 = ast;
            }
            this._retTree = ast2;
        }
        this._retTree = ast2;
    }

    public final void finallyClause(AST ast) throws RecognitionException {
        AST ast2;
        RecognitionException e;
        GrammarAST firstChild;
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        try {
            GrammarAST grammarAST2 = (GrammarAST) ast;
            match(ast, 67);
            firstChild = ast.getFirstChild();
        } catch (RecognitionException e2) {
            e = e2;
        }
        try {
            GrammarAST grammarAST3 = firstChild;
            match(firstChild, 40);
            firstChild.getNextSibling();
            ast2 = ast.getNextSibling();
        } catch (RecognitionException e3) {
            e = e3;
            ast = firstChild;
            reportError(e);
            if (ast != null) {
                ast2 = ast.getNextSibling();
            } else {
                ast2 = ast;
            }
            this._retTree = ast2;
        }
        this._retTree = ast2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void rewrite_template(antlr.collections.AST r9) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 384
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.rewrite_template(antlr.collections.AST):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 2, insn: 0x021e: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:114:0x021e
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public final void atom(
    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 2, insn: 0x021e: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:114:0x021e
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:228)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:198)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:151)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:364)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3, types: [antlr.collections.AST] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void ebnf(antlr.collections.AST r4) throws antlr.RecognitionException {
        /*
            r3 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL
            if (r4 != r0) goto L_0x0005
            goto L_0x0008
        L_0x0005:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0008:
            if (r4 != 0) goto L_0x0011
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x000e
            r4 = r0
            goto L_0x0011
        L_0x000e:
            r0 = move-exception
            goto L_0x0088
        L_0x0011:
            int r0 = r4.getType()     // Catch: RecognitionException -> 0x000e
            r1 = 1
            switch(r0) {
                case 9: goto L_0x0073;
                case 10: goto L_0x0056;
                case 11: goto L_0x0039;
                case 12: goto L_0x001c;
                default: goto L_0x0019;
            }     // Catch: RecognitionException -> 0x000e
        L_0x0019:
            antlr.NoViableAltException r0 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x000e
            goto L_0x0084
        L_0x001c:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r0 = 12
            r3.match(r4, r0)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r4.getFirstChild()     // Catch: RecognitionException -> 0x000e
            r3.block(r0, r1)     // Catch: RecognitionException -> 0x007f
            antlr.collections.AST r1 = r3._retTree     // Catch: RecognitionException -> 0x007f
            antlr.collections.AST r0 = r4.getNextSibling()     // Catch: RecognitionException -> 0x000e
            java.lang.String r4 = "+ "
            r3.out(r4)     // Catch: RecognitionException -> 0x007f
            goto L_0x007e
        L_0x0039:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r0 = 11
            r3.match(r4, r0)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r4.getFirstChild()     // Catch: RecognitionException -> 0x000e
            r3.block(r0, r1)     // Catch: RecognitionException -> 0x007f
            antlr.collections.AST r1 = r3._retTree     // Catch: RecognitionException -> 0x007f
            antlr.collections.AST r0 = r4.getNextSibling()     // Catch: RecognitionException -> 0x000e
            java.lang.String r4 = "* "
            r3.out(r4)     // Catch: RecognitionException -> 0x007f
            goto L_0x007e
        L_0x0056:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r0 = 10
            r3.match(r4, r0)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r4.getFirstChild()     // Catch: RecognitionException -> 0x000e
            r3.block(r0, r1)     // Catch: RecognitionException -> 0x007f
            antlr.collections.AST r1 = r3._retTree     // Catch: RecognitionException -> 0x007f
            antlr.collections.AST r0 = r4.getNextSibling()     // Catch: RecognitionException -> 0x000e
            java.lang.String r4 = "? "
            r3.out(r4)     // Catch: RecognitionException -> 0x007f
            goto L_0x007e
        L_0x0073:
            r3.block(r4, r1)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r3._retTree     // Catch: RecognitionException -> 0x000e
            java.lang.String r4 = " "
            r3.out(r4)     // Catch: RecognitionException -> 0x007f
        L_0x007e:
            goto L_0x0094
        L_0x007f:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L_0x0088
        L_0x0084:
            r0.<init>(r4)     // Catch: RecognitionException -> 0x000e
            throw r0     // Catch: RecognitionException -> 0x000e
        L_0x0088:
            r3.reportError(r0)
            if (r4 == 0) goto L_0x0093
            antlr.collections.AST r0 = r4.getNextSibling()
            goto L_0x0094
        L_0x0093:
            r0 = r4
        L_0x0094:
            r3._retTree = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.ebnf(antlr.collections.AST):void");
    }

    public final void tree(AST ast) throws RecognitionException {
        AST ast2;
        RecognitionException e;
        AST ast3;
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        try {
            GrammarAST grammarAST2 = (GrammarAST) ast;
            match(ast, 75);
            AST firstChild = ast.getFirstChild();
            try {
                out(" ^(");
                element(firstChild);
                AST ast4 = this._retTree;
                while (true) {
                    if (ast4 == null) {
                        try {
                            ast3 = ASTNULL;
                        } catch (RecognitionException e2) {
                            e = e2;
                            ast2 = ast4;
                            reportError(e);
                            if (ast2 != null) {
                                ast2 = ast2.getNextSibling();
                            }
                            this._retTree = ast2;
                        }
                    } else {
                        ast3 = ast4;
                    }
                    if (!(ast3.getType() == 9 || ast3.getType() == 10 || ast3.getType() == 11 || ast3.getType() == 12 || ast3.getType() == 13 || ast3.getType() == 14 || ast3.getType() == 15 || ast3.getType() == 16 || ast3.getType() == 30 || ast3.getType() == 31 || ast3.getType() == 35 || ast3.getType() == 36 || ast3.getType() == 37 || ast3.getType() == 39 || ast3.getType() == 40 || ast3.getType() == 49 || ast3.getType() == 50 || ast3.getType() == 51 || ast3.getType() == 55 || ast3.getType() == 59 || ast3.getType() == 68 || ast3.getType() == 69 || ast3.getType() == 71 || ast3.getType() == 72 || ast3.getType() == 73 || ast3.getType() == 74 || ast3.getType() == 75)) {
                        break;
                    }
                    element(ast3);
                    ast4 = this._retTree;
                }
                out(") ");
                ast2 = ast.getNextSibling();
            } catch (RecognitionException e3) {
                e = e3;
                ast2 = ast3;
            }
        } catch (RecognitionException e4) {
            e = e4;
            ast2 = ast;
        }
        this._retTree = ast2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v3, types: [antlr.collections.AST] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void ast_suffix(antlr.collections.AST r4) throws antlr.RecognitionException {
        /*
            r3 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL
            if (r4 != r0) goto L_0x0005
            goto L_0x0008
        L_0x0005:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0008:
            if (r4 != 0) goto L_0x0010
            antlr.ASTNULLType r0 = org.antlr.tool.ANTLRTreePrinter.ASTNULL     // Catch: RecognitionException -> 0x000e
            r4 = r0
            goto L_0x0010
        L_0x000e:
            r0 = move-exception
            goto L_0x0047
        L_0x0010:
            int r0 = r4.getType()     // Catch: RecognitionException -> 0x000e
            r1 = 59
            if (r0 == r1) goto L_0x0032
            r1 = 71
            if (r0 == r1) goto L_0x0022
            antlr.NoViableAltException r0 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x000e
            r0.<init>(r4)     // Catch: RecognitionException -> 0x000e
            throw r0     // Catch: RecognitionException -> 0x000e
        L_0x0022:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r3.match(r4, r1)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r4.getNextSibling()     // Catch: RecognitionException -> 0x000e
            java.lang.String r4 = "^"
            r3.out(r4)     // Catch: RecognitionException -> 0x0043
            goto L_0x0042
        L_0x0032:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r3.match(r4, r1)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r4.getNextSibling()     // Catch: RecognitionException -> 0x000e
            java.lang.String r4 = "!"
            r3.out(r4)     // Catch: RecognitionException -> 0x0043
        L_0x0042:
            goto L_0x0052
        L_0x0043:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
        L_0x0047:
            r3.reportError(r0)
            if (r4 == 0) goto L_0x0051
            antlr.collections.AST r0 = r4.getNextSibling()
            goto L_0x0052
        L_0x0051:
            r0 = r4
        L_0x0052:
            r3._retTree = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.ANTLRTreePrinter.ast_suffix(antlr.collections.AST):void");
    }
}
