package com.his.nurse.dialog;

import com.his.nurse.R;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * @author gordon
 * 加载进度框
 */
public class LoadingDialog {
    
    private Context ctx;
    
    private Dialog dlg;

    private String content;

    private TextView tvContent;

    public LoadingDialog(Context ctx) {
        this.ctx = ctx;
        dlg = new Dialog(ctx);
        dlg.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(ctx).inflate(R.layout.dialog_loading, null);
        tvContent = (TextView) view.findViewById(R.id.loading_tv_content);
        dlg.setContentView(view);
    }
    
    public void setContentText(String text) {
        this.content = text;
        tvContent.setText(text + "...");
    }
    
    public LoadingDialog(Context ctx, String content) {
        this(ctx);
        setContentText(content);
    }
    
    public void show() {
        dlg.show();
    }

    public void cancel() {
        dlg.cancel();
    }
    
}
