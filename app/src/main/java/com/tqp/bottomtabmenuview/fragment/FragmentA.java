package com.tqp.bottomtabmenuview.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tqp.bottomtabmenuview.MainActivity1;
import com.tqp.bottomtabmenuview.MyApplication;
import com.tqp.bottomtabmenuview.R;

public class FragmentA extends Fragment {

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
//        ll.setBackgroundColor(Color.BLUE);
    }

    private void initView(View view){
        LinearLayout ll = (LinearLayout) view.findViewById(R.id.frbg);
        ll.setBackgroundColor(Color.BLUE);
        TextView textView = (TextView) view.findViewById(R.id.text);
        if (MyApplication.tag == 1){
            textView.setText("滑动有效果");
        }
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity1.class);
                startActivity(intent);
            }
        });
    }

}
