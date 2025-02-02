package org.antlr.stringtemplate.language;

import antlr.RecognitionException;
import antlr.TreeParser;
import antlr.collections.AST;
import antlr.collections.impl.BitSet;
import java.util.Map;
import java.util.Set;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateWriter;
/* loaded from: /storage/emulated/0/MT2/apks/Dixes/classes.dex */
public class ActionEvaluator extends TreeParser implements ActionEvaluatorTokenTypes {
    public static final String[] _tokenNames = {"<0>", "EOF", "<2>", "NULL_TREE_LOOKAHEAD", "APPLY", "MULTI_APPLY", "ARGS", "INCLUDE", "\"if\"", "VALUE", "TEMPLATE", "FUNCTION", "SINGLEVALUEARG", "LIST", "NOTHING", "SEMI", "LPAREN", "RPAREN", "\"elseif\"", "COMMA", "ID", "ASSIGN", "COLON", "NOT", "PLUS", "DOT", "\"first\"", "\"rest\"", "\"last\"", "\"length\"", "\"strip\"", "\"trunc\"", "\"super\"", "ANONYMOUS_TEMPLATE", "STRING", "INT", "LBRACK", "RBRACK", "DOTDOTDOT", "TEMPLATE_ARGS", "NESTED_ANONYMOUS_TEMPLATE", "ESC_CHAR", "WS", "WS_CHAR"};
    public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
    protected ASTExpr chunk;
    protected StringTemplateWriter out;
    protected StringTemplate self;

    /* loaded from: /storage/emulated/0/MT2/apks/Dixes/classes.dex */
    public static class NameValuePair {
        public String name;
        public Object value;
    }

    public ActionEvaluator(StringTemplate stringTemplate, ASTExpr aSTExpr, StringTemplateWriter stringTemplateWriter) {
        this.self = null;
        this.out = null;
        this.chunk = null;
        this.self = stringTemplate;
        this.chunk = aSTExpr;
        this.out = stringTemplateWriter;
    }

    public void reportError(RecognitionException recognitionException) {
        this.self.error("eval tree parse error", recognitionException);
    }

    public ActionEvaluator() {
        this.self = null;
        this.out = null;
        this.chunk = null;
        this.tokenNames = _tokenNames;
    }

