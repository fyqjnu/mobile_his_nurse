package com.his.nurse.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.his.nurse.R;
import com.his.nurse.util.DensityUtil;
import com.his.nurse.util.ILog;

/**
 * 搜索控件
 */
public class SearchView extends RelativeLayout implements OnClickListener {
    
    private static final String tag_qr = "start_qr";
    private static final String tag_search = "start_search";
    
    //二维码按钮
    private ImageView ivQrCode;
    
    private EditText etInput;
    
    private ImageView ivSearch;
    
    private static final String inputHint = "请输入病人床位号/姓名/住院号";
    
    private LinearLayout layout;

    public SearchView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        int h = DensityUtil.dip2px(getContext(), 8);
        int v = DensityUtil.dip2px(getContext(), 5);
        setPadding(h, v, h, v);
        layout = new LinearLayout(getContext());
        addView(layout, -1, -2);
        layout.setGravity(Gravity.CENTER_VERTICAL);
        layout.setBackgroundResource(R.drawable.search_bg);
        
        etInput = new EditText(getContext());
        etInput.setId(1);
        
        etInput.setBackground(null);
        etInput.setHint(inputHint);
        etInput.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.textsize_small));
       
        ivSearch = new ImageView(getContext());
        ivSearch.setImageResource(R.drawable.search);
        ivSearch.setOnClickListener(this);
        ivSearch.setTag(tag_search);
        layout.addView(ivSearch);
        
        LinearLayout.LayoutParams lpEt = new LinearLayout.LayoutParams(-1, -2);
        lpEt.weight = 1;
        layout.addView(etInput, lpEt);
        
        ivQrCode = new ImageView(getContext());
        ivQrCode.setImageResource(R.drawable.qr_code);
        ivQrCode.setOnClickListener(this);
        ivQrCode.setTag(tag_qr);
        layout.addView(ivQrCode);
        
    }

    public SearchView(Context context) {
        super(context);
        init();
    }

    @Override
    public void onClick(View v) {
        Object tag = v.getTag();
        if (tag_qr.equals(tag)) {
            ILog.d("启动二维码");
            if (searchListener != null) {
                searchListener.onScan();
            }
        } else if (tag_search.equals(tag)) {
            String keyWord = etInput.getText().toString();
            if (inputHint.equals(keyWord) || TextUtils.isEmpty(keyWord)) {
                Toast.makeText(getContext(), inputHint, Toast.LENGTH_SHORT).show();
                return ;
            }
            ILog.d("开始搜索:" + keyWord);
            if (searchListener != null) {
                searchListener.onSearch(keyWord);
            }
        }
    }
    
    private ISearchListener searchListener;
    
    public void setSearchListener(ISearchListener listener) {
        searchListener = listener;
    }
    
    public interface ISearchListener {
        void onSearch(String keyWord);
        void onScan();
    }
    
}
