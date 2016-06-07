package com.tqp.bottomtabmenuview;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.tqp.bottomtabmenuview.bottomRadiobutton.CustomRadioGroup;
import com.tqp.bottomtabmenuview.bottomRadiobutton.MainBodyPageChangeListener;
import com.tqp.bottomtabmenuview.fragment.FragmentA;
import com.tqp.bottomtabmenuview.fragment.FragmentB;
import com.tqp.bottomtabmenuview.fragment.FragmentC;
import com.tqp.bottomtabmenuview.fragment.FragmentD;

public class MainActivity1 extends AppCompatActivity {
	private CustomRadioGroup footer;
	private ViewPager body;
	private int[] itemImage={R.mipmap.bom_fragment_main_normal,R.mipmap.bom_fragment_appointment_normal,R.mipmap.bom_fragment_zixun_normal,R.mipmap.bom_fragment_persion_normal};
	private int[] itemCheckedImage={R.mipmap.bom_fragment_main_select,R.mipmap.bom_fragment_appointment_select,R.mipmap.bom_fragment_zixun_select,R.mipmap.bom_fragment_persion_select};
	private String[] itemText={"首页","订单","资讯","我的"};
	private List<Fragment> fragmentList = new ArrayList<Fragment>();
	private int paramsOfView = 0;
	public static String fromTag;
	private long mExitTime;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_main1);
		initView();
		onEventClick();
	}

	private void initView(){
		footer = (CustomRadioGroup)findViewById(R.id.main_footer);
		body = (ViewPager) findViewById(R.id.main_body);
		MyApplication.tag = 1;
	}

	public void onEventClick() {
		for (int i = 0; i < itemImage.length; i++) {
			footer.addItem(itemImage[i],itemCheckedImage[i],itemText[i]);
		}
		FragmentA fragment0 = new FragmentA();
		FragmentB fragment1 = new FragmentB();
		FragmentC fragment2 = new FragmentC();
		FragmentD fragment3 = new FragmentD();
		fragmentList.add(fragment0);
		fragmentList.add(fragment1);
		fragmentList.add(fragment2);
		fragmentList.add(fragment3);
		body.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
		final MainBodyPageChangeListener bodyChangeListener=new MainBodyPageChangeListener(footer);
		body.setOnPageChangeListener(bodyChangeListener);
		body.setCurrentItem(paramsOfView);
		footer.setCheckedIndex(paramsOfView);
		footer.setOnItemChangedListener(new CustomRadioGroup.OnItemChangedListener() {
			public void onItemChanged() {
				body.setCurrentItem(footer.getCheckedIndex(),false);
				paramsOfView = footer.getCheckedIndex();
			}
		});
		/**
		 * BUG :显示不出数字。数字尺寸太大
		 */
//		footer.setItemNewsCount(1, 10);//设置消息数量
	}

	class MyViewPagerAdapter extends FragmentPagerAdapter{

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		MyApplication.tag = 0;
		finish();
	}

}
