package com.example.fragmenty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmenty.databinding.Fragment1Binding;


public class Fragment1 extends Fragment {

    private Fragment1Binding fragment1Binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragment1Binding = Fragment1Binding.inflate(getLayoutInflater());
        View view = fragment1Binding.getRoot();
        getParentFragmentManager()
                .setFragmentResultListener("datafromactivity", this, (s, b) -> {
                    Log.d("xxx",b.getString("info"));
                    fragment1Binding.testview.setText(b.getString("info"));
                });
        getParentFragmentManager()
                .setFragmentResultListener("datafromfragment2", this, (s, b) -> {
                    Log.d("xxx",b.getString("data"));
                    fragment1Binding.fragtest.setText(b.getString("data"));
                });
        return view;

    }



}