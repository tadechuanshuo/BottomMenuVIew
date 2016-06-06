package com.tqp.bottomtabmenuview.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tqp.bottomtabmenuview.MyApplication;
import com.tqp.bottomtabmenuview.R;

public class FragmentB extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenttest, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        LinearLayout ll = (LinearLayout) getView().findViewById(R.id.frbg);
//        ll.setBackgroundColor(Color.RED);
    }

    private void initView(View view){
        LinearLayout ll = (LinearLayout) view.findViewById(R.id.frbg);
        ll.setBackgroundColor(Color.RED);
        TextView textView = (TextView) view.findViewById(R.id.text);
        if (MyApplication.tag == 1){
            textView.setText("滑动有效果");
        }
    }
}