    public final int action(AST ast) throws RecognitionException {
        AST ast2;
        RecognitionException e;
        if (ast != ASTNULL) {
            StringTemplateAST stringTemplateAST = (StringTemplateAST) ast;
        }
        int i = 0;
        try {
            Object expr = expr(ast);
            ast2 = this._retTree;
            try {
                i = this.chunk.writeAttribute(this.self, expr, this.out);
            } catch (RecognitionException e2) {
                e = e2;
                reportError(e);
                if (ast2 != null) {
                    ast2 = ast2.getNextSibling();
                }
                this._retTree = ast2;
                return i;
            }
        } catch (RecognitionException e3) {
            e = e3;
            ast2 = ast;
        }
        this._retTree = ast2;
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc  */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final java.lang.Object expr(antlr.collections.AST r8) throws antlr.RecognitionException {
        /*
            r7 = this;
            antlr.ASTNULLType r0 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL
            if (r8 != r0) goto L_0x0006
            goto L_0x0009
        L_0x0006:
            r0 = r8
            org.antlr.stringtemplate.language.StringTemplateAST r0 = (org.antlr.stringtemplate.language.StringTemplateAST) r0
        L_0x0009:
            r0 = 0
            if (r8 != 0) goto L_0x0018
            antlr.ASTNULLType r1 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL     // Catch: RecognitionException -> 0x0012
            r8 = r1
            goto L_0x0018
        L_0x0012:
            r1 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
            goto L_0x00c6
        L_0x0018:
            int r1 = r8.getType()     // Catch: RecognitionException -> 0x0012
            switch(r1) {
                case 4: goto L_0x00b2;
                case 5: goto L_0x00b2;
                case 7: goto L_0x00ab;
                case 9: goto L_0x0069;
                case 11: goto L_0x0062;
                case 13: goto L_0x005b;
                case 20: goto L_0x0053;
                case 24: goto L_0x0023;
                case 25: goto L_0x0053;
                case 33: goto L_0x0053;
                case 34: goto L_0x0053;
                case 35: goto L_0x0053;
                default: goto L_0x001f;
            }     // Catch: RecognitionException -> 0x0012
        L_0x001f:
            antlr.NoViableAltException r1 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x0012
            goto L_0x00c2
        L_0x0023:
            r1 = r8
            org.antlr.stringtemplate.language.StringTemplateAST r1 = (org.antlr.stringtemplate.language.StringTemplateAST) r1     // Catch: RecognitionException -> 0x0012
            r1 = 24
            r7.match(r8, r1)     // Catch: RecognitionException -> 0x0012
            antlr.collections.AST r1 = r8.getFirstChild()     // Catch: RecognitionException -> 0x0012
            java.lang.Object r2 = r7.expr(r1)     // Catch: RecognitionException -> 0x00a5
            antlr.collections.AST r3 = r7._retTree     // Catch: RecognitionException -> 0x00a5
            java.lang.Object r1 = r7.expr(r3)     // Catch: RecognitionException -> 0x004e
            antlr.collections.AST r4 = r7._retTree     // Catch: RecognitionException -> 0x004e
            org.antlr.stringtemplate.language.ASTExpr r3 = r7.chunk     // Catch: RecognitionException -> 0x0049
            java.lang.Object r1 = r3.add(r2, r1)     // Catch: RecognitionException -> 0x0049
            antlr.collections.AST r0 = r8.getNextSibling()     // Catch: RecognitionException -> 0x00bc
            goto L_0x00b9
        L_0x0049:
            r1 = move-exception
            r8 = r0
            r0 = r4
            goto L_0x00c6
        L_0x004e:
            r1 = move-exception
            r8 = r0
            r0 = r3
            goto L_0x00c6
        L_0x0053:
            java.lang.Object r1 = r7.attribute(r8)     // Catch: RecognitionException -> 0x0012
            antlr.collections.AST r0 = r7._retTree     // Catch: RecognitionException -> 0x00bc
            goto L_0x00b9
        L_0x005b:
            java.lang.Object r1 = r7.list(r8)     // Catch: RecognitionException -> 0x0012
            antlr.collections.AST r0 = r7._retTree     // Catch: RecognitionException -> 0x00bc
            goto L_0x00b9
        L_0x0062:
            java.lang.Object r1 = r7.function(r8)     // Catch: RecognitionException -> 0x0012
            antlr.collections.AST r0 = r7._retTree     // Catch: RecognitionException -> 0x00bc
            goto L_0x00b9
        L_0x0069:
            r1 = r8
            org.antlr.stringtemplate.language.StringTemplateAST r1 = (org.antlr.stringtemplate.language.StringTemplateAST) r1     // Catch: RecognitionException -> 0x0012
            r1 = 9
            r7.match(r8, r1)     // Catch: RecognitionException -> 0x0012
            antlr.collections.AST r1 = r8.getFirstChild()     // Catch: RecognitionException -> 0x0012
            java.lang.Object r2 = r7.expr(r1)     // Catch: RecognitionException -> 0x00a5
            antlr.collections.AST r3 = r7._retTree     // Catch: RecognitionException -> 0x00a5
            antlr.collections.AST r1 = r8.getNextSibling()     // Catch: RecognitionException -> 0x0012
            java.io.StringWriter r8 = new java.io.StringWriter     // Catch: RecognitionException -> 0x00a5
            r8.<init>()     // Catch: RecognitionException -> 0x00a5
            org.antlr.stringtemplate.StringTemplate r3 = r7.self     // Catch: RecognitionException -> 0x00a5
            org.antlr.stringtemplate.StringTemplateGroup r3 = r3.getGroup()     // Catch: RecognitionException -> 0x00a5
            org.antlr.stringtemplate.StringTemplateWriter r3 = r3.getStringTemplateWriter(r8)     // Catch: RecognitionException -> 0x00a5
            org.antlr.stringtemplate.language.ASTExpr r4 = r7.chunk     // Catch: RecognitionException -> 0x00a5
            org.antlr.stringtemplate.StringTemplate r5 = r7.self     // Catch: RecognitionException -> 0x00a5
            int r2 = r4.writeAttribute(r5, r2, r3)     // Catch: RecognitionException -> 0x00a5
            if (r2 <= 0) goto L_0x00a1
            java.lang.String r8 = r8.toString()     // Catch: RecognitionException -> 0x00a5
            r0 = r1
            r1 = r8
            goto L_0x00b9
        L_0x00a1:
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x00b9
        L_0x00a5:
            r8 = move-exception
            r6 = r1
            r1 = r8
            r8 = r0
            r0 = r6
            goto L_0x00c6
        L_0x00ab:
            java.lang.Object r1 = r7.templateInclude(r8)     // Catch: RecognitionException -> 0x0012
            antlr.collections.AST r0 = r7._retTree     // Catch: RecognitionException -> 0x00bc
            goto L_0x00b9
        L_0x00b2:
            java.lang.Object r1 = r7.templateApplication(r8)     // Catch: RecognitionException -> 0x0012
            antlr.collections.AST r0 = r7._retTree     // Catch: RecognitionException -> 0x00bc
        L_0x00b9:
            r8 = r1
            goto L_0x00d0
        L_0x00bc:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r1
            r1 = r6
            goto L_0x00c6
        L_0x00c2:
            r1.<init>(r8)     // Catch: RecognitionException -> 0x0012
            throw r1     // Catch: RecognitionException -> 0x0012
        L_0x00c6:
            r7.reportError(r1)
            if (r0 == 0) goto L_0x00d0
            antlr.collections.AST r0 = r0.getNextSibling()
        L_0x00d0:
            r7._retTree = r0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.stringtemplate.language.ActionEvaluator.expr(antlr.collections.AST):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f7  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final java.lang.Object templateApplication(antlr.collections.AST r9) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 262
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.stringtemplate.language.ActionEvaluator.templateApplication(antlr.collections.AST):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0116  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final java.lang.Object attribute(antlr.collections.AST r7) throws antlr.RecognitionException {
        /*
        // Method dump skipped, instructions count: 296
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.stringtemplate.language.ActionEvaluator.attribute(antlr.collections.AST):java.lang.Object");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 4, insn: 0x009a: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:42:0x009a
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public final java.lang.Object templateInclude(
    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 4, insn: 0x009a: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:42:0x009a
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00db  */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final java.lang.Object function(antlr.collections.AST r6) throws antlr.RecognitionException {
        /*
            r5 = this;
            antlr.ASTNULLType r0 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL
            if (r6 != r0) goto L_0x0006
            goto L_0x0009
        L_0x0006:
            r0 = r6
            org.antlr.stringtemplate.language.StringTemplateAST r0 = (org.antlr.stringtemplate.language.StringTemplateAST) r0
        L_0x0009:
            r0 = 0
            r1 = r6
            org.antlr.stringtemplate.language.StringTemplateAST r1 = (org.antlr.stringtemplate.language.StringTemplateAST) r1     // Catch: RecognitionException -> 0x00d2
            r1 = 11
            r5.match(r6, r1)     // Catch: RecognitionException -> 0x00d2
            antlr.collections.AST r1 = r6.getFirstChild()     // Catch: RecognitionException -> 0x00d2
            if (r1 != 0) goto L_0x0020
            antlr.ASTNULLType r2 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL     // Catch: RecognitionException -> 0x001d
            r1 = r2
            goto L_0x0020
        L_0x001d:
            r6 = move-exception
            goto L_0x00d6
        L_0x0020:
            int r2 = r1.getType()     // Catch: RecognitionException -> 0x001d
            switch(r2) {
                case 26: goto L_0x00a9;
                case 27: goto L_0x0090;
                case 28: goto L_0x0077;
                case 29: goto L_0x005e;
                case 30: goto L_0x0045;
                case 31: goto L_0x002b;
                default: goto L_0x0027;
            }     // Catch: RecognitionException -> 0x001d
        L_0x0027:
            antlr.NoViableAltException r6 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x001d
            goto L_0x00ce
        L_0x002b:
            r2 = r1
            org.antlr.stringtemplate.language.StringTemplateAST r2 = (org.antlr.stringtemplate.language.StringTemplateAST) r2     // Catch: RecognitionException -> 0x001d
            r2 = 31
            r5.match(r1, r2)     // Catch: RecognitionException -> 0x001d
            antlr.collections.AST r2 = r1.getNextSibling()     // Catch: RecognitionException -> 0x001d
            java.lang.Object r1 = r5.singleFunctionArg(r2)     // Catch: RecognitionException -> 0x00cb
            antlr.collections.AST r3 = r5._retTree     // Catch: RecognitionException -> 0x00cb
            org.antlr.stringtemplate.language.ASTExpr r2 = r5.chunk     // Catch: RecognitionException -> 0x00c8
            java.lang.Object r1 = r2.trunc(r1)     // Catch: RecognitionException -> 0x00c8
            goto L_0x00c2
        L_0x0045:
            r2 = r1
            org.antlr.stringtemplate.language.StringTemplateAST r2 = (org.antlr.stringtemplate.language.StringTemplateAST) r2     // Catch: RecognitionException -> 0x001d
            r2 = 30
            r5.match(r1, r2)     // Catch: RecognitionException -> 0x001d
            antlr.collections.AST r2 = r1.getNextSibling()     // Catch: RecognitionException -> 0x001d
            java.lang.Object r1 = r5.singleFunctionArg(r2)     // Catch: RecognitionException -> 0x00cb
            antlr.collections.AST r3 = r5._retTree     // Catch: RecognitionException -> 0x00cb
            org.antlr.stringtemplate.language.ASTExpr r2 = r5.chunk     // Catch: RecognitionException -> 0x00c8
            java.lang.Object r1 = r2.strip(r1)     // Catch: RecognitionException -> 0x00c8
            goto L_0x00c2
        L_0x005e:
            r2 = r1
            org.antlr.stringtemplate.language.StringTemplateAST r2 = (org.antlr.stringtemplate.language.StringTemplateAST) r2     // Catch: RecognitionException -> 0x001d
            r2 = 29
            r5.match(r1, r2)     // Catch: RecognitionException -> 0x001d
            antlr.collections.AST r2 = r1.getNextSibling()     // Catch: RecognitionException -> 0x001d
            java.lang.Object r1 = r5.singleFunctionArg(r2)     // Catch: RecognitionException -> 0x00cb
            antlr.collections.AST r3 = r5._retTree     // Catch: RecognitionException -> 0x00cb
            org.antlr.stringtemplate.language.ASTExpr r2 = r5.chunk     // Catch: RecognitionException -> 0x00c8
            java.lang.Object r1 = r2.length(r1)     // Catch: RecognitionException -> 0x00c8
            goto L_0x00c2
        L_0x0077:
            r2 = r1
            org.antlr.stringtemplate.language.StringTemplateAST r2 = (org.antlr.stringtemplate.language.StringTemplateAST) r2     // Catch: RecognitionException -> 0x001d
            r2 = 28
            r5.match(r1, r2)     // Catch: RecognitionException -> 0x001d
            antlr.collections.AST r2 = r1.getNextSibling()     // Catch: RecognitionException -> 0x001d
            java.lang.Object r1 = r5.singleFunctionArg(r2)     // Catch: RecognitionException -> 0x00cb
            antlr.collections.AST r3 = r5._retTree     // Catch: RecognitionException -> 0x00cb
            org.antlr.stringtemplate.language.ASTExpr r2 = r5.chunk     // Catch: RecognitionException -> 0x00c8
            java.lang.Object r1 = r2.last(r1)     // Catch: RecognitionException -> 0x00c8
            goto L_0x00c2
        L_0x0090:
            r2 = r1
            org.antlr.stringtemplate.language.StringTemplateAST r2 = (org.antlr.stringtemplate.language.StringTemplateAST) r2     // Catch: RecognitionException -> 0x001d
            r2 = 27
            r5.match(r1, r2)     // Catch: RecognitionException -> 0x001d
            antlr.collections.AST r2 = r1.getNextSibling()     // Catch: RecognitionException -> 0x001d
            java.lang.Object r1 = r5.singleFunctionArg(r2)     // Catch: RecognitionException -> 0x00cb
            antlr.collections.AST r3 = r5._retTree     // Catch: RecognitionException -> 0x00cb
            org.antlr.stringtemplate.language.ASTExpr r2 = r5.chunk     // Catch: RecognitionException -> 0x00c8
            java.lang.Object r1 = r2.rest(r1)     // Catch: RecognitionException -> 0x00c8
            goto L_0x00c2
        L_0x00a9:
            r2 = r1
            org.antlr.stringtemplate.language.StringTemplateAST r2 = (org.antlr.stringtemplate.language.StringTemplateAST) r2     // Catch: RecognitionException -> 0x001d
            r2 = 26
            r5.match(r1, r2)     // Catch: RecognitionException -> 0x001d
            antlr.collections.AST r2 = r1.getNextSibling()     // Catch: RecognitionException -> 0x001d
            java.lang.Object r1 = r5.singleFunctionArg(r2)     // Catch: RecognitionException -> 0x00cb
            antlr.collections.AST r3 = r5._retTree     // Catch: RecognitionException -> 0x00cb
            org.antlr.stringtemplate.language.ASTExpr r2 = r5.chunk     // Catch: RecognitionException -> 0x00c8
            java.lang.Object r1 = r2.first(r1)     // Catch: RecognitionException -> 0x00c8
        L_0x00c2:
            r0 = r1
            antlr.collections.AST r1 = r6.getNextSibling()     // Catch: RecognitionException -> 0x00d2
            goto L_0x00df
        L_0x00c8:
            r6 = move-exception
            r1 = r3
            goto L_0x00d6
        L_0x00cb:
            r6 = move-exception
            r1 = r2
            goto L_0x00d6
        L_0x00ce:
            r6.<init>(r1)     // Catch: RecognitionException -> 0x001d
            throw r6     // Catch: RecognitionException -> 0x001d
        L_0x00d2:
            r1 = move-exception
            r4 = r1
            r1 = r6
            r6 = r4
        L_0x00d6:
            r5.reportError(r6)
            if (r1 == 0) goto L_0x00df
            antlr.collections.AST r1 = r1.getNextSibling()
        L_0x00df:
            r5._retTree = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.stringtemplate.language.ActionEvaluator.function(antlr.collections.AST):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final java.lang.Object list(antlr.collections.AST r7) throws antlr.RecognitionException {
        /*
            r6 = this;
            antlr.ASTNULLType r0 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL
            if (r7 != r0) goto L_0x0006
            goto L_0x0009
        L_0x0006:
            r0 = r7
            org.antlr.stringtemplate.language.StringTemplateAST r0 = (org.antlr.stringtemplate.language.StringTemplateAST) r0
        L_0x0009:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r7
            org.antlr.stringtemplate.language.StringTemplateAST r2 = (org.antlr.stringtemplate.language.StringTemplateAST) r2     // Catch: RecognitionException -> 0x0075
            r2 = 13
            r6.match(r7, r2)     // Catch: RecognitionException -> 0x0075
            antlr.collections.AST r2 = r7.getFirstChild()     // Catch: RecognitionException -> 0x0075
            r3 = 0
        L_0x001e:
            if (r2 != 0) goto L_0x0026
            antlr.ASTNULLType r4 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL     // Catch: RecognitionException -> 0x0024
            r2 = r4
            goto L_0x0026
        L_0x0024:
            r7 = move-exception
            goto L_0x0078
        L_0x0026:
            int r4 = r2.getType()     // Catch: RecognitionException -> 0x0024
            switch(r4) {
                case 4: goto L_0x004f;
                case 5: goto L_0x004f;
                case 7: goto L_0x004f;
                case 9: goto L_0x004f;
                case 11: goto L_0x004f;
                case 13: goto L_0x004f;
                case 14: goto L_0x0031;
                case 20: goto L_0x004f;
                case 24: goto L_0x004f;
                case 25: goto L_0x004f;
                case 33: goto L_0x004f;
                case 34: goto L_0x004f;
                case 35: goto L_0x004f;
                default: goto L_0x002d;
            }     // Catch: RecognitionException -> 0x0024
        L_0x002d:
            r4 = 1
            if (r3 < r4) goto L_0x006f
            goto L_0x0062
        L_0x0031:
            r4 = r2
            org.antlr.stringtemplate.language.StringTemplateAST r4 = (org.antlr.stringtemplate.language.StringTemplateAST) r4     // Catch: RecognitionException -> 0x0024
            r4 = 14
            r6.match(r2, r4)     // Catch: RecognitionException -> 0x0024
            antlr.collections.AST r4 = r2.getNextSibling()     // Catch: RecognitionException -> 0x0024
            org.antlr.stringtemplate.language.ActionEvaluator$1 r2 = new org.antlr.stringtemplate.language.ActionEvaluator$1     // Catch: RecognitionException -> 0x004c
            r2.<init>()     // Catch: RecognitionException -> 0x004c
            java.util.Iterator r2 = r2.iterator()     // Catch: RecognitionException -> 0x004c
            r0.add(r2)     // Catch: RecognitionException -> 0x004c
            r2 = r4
            goto L_0x005f
        L_0x004c:
            r7 = move-exception
            r2 = r4
            goto L_0x0078
        L_0x004f:
            java.lang.Object r4 = r6.expr(r2)     // Catch: RecognitionException -> 0x0024
            antlr.collections.AST r5 = r6._retTree     // Catch: RecognitionException -> 0x0024
            if (r4 == 0) goto L_0x005e
            r0.add(r4)     // Catch: RecognitionException -> 0x005b
            goto L_0x005e
        L_0x005b:
            r7 = move-exception
            r2 = r5
            goto L_0x0078
        L_0x005e:
            r2 = r5
        L_0x005f:
            int r3 = r3 + 1
            goto L_0x001e
        L_0x0062:
            antlr.collections.AST r2 = r7.getNextSibling()     // Catch: RecognitionException -> 0x0075
            org.antlr.stringtemplate.language.Cat r7 = new org.antlr.stringtemplate.language.Cat     // Catch: RecognitionException -> 0x0024
            r7.<init>(r0)     // Catch: RecognitionException -> 0x0024
            r1 = r7
            goto L_0x0081
        L_0x006f:
            antlr.NoViableAltException r7 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x0024
            r7.<init>(r2)     // Catch: RecognitionException -> 0x0024
            throw r7     // Catch: RecognitionException -> 0x0024
        L_0x0075:
            r0 = move-exception
            r2 = r7
            r7 = r0
        L_0x0078:
            r6.reportError(r7)
            if (r2 == 0) goto L_0x0081
            antlr.collections.AST r2 = r2.getNextSibling()
        L_0x0081:
            r6._retTree = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.stringtemplate.language.ActionEvaluator.list(antlr.collections.AST):java.lang.Object");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 3, insn: 0x00d7: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:47:0x00d7
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public final void template(
    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 3, insn: 0x00d7: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:47:0x00d7
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v0 ??
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

    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final java.lang.Object singleFunctionArg(antlr.collections.AST r5) throws antlr.RecognitionException {
        /*
            r4 = this;
            antlr.ASTNULLType r0 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL
            if (r5 != r0) goto L_0x0006
            goto L_0x0009
        L_0x0006:
            r0 = r5
            org.antlr.stringtemplate.language.StringTemplateAST r0 = (org.antlr.stringtemplate.language.StringTemplateAST) r0
        L_0x0009:
            r0 = 0
            r1 = r5
            org.antlr.stringtemplate.language.StringTemplateAST r1 = (org.antlr.stringtemplate.language.StringTemplateAST) r1     // Catch: RecognitionException -> 0x0030
            r1 = 12
            r4.match(r5, r1)     // Catch: RecognitionException -> 0x0030
            antlr.collections.AST r1 = r5.getFirstChild()     // Catch: RecognitionException -> 0x0030
            java.lang.Object r2 = r4.expr(r1)     // Catch: RecognitionException -> 0x002b
            antlr.collections.AST r0 = r4._retTree     // Catch: RecognitionException -> 0x0026
            antlr.collections.AST r0 = r5.getNextSibling()     // Catch: RecognitionException -> 0x0023
            goto L_0x003c
        L_0x0023:
            r0 = move-exception
            r1 = r0
            goto L_0x0032
        L_0x0026:
            r0 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x0033
        L_0x002b:
            r5 = move-exception
            r2 = r0
            r0 = r1
            r1 = r5
            goto L_0x0033
        L_0x0030:
            r1 = move-exception
            r2 = r0
        L_0x0032:
            r0 = r5
        L_0x0033:
            r4.reportError(r1)
            if (r0 == 0) goto L_0x003c
            antlr.collections.AST r0 = r0.getNextSibling()
        L_0x003c:
            r4._retTree = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.stringtemplate.language.ActionEvaluator.singleFunctionArg(antlr.collections.AST):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:2|(1:4)|5|(2:45|7)|10|(3:20|41|42)|32|46|33|34|41|42|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0071, code lost:
        r6 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060 A[Catch: RecognitionException -> 0x0011, FALL_THROUGH, TRY_ENTER, TRY_LEAVE, TryCatch #1 {RecognitionException -> 0x0011, blocks: (B:7:0x000d, B:10:0x0013, B:20:0x002a, B:21:0x002d, B:22:0x0030, B:23:0x0033, B:24:0x0038, B:25:0x0039, B:27:0x004d, B:32:0x0060), top: B:45:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final boolean ifCondition(antlr.collections.AST r6) throws antlr.RecognitionException {
        /*
            r5 = this;
            antlr.ASTNULLType r0 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL
            if (r6 != r0) goto L_0x0006
            goto L_0x0009
        L_0x0006:
            r0 = r6
            org.antlr.stringtemplate.language.StringTemplateAST r0 = (org.antlr.stringtemplate.language.StringTemplateAST) r0
        L_0x0009:
            r0 = 0
            if (r6 != 0) goto L_0x0013
            antlr.ASTNULLType r1 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL     // Catch: RecognitionException -> 0x0011
            r6 = r1
            goto L_0x0013
        L_0x0011:
            r1 = move-exception
            goto L_0x0072
        L_0x0013:
            int r1 = r6.getType()     // Catch: RecognitionException -> 0x0011
            r2 = 7
            if (r1 == r2) goto L_0x0060
            r2 = 9
            if (r1 == r2) goto L_0x0060
            r2 = 11
            if (r1 == r2) goto L_0x0060
            r2 = 13
            if (r1 == r2) goto L_0x0060
            r2 = 20
            if (r1 == r2) goto L_0x0060
            switch(r1) {
                case 4: goto L_0x0060;
                case 5: goto L_0x0060;
                default: goto L_0x002d;
            }     // Catch: RecognitionException -> 0x0011
        L_0x002d:
            switch(r1) {
                case 23: goto L_0x0039;
                case 24: goto L_0x0060;
                case 25: goto L_0x0060;
                default: goto L_0x0030;
            }     // Catch: RecognitionException -> 0x0011
        L_0x0030:
            switch(r1) {
                case 33: goto L_0x0060;
                case 34: goto L_0x0060;
                case 35: goto L_0x0060;
                default: goto L_0x0033;
            }     // Catch: RecognitionException -> 0x0011
        L_0x0033:
            antlr.NoViableAltException r1 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x0011
            r1.<init>(r6)     // Catch: RecognitionException -> 0x0011
            throw r1     // Catch: RecognitionException -> 0x0011
        L_0x0039:
            r1 = r6
            org.antlr.stringtemplate.language.StringTemplateAST r1 = (org.antlr.stringtemplate.language.StringTemplateAST) r1     // Catch: RecognitionException -> 0x0011
            r1 = 23
            r5.match(r6, r1)     // Catch: RecognitionException -> 0x0011
            antlr.collections.AST r1 = r6.getFirstChild()     // Catch: RecognitionException -> 0x0011
            java.lang.Object r2 = r5.ifAtom(r1)     // Catch: RecognitionException -> 0x005b
            antlr.collections.AST r3 = r5._retTree     // Catch: RecognitionException -> 0x005b
            antlr.collections.AST r1 = r6.getNextSibling()     // Catch: RecognitionException -> 0x0011
            org.antlr.stringtemplate.language.ASTExpr r6 = r5.chunk     // Catch: RecognitionException -> 0x005b
            boolean r6 = r6.testAttributeTrue(r2)     // Catch: RecognitionException -> 0x005b
            r6 = r6 ^ 1
            r0 = r6
            goto L_0x006f
        L_0x005b:
            r6 = move-exception
            r4 = r1
            r1 = r6
            r6 = r4
            goto L_0x0072
        L_0x0060:
            java.lang.Object r1 = r5.ifAtom(r6)     // Catch: RecognitionException -> 0x0011
            antlr.collections.AST r2 = r5._retTree     // Catch: RecognitionException -> 0x0011
            org.antlr.stringtemplate.language.ASTExpr r6 = r5.chunk     // Catch: RecognitionException -> 0x0070
            boolean r6 = r6.testAttributeTrue(r1)     // Catch: RecognitionException -> 0x0070
            r0 = r6
            r1 = r2
        L_0x006f:
            goto L_0x007d
        L_0x0070:
            r1 = move-exception
            r6 = r2
        L_0x0072:
            r5.reportError(r1)
            if (r6 == 0) goto L_0x007c
            antlr.collections.AST r1 = r6.getNextSibling()
            goto L_0x007d
        L_0x007c:
            r1 = r6
        L_0x007d:
            r5._retTree = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.stringtemplate.language.ActionEvaluator.ifCondition(antlr.collections.AST):boolean");
    }

    public final Object ifAtom(AST ast) throws RecognitionException {
        Object obj;
        RecognitionException e;
        if (ast != ASTNULL) {
            StringTemplateAST stringTemplateAST = (StringTemplateAST) ast;
        }
        try {
            obj = expr(ast);
        } catch (RecognitionException e2) {
            e = e2;
            obj = null;
        }
        try {
            ast = this._retTree;
        } catch (RecognitionException e3) {
            e = e3;
            reportError(e);
            if (ast != null) {
                ast = ast.getNextSibling();
            }
            this._retTree = ast;
            return obj;
        }
        this._retTree = ast;
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final java.util.Map argList(antlr.collections.AST r4, org.antlr.stringtemplate.StringTemplate r5, java.util.Map r6) throws antlr.RecognitionException {
        /*
            r3 = this;
            antlr.ASTNULLType r0 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL
            if (r4 != r0) goto L_0x0006
            goto L_0x0009
        L_0x0006:
            r0 = r4
            org.antlr.stringtemplate.language.StringTemplateAST r0 = (org.antlr.stringtemplate.language.StringTemplateAST) r0
        L_0x0009:
            if (r6 != 0) goto L_0x0011
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
        L_0x0011:
            if (r4 != 0) goto L_0x0019
            antlr.ASTNULLType r0 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL     // Catch: RecognitionException -> 0x0017
            r4 = r0
            goto L_0x0019
        L_0x0017:
            r5 = move-exception
            goto L_0x0063
        L_0x0019:
            int r0 = r4.getType()     // Catch: RecognitionException -> 0x0017
            r1 = 6
            if (r0 == r1) goto L_0x0030
            r1 = 12
            if (r0 == r1) goto L_0x002a
            antlr.NoViableAltException r5 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x0017
            r5.<init>(r4)     // Catch: RecognitionException -> 0x0017
            throw r5     // Catch: RecognitionException -> 0x0017
        L_0x002a:
            r3.singleTemplateArg(r4, r5, r6)     // Catch: RecognitionException -> 0x0017
            antlr.collections.AST r5 = r3._retTree     // Catch: RecognitionException -> 0x0017
            goto L_0x005b
        L_0x0030:
            r0 = r4
            org.antlr.stringtemplate.language.StringTemplateAST r0 = (org.antlr.stringtemplate.language.StringTemplateAST) r0     // Catch: RecognitionException -> 0x0017
            r3.match(r4, r1)     // Catch: RecognitionException -> 0x0017
            antlr.collections.AST r0 = r4.getFirstChild()     // Catch: RecognitionException -> 0x0017
        L_0x003b:
            if (r0 != 0) goto L_0x0044
            antlr.ASTNULLType r1 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL     // Catch: RecognitionException -> 0x0041
            r0 = r1
            goto L_0x0044
        L_0x0041:
            r5 = move-exception
            r4 = r0
            goto L_0x0063
        L_0x0044:
            int r1 = r0.getType()     // Catch: RecognitionException -> 0x0041
            r2 = 21
            if (r1 == r2) goto L_0x005c
            int r1 = r0.getType()     // Catch: RecognitionException -> 0x0041
            r2 = 38
            if (r1 != r2) goto L_0x0055
            goto L_0x005c
        L_0x0055:
            antlr.collections.AST r5 = r4.getNextSibling()     // Catch: RecognitionException -> 0x0017
        L_0x005b:
            goto L_0x006f
        L_0x005c:
            r3.argumentAssignment(r0, r5, r6)     // Catch: RecognitionException -> 0x0041
            antlr.collections.AST r1 = r3._retTree     // Catch: RecognitionException -> 0x0041
            r0 = r1
            goto L_0x003b
        L_0x0063:
            r3.reportError(r5)
            if (r4 == 0) goto L_0x006e
            antlr.collections.AST r5 = r4.getNextSibling()
            goto L_0x006f
        L_0x006e:
            r5 = r4
        L_0x006f:
            r3._retTree = r5
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.stringtemplate.language.ActionEvaluator.argList(antlr.collections.AST, org.antlr.stringtemplate.StringTemplate, java.util.Map):java.util.Map");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void argumentAssignment(antlr.collections.AST r5, org.antlr.stringtemplate.StringTemplate r6, java.util.Map r7) throws antlr.RecognitionException {
        /*
            r4 = this;
            antlr.ASTNULLType r0 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL
            if (r5 != r0) goto L_0x0005
            goto L_0x0008
        L_0x0005:
            r0 = r5
            org.antlr.stringtemplate.language.StringTemplateAST r0 = (org.antlr.stringtemplate.language.StringTemplateAST) r0
        L_0x0008:
            if (r5 != 0) goto L_0x0013
            antlr.ASTNULLType r0 = org.antlr.stringtemplate.language.ActionEvaluator.ASTNULL     // Catch: RecognitionException -> 0x0010
            r5 = r0
            goto L_0x0013
        L_0x0010:
            r6 = move-exception
            r7 = r5
            goto L_0x006a
        L_0x0013:
            int r0 = r5.getType()     // Catch: RecognitionException -> 0x0010
            r1 = 21
            if (r0 == r1) goto L_0x0036
            r7 = 38
            if (r0 == r7) goto L_0x0025
            antlr.NoViableAltException r6 = new antlr.NoViableAltException     // Catch: RecognitionException -> 0x0010
            r6.<init>(r5)     // Catch: RecognitionException -> 0x0010
            throw r6     // Catch: RecognitionException -> 0x0010
        L_0x0025:
            r0 = r5
            org.antlr.stringtemplate.language.StringTemplateAST r0 = (org.antlr.stringtemplate.language.StringTemplateAST) r0     // Catch: RecognitionException -> 0x0010
            r4.match(r5, r7)     // Catch: RecognitionException -> 0x0010
            antlr.collections.AST r7 = r5.getNextSibling()     // Catch: RecognitionException -> 0x0010
            r5 = 1
            r6.setPassThroughAttributes(r5)     // Catch: RecognitionException -> 0x0034
            goto L_0x0064
        L_0x0034:
            r6 = move-exception
            goto L_0x006a
        L_0x0036:
            r0 = r5
            org.antlr.stringtemplate.language.StringTemplateAST r0 = (org.antlr.stringtemplate.language.StringTemplateAST) r0     // Catch: RecognitionException -> 0x0010
            r4.match(r5, r1)     // Catch: RecognitionException -> 0x0010
            antlr.collections.AST r0 = r5.getFirstChild()     // Catch: RecognitionException -> 0x0010
            r1 = r0
            org.antlr.stringtemplate.language.StringTemplateAST r1 = (org.antlr.stringtemplate.language.StringTemplateAST) r1     // Catch: RecognitionException -> 0x0068
            r2 = 20
            r4.match(r0, r2)     // Catch: RecognitionException -> 0x0068
            antlr.collections.AST r2 = r0.getNextSibling()     // Catch: RecognitionException -> 0x0068
            java.lang.Object r0 = r4.expr(r2)     // Catch: RecognitionException -> 0x0065
            antlr.collections.AST r3 = r4._retTree     // Catch: RecognitionException -> 0x0065
            antlr.collections.AST r2 = r5.getNextSibling()     // Catch: RecognitionException -> 0x0010
            if (r0 == 0) goto L_0x0063
            org.antlr.stringtemplate.StringTemplate r5 = r4.self     // Catch: RecognitionException -> 0x0065
            java.lang.String r1 = r1.getText()     // Catch: RecognitionException -> 0x0065
            r5.rawSetArgumentAttribute(r6, r7, r1, r0)     // Catch: RecognitionException -> 0x0065
        L_0x0063:
            r7 = r2
        L_0x0064:
            goto L_0x0073
        L_0x0065:
            r6 = move-exception
            r7 = r2
            goto L_0x006a
        L_0x0068:
            r6 = move-exception
            r7 = r0
        L_0x006a:
            r4.reportError(r6)
            if (r7 == 0) goto L_0x0073
            antlr.collections.AST r7 = r7.getNextSibling()
        L_0x0073:
            r4._retTree = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.antlr.stringtemplate.language.ActionEvaluator.argumentAssignment(antlr.collections.AST, org.antlr.stringtemplate.StringTemplate, java.util.Map):void");
    }

    public final void singleTemplateArg(AST ast, StringTemplate stringTemplate, Map map) throws RecognitionException {
        AST ast2;
        RecognitionException e;
        if (ast != ASTNULL) {
            StringTemplateAST stringTemplateAST = (StringTemplateAST) ast;
        }
        try {
            StringTemplateAST stringTemplateAST2 = (StringTemplateAST) ast;
            match(ast, 12);
            ast2 = ast.getFirstChild();
        } catch (RecognitionException e2) {
            e = e2;
            ast2 = ast;
        }
        try {
            Object expr = expr(ast2);
            AST ast3 = this._retTree;
            ast2 = ast.getNextSibling();
            if (expr != null) {
                String str = null;
                Map formalArguments = stringTemplate.getFormalArguments();
                boolean z = true;
                if (formalArguments != null) {
                    Set keySet = formalArguments.keySet();
                    if (keySet.size() == 1) {
                        str = (String) keySet.toArray()[0];
                        z = false;
                    }
                }
                if (z) {
                    StringTemplate stringTemplate2 = this.self;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("template ");
                    stringBuffer.append(stringTemplate.getName());
                    stringBuffer.append(" must have exactly one formal arg in template context ");
                    stringBuffer.append(this.self.getEnclosingInstanceStackString());
                    stringTemplate2.error(stringBuffer.toString());
                } else {
                    this.self.rawSetArgumentAttribute(stringTemplate, map, str, expr);
                }
            }
        } catch (RecognitionException e3) {
            e = e3;
            reportError(e);
            if (ast2 != null) {
                ast2 = ast2.getNextSibling();
            }
            this._retTree = ast2;
        }
        this._retTree = ast2;
    }

    private static final long[] mk_tokenSet_0() {
        return new long[]{60180933296L, 0};
    }
}
