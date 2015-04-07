package com.his.nurse.adapter;

import com.his.nurse.R;
import com.his.nurse.util.ILog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DoctorAdviceInfoAdapter extends BaseAdapter{
	private Context mContext;
	private LayoutInflater inflater;
	private int size;
	public DoctorAdviceInfoAdapter(Context context){
		this.mContext = context;
		this.inflater = LayoutInflater.from(context);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final int selectId = position;
		ViewHolder viewHolder = null;
//		if(convertView == null){
			convertView = inflater.inflate(R.layout.activity_doctor_advice_info_item, null);
			viewHolder = new ViewHolder();
			viewHolder.tv_yongfa = (TextView)convertView.findViewById(R.id.tv_yongfa);
			viewHolder.ll_yongfa = (LinearLayout)convertView.findViewById(R.id.ll_yongfa);
			viewHolder.tv_advice_name = (TextView)convertView.findViewById(R.id.tv_advice_name);
			viewHolder.tv_advice_guige = (TextView)convertView.findViewById(R.id.tv_advice_guige);
			viewHolder.tv_advice_yongliang = (TextView)convertView.findViewById(R.id.tv_advice_yongliang);
			viewHolder.tv_advice_give_way = (TextView)convertView.findViewById(R.id.tv_advice_give_way);
			viewHolder.iv_doctor_advice_confirm = (ImageView)convertView.findViewById(R.id.iv_doctor_advice_confirm);
//			convertView.setTag(viewHolder);
			/*}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}*/
		viewHolder.ll_yongfa.setGravity(Gravity.CENTER);
		viewHolder.tv_yongfa.measure(0, 0);
        int h = (int) (Math.max(viewHolder.tv_yongfa.getMeasuredWidth(), viewHolder.tv_yongfa.getMeasuredWidth()) + 10*mContext.getResources().getDisplayMetrics().density);
        viewHolder.ll_yongfa.getLayoutParams().width = h;
        viewHolder.ll_yongfa.getLayoutParams().height = h;
        ILog.d(h);
        
        Bitmap bg = createRoundBitmap(h, android.graphics.Color.parseColor("#00b4ff"));
        viewHolder.ll_yongfa.setBackgroundDrawable(new BitmapDrawable(bg));
        
        if(position == 1){
        	viewHolder.tv_advice_name.setText("醒脑静注射液");
        	viewHolder.tv_advice_guige.setText("10ml*1支");
        	viewHolder.tv_advice_yongliang.setText("20ml");
        	viewHolder.tv_advice_give_way.setText("口服");
        	viewHolder.iv_doctor_advice_confirm.setVisibility(View.INVISIBLE);
        }else{
        	viewHolder.iv_doctor_advice_confirm.setVisibility(View.VISIBLE);
        }
		return convertView;
	}
	
	static class ViewHolder{
		private TextView tv_advice_name;
		private TextView tv_advice_guige;
		private TextView tv_advice_yongliang;
		private TextView tv_advice_give_way;
		private TextView tv_yongfa;
		private LinearLayout ll_yongfa;
		private ImageView iv_doctor_advice_confirm;
	}
	
	private Bitmap createRoundBitmap(int d, int color) {
        Bitmap bg = Bitmap.createBitmap(d, d, Config.ARGB_8888);
        Canvas c = new Canvas(bg);
        Paint p = new Paint();
        p.setColor(color);
        c.drawRoundRect(new RectF(new Rect(0, 0, d, d)), d/2, d/2, p);
        return bg;
    }

}
