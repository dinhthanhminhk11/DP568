package com.example.dp568dapp.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.dp568dapp.R;
import com.example.dp568dapp.ui.fragment.BookmarkFragment;
import com.example.dp568dapp.ui.fragment.HomeFragment;
import com.example.dp568dapp.ui.fragment.LiveFragment;
import com.example.dp568dapp.ui.fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private FrameLayout content;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.color_background));

        content = (FrameLayout) findViewById(R.id.content);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);

        loadFragment(new HomeFragment());
        navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        loadFragment(new HomeFragment());
                        return true;
                    case R.id.live:
                        loadFragment(new LiveFragment());
                        return true;
                    case R.id.bookmark:
                        loadFragment(new BookmarkFragment());
                        return true;
                    case R.id.setting:
                        loadFragment(new SettingFragment());
                        return true;
                }
                return false;
            }
        });

    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction4.replace(R.id.content, fragment, "");
        fragmentTransaction4.commit();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }
}