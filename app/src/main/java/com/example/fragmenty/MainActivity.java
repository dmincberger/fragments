package com.example.fragmenty;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.fragmenty.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bundle = new Bundle();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        activityMainBinding.bt1.setOnClickListener(v -> {
            bundle.putString("info", "dane do wysłania frag1");
            getSupportFragmentManager().setFragmentResult("datafromactivity", bundle);
            replaceFragment(fragment1);
        });
        activityMainBinding.bt2.setOnClickListener(v -> {
            bundle.putString("info", "dane do wysłania frag2");
            getSupportFragmentManager().setFragmentResult("datafromactivity", bundle);
            replaceFragment(fragment2);
        });


    }
    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}