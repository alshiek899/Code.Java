package org.antlr.tool;

import antlr.ASTNULLType;
import antlr.MismatchedTokenException;
import antlr.NoViableAltException;
import antlr.RecognitionException;
import antlr.SemanticException;
import antlr.Token;
import antlr.TreeParser;
import antlr.collections.AST;
import antlr.collections.impl.BitSet;
import java.util.LinkedList;
import org.antlr.analysis.NFA;
import org.antlr.analysis.NFAState;
import org.antlr.analysis.Transition;
import org.antlr.misc.IntSet;
import org.antlr.misc.IntervalSet;
/* loaded from: /storage/emulated/0/MT2/apks/Dixes/classes.dex */
public class TreeToNFAConverter extends TreeParser implements TreeToNFAConverterTokenTypes {
    public static final String[] _tokenNames = {"<0>", "EOF", "<2>", "NULL_TREE_LOOKAHEAD", "\"options\"", "\"tokens\"", "\"parser\"", "LEXER", "RULE", "BLOCK", "OPTIONAL", "CLOSURE", "POSITIVE_CLOSURE", "SYNPRED", "RANGE", "CHAR_RANGE", "EPSILON", "ALT", "EOR", "EOB", "EOA", "ID", "ARG", "ARGLIST", "RET", "LEXER_GRAMMAR", "PARSER_GRAMMAR", "TREE_GRAMMAR", "COMBINED_GRAMMAR", "INITACTION", "FORCED_ACTION", "LABEL", "TEMPLATE", "\"scope\"", "\"import\"", "GATED_SEMPRED", "SYN_SEMPRED", "BACKTRACK_SEMPRED", "\"fragment\"", "DOT", "ACTION", "DOC_COMMENT", "SEMI", "\"lexer\"", "\"tree\"", "\"grammar\"", "AMPERSAND", "COLON", "RCURLY", "ASSIGN", "STRING_LITERAL", "CHAR_LITERAL", "INT", "STAR", "COMMA", "TOKEN_REF", "\"protected\"", "\"public\"", "\"private\"", "BANG", "ARG_ACTION", "\"returns\"", "\"throws\"", "LPAREN", "OR", "RPAREN", "\"catch\"", "\"finally\"", "PLUS_ASSIGN", "SEMPRED", "IMPLIES", "ROOT", "WILDCARD", "RULE_REF", "NOT", "TREE_BEGIN", "QUESTION", "PLUS", "OPEN_ELEMENT_OPTION", "CLOSE_ELEMENT_OPTION", "REWRITE", "ETC", "DOLLAR", "DOUBLE_QUOTE_STRING_LITERAL", "DOUBLE_ANGLE_STRING_LITERAL", "WS", "COMMENT", "SL_COMMENT", "ML_COMMENT", "STRAY_BRACKET", "ESC", "DIGIT", "XDIGIT", "NESTED_ARG_ACTION", "NESTED_ACTION", "ACTION_CHAR_LITERAL", "ACTION_STRING_LITERAL", "ACTION_ESC", "WS_LOOP", "INTERNAL_RULE_REF", "WS_OPT", "SRC"};
    public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
    protected int blockLevel;
    protected String currentRuleName;
    protected NFAFactory factory;
    protected Grammar grammar;
    protected NFA nfa;
    protected int outerAltNum;

    public TreeToNFAConverter(Grammar grammar, NFA nfa, NFAFactory nFAFactory) {
        this();
        this.grammar = grammar;
        this.nfa = nfa;
        this.factory = nFAFactory;
    }

    protected void addFollowTransition(String str, NFAState nFAState) {
        NFAState nFAState2 = this.grammar.getRule(str).stopState;
        while (nFAState2.transition(1) != null) {
            nFAState2 = (NFAState) nFAState2.transition(1).target;
        }
        if (nFAState2.transition(0) != null) {
            NFAState newState = this.factory.newState();
            nFAState2.addTransition(new Transition(-5, newState));
            nFAState2 = newState;
        }
        nFAState2.addTransition(new Transition(-5, nFAState));
    }

    protected void finish() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.grammar.getRules());
        if (this.factory.build_EOFStates(linkedList) == 0) {
            ErrorManager.grammarWarning(138, this.grammar, null, this.grammar.name);
        }
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
        stringBuffer.append("buildnfa: ");
        stringBuffer.append(recognitionException.toString());
        ErrorManager.syntaxError(100, grammar, token, stringBuffer.toString(), recognitionException);
    }

    public TreeToNFAConverter() {
        this.factory = null;
        this.nfa = null;
        this.grammar = null;
        this.currentRuleName = null;
        this.outerAltNum = 0;
        this.blockLevel = 0;
        this.tokenNames = _tokenNames;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void grammar(antlr.collections.AST r4) throws antlr.RecognitionException {
        /*
            r3 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.TreeToNFAConverter.ASTNULL
            if (r4 != r0) goto L_0x0005
            goto L_0x0008
        L_0x0005:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0008:
            if (r4 != 0) goto L_0x0011
            antlr.ASTNULLType r0 = org.antlr.tool.TreeToNFAConverter.ASTNULL     // Catch: RecognitionException -> 0x000e
            r4 = r0
            goto L_0x0011
        L_0x000e:
            r0 = move-exception
            goto L_0x0089
        L_0x0011:
            int r0 = r4.getType()     // Catch: RecognitionException -> 0x000e
            switch(r0) {
                case 25: goto L_0x0063;
                case 26: goto L_0x004b;
                case 27: goto L_0x0033;
                case 28: goto L_0x001b;
                default: goto L_0x0018;
            }     // Catch: RecognitionException -> 0x000e
        L_0x0018:
            antlr.NoViableAltException r0 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x000e
            goto L_0x0085
        L_0x001b:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r0 = 28
            r3.match(r4, r0)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r4.getFirstChild()     // Catch: RecognitionException -> 0x000e
            r3.grammarSpec(r0)     // Catch: RecognitionException -> 0x0080
            antlr.collections.AST r1 = r3._retTree     // Catch: RecognitionException -> 0x0080
            antlr.collections.AST r0 = r4.getNextSibling()     // Catch: RecognitionException -> 0x000e
            goto L_0x007b
        L_0x0033:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r0 = 27
            r3.match(r4, r0)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r4.getFirstChild()     // Catch: RecognitionException -> 0x000e
            r3.grammarSpec(r0)     // Catch: RecognitionException -> 0x0080
            antlr.collections.AST r1 = r3._retTree     // Catch: RecognitionException -> 0x0080
            antlr.collections.AST r0 = r4.getNextSibling()     // Catch: RecognitionException -> 0x000e
            goto L_0x007b
        L_0x004b:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r0 = 26
            r3.match(r4, r0)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r4.getFirstChild()     // Catch: RecognitionException -> 0x000e
            r3.grammarSpec(r0)     // Catch: RecognitionException -> 0x0080
            antlr.collections.AST r1 = r3._retTree     // Catch: RecognitionException -> 0x0080
            antlr.collections.AST r0 = r4.getNextSibling()     // Catch: RecognitionException -> 0x000e
            goto L_0x007b
        L_0x0063:
            r0 = r4
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0     // Catch: RecognitionException -> 0x000e
            r0 = 25
            r3.match(r4, r0)     // Catch: RecognitionException -> 0x000e
            antlr.collections.AST r0 = r4.getFirstChild()     // Catch: RecognitionException -> 0x000e
            r3.grammarSpec(r0)     // Catch: RecognitionException -> 0x0080
            antlr.collections.AST r1 = r3._retTree     // Catch: RecognitionException -> 0x0080
            antlr.collections.AST r0 = r4.getNextSibling()     // Catch: RecognitionException -> 0x000e
        L_0x007b:
            r4 = r0
            r3.finish()     // Catch: RecognitionException -> 0x000e
            goto L_0x0093
        L_0x0080:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L_0x0089
        L_0x0085:
            r0.<init>(r4)     // Catch: RecognitionException -> 0x000e
            throw r0     // Catch: RecognitionException -> 0x000e
        L_0x0089:
            r3.reportError(r0)
            if (r4 == 0) goto L_0x0093
            antlr.collections.AST r4 = r4.getNextSibling()
        L_0x0093:
            r3._retTree = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.TreeToNFAConverter.grammar(antlr.collections.AST):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00ea A[Catch: RecognitionException -> 0x0120, TryCatch #1 {RecognitionException -> 0x0120, blocks: (B:5:0x0009, B:11:0x0021, B:12:0x0025, B:13:0x0028, B:14:0x002c, B:16:0x003e, B:17:0x0041, B:18:0x0045, B:19:0x0048, B:21:0x004d, B:27:0x0068, B:29:0x0070, B:30:0x0073, B:34:0x0082, B:35:0x0085, B:36:0x008a, B:37:0x008b, B:43:0x00a7, B:45:0x00b1, B:46:0x00b4, B:51:0x00c2, B:52:0x00c7, B:54:0x00c9, B:60:0x00e3, B:62:0x00ea, B:63:0x00ed, B:65:0x00f3, B:68:0x00fc, B:69:0x00ff, B:71:0x0105, B:72:0x0112, B:73:0x0118, B:74:0x011b, B:75:0x011c, B:76:0x011f), top: B:85:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f3 A[Catch: RecognitionException -> 0x0120, TryCatch #1 {RecognitionException -> 0x0120, blocks: (B:5:0x0009, B:11:0x0021, B:12:0x0025, B:13:0x0028, B:14:0x002c, B:16:0x003e, B:17:0x0041, B:18:0x0045, B:19:0x0048, B:21:0x004d, B:27:0x0068, B:29:0x0070, B:30:0x0073, B:34:0x0082, B:35:0x0085, B:36:0x008a, B:37:0x008b, B:43:0x00a7, B:45:0x00b1, B:46:0x00b4, B:51:0x00c2, B:52:0x00c7, B:54:0x00c9, B:60:0x00e3, B:62:0x00ea, B:63:0x00ed, B:65:0x00f3, B:68:0x00fc, B:69:0x00ff, B:71:0x0105, B:72:0x0112, B:73:0x0118, B:74:0x011b, B:75:0x011c, B:76:0x011f), top: B:85:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fa A[LOOP:0: B:67:0x00fa->B:71:0x0105, LOOP_START, PHI: r7 
      PHI: (r7v15 antlr.collections.AST) = (r7v14 antlr.collections.AST), (r7v17 antlr.collections.AST) binds: [B:64:0x00f1, B:71:0x0105] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void grammarSpec(antlr.collections.AST r7) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 368
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.TreeToNFAConverter.grammarSpec(antlr.collections.AST):void");
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

    /* JADX WARN: Removed duplicated region for block: B:103:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010a A[Catch: RecognitionException -> 0x01c6, TryCatch #4 {RecognitionException -> 0x01c6, blocks: (B:8:0x0026, B:10:0x0038, B:11:0x003b, B:15:0x0047, B:16:0x004a, B:17:0x004f, B:18:0x0050, B:19:0x0059, B:25:0x006d, B:28:0x0079, B:29:0x007e, B:30:0x007f, B:31:0x008d, B:35:0x009d, B:41:0x00b2, B:42:0x00b7, B:43:0x00b8, B:45:0x00c8, B:46:0x00cb, B:51:0x00d7, B:52:0x00dc, B:54:0x00de, B:56:0x00ec, B:57:0x00ef, B:61:0x00f9, B:62:0x00fe, B:63:0x00ff, B:66:0x010a, B:67:0x010d, B:69:0x0113, B:70:0x011e, B:76:0x0131, B:78:0x0139, B:79:0x013c, B:80:0x0141, B:81:0x0142, B:82:0x014b), top: B:114:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0113 A[Catch: RecognitionException -> 0x01c6, TryCatch #4 {RecognitionException -> 0x01c6, blocks: (B:8:0x0026, B:10:0x0038, B:11:0x003b, B:15:0x0047, B:16:0x004a, B:17:0x004f, B:18:0x0050, B:19:0x0059, B:25:0x006d, B:28:0x0079, B:29:0x007e, B:30:0x007f, B:31:0x008d, B:35:0x009d, B:41:0x00b2, B:42:0x00b7, B:43:0x00b8, B:45:0x00c8, B:46:0x00cb, B:51:0x00d7, B:52:0x00dc, B:54:0x00de, B:56:0x00ec, B:57:0x00ef, B:61:0x00f9, B:62:0x00fe, B:63:0x00ff, B:66:0x010a, B:67:0x010d, B:69:0x0113, B:70:0x011e, B:76:0x0131, B:78:0x0139, B:79:0x013c, B:80:0x0141, B:81:0x0142, B:82:0x014b), top: B:114:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011e A[Catch: RecognitionException -> 0x01c6, TRY_LEAVE, TryCatch #4 {RecognitionException -> 0x01c6, blocks: (B:8:0x0026, B:10:0x0038, B:11:0x003b, B:15:0x0047, B:16:0x004a, B:17:0x004f, B:18:0x0050, B:19:0x0059, B:25:0x006d, B:28:0x0079, B:29:0x007e, B:30:0x007f, B:31:0x008d, B:35:0x009d, B:41:0x00b2, B:42:0x00b7, B:43:0x00b8, B:45:0x00c8, B:46:0x00cb, B:51:0x00d7, B:52:0x00dc, B:54:0x00de, B:56:0x00ec, B:57:0x00ef, B:61:0x00f9, B:62:0x00fe, B:63:0x00ff, B:66:0x010a, B:67:0x010d, B:69:0x0113, B:70:0x011e, B:76:0x0131, B:78:0x0139, B:79:0x013c, B:80:0x0141, B:81:0x0142, B:82:0x014b), top: B:114:0x0026 }] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void rule(antlr.collections.AST r13) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 494
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.TreeToNFAConverter.rule(antlr.collections.AST):void");
    }

    public final void modifier(AST ast) throws RecognitionException {
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
        int type = ast.getType();
        if (type != 38) {
            switch (type) {
                case 56:
                    GrammarAST grammarAST2 = (GrammarAST) ast;
                    match(ast, 56);
                    ast2 = ast.getNextSibling();
                    break;
                case 57:
                    GrammarAST grammarAST3 = (GrammarAST) ast;
                    match(ast, 57);
                    ast2 = ast.getNextSibling();
                    break;
                case 58:
                    GrammarAST grammarAST4 = (GrammarAST) ast;
                    match(ast, 58);
                    ast2 = ast.getNextSibling();
                    break;
                default:
                    throw new NoViableAltException(ast);
            }
        } else {
            GrammarAST grammarAST5 = (GrammarAST) ast;
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
            antlr.ASTNULLType r0 = org.antlr.tool.TreeToNFAConverter.ASTNULL
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
            antlr.ASTNULLType r1 = org.antlr.tool.TreeToNFAConverter.ASTNULL     // Catch: RecognitionException -> 0x001b
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
            antlr.ASTNULLType r1 = org.antlr.tool.TreeToNFAConverter.ASTNULL     // Catch: RecognitionException -> 0x001b
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
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.TreeToNFAConverter.ruleScopeSpec(antlr.collections.AST):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final org.antlr.analysis.StateCluster block(antlr.collections.AST r10) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 256
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.TreeToNFAConverter.block(antlr.collections.AST):org.antlr.analysis.StateCluster");
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

    /* JADX WARN: Removed duplicated region for block: B:60:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final org.antlr.analysis.StateCluster set(antlr.collections.AST r10) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 222
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.TreeToNFAConverter.set(antlr.collections.AST):org.antlr.analysis.StateCluster");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final org.antlr.analysis.StateCluster alternative(antlr.collections.AST r7) throws antlr.RecognitionException {
        /*
            r6 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.TreeToNFAConverter.ASTNULL
            if (r7 != r0) goto L_0x0006
            goto L_0x0009
        L_0x0006:
            r0 = r7
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0009:
            r0 = 0
            r1 = r7
            org.antlr.tool.GrammarAST r1 = (org.antlr.tool.GrammarAST) r1     // Catch: RecognitionException -> 0x0061
            r1 = 17
            r6.match(r7, r1)     // Catch: RecognitionException -> 0x0061
            antlr.collections.AST r1 = r7.getFirstChild()     // Catch: RecognitionException -> 0x0061
            r2 = 0
        L_0x0019:
            if (r1 != 0) goto L_0x0021
            antlr.ASTNULLType r3 = org.antlr.tool.TreeToNFAConverter.ASTNULL     // Catch: RecognitionException -> 0x001f
            r1 = r3
            goto L_0x0021
        L_0x001f:
            r7 = move-exception
            goto L_0x0065
        L_0x0021:
            antlr.collections.impl.BitSet r3 = org.antlr.tool.TreeToNFAConverter._tokenSet_0     // Catch: RecognitionException -> 0x001f
            int r4 = r1.getType()     // Catch: RecognitionException -> 0x001f
            boolean r3 = r3.member(r4)     // Catch: RecognitionException -> 0x001f
            if (r3 == 0) goto L_0x0042
            org.antlr.analysis.StateCluster r3 = r6.element(r1)     // Catch: RecognitionException -> 0x001f
            antlr.collections.AST r4 = r6._retTree     // Catch: RecognitionException -> 0x001f
            org.antlr.tool.NFAFactory r1 = r6.factory     // Catch: RecognitionException -> 0x003f
            org.antlr.analysis.StateCluster r1 = r1.build_AB(r0, r3)     // Catch: RecognitionException -> 0x003f
            int r2 = r2 + 1
            r0 = r1
            r1 = r4
            goto L_0x0019
        L_0x003f:
            r7 = move-exception
            r1 = r4
            goto L_0x0065
        L_0x0042:
            r3 = 1
            if (r2 < r3) goto L_0x005b
            antlr.collections.AST r1 = r7.getNextSibling()     // Catch: RecognitionException -> 0x0061
            if (r0 != 0) goto L_0x0053
            org.antlr.tool.NFAFactory r7 = r6.factory     // Catch: RecognitionException -> 0x001f
            org.antlr.analysis.StateCluster r7 = r7.build_Epsilon()     // Catch: RecognitionException -> 0x001f
            goto L_0x0059
        L_0x0053:
            org.antlr.tool.NFAFactory r7 = r6.factory     // Catch: RecognitionException -> 0x001f
            r7.optimizeAlternative(r0)     // Catch: RecognitionException -> 0x001f
            r7 = r0
        L_0x0059:
            r0 = r7
            goto L_0x006e
        L_0x005b:
            antlr.NoViableAltException r7 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x001f
            r7.<init>(r1)     // Catch: RecognitionException -> 0x001f
            throw r7     // Catch: RecognitionException -> 0x001f
        L_0x0061:
            r1 = move-exception
            r5 = r1
            r1 = r7
            r7 = r5
        L_0x0065:
            r6.reportError(r7)
            if (r1 == 0) goto L_0x006e
            antlr.collections.AST r1 = r1.getNextSibling()
        L_0x006e:
            r6._retTree = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.TreeToNFAConverter.alternative(antlr.collections.AST):org.antlr.analysis.StateCluster");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void rewrite(antlr.collections.AST r9) throws antlr.RecognitionException {
        /*
            r8 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.TreeToNFAConverter.ASTNULL
            if (r9 != r0) goto L_0x0006
            r0 = 0
            goto L_0x0009
        L_0x0006:
            r0 = r9
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x0009:
            if (r9 != 0) goto L_0x0012
            antlr.ASTNULLType r1 = org.antlr.tool.TreeToNFAConverter.ASTNULL     // Catch: RecognitionException -> 0x000f
            r9 = r1
            goto L_0x0012
        L_0x000f:
            r0 = move-exception
            goto L_0x00b9
        L_0x0012:
            int r1 = r9.getType()     // Catch: RecognitionException -> 0x000f
            r2 = 80
            if (r1 != r2) goto L_0x00b8
            org.antlr.tool.Grammar r1 = r8.grammar     // Catch: RecognitionException -> 0x000f
            java.lang.String r3 = "output"
            java.lang.Object r1 = r1.getOption(r3)     // Catch: RecognitionException -> 0x000f
            if (r1 != 0) goto L_0x002f
            r1 = 149(0x95, float:2.09E-43)
            org.antlr.tool.Grammar r3 = r8.grammar     // Catch: RecognitionException -> 0x000f
            antlr.Token r4 = r0.token     // Catch: RecognitionException -> 0x000f
            java.lang.String r5 = r8.currentRuleName     // Catch: RecognitionException -> 0x000f
            org.antlr.tool.ErrorManager.grammarError(r1, r3, r4, r5)     // Catch: RecognitionException -> 0x000f
        L_0x002f:
            r1 = r9
            org.antlr.tool.GrammarAST r1 = (org.antlr.tool.GrammarAST) r1     // Catch: RecognitionException -> 0x000f
            r8.match(r9, r2)     // Catch: RecognitionException -> 0x000f
            antlr.collections.AST r1 = r9.getFirstChild()     // Catch: RecognitionException -> 0x000f
            if (r1 != 0) goto L_0x0044
            antlr.ASTNULLType r2 = org.antlr.tool.TreeToNFAConverter.ASTNULL     // Catch: RecognitionException -> 0x0040
            r1 = r2
            goto L_0x0044
        L_0x0040:
            r0 = move-exception
            r9 = r1
            goto L_0x00b9
        L_0x0044:
            int r2 = r1.getType()     // Catch: RecognitionException -> 0x0040
            r3 = 81
            r4 = 40
            r5 = 32
            r6 = 17
            if (r2 == r6) goto L_0x006f
            if (r2 == r5) goto L_0x006f
            if (r2 == r4) goto L_0x006f
            r7 = 69
            if (r2 == r7) goto L_0x0062
            if (r2 == r3) goto L_0x006f
            antlr.NoViableAltException r9 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x0040
            r9.<init>(r1)     // Catch: RecognitionException -> 0x0040
            throw r9     // Catch: RecognitionException -> 0x0040
        L_0x0062:
            r2 = r1
            org.antlr.tool.GrammarAST r2 = (org.antlr.tool.GrammarAST) r2     // Catch: RecognitionException -> 0x0040
            r8.match(r1, r7)     // Catch: RecognitionException -> 0x0040
            antlr.collections.AST r2 = r1.getNextSibling()     // Catch: RecognitionException -> 0x0040
            r1 = r2
            goto L_0x0070
        L_0x006f:
        L_0x0070:
            if (r1 != 0) goto L_0x0075
            antlr.ASTNULLType r2 = org.antlr.tool.TreeToNFAConverter.ASTNULL     // Catch: RecognitionException -> 0x0040
            r1 = r2
        L_0x0075:
            int r2 = r1.getType()     // Catch: RecognitionException -> 0x0040
            if (r2 == r6) goto L_0x00a5
            if (r2 == r5) goto L_0x009b
            if (r2 == r4) goto L_0x0091
            if (r2 == r3) goto L_0x0087
            antlr.NoViableAltException r9 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x0040
            r9.<init>(r1)     // Catch: RecognitionException -> 0x0040
            throw r9     // Catch: RecognitionException -> 0x0040
        L_0x0087:
            r2 = r1
            org.antlr.tool.GrammarAST r2 = (org.antlr.tool.GrammarAST) r2     // Catch: RecognitionException -> 0x0040
            r8.match(r1, r3)     // Catch: RecognitionException -> 0x0040
            r1.getNextSibling()     // Catch: RecognitionException -> 0x0040
            goto L_0x00af
        L_0x0091:
            r2 = r1
            org.antlr.tool.GrammarAST r2 = (org.antlr.tool.GrammarAST) r2     // Catch: RecognitionException -> 0x0040
            r8.match(r1, r4)     // Catch: RecognitionException -> 0x0040
            r1.getNextSibling()     // Catch: RecognitionException -> 0x0040
            goto L_0x00af
        L_0x009b:
            r2 = r1
            org.antlr.tool.GrammarAST r2 = (org.antlr.tool.GrammarAST) r2     // Catch: RecognitionException -> 0x0040
            r8.match(r1, r5)     // Catch: RecognitionException -> 0x0040
            r1.getNextSibling()     // Catch: RecognitionException -> 0x0040
            goto L_0x00af
        L_0x00a5:
            r2 = r1
            org.antlr.tool.GrammarAST r2 = (org.antlr.tool.GrammarAST) r2     // Catch: RecognitionException -> 0x0040
            r8.match(r1, r6)     // Catch: RecognitionException -> 0x0040
            r1.getNextSibling()     // Catch: RecognitionException -> 0x0040
        L_0x00af:
            antlr.collections.AST r1 = r9.getNextSibling()     // Catch: RecognitionException -> 0x000f
            r9 = r1
            goto L_0x0009
        L_0x00b8:
            goto L_0x00c3
        L_0x00b9:
            r8.reportError(r0)
            if (r9 == 0) goto L_0x00c3
            antlr.collections.AST r9 = r9.getNextSibling()
        L_0x00c3:
            r8._retTree = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.TreeToNFAConverter.rewrite(antlr.collections.AST):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 3, insn: 0x01c3: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:82:0x01c2
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public final org.antlr.analysis.StateCluster element(
    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 3, insn: 0x01c3: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:82:0x01c2
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v0 ??
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

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 7, insn: 0x0137: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:81:0x0136
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public final org.antlr.analysis.StateCluster atom(
    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 7, insn: 0x0137: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:81:0x0136
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r11v0 ??
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

    /* JADX WARN: Can't wrap try/catch for region: R(13:2|(1:4)|5|(2:121|7)|11|(1:15)|103|122|104|105|111|112|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01b4, code lost:
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01b5, code lost:
        r2 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final org.antlr.analysis.StateCluster atom_or_notatom(antlr.collections.AST r13) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 472
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.TreeToNFAConverter.atom_or_notatom(antlr.collections.AST):org.antlr.analysis.StateCluster");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d9  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [antlr.collections.AST] */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final org.antlr.analysis.StateCluster ebnf(antlr.collections.AST r10) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 490
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.TreeToNFAConverter.ebnf(antlr.collections.AST):org.antlr.analysis.StateCluster");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:2|(1:4)(1:5)|(3:54|6|(6:56|7|42|8|46|9))|(7:(2:48|11)|14|(4:16|44|17|18)(1:58)|37|(1:39)|40|41)|21|50|22|52|23|40|41|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
        r9 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
        r0 = r9;
        r9 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final org.antlr.analysis.StateCluster tree(antlr.collections.AST r9) throws antlr.RecognitionException {
        /*
            r8 = this;
            antlr.ASTNULLType r0 = org.antlr.tool.TreeToNFAConverter.ASTNULL
            r1 = 0
            if (r9 != r0) goto L_0x0008
            r0 = r1
            goto L_0x000b
        L_0x0008:
            r0 = r9
            org.antlr.tool.GrammarAST r0 = (org.antlr.tool.GrammarAST) r0
        L_0x000b:
            r2 = r9
            org.antlr.tool.GrammarAST r2 = (org.antlr.tool.GrammarAST) r2     // Catch: RecognitionException -> 0x0084
            r2 = 75
            r8.match(r9, r2)     // Catch: RecognitionException -> 0x0084
            antlr.collections.AST r2 = r9.getFirstChild()     // Catch: RecognitionException -> 0x0084
            r3 = r2
            org.antlr.tool.GrammarAST r3 = (org.antlr.tool.GrammarAST) r3     // Catch: RecognitionException -> 0x0080
            org.antlr.analysis.StateCluster r4 = r8.element(r2)     // Catch: RecognitionException -> 0x0080
            antlr.collections.AST r1 = r8._retTree     // Catch: RecognitionException -> 0x007c
            org.antlr.tool.NFAFactory r2 = r8.factory     // Catch: RecognitionException -> 0x0079
            r5 = 2
            org.antlr.analysis.StateCluster r2 = r2.build_Atom(r5, r3)     // Catch: RecognitionException -> 0x0079
            org.antlr.tool.NFAFactory r5 = r8.factory     // Catch: RecognitionException -> 0x0079
            org.antlr.analysis.StateCluster r5 = r5.build_AB(r4, r2)     // Catch: RecognitionException -> 0x0079
        L_0x0031:
            if (r1 != 0) goto L_0x003b
            antlr.ASTNULLType r4 = org.antlr.tool.TreeToNFAConverter.ASTNULL     // Catch: RecognitionException -> 0x0037
            r1 = r4
            goto L_0x003b
        L_0x0037:
            r9 = move-exception
            r0 = r1
            r3 = r5
            goto L_0x0089
        L_0x003b:
            antlr.collections.impl.BitSet r4 = org.antlr.tool.TreeToNFAConverter._tokenSet_0     // Catch: RecognitionException -> 0x0037
            int r6 = r1.getType()     // Catch: RecognitionException -> 0x0037
            boolean r4 = r4.member(r6)     // Catch: RecognitionException -> 0x0037
            if (r4 == 0) goto L_0x005d
            r3 = r1
            org.antlr.tool.GrammarAST r3 = (org.antlr.tool.GrammarAST) r3     // Catch: RecognitionException -> 0x0037
            org.antlr.analysis.StateCluster r4 = r8.element(r1)     // Catch: RecognitionException -> 0x0037
            antlr.collections.AST r6 = r8._retTree     // Catch: RecognitionException -> 0x0037
            org.antlr.tool.NFAFactory r1 = r8.factory     // Catch: RecognitionException -> 0x0059
            org.antlr.analysis.StateCluster r1 = r1.build_AB(r5, r4)     // Catch: RecognitionException -> 0x0059
            r5 = r1
            r1 = r6
            goto L_0x0031
        L_0x0059:
            r9 = move-exception
            r3 = r5
            r0 = r6
            goto L_0x0089
        L_0x005d:
            org.antlr.tool.NFAFactory r4 = r8.factory     // Catch: RecognitionException -> 0x0037
            r6 = 3
            org.antlr.analysis.StateCluster r3 = r4.build_Atom(r6, r3)     // Catch: RecognitionException -> 0x0037
            org.antlr.tool.NFAFactory r4 = r8.factory     // Catch: RecognitionException -> 0x0037
            org.antlr.analysis.StateCluster r3 = r4.build_AB(r5, r3)     // Catch: RecognitionException -> 0x0037
            org.antlr.analysis.NFAState r2 = r2.left     // Catch: RecognitionException -> 0x0076
            r0.NFATreeDownState = r2     // Catch: RecognitionException -> 0x0076
            antlr.collections.AST r0 = r9.getNextSibling()     // Catch: RecognitionException -> 0x0074
            goto L_0x0092
        L_0x0074:
            r0 = move-exception
            goto L_0x0086
        L_0x0076:
            r9 = move-exception
            r0 = r1
            goto L_0x0089
        L_0x0079:
            r9 = move-exception
            r0 = r1
            goto L_0x007e
        L_0x007c:
            r9 = move-exception
            r0 = r2
        L_0x007e:
            r3 = r4
            goto L_0x0089
        L_0x0080:
            r9 = move-exception
            r3 = r1
            r0 = r2
            goto L_0x0089
        L_0x0084:
            r0 = move-exception
            r3 = r1
        L_0x0086:
            r7 = r0
            r0 = r9
            r9 = r7
        L_0x0089:
            r8.reportError(r9)
            if (r0 == 0) goto L_0x0092
            antlr.collections.AST r0 = r0.getNextSibling()
        L_0x0092:
            r8._retTree = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.TreeToNFAConverter.tree(antlr.collections.AST):org.antlr.analysis.StateCluster");
    }

    public final void ast_suffix(AST ast) throws RecognitionException {
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
        int type = ast.getType();
        if (type == 59) {
            GrammarAST grammarAST2 = (GrammarAST) ast;
            match(ast, 59);
            ast2 = ast.getNextSibling();
        } else if (type != 71) {
            throw new NoViableAltException(ast);
        } else {
            GrammarAST grammarAST3 = (GrammarAST) ast;
            match(ast, 71);
            ast2 = ast.getNextSibling();
        }
        this._retTree = ast2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0180  */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v14, types: [org.antlr.tool.GrammarAST] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v30, types: [org.antlr.misc.IntSet] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void setElement(antlr.collections.AST r6, org.antlr.misc.IntSet r7) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 400
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.tool.TreeToNFAConverter.setElement(antlr.collections.AST, org.antlr.misc.IntSet):void");
    }

    public final IntSet setRule(AST ast) throws RecognitionException {
        IntervalSet intervalSet = new IntervalSet();
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        try {
            GrammarAST grammarAST2 = (GrammarAST) ast;
            match(ast, 8);
            GrammarAST firstChild = ast.getFirstChild();
            GrammarAST grammarAST3 = firstChild;
            match(firstChild, 21);
            ASTNULLType nextSibling = firstChild.getNextSibling();
            if (nextSibling == null) {
                nextSibling = ASTNULL;
            }
            int type = nextSibling.getType();
            if (type != 22) {
                if (type != 38) {
                    switch (type) {
                        case 56:
                        case 57:
                        case 58:
                            break;
                        default:
                            throw new NoViableAltException(nextSibling);
                    }
                }
                modifier(nextSibling);
                nextSibling = this._retTree;
            }
            GrammarAST grammarAST4 = (GrammarAST) nextSibling;
            match(nextSibling, 22);
            GrammarAST nextSibling2 = nextSibling.getNextSibling();
            GrammarAST grammarAST5 = nextSibling2;
            match(nextSibling2, 24);
            ASTNULLType nextSibling3 = nextSibling2.getNextSibling();
            if (nextSibling3 == null) {
                nextSibling3 = ASTNULL;
            }
            int type2 = nextSibling3.getType();
            if (type2 == 4) {
                GrammarAST grammarAST6 = (GrammarAST) nextSibling3;
                match(nextSibling3, 4);
                nextSibling3 = nextSibling3.getNextSibling();
            } else if (type2 != 9 && type2 != 33 && type2 != 46) {
                throw new NoViableAltException(nextSibling3);
            }
            if (nextSibling3 == null) {
                nextSibling3 = ASTNULL;
            }
            int type3 = nextSibling3.getType();
            if (type3 != 9) {
                if (type3 == 33) {
                    ruleScopeSpec(nextSibling3);
                    nextSibling3 = this._retTree;
                } else if (type3 != 46) {
                    throw new NoViableAltException(nextSibling3);
                }
            }
            while (true) {
                if (nextSibling3 == null) {
                    nextSibling3 = ASTNULL;
                }
                if (nextSibling3.getType() == 46) {
                    GrammarAST grammarAST7 = (GrammarAST) nextSibling3;
                    match(nextSibling3, 46);
                    nextSibling3 = nextSibling3.getNextSibling();
                } else {
                    GrammarAST grammarAST8 = (GrammarAST) nextSibling3;
                    match(nextSibling3, 9);
                    ASTNULLType firstChild2 = nextSibling3.getFirstChild();
                    if (firstChild2 == null) {
                        firstChild2 = ASTNULL;
                    }
                    int type4 = firstChild2.getType();
                    if (type4 == 4) {
                        GrammarAST grammarAST9 = (GrammarAST) firstChild2;
                        match(firstChild2, 4);
                        firstChild2 = firstChild2.getNextSibling();
                    } else if (type4 != 17) {
                        throw new NoViableAltException(firstChild2);
                    }
                    int i = 0;
                    while (true) {
                        if (firstChild2 == null) {
                            firstChild2 = ASTNULL;
                        }
                        if (firstChild2.getType() == 17) {
                            GrammarAST grammarAST10 = (GrammarAST) firstChild2;
                            match(firstChild2, 17);
                            ASTNULLType firstChild3 = firstChild2.getFirstChild();
                            if (firstChild3 == null) {
                                firstChild3 = ASTNULL;
                            }
                            int type5 = firstChild3.getType();
                            if (!(type5 == 9 || type5 == 15)) {
                                if (type5 == 37) {
                                    GrammarAST grammarAST11 = (GrammarAST) firstChild3;
                                    match(firstChild3, 37);
                                    firstChild3 = firstChild3.getNextSibling();
                                } else if (!(type5 == 55 || type5 == 74)) {
                                    switch (type5) {
                                        case 50:
                                        case 51:
                                            break;
                                        default:
                                            throw new NoViableAltException(firstChild3);
                                    }
                                }
                            }
                            setElement(firstChild3, intervalSet);
                            GrammarAST grammarAST12 = this._retTree;
                            GrammarAST grammarAST13 = grammarAST12;
                            match(grammarAST12, 20);
                            grammarAST12.getNextSibling();
                            firstChild2 = firstChild2.getNextSibling();
                            i++;
                        } else if (i >= 1) {
                            GrammarAST grammarAST14 = (GrammarAST) firstChild2;
                            match(firstChild2, 19);
                            firstChild2.getNextSibling();
                            ASTNULLType nextSibling4 = nextSibling3.getNextSibling();
                            if (nextSibling4 == null) {
                                nextSibling4 = ASTNULL;
                            }
                            int type6 = nextSibling4.getType();
                            if (type6 != 18) {
                                switch (type6) {
                                    case 66:
                                    case 67:
                                        exceptionGroup(nextSibling4);
                                        nextSibling4 = this._retTree;
                                        break;
                                    default:
                                        throw new NoViableAltException(nextSibling4);
                                }
                            }
                            GrammarAST grammarAST15 = (GrammarAST) nextSibling4;
                            match(nextSibling4, 18);
                            nextSibling4.getNextSibling();
                            this._retTree = ast.getNextSibling();
                            return intervalSet;
                        } else {
                            throw new NoViableAltException(firstChild2);
                        }
                    }
                }
            }
        } catch (RecognitionException e) {
            throw e;
        }
    }

    public final void testBlockAsSet(AST ast) throws RecognitionException {
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        Rule locallyDefinedRule = this.grammar.getLocallyDefinedRule(this.currentRuleName);
        try {
            GrammarAST grammarAST2 = (GrammarAST) ast;
            match(ast, 9);
            ASTNULLType firstChild = ast.getFirstChild();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (firstChild == null) {
                    firstChild = ASTNULL;
                }
                if (firstChild.getType() == 17) {
                    GrammarAST grammarAST3 = (GrammarAST) firstChild;
                    match(firstChild, 17);
                    ASTNULLType firstChild2 = firstChild.getFirstChild();
                    if (firstChild2 == null) {
                        firstChild2 = ASTNULL;
                    }
                    int type = firstChild2.getType();
                    if (!(type == 9 || type == 15)) {
                        if (type == 37) {
                            GrammarAST grammarAST4 = (GrammarAST) firstChild2;
                            match(firstChild2, 37);
                            firstChild2 = firstChild2.getNextSibling();
                        } else if (!(type == 55 || type == 74)) {
                            switch (type) {
                                case 50:
                                case 51:
                                    break;
                                default:
                                    throw new NoViableAltException(firstChild2);
                            }
                        }
                    }
                    testSetElement(firstChild2);
                    GrammarAST grammarAST5 = this._retTree;
                    i2++;
                    GrammarAST grammarAST6 = grammarAST5;
                    match(grammarAST5, 20);
                    grammarAST5.getNextSibling();
                    firstChild = firstChild.getNextSibling();
                    if (locallyDefinedRule.hasRewrite(this.outerAltNum)) {
                        throw new SemanticException("!r.hasRewrite(outerAltNum)");
                    }
                    i++;
                } else if (i >= 1) {
                    GrammarAST grammarAST7 = (GrammarAST) firstChild;
                    match(firstChild, 19);
                    firstChild.getNextSibling();
                    AST nextSibling = ast.getNextSibling();
                    if (i2 <= 1) {
                        throw new SemanticException("nAlts>1");
                    }
                    this._retTree = nextSibling;
                    return;
                } else {
                    throw new NoViableAltException(firstChild);
                }
            }
        } catch (RecognitionException e) {
            throw e;
        }
    }

    public final void testSetElement(AST ast) throws RecognitionException {
        AST ast2;
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        if (ast == null) {
            try {
                ast = ASTNULL;
            } catch (RecognitionException e) {
                throw e;
            }
        }
        int type = ast.getType();
        if (type == 9) {
            testBlockAsSet(ast);
            ast2 = this._retTree;
        } else if (type == 15) {
            GrammarAST grammarAST2 = (GrammarAST) ast;
            match(ast, 15);
            GrammarAST firstChild = ast.getFirstChild();
            GrammarAST grammarAST3 = firstChild;
            match(firstChild, 51);
            GrammarAST nextSibling = firstChild.getNextSibling();
            GrammarAST grammarAST4 = nextSibling;
            match(nextSibling, 51);
            nextSibling.getNextSibling();
            ast2 = ast.getNextSibling();
        } else if (type == 51) {
            GrammarAST grammarAST5 = (GrammarAST) ast;
            match(ast, 51);
            ast2 = ast.getNextSibling();
        } else if (type == 55) {
            GrammarAST grammarAST6 = (GrammarAST) ast;
            match(ast, 55);
            ast2 = ast.getNextSibling();
            if (this.grammar.type == 1) {
                Rule rule = this.grammar.getRule(grammarAST6.getText());
                if (rule == null) {
                    throw new RecognitionException("invalid rule");
                }
                testSetRule(rule.tree);
            }
        } else if (type != 74) {
            if (ast == null) {
                ast = ASTNULL;
            }
            if (ast.getType() != 50 || this.grammar.type == 1) {
                throw new NoViableAltException(ast);
            }
            GrammarAST grammarAST7 = (GrammarAST) ast;
            match(ast, 50);
            ast2 = ast.getNextSibling();
        } else {
            GrammarAST grammarAST8 = (GrammarAST) ast;
            match(ast, 74);
            testSetElement(ast.getFirstChild());
            AST ast3 = this._retTree;
            ast2 = ast.getNextSibling();
        }
        this._retTree = ast2;
    }

    public final void testSetRule(AST ast) throws RecognitionException {
        if (ast != ASTNULL) {
            GrammarAST grammarAST = (GrammarAST) ast;
        }
        try {
            GrammarAST grammarAST2 = (GrammarAST) ast;
            match(ast, 8);
            GrammarAST firstChild = ast.getFirstChild();
            GrammarAST grammarAST3 = firstChild;
            match(firstChild, 21);
            ASTNULLType nextSibling = firstChild.getNextSibling();
            if (nextSibling == null) {
                nextSibling = ASTNULL;
            }
            int type = nextSibling.getType();
            if (type != 22) {
                if (type != 38) {
                    switch (type) {
                        case 56:
                        case 57:
                        case 58:
                            break;
                        default:
                            throw new NoViableAltException(nextSibling);
                    }
                }
                modifier(nextSibling);
                nextSibling = this._retTree;
            }
            GrammarAST grammarAST4 = (GrammarAST) nextSibling;
            match(nextSibling, 22);
            GrammarAST nextSibling2 = nextSibling.getNextSibling();
            GrammarAST grammarAST5 = nextSibling2;
            match(nextSibling2, 24);
            ASTNULLType nextSibling3 = nextSibling2.getNextSibling();
            if (nextSibling3 == null) {
                nextSibling3 = ASTNULL;
            }
            int type2 = nextSibling3.getType();
            if (type2 == 4) {
                GrammarAST grammarAST6 = (GrammarAST) nextSibling3;
                match(nextSibling3, 4);
                nextSibling3 = nextSibling3.getNextSibling();
            } else if (type2 != 9 && type2 != 33 && type2 != 46) {
                throw new NoViableAltException(nextSibling3);
            }
            if (nextSibling3 == null) {
                nextSibling3 = ASTNULL;
            }
            int type3 = nextSibling3.getType();
            if (type3 != 9) {
                if (type3 == 33) {
                    ruleScopeSpec(nextSibling3);
                    nextSibling3 = this._retTree;
                } else if (type3 != 46) {
                    throw new NoViableAltException(nextSibling3);
                }
            }
            while (true) {
                if (nextSibling3 == null) {
                    nextSibling3 = ASTNULL;
                }
                if (nextSibling3.getType() == 46) {
                    GrammarAST grammarAST7 = (GrammarAST) nextSibling3;
                    match(nextSibling3, 46);
                    nextSibling3 = nextSibling3.getNextSibling();
                } else {
                    GrammarAST grammarAST8 = (GrammarAST) nextSibling3;
                    match(nextSibling3, 9);
                    ASTNULLType firstChild2 = nextSibling3.getFirstChild();
                    int i = 0;
                    while (true) {
                        if (firstChild2 == null) {
                            firstChild2 = ASTNULL;
                        }
                        if (firstChild2.getType() == 17) {
                            GrammarAST grammarAST9 = (GrammarAST) firstChild2;
                            match(firstChild2, 17);
                            ASTNULLType firstChild3 = firstChild2.getFirstChild();
                            if (firstChild3 == null) {
                                firstChild3 = ASTNULL;
                            }
                            int type4 = firstChild3.getType();
                            if (!(type4 == 9 || type4 == 15)) {
                                if (type4 == 37) {
                                    GrammarAST grammarAST10 = (GrammarAST) firstChild3;
                                    match(firstChild3, 37);
                                    firstChild3 = firstChild3.getNextSibling();
                                } else if (!(type4 == 55 || type4 == 74)) {
                                    switch (type4) {
                                        case 50:
                                        case 51:
                                            break;
                                        default:
                                            throw new NoViableAltException(firstChild3);
                                    }
                                }
                            }
                            testSetElement(firstChild3);
                            GrammarAST grammarAST11 = this._retTree;
                            GrammarAST grammarAST12 = grammarAST11;
                            match(grammarAST11, 20);
                            grammarAST11.getNextSibling();
                            firstChild2 = firstChild2.getNextSibling();
                            i++;
                        } else if (i >= 1) {
                            GrammarAST grammarAST13 = (GrammarAST) firstChild2;
                            match(firstChild2, 19);
                            firstChild2.getNextSibling();
                            ASTNULLType nextSibling4 = nextSibling3.getNextSibling();
                            if (nextSibling4 == null) {
                                nextSibling4 = ASTNULL;
                            }
                            int type5 = nextSibling4.getType();
                            if (type5 != 18) {
                                switch (type5) {
                                    case 66:
                                    case 67:
                                        exceptionGroup(nextSibling4);
                                        nextSibling4 = this._retTree;
                                        break;
                                    default:
                                        throw new NoViableAltException(nextSibling4);
                                }
                            }
                            GrammarAST grammarAST14 = (GrammarAST) nextSibling4;
                            match(nextSibling4, 18);
                            nextSibling4.getNextSibling();
                            this._retTree = ast.getNextSibling();
                            return;
                        } else {
                            throw new NoViableAltException(firstChild2);
                        }
                    }
                }
            }
        } catch (RecognitionException e) {
            throw e;
        }
    }

    private static final long[] mk_tokenSet_0() {
        return new long[]{616432089855819264L, 4016, 0, 0};
    }
}
