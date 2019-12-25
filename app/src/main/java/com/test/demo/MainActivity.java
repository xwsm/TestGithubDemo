package com.test.demo;

import android.content.Intent;
import android.os.Bundle;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    CommonTabLayout tab_layout;

    SlidingTabLayout tab2_layout;
    ViewPager viewPager;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        startActivity(new Intent(this, haha.class));
        tab_layout = findViewById(R.id.tab_layout);
        tab2_layout = findViewById(R.id.tab2_layout);
        viewPager = findViewById(R.id.vp);
        mTabEntities.add(new CustomTabEntity() {
            @Override
            public String getTabTitle() {
                return "我发起的";
            }

            @Override
            public int getTabSelectedIcon() {
                return 0;
            }

            @Override
            public int getTabUnselectedIcon() {
                return 0;
            }
        });




        mTabEntities.add(new CustomTabEntity() {
            @Override
            public String getTabTitle() {
                return "我接收的";
            }

            @Override
            public int getTabSelectedIcon() {
                return 0;
            }

            @Override
            public int getTabUnselectedIcon() {
                return 0;
            }
        });
        tab_layout.setTabData(mTabEntities);
        initData();
    }
    String[] titles = {"不不不", "看看看"};
    List<Fragment> fragmentList=new ArrayList<>();

    void initData() {
        fragmentList.add(new testFragment());
        fragmentList.add(new testFragment());

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tab2_layout.setViewPager(viewPager, titles);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }
        startActivity(new Intent(this, haha.class));
    }
}
