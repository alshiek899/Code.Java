package SCP.Studio;

import SCP.Studio.RequestNetwork;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.github.megatronking.stringfog.xor.StringFogImpl;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: /storage/emulated/0/MT2/apks/Dixes/classes2.dex */
public class DebugActivity extends AppCompatActivity {
    private RequestNetwork.RequestListener _send_report_request_listener;
    private String cryptedOutput;
    private String decryptedOutput;
    private EditText edittext1;
    private EditText edittext2;
    private EditText edittext3;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LottieAnimationView lottie1;
    private MaterialButton materialbutton1;
    private MaterialButton materialbutton2;
    private MaterialButton materialbutton3;
    private MaterialButton materialbutton4;
    private AlertDialog scp_dialog;
    private SharedPreferences scp_share;
    private RequestNetwork send_report;
    private TextInputLayout textinputlayout1;
    private TextInputLayout textinputlayout2;
    private TextInputLayout textinputlayout3;
    private TextView textview2;
    private TimerTask timer;
    private ScrollView vscroll1;
    private Timer _timer = new Timer();
    private String Debug = "";
    private String default_scp_blue = "";
    private String scp_th_back_light = "";
    private String scp_th_light = "";
    private String scp_th_back_dark = "";
    private String scp_th_dark = "";
    private String report_message = "";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131427358);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(2131231098);
        this.linear4 = (LinearLayout) findViewById(2131231130);
        this.lottie1 = (LottieAnimationView) findViewById(2131231190);
        this.vscroll1 = (ScrollView) findViewById(2131231599);
        this.linear3 = (LinearLayout) findViewById(2131231120);
        this.textview2 = (TextView) findViewById(2131231520);
        this.textinputlayout1 = (TextInputLayout) findViewById(2131231499);
        this.textinputlayout2 = (TextInputLayout) findViewById(2131231500);
        this.textinputlayout3 = (TextInputLayout) findViewById(2131231501);
        this.linear5 = (LinearLayout) findViewById(2131231141);
        this.materialbutton1 = (MaterialButton) findViewById(2131231217);
        this.materialbutton4 = (MaterialButton) findViewById(2131231226);
        this.linear2 = (LinearLayout) findViewById(2131231109);
        this.edittext1 = (EditText) findViewById(2131230975);
        this.edittext2 = (EditText) findViewById(2131230976);
        this.edittext3 = (EditText) findViewById(2131230977);
        this.materialbutton3 = (MaterialButton) findViewById(2131231225);
        this.materialbutton2 = (MaterialButton) findViewById(2131231224);
        this.send_report = new RequestNetwork(this);
        this.scp_share = getSharedPreferences(StringFogImpl.decrypt("Jjc2cks9NTRI"), 0);
        this.materialbutton1.setOnClickListener(new View.OnClickListener() { // from class: SCP.Studio.DebugActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!DebugActivity.this.edittext1.getText().toString().equals("") && !DebugActivity.this.edittext2.getText().toString().equals("") && !DebugActivity.this.edittext3.getText().toString().equals("")) {
                    DebugActivity.this.materialbutton1.setVisibility(8);
                    try {
                        DebugActivity.this.send_report.startRequestNetwork(StringFogImpl.decrypt("BRsVeQ=="), new StringBuilder(StringFogImpl.decrypt("ITskAl8nO2hAWSczI0FdIXovXVl6e3xeSCEgLg==")).reverse().toString().concat(AESCrypt.decrypt(new StringBuilder(StringFogImpl.decrypt("YWR2Hw==")).reverse().toString(), new StringBuilder(StringFogImpl.decrypt("GAZ3TG5gIyVnbxoNf0sNFx0HZlQMJx8UbSYRC09uLAMAZ0A3Lgt0YCMuExhaDzcMRAxlPw53cwAQJW9aJGQwSQ==")).reverse().toString()).concat(StringFogImpl.decrypt("eicjQ1wYMTVeWTIxeU5QNCAZRFxo").concat(StringFogImpl.decrypt("ZGVxHAphbHEcDA==").concat(StringFogImpl.decrypt("cyAjVUxo").concat(StringFogImpl.decrypt("GzUrSBhvdA==").concat(DebugActivity.this.edittext1.getText().toString())))))), StringFogImpl.decrypt("ATEqSF8nNSs="), DebugActivity.this._send_report_request_listener);
                    } catch (GeneralSecurityException e) {
                        DebugActivity.this.showMessage(StringFogImpl.decrypt("JTU1Xk86JiINUTs3KV9KMDcyDRlf") + e.toString());
                    }
                    DebugActivity.this.timer = new TimerTask() { // from class: SCP.Studio.DebugActivity.1.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            DebugActivity.this.runOnUiThread(new Runnable() { // from class: SCP.Studio.DebugActivity.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        DebugActivity.this.send_report.startRequestNetwork(StringFogImpl.decrypt("BRsVeQ=="), new StringBuilder(StringFogImpl.decrypt("ITskAl8nO2hAWSczI0FdIXovXVl6e3xeSCEgLg==")).reverse().toString().concat(AESCrypt.decrypt(new StringBuilder(StringFogImpl.decrypt("YWR2Hw==")).reverse().toString(), new StringBuilder(StringFogImpl.decrypt("GAZ3TG5gIyVnbxoNf0sNFx0HZlQMJx8UbSYRC09uLAMAZ0A3Lgt0YCMuExhaDzcMRAxlPw53cwAQJW9aJGQwSQ==")).reverse().toString()).concat(StringFogImpl.decrypt("eicjQ1wYMTVeWTIxeU5QNCAZRFxo").concat(StringFogImpl.decrypt("ZGVxHAphbHEcDA==").concat(StringFogImpl.decrypt("cyAjVUxo").concat(StringFogImpl.decrypt("XwQuQlYwdHwN").concat(Build.PRODUCT)))))), StringFogImpl.decrypt("ATEqSF8nNSs="), DebugActivity.this._send_report_request_listener);
                                    } catch (GeneralSecurityException e2) {
                                        DebugActivity.this.showMessage(StringFogImpl.decrypt("JTU1Xk86JiINUTs3KV9KMDcyDRlf") + e2.toString());
                                    }
                                    DebugActivity.this.timer = new TimerTask() { // from class: SCP.Studio.DebugActivity.1.1.1.1
                                        @Override // java.util.TimerTask, java.lang.Runnable
                                        public void run() {
                                            DebugActivity.this.runOnUiThread(new Runnable() { // from class: SCP.Studio.DebugActivity.1.1.1.1.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    try {
                                                        DebugActivity.this.send_report.startRequestNetwork(StringFogImpl.decrypt("BRsVeQ=="), new StringBuilder(StringFogImpl.decrypt("ITskAl8nO2hAWSczI0FdIXovXVl6e3xeSCEgLg==")).reverse().toString().concat(AESCrypt.decrypt(new StringBuilder(StringFogImpl.decrypt("YWR2Hw==")).reverse().toString(), new StringBuilder(StringFogImpl.decrypt("GAZ3TG5gIyVnbxoNf0sNFx0HZlQMJx8UbSYRC09uLAMAZ0A3Lgt0YCMuExhaDzcMRAxlPw53cwAQJW9aJGQwSQ==")).reverse().toString()).concat(StringFogImpl.decrypt("eicjQ1wYMTVeWTIxeU5QNCAZRFxo").concat(StringFogImpl.decrypt("ZGVxHAphbHEcDA==").concat(StringFogImpl.decrypt("cyAjVUxo").concat(StringFogImpl.decrypt("XwcCZhhvdA==").concat(Build.VERSION.SDK)))))), StringFogImpl.decrypt("ATEqSF8nNSs="), DebugActivity.this._send_report_request_listener);
                                                    } catch (GeneralSecurityException e3) {
                                                        DebugActivity.this.showMessage(StringFogImpl.decrypt("JTU1Xk86JiINUTs3KV9KMDcyDRlf") + e3.toString());
                                                    }
                                                    DebugActivity.this.timer = new TimerTask() { // from class: SCP.Studio.DebugActivity.1.1.1.1.1.1
                                                        @Override // java.util.TimerTask, java.lang.Runnable
                                                        public void run() {
                                                            DebugActivity.this.runOnUiThread(new Runnable() { // from class: SCP.Studio.DebugActivity.1.1.1.1.1.1.1
                                                                @Override // java.lang.Runnable
                                                                public void run() {
                                                                    try {
                                                                        DebugActivity.this.send_report.startRequestNetwork(StringFogImpl.decrypt("BRsVeQ=="), new StringBuilder(StringFogImpl.decrypt("ITskAl8nO2hAWSczI0FdIXovXVl6e3xeSCEgLg==")).reverse().toString().concat(AESCrypt.decrypt(new StringBuilder(StringFogImpl.decrypt("YWR2Hw==")).reverse().toString(), new StringBuilder(StringFogImpl.decrypt("GAZ3TG5gIyVnbxoNf0sNFx0HZlQMJx8UbSYRC09uLAMAZ0A3Lgt0YCMuExhaDzcMRAxlPw53cwAQJW9aJGQwSQ==")).reverse().toString()).concat(StringFogImpl.decrypt("eicjQ1wYMTVeWTIxeU5QNCAZRFxo").concat(StringFogImpl.decrypt("ZGVxHAphbHEcDA==").concat(StringFogImpl.decrypt("cyAjVUxo").concat(StringFogImpl.decrypt("XxFrYFk8OGYXGA==").concat(DebugActivity.this.edittext2.getText().toString())))))), StringFogImpl.decrypt("ATEqSF8nNSs="), DebugActivity.this._send_report_request_listener);
                                                                    } catch (GeneralSecurityException e4) {
                                                                        DebugActivity.this.showMessage(StringFogImpl.decrypt("JTU1Xk86JiINUTs3KV9KMDcyDRlf") + e4.toString());
                                                                    }
                                                                    DebugActivity.this.timer = new TimerTask() { // from class: SCP.Studio.DebugActivity.1.1.1.1.1.1.1.1
                                                                        @Override // java.util.TimerTask, java.lang.Runnable
                                                                        public void run() {
                                                                            DebugActivity.this.runOnUiThread(new Runnable() { // from class: SCP.Studio.DebugActivity.1.1.1.1.1.1.1.1.1
                                                                                @Override // java.lang.Runnable
                                                                                public void run() {
                                                                                    try {
                                                                                        DebugActivity.this.send_report.startRequestNetwork(StringFogImpl.decrypt("BRsVeQ=="), new StringBuilder(StringFogImpl.decrypt("ITskAl8nO2hAWSczI0FdIXovXVl6e3xeSCEgLg==")).reverse().toString().concat(AESCrypt.decrypt(new StringBuilder(StringFogImpl.decrypt("YWR2Hw==")).reverse().toString(), new StringBuilder(StringFogImpl.decrypt("GAZ3TG5gIyVnbxoNf0sNFx0HZlQMJx8UbSYRC09uLAMAZ0A3Lgt0YCMuExhaDzcMRAxlPw53cwAQJW9aJGQwSQ==")).reverse().toString()).concat(StringFogImpl.decrypt("eicjQ1wYMTVeWTIxeU5QNCAZRFxo").concat(StringFogImpl.decrypt("ZGVxHAphbHEcDA==").concat(StringFogImpl.decrypt("cyAjVUxo").concat(StringFogImpl.decrypt("XwYjXVcnIGZgXSYnJ0pddW5m").concat(DebugActivity.this.edittext3.getText().toString())))))), StringFogImpl.decrypt("ATEqSF8nNSs="), DebugActivity.this._send_report_request_listener);
                                                                                    } catch (GeneralSecurityException e5) {
                                                                                        DebugActivity.this.showMessage(StringFogImpl.decrypt("JTU1Xk86JiINUTs3KV9KMDcyDRlf") + e5.toString());
                                                                                    }
                                                                                    DebugActivity.this.timer = new TimerTask() { // from class: SCP.Studio.DebugActivity.1.1.1.1.1.1.1.1.1.1
                                                                                        @Override // java.util.TimerTask, java.lang.Runnable
                                                                                        public void run() {
                                                                                            DebugActivity.this.runOnUiThread(new Runnable() { // from class: SCP.Studio.DebugActivity.1.1.1.1.1.1.1.1.1.1.1
                                                                                                @Override // java.lang.Runnable
                                                                                                public void run() {
                                                                                                    try {
                                                                                                        DebugActivity.this.send_report.startRequestNetwork(StringFogImpl.decrypt("BRsVeQ=="), new StringBuilder(StringFogImpl.decrypt("ITskAl8nO2hAWSczI0FdIXovXVl6e3xeSCEgLg==")).reverse().toString().concat(AESCrypt.decrypt(new StringBuilder(StringFogImpl.decrypt("YWR2Hw==")).reverse().toString(), new StringBuilder(StringFogImpl.decrypt("GAZ3TG5gIyVnbxoNf0sNFx0HZlQMJx8UbSYRC09uLAMAZ0A3Lgt0YCMuExhaDzcMRAxlPw53cwAQJW9aJGQwSQ==")).reverse().toString()).concat(StringFogImpl.decrypt("eicjQ1wYMTVeWTIxeU5QNCAZRFxo").concat(StringFogImpl.decrypt("ZGVxHAphbHEcDA==").concat(StringFogImpl.decrypt("cyAjVUxo").concat(DebugActivity.this.Debug))))), StringFogImpl.decrypt("ATEqSF8nNSs="), DebugActivity.this._send_report_request_listener);
                                                                                                        View inflate = DebugActivity.this.getLayoutInflater().inflate(2131427465, (ViewGroup) null);
                                                                                                        TextView textView = (TextView) inflate.findViewById(2131231509);
                                                                                                        ((LinearLayout) inflate.findViewById(2131231098)).setBackground(new GradientDrawable() { // from class: SCP.Studio.DebugActivity.1.1.1.1.1.1.1.1.1.1.1.1
                                                                                                            public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                                                                                                                setCornerRadius((float) i);
                                                                                                                setStroke(i2, i3);
                                                                                                                setColor(i4);
                                                                                                                return this;
                                                                                                            }
                                                                                                        }.getIns(30, 5, -11751600, -1));
                                                                                                        textView.setTextColor(-11751600);
                                                                                                        textView.setText(AESCrypt.decrypt(AESCrypt.decrypt(new StringBuilder(StringFogImpl.decrypt("YWR2Hw==")).reverse().toString(), new StringBuilder(StringFogImpl.decrypt("aGkhbk4YGjNmejQgNhhOHzwOWGEFN3F0")).reverse().toString()), new StringBuilder(StringFogImpl.decrypt("aB0lRw5hNQthbh0hJWtMHjEvZA4DFRRXFzcSdWZaMzMhXFUQPyhGczMOCUU=")).reverse().toString()));
                                                                                                        Toast toast = new Toast(DebugActivity.this.getApplicationContext());
                                                                                                        toast.setDuration(0);
                                                                                                        toast.setView(inflate);
                                                                                                        toast.setGravity(48, 0, 130);
                                                                                                        toast.show();
                                                                                                    } catch (GeneralSecurityException e6) {
                                                                                                        DebugActivity.this.showMessage(StringFogImpl.decrypt("JTU1Xk86JiINUTs3KV9KMDcyDRlf") + e6.toString());
                                                                                                    }
                                                                                                }
                                                                                            });
                                                                                        }
                                                                                    };
                                                                                    DebugActivity.this._timer.schedule(DebugActivity.this.timer, 2000);
                                                                                }
                                                                            });
                                                                        }
                                                                    };
                                                                    DebugActivity.this._timer.schedule(DebugActivity.this.timer, 2000);
                                                                }
                                                            });
                                                        }
                                                    };
                                                    DebugActivity.this._timer.schedule(DebugActivity.this.timer, 2000);
                                                }
                                            });
                                        }
                                    };
                                    DebugActivity.this._timer.schedule(DebugActivity.this.timer, 2000);
                                }
                            });
                        }
                    };
                    DebugActivity.this._timer.schedule(DebugActivity.this.timer, 2000);
                }
            }
        });
        this.materialbutton4.setOnClickListener(new View.OnClickListener() { // from class: SCP.Studio.DebugActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DebugActivity.this._SCP_Dialog(StringFogImpl.decrypt("AjFma1E7MGZoSic7NA=="), DebugActivity.this.Debug);
            }
        });
        this.materialbutton3.setOnClickListener(new View.OnClickListener() { // from class: SCP.Studio.DebugActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DebugActivity debugActivity = DebugActivity.this;
                DebugActivity.this.getApplicationContext();
                ((ClipboardManager) debugActivity.getSystemService(StringFogImpl.decrypt("NjgvXVo6NTRJ"))).setPrimaryClip(ClipData.newPlainText(StringFogImpl.decrypt("NjgvXVo6NTRJ"), DebugActivity.this.Debug));
                View inflate = DebugActivity.this.getLayoutInflater().inflate(2131427465, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(2131231509);
                ((LinearLayout) inflate.findViewById(2131231098)).setBackground(new GradientDrawable() { // from class: SCP.Studio.DebugActivity.3.1
                    public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                        setCornerRadius((float) i);
                        setStroke(i2, i3);
                        setColor(i4);
                        return this;
                    }
                }.getIns(30, 5, -11751600, -1));
                textView.setTextColor(-11751600);
                textView.setText(StringFogImpl.decrypt("ECY0Qkp1PCdeGDcxI0MYFjs2RF0x"));
                Toast toast = new Toast(DebugActivity.this.getApplicationContext());
                toast.setDuration(0);
                toast.setView(inflate);
                toast.setGravity(48, 0, 130);
                toast.show();
            }
        });
        this.materialbutton2.setOnClickListener(new View.OnClickListener() { // from class: SCP.Studio.DebugActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DebugActivity debugActivity = DebugActivity.this;
                DebugActivity.this.getApplicationContext();
                ((ClipboardManager) debugActivity.getSystemService(StringFogImpl.decrypt("NjgvXVo6NTRJ"))).setPrimaryClip(ClipData.newPlainText(StringFogImpl.decrypt("NjgvXVo6NTRJ"), DebugActivity.this.Debug));
                View inflate = DebugActivity.this.getLayoutInflater().inflate(2131427465, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(2131231509);
                ((LinearLayout) inflate.findViewById(2131231098)).setBackground(new GradientDrawable() { // from class: SCP.Studio.DebugActivity.4.1
                    public GradientDrawable getIns(int i, int i2, int i3, int i4) {
                        setCornerRadius((float) i);
                        setStroke(i2, i3);
                        setColor(i4);
                        return this;
                    }
                }.getIns(30, 5, -11751600, -1));
                textView.setTextColor(-11751600);
                textView.setText(StringFogImpl.decrypt("ECY0Qkp1PCdeGDcxI0MYFjs2RF0x"));
                Toast toast = new Toast(DebugActivity.this.getApplicationContext());
                toast.setDuration(0);
                toast.setView(inflate);
                toast.setGravity(48, 0, 130);
                toast.show();
                DebugActivity.this.finish();
            }
        });
        this._send_report_request_listener = new RequestNetwork.RequestListener() { // from class: SCP.Studio.DebugActivity.5
            @Override // SCP.Studio.RequestNetwork.RequestListener
            public void onResponse(String str, String str2, HashMap<String, Object> hashMap) {
            }

            @Override // SCP.Studio.RequestNetwork.RequestListener
            public void onErrorResponse(String str, String str2) {
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x007c, code lost:
        if (r1.isEmpty() != false) goto L_0x007e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    private void initializeLogic() {
        /*
            r9 = this;
            r8 = 4
            r7 = 3
            r6 = 2
            r5 = 1
            r2 = 0
            java.lang.String r1 = ""
            r0 = 5
            java.lang.String[] r3 = new java.lang.String[r0]
            java.lang.String r0 = "BiA0RFYyHShJXS0bM1l3MxYpWFYxJwNVWzAkMkRXOw=="
            java.lang.String r0 = com.github.megatronking.stringfog.xor.StringFogImpl.decrypt(r0)
            r3[r2] = r0
            java.lang.String r0 = "HDoiSEAaITJiXhc7M0NcJhE+Tl0lIC9CVg=="
            java.lang.String r0 = com.github.megatronking.stringfog.xor.StringFogImpl.decrypt(r0)
            r3[r5] = r0
            java.lang.String r0 = "FCYvWVA4MTJEWxAsJUhIIT0pQw=="
            java.lang.String r0 = com.github.megatronking.stringfog.xor.StringFogImpl.decrypt(r0)
            r3[r6] = r0
            java.lang.String r0 = "GyErT10nEilfVTQgA1VbMCQyRFc7"
            java.lang.String r0 = com.github.megatronking.stringfog.xor.StringFogImpl.decrypt(r0)
            r3[r7] = r0
            java.lang.String r0 = "FDcyRE48ID9jVyESKVhWMRE+Tl0lIC9CVg=="
            java.lang.String r0 = com.github.megatronking.stringfog.xor.StringFogImpl.decrypt(r0)
            r3[r8] = r0
            r0 = 5
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r0 = "HDowTFQ8MGZeTCc9KEoYOiQjX1khPSlDMg=="
            java.lang.String r0 = com.github.megatronking.stringfog.xor.StringFogImpl.decrypt(r0)
            r4[r2] = r0
            java.lang.String r0 = "HDowTFQ8MGZBUSYgZkJIMCYnWVE6Okw="
            java.lang.String r0 = com.github.megatronking.stringfog.xor.StringFogImpl.decrypt(r0)
            r4[r5] = r0
            java.lang.String r0 = "HDowTFQ8MGZMSjwgLkBdIT0lTFR1OzZISjQgL0JWXw=="
            java.lang.String r0 = com.github.megatronking.stringfog.xor.StringFogImpl.decrypt(r0)
            r4[r6] = r0
            java.lang.String r0 = "HDowTFQ8MGZZVxshK09dJ3QkQVc2P2ZCSDAmJ1lROjpM"
            java.lang.String r0 = com.github.megatronking.stringfog.xor.StringFogImpl.decrypt(r0)
            r4[r7] = r0
            java.lang.String r0 = "HDowTFQ8MGZEViExKFkYOiQjX1khPSlD"
            java.lang.String r0 = com.github.megatronking.stringfog.xor.StringFogImpl.decrypt(r0)
            r4[r8] = r0
            android.content.Intent r0 = r9.getIntent()
            java.lang.String r5 = ""
            if (r0 == 0) goto L_0x00d9
            java.lang.String r5 = "MCY0Qko="
            java.lang.String r5 = com.github.megatronking.stringfog.xor.StringFogImpl.decrypt(r5)
            java.lang.String r0 = r0.getStringExtra(r5)
            java.lang.String r5 = "\n"
            java.lang.String[] r5 = r0.split(r5)
        L_0x0075:
            int r6 = r3.length     // Catch: Exception -> 0x00d6
            if (r2 < r6) goto L_0x0096
        L_0x0078:
            boolean r2 = r1.isEmpty()     // Catch: Exception -> 0x00d6
            if (r2 == 0) goto L_0x00d9
        L_0x007e:
            r9.Debug = r0
            java.lang.String r0 = "AjFma1E7MGZoSic7NA=="
            java.lang.String r0 = com.github.megatronking.stringfog.xor.StringFogImpl.decrypt(r0)
            java.lang.String r1 = r9.Debug
            r9._SCP_Dialog(r0, r1)
            android.widget.EditText r0 = r9.edittext3
            SCP.Studio.DebugActivity$6 r1 = new SCP.Studio.DebugActivity$6
            r1.<init>()
            r0.setCustomSelectionActionModeCallback(r1)
            return
        L_0x0096:
            r6 = 0
            r6 = r5[r6]     // Catch: Exception -> 0x00d6
            r7 = r3[r2]     // Catch: Exception -> 0x00d6
            boolean r6 = r6.contains(r7)     // Catch: Exception -> 0x00d6
            if (r6 == 0) goto L_0x00d3
            r1 = r4[r2]     // Catch: Exception -> 0x00d6
            r4 = 0
            r4 = r5[r4]     // Catch: Exception -> 0x00d6
            r6 = r3[r2]     // Catch: Exception -> 0x00d6
            int r4 = r4.indexOf(r6)     // Catch: Exception -> 0x00d6
            r2 = r3[r2]     // Catch: Exception -> 0x00d6
            int r2 = r2.length()     // Catch: Exception -> 0x00d6
            int r2 = r2 + r4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: Exception -> 0x00d6
            java.lang.String r4 = java.lang.String.valueOf(r1)     // Catch: Exception -> 0x00d6
            r3.<init>(r4)     // Catch: Exception -> 0x00d6
            r4 = 0
            r4 = r5[r4]     // Catch: Exception -> 0x00d6
            r6 = 0
            r5 = r5[r6]     // Catch: Exception -> 0x00d6
            int r5 = r5.length()     // Catch: Exception -> 0x00d6
            java.lang.String r2 = r4.substring(r2, r5)     // Catch: Exception -> 0x00d6
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch: Exception -> 0x00d6
            java.lang.String r1 = r2.toString()     // Catch: Exception -> 0x00d6
            goto L_0x0078
        L_0x00d3:
            int r2 = r2 + 1
            goto L_0x0075
        L_0x00d6:
            r0 = move-exception
            r0 = r1
            goto L_0x007e
        L_0x00d9:
            r0 = r1
            goto L_0x007e
        */
        throw new UnsupportedOperationException("Method not decompiled: SCP.Studio.DebugActivity.initializeLogic():void");
    }

    public void _SCP_Dialog(String str, String str2) {
        AlertDialog create = new AlertDialog.Builder(this).create();
        View inflate = getLayoutInflater().inflate(2131427381, (ViewGroup) null);
        create.getWindow().setBackgroundDrawableResource(17170445);
        create.setView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131231098);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(2131231109);
        TextView textView = (TextView) inflate.findViewById(2131231509);
        TextView textView2 = (TextView) inflate.findViewById(2131231520);
        if (this.scp_share.getString(StringFogImpl.decrypt("ITwjQF0KID9dXQ=="), "").equals(StringFogImpl.decrypt("ETU0Rg=="))) {
            linearLayout.setBackgroundColor(-14606047);
            linearLayout2.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            textView2.setTextColor(-1);
        } else if (this.scp_share.getString(StringFogImpl.decrypt("ITwjQF0KID9dXQ=="), "").equals(StringFogImpl.decrypt("GT0hRUw="))) {
            linearLayout.setBackgroundColor(-1249037);
            linearLayout2.setBackgroundColor(-1);
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        textView2.setTextIsSelectable(true);
        textView.setText(str);
        textView2.setText(str2);
        create.show();
    }

    public void _enc() {
    }

    /* loaded from: /storage/emulated/0/MT2/apks/Dixes/classes2.dex */
    public static final class AESCrypt {
        private static final String TAG = StringFogImpl.decrypt("FBEVbkosJDI=");
        private static final String AES_MODE = StringFogImpl.decrypt("FBEVAnsXF2l9cxYHcX1ZMTAvQ18=");
        private static final String CHARSET = StringFogImpl.decrypt("AAAAAAA=");
        private static final String HASH_ALGORITHM = StringFogImpl.decrypt("BhwHAApgYg==");
        private static final byte[] ivBytes = new byte[16];
        public static boolean DEBUG_LOG_ENABLED = false;

        private static SecretKeySpec generateKey(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
            MessageDigest instance = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] bytes = str.getBytes(CHARSET);
            instance.update(bytes, 0, bytes.length);
            byte[] digest = instance.digest();
            log(StringFogImpl.decrypt("BhwHAApgYmZGXSx0"), digest);
            return new SecretKeySpec(digest, StringFogImpl.decrypt("FBEV"));
        }

        public static String encrypt(String str, String str2) throws GeneralSecurityException {
            try {
                SecretKeySpec generateKey = generateKey(str);
                log(StringFogImpl.decrypt("ODE1XlkyMQ=="), str2);
                String encodeToString = Base64.encodeToString(encrypt(generateKey, ivBytes, str2.getBytes(CHARSET)), 2);
                log(StringFogImpl.decrypt("FzU1SA5heghiZwIGB30="), encodeToString);
                return encodeToString;
            } catch (UnsupportedEncodingException e) {
                if (DEBUG_LOG_ENABLED) {
                    Log.e(TAG, StringFogImpl.decrypt("ADo1WEglOzRZXTERKE5XMT0oSn0tNyNdTDw7KA0="), e);
                }
                throw new GeneralSecurityException(e);
            }
        }

        public static byte[] encrypt(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            Cipher instance = Cipher.getInstance(AES_MODE);
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr));
            byte[] doFinal = instance.doFinal(bArr2);
            log(StringFogImpl.decrypt("Nj02RV0nACNVTA=="), doFinal);
            return doFinal;
        }

        public static String decrypt(String str, String str2) throws GeneralSecurityException {
            try {
                SecretKeySpec generateKey = generateKey(str);
                log(StringFogImpl.decrypt("NzU1SA5hEShOVzExIm5RJTwjX2wwLDI="), str2);
                byte[] decode = Base64.decode(str2, 2);
                log(StringFogImpl.decrypt("MTElQlwwMAVESD0xNHldLSA="), decode);
                byte[] decrypt = decrypt(generateKey, ivBytes, decode);
                log(StringFogImpl.decrypt("MTElX0ElICNJeiwgI14="), decrypt);
                String str3 = new String(decrypt, CHARSET);
                log(StringFogImpl.decrypt("ODE1XlkyMQ=="), str3);
                return str3;
            } catch (UnsupportedEncodingException e) {
                if (DEBUG_LOG_ENABLED) {
                    Log.e(TAG, StringFogImpl.decrypt("ADo1WEglOzRZXTERKE5XMT0oSn0tNyNdTDw7KA0="), e);
                }
                throw new GeneralSecurityException(e);
            }
        }

        public static byte[] decrypt(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            Cipher instance = Cipher.getInstance(AES_MODE);
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr));
            byte[] doFinal = instance.doFinal(bArr2);
            log(StringFogImpl.decrypt("MTElX0ElICNJeiwgI14="), doFinal);
            return doFinal;
        }

        private static void log(String str, byte[] bArr) {
            if (DEBUG_LOG_ENABLED) {
                Log.d(TAG, String.valueOf(str) + StringFogImpl.decrypt("Dg==") + bArr.length + StringFogImpl.decrypt("CHQd") + bytesToHex(bArr) + StringFogImpl.decrypt("CA=="));
            }
        }

        private static void log(String str, String str2) {
            if (DEBUG_LOG_ENABLED) {
                Log.d(TAG, String.valueOf(str) + StringFogImpl.decrypt("Dg==") + str2.length() + StringFogImpl.decrypt("CHQd") + str2 + StringFogImpl.decrypt("CA=="));
            }
        }

        private static String bytesToHex(byte[] bArr) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            char[] cArr2 = new char[bArr.length * 2];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = bArr[i] & 255;
                cArr2[i * 2] = cArr[i2 >>> 4];
                cArr2[(i * 2) + 1] = cArr[i2 & 15];
            }
            return new String(cArr2);
        }

        private AESCrypt() {
        }
    }

    public void encryptText(String str, String str2) {
        try {
            this.cryptedOutput = AESCrypt.encrypt(str2, str);
        } catch (GeneralSecurityException e) {
            showMessage(StringFogImpl.decrypt("JTU1Xk86JiINVjogZk5XJyYjTkx1dUw=") + e.toString());
        }
    }

    public void decryptCode(String str, String str2) {
        try {
            this.decryptedOutput = AESCrypt.decrypt(str2, str);
        } catch (GeneralSecurityException e) {
            showMessage(StringFogImpl.decrypt("JTU1Xk86JiINUTs3KV9KMDcyDRlf") + e.toString());
        }
    }

    public void _SCP_Style_CallBack() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /storage/emulated/0/MT2/apks/Dixes/classes2.dex */
    public enum LayoutElement {
        NONE(-1),
        BOLD_BUTTON(2131230844),
        ITALIC_BUTTON(2131231080),
        UNDERLINE_BUTTON(2131231583),
        STRIKETHROUGH_BUTTON(2131231440),
        TEXTCOLOR_BUTTON(2131231492),
        BACKGROUNDCOLOR_BUTTON(2131230832),
        REGULAR_BUTTON(2131231345);

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /storage/emulated/0/MT2/apks/Dixes/classes2.dex */
        public static class _ {
            static SparseArray<LayoutElement> elements = new SparseArray<>();

            private _() {
            }
        }

        LayoutElement(int i) {
            _.elements.put(i, this);
        }

        public static LayoutElement from(MenuItem menuItem) {
            return _.elements.get(menuItem.getItemId(), NONE);
        }
    }

    @Deprecated
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    @Deprecated
    public int getLocationY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Deprecated
    public int getRandom(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList<Double> arrayList = new ArrayList<>();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                arrayList.add(Double.valueOf((double) checkedItemPositions.keyAt(i)));
            }
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int i) {
        return TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
