package com.kuahusg.v2exwithmvp.View.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kuahusg.v2exwithmvp.Interface.AutoHideFabListener;
import com.kuahusg.v2exwithmvp.Interface.RequestDataCallback;
import com.kuahusg.v2exwithmvp.Presenter.BasePresenter;
import com.kuahusg.v2exwithmvp.R;
import com.kuahusg.v2exwithmvp.View.Fragment.NewsFragment;

public class MainActivity extends BaseActivity<BasePresenter> implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    private NewsFragment newsFragment;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FloatingActionButton fab;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initEvent();


    }

    @Override
    protected void onResume() {
        super.onResume();
//        swipeRefreshLayout.setRefreshing(true);
        newsFragment.requestDataCallback(new RequestDataCallback() {
            @Override
            public void init() {
//                Toast.makeText(MainActivity.this, "start refreshing", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(true);
            }

            @Override
            public void err(String m) {
                Snackbar.make(fab, m, Snackbar.LENGTH_LONG).show();
                swipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void finish() {
//                Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        newsFragment.setAutoHideFabListener(new AutoHideFabListener() {
            @Override
            public void hide() {
                fab.hide();
            }

            @Override
            public void show() {
                fab.show();
            }
        });


    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter setPresenter() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                Toast.makeText(MainActivity.this, "you click fab, but it is not use", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        newsFragment.getPresenter().requestNews();
    }

    public void initView() {
        newsFragment = new NewsFragment();
        toolbar = setToolbar(getString(R.string.app_name), R.mipmap.ic_launcher);
        drawerLayout = (DrawerLayout) findViewById(R.id.container_drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.layout_swipe_refresh);
        drawerLayout = (DrawerLayout) findViewById(R.id.container_drawer_layout);
    }

    public void initEvent() {
        setFragment(newsFragment);
        fab.setOnClickListener(this);
        swipeRefreshLayout.setOnRefreshListener(this);
        setupNavigationView(navigationView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);




    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_main_content, fragment)
                .commit();
    }

    public void setupNavigationView(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    // TODO: 16-7-25  
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }
}
