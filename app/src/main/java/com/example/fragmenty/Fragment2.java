package com.example.fragmenty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmenty.databinding.Fragment2Binding;


public class Fragment2 extends Fragment {

    private Fragment2Binding fragment2Binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragment2Binding = Fragment2Binding.inflate(getLayoutInflater());
        View view = fragment2Binding.getRoot();
        getParentFragmentManager()
                .setFragmentResultListener("datafromactivity", this, (s, b) -> {
                    Log.d("xxx",b.getString("info"));
                    fragment2Binding.testview.setText(b.getString("info"));
                });
        fragment2Binding.dataSet.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("data", "data from fragment 2 to fragment 1");
            getParentFragmentManager().setFragmentResult("datafromfragment2", bundle);
        });
        return view;

    }
}