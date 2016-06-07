package com.tqp.bottomtabmenuview.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tqp.bottomtabmenuview.R;

/**
 * Created by TQP on 2016/6/6.
 */
public class TabMenuView extends LinearLayout {

    private LinearLayout llnormal, llselect;
    private ImageView img_normal, img_select;
    private TextView txt_normal, txt_select;
    private boolean interruptFlag;
    private Context mContext;
    private Animation mAnim_normal;
    private Animation mAnim_select;

    public TabMenuView(Context context) {
        super(context);
        mContext = context;
        initView(mContext);
    }

    public TabMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView(mContext);
    }

    private void initView(Context mContext){
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.tab_menu_layout, this);
        llnormal = (LinearLayout) findViewById(R.id.tab_bottom_normal);
        img_normal = (ImageView) findViewById(R.id.img_normal);
        txt_normal = (TextView) findViewById(R.id.txt_normal);
        llselect = (LinearLayout) findViewById(R.id.tab_bottom_selector);
        img_select = (ImageView) findViewById(R.id.img_select);
        txt_select = (TextView) findViewById(R.id.txt_select);
        mAnim_normal = AnimationUtils.loadAnimation(mContext,R.anim.bottommenu_out_anim);
        mAnim_normal.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!interruptFlag) {
                    llnormal.setVisibility(View.GONE);
                }
            }
        });

        mAnim_select = AnimationUtils.loadAnimation(mContext,R.anim.bottommenu_in_anim);
    }

    /**
     * 放入相应的资源，这里的ntitle和stitle放两个是因为有的APP可能会有不同的文字，如果不需要可以只取一个
     * @param nd
     * @param ntitle
     * @param sd
     * @param stitle
     */
    public void setImageAndText(int nd, String ntitle, int sd, String stitle) {
        img_normal.setImageResource(nd);
        txt_normal.setText(ntitle);
        img_select.setImageResource(sd);
        txt_select.setText(stitle);
    }

    public void unSelected() {
        llnormal.clearAnimation();
        llselect.clearAnimation();
        clearAnimation();
        llnormal.setVisibility(View.VISIBLE);
        interruptFlag = true;
    }

    public void selected() {
        interruptFlag = false;
        llnormal.startAnimation(mAnim_normal);
        llselect.startAnimation(mAnim_select);
    }
}
