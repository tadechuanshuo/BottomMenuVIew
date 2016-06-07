package com.tqp.bottomtabmenuview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;

import com.tqp.bottomtabmenuview.bottomnavigation.BottomBarTab;
import com.tqp.bottomtabmenuview.bottomnavigation.BottomNavigationBar;
import com.tqp.bottomtabmenuview.fragment.FragmentA;
import com.tqp.bottomtabmenuview.fragment.FragmentB;
import com.tqp.bottomtabmenuview.fragment.FragmentC;
import com.tqp.bottomtabmenuview.fragment.FragmentD;

/**
 * Created by TQP on 2016/6/7.
 */
public class TestActivity extends FragmentActivity {

    private FrameLayout container;
    private BottomNavigationBar bottomLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1);
        MyApplication.tag = 2;
        container = (FrameLayout) findViewById(R.id.container);
        bottomLayout = (BottomNavigationBar)findViewById(R.id.bottomLayout);
        setUpBottomNavigationBar();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FragmentA()).commitAllowingStateLoss();
    }

    public void setUpBottomNavigationBar() {
        bottomLayout.setTabWidthSelectedScale(1.5f);
        bottomLayout.setTextDefaultVisible(false);
//        bottomLayout.setTextColorResId(R.color.color_tab_text);
        bottomLayout.addTab(R.drawable.selector_movie, "Movies & Tv", 0xff4a5965);
        bottomLayout.addTab(R.drawable.selector_music, "Music", 0xff096c54);
        bottomLayout.addTab(R.drawable.selector_books, "Books", 0xff8a6a64);
        bottomLayout.addTab(R.drawable.selector_news, "Newsstand", 0xff553b36);
        bottomLayout.setOnTabListener(new BottomNavigationBar.TabListener() {
            @Override
            public void onSelected(BottomBarTab tab, int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new FragmentA();
                        break;
                    case 1:
                        fragment = new FragmentB();
                        break;
                    case 2:
                        fragment = new FragmentC();
                        break;
                    case 3:
                        fragment = new FragmentD();
                        break;
                    default:
                        fragment = new FragmentA();
                        break;
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment)
//                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .commitAllowingStateLoss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MyApplication.tag = 1;
        finish();
    }
}
