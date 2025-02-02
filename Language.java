package io.github.rosemoe.sora.lang;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import io.github.rosemoe.sora.lang.analysis.AnalyzeManager;
import io.github.rosemoe.sora.lang.completion.CompletionCancelledException;
import io.github.rosemoe.sora.lang.completion.CompletionPublisher;
import io.github.rosemoe.sora.lang.smartEnter.NewlineHandler;
import io.github.rosemoe.sora.text.CharPosition;
import io.github.rosemoe.sora.text.ContentReference;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
/* loaded from: /storage/emulated/0/MT2/apks/Dixes/classes.dex */
public interface Language {
    public static final int INTERRUPTION_LEVEL_NONE;
    public static final int INTERRUPTION_LEVEL_SLIGHT;
    public static final int INTERRUPTION_LEVEL_STRONG;

    void destroy();

    @WorkerThread
    CharSequence format(CharSequence charSequence);

    @NonNull
    AnalyzeManager getAnalyzeManager();

    @UiThread
    int getIndentAdvance(@NonNull ContentReference contentReference, int i, int i2);

    int getInterruptionLevel();

    @Nullable
    @UiThread
    NewlineHandler[] getNewlineHandlers();

    @UiThread
    SymbolPairMatch getSymbolPairs();

    @WorkerThread
    void requireAutoComplete(@NonNull ContentReference contentReference, @NonNull CharPosition charPosition, @NonNull CompletionPublisher completionPublisher, @NonNull Bundle bundle) throws CompletionCancelledException;

    @UiThread
    boolean useTab();
}
