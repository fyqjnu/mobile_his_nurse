package com.his.nurse.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import com.his.nurse.R;
import com.his.nurse.util.DensityUtil;

public class BottleView extends View {

    private static final int width = 80;
    
    private static final int height = 120;

    private Bitmap bitmap;
    
    private int progress;
    
    private int bgColor = Color.GRAY;
    
    private int progressColor = color_normal;
    
    //正常颜色
    private static final int color_normal = Color.GREEN;
    //预警
    private static final int color_warn = Color.YELLOW;
    //告警
    private static final int color_danger = Color.RED;
    
    public BottleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        init();
    }

    public BottleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        init();
    }

    public BottleView(Context context) {
        super(context);
        init();
    }
    
    private void init() {
        BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.bottle);
        bitmap = drawable.getBitmap();
        bitmap.setDensity(120);
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       /* 
        int mw = 0;
        int mh = 0;
        
        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        mw = MeasureSpec.getSize(widthMeasureSpec);
        if (wMode == MeasureSpec.UNSPECIFIED) {
            ILog.d("用固定宽度");
        }
        mw = calcWidth();
        int hMode = MeasureSpec.getMode(heightMeasureSpec);
        mh = MeasureSpec.getSize(heightMeasureSpec);
        if (hMode == MeasureSpec.UNSPECIFIED) {
        }
        mh = calcHeight();
        
        ILog.d("w:" + mw + ", h:" + mh);
        */
        setMeasuredDimension(bitmap.getWidth(), bitmap.getHeight());
    }

    private int calcHeight() {
        return (int) (calcWidth()*1.4f);
    }

    private int calcWidth() {
        return DensityUtil.dip2px(getContext(), width);
    }
    
    
    
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // TODO Auto-generated method stub
        super.onLayout(changed, l, t, r, b);
    }
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
    
    /**
     * @param progress 剩下进度
     */
    public void setRemainProgress(int progress) {
        this.progress = progress;
        if (progress <= 5) {
            progressColor = color_danger;
        } else if (progress <= 20) {
            progressColor = color_warn;
        } else {
            progressColor = color_normal;
        }
        invalidate();
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(bgColor);
        Paint paint = new Paint();
        
        paint.setColor(progressColor);
        canvas.drawRect(new RectF(0, bitmap.getHeight()*(1-progress*1f/100), bitmap.getWidth(), bitmap.getHeight()), paint);
        
        canvas.drawBitmap(bitmap, 0, 0, paint);
        
        /*int w = (int) (calcWidth()*0.2);
        int h = w;
        paint.setColor(Color.YELLOW);
        canvas.drawArc(new RectF(new Rect(0, 0, w, h)), 180, 90, true, paint);
        canvas.drawArc(new RectF(new Rect(0, calcWidth()-w, w, calcWidth())), 90, 90, true, paint);
        canvas.drawArc(new RectF(new Rect(calcWidth()-w, 0, calcWidth(), h)), 270, 90, true, paint);
        canvas.drawArc(new RectF(new Rect(calcWidth()-w, calcWidth()-w, calcWidth(), calcWidth())), 0, 90, true, paint);
        canvas.drawRect(new Rect(0, w/2, calcWidth(), calcWidth()-w/2), paint);
        canvas.drawRect(new Rect(w/2, 0, calcWidth()-w/2, calcWidth()), paint);
        canvas.drawRect(new RectF(calcWidth()*0.35f, calcWidth(), calcWidth()*0.75f, calcWidth()*1.2f), paint);
        
        canvas.drawArc(new RectF(calcWidth()*0.35f, calcWidth()*1.2f-w/2, calcWidth()*0.35f+w, calcWidth()*1.2f+w/2), 90, 90, true, paint);
        canvas.drawArc(new RectF(calcWidth()*0.75f-w, calcWidth()*1.2f-w/2, calcWidth()*0.75f, calcWidth()*1.2f+w/2), 0, 90, true, paint);
        canvas.drawRect(new RectF(calcWidth()*0.35f+w/2, calcWidth()*1.2f-w/2, calcWidth()*0.75f-w/2, calcWidth()*1.2f+w/2), paint);*/
        
    }

}
