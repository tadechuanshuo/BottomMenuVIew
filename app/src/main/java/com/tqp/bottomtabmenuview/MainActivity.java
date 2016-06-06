package com.tqp.bottomtabmenuview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

import com.tqp.bottomtabmenuview.customView.TabMenuView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup(); // Call setup() before adding tabs if loading TabHost
        // using findViewById().

//        final WJTabMenuView mv = (WJTabMenuView) LayoutInflater.from(this).inflate(R.layout.test, null);
//        mv.setText("Tag A");
//        final WJTabMenuView mv2 = (WJTabMenuView) LayoutInflater.from(this).inflate(R.layout.test, null);
//        mv2.setText("Tag B");
//        final WJTabMenuView mv3 = (WJTabMenuView) LayoutInflater.from(this).inflate(R.layout.test, null);
//        mv3.setText("Tag C");
//        final WJTabMenuView mv4 = (WJTabMenuView) LayoutInflater.from(this).inflate(R.layout.test, null);
//        mv4.setText("Tag D");

        final TabMenuView mv = (TabMenuView) LayoutInflater.from(this).inflate(R.layout.menu_view_layout, null);
        mv.setImageAndText(R.mipmap.bom_fragment_main_normal, "首页", R.mipmap.bom_fragment_main_select, "首页");
        final TabMenuView mv2 = (TabMenuView) LayoutInflater.from(this).inflate(R.layout.menu_view_layout, null);
        mv2.setImageAndText(R.mipmap.bom_fragment_appointment_normal, "预约", R.mipmap.bom_fragment_appointment_select, "预约");
        final TabMenuView mv3 = (TabMenuView) LayoutInflater.from(this).inflate(R.layout.menu_view_layout, null);
        mv3.setImageAndText(R.mipmap.bom_fragment_zixun_normal, "咨询", R.mipmap.bom_fragment_zixun_select, "咨询");
        final TabMenuView mv4 = (TabMenuView) LayoutInflater.from(this).inflate(R.layout.menu_view_layout, null);
        mv4.setImageAndText(R.mipmap.bom_fragment_persion_normal, "我的", R.mipmap.bom_fragment_persion_select, "我的");

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                mv.unSelected();
                mv2.unSelected();
                mv3.unSelected();
                mv4.unSelected();
                if (tabId.equals("taba")) {
                    mv.selected();
                } else if (tabId.equals("tabb")) {
                    mv2.selected();
                } else if (tabId.equals("tabc")) {
                    mv3.selected();
                } else if (tabId.equals("tabd")) {
                    mv4.selected();
                }
            }
        });

        tabHost.addTab(tabHost.newTabSpec("taba").setIndicator(mv)
                .setContent(R.id.tab1));
        tabHost.addTab(tabHost.newTabSpec("tabb").setIndicator(mv2)
                .setContent(R.id.tab2));
        tabHost.addTab(tabHost.newTabSpec("tabc").setIndicator(mv3)
                .setContent(R.id.tab3));
        tabHost.addTab(tabHost.newTabSpec("tabd").setIndicator(mv4)
                .setContent(R.id.tab4));

    }

}
