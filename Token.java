package org.antlr.runtime;
/* loaded from: /storage/emulated/0/MT2/apks/Dixes/classes.dex */
public interface Token {
    public static final int DEFAULT_CHANNEL;
    public static final int DOWN;
    public static final int EOF;
    public static final int EOR_TOKEN_TYPE;
    public static final int HIDDEN_CHANNEL;
    public static final int INVALID_TOKEN_TYPE;
    public static final int MIN_TOKEN_TYPE;
    public static final int UP;
    public static final Token EOF_TOKEN = new CommonToken(-1);
    public static final Token INVALID_TOKEN = new CommonToken(0);
    public static final Token SKIP_TOKEN = new CommonToken(0);

    int getChannel();

    int getCharPositionInLine();

    CharStream getInputStream();

    int getLine();

    String getText();

    int getTokenIndex();

    int getType();

    void setChannel(int i);

    void setCharPositionInLine(int i);

    void setInputStream(CharStream charStream);

    void setLine(int i);

    void setText(String str);

    void setTokenIndex(int i);

    void setType(int i);
}
