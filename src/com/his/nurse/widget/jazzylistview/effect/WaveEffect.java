package com.his.nurse.widget.jazzylistview.effect;

import android.view.View;

import com.his.nurse.widget.jazzylistview.JazzyEffect;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class WaveEffect implements JazzyEffect {

	@Override
	public void initView(View item, int position, int scrollDirection) {
		ViewHelper.setTranslationX(item, -item.getWidth());
	}

	@Override
	public void setupAnimation(View item, int position, int scrollDirection,
			ViewPropertyAnimator animator) {
		animator.translationX(0);
	}

}
