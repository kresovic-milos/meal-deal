package com.povio.mealdeal.ui.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.povio.mealdeal.R;
import com.povio.mealdeal.databinding.ActivityMainBinding;
import com.povio.mealdeal.ui.adapters.AdapterTabsMain;
import com.povio.mealdeal.utils.Constants;
import com.povio.mealdeal.utils.FontCache;
import com.povio.mealdeal.viewmodel.BaseViewModel;
import com.povio.mealdeal.viewmodel.ViewModelMain;

public class ActivityMain extends ToolbarActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ViewModelMain viewModelMain;

    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModelMain);
        super.onCreate(savedInstanceState, R.string.app_name);

        handleIntent(getIntent());

//        ((AppMealDeal) getApplication()).getComponent().inject(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);


        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        TextView headerTextMeal = (TextView) headerView.findViewById(R.id.textview_drawer_header_meal);
        headerTextMeal.setTypeface(FontCache.getTypeface(Constants.Font.THICK_1, this));
        TextView headerTextDeal = (TextView) headerView.findViewById(R.id.textview_drawer_header_deal);
        headerTextDeal.setTypeface(FontCache.getTypeface(Constants.Font.SKINNY_1, this));

        setupViewPager(binding.viewpager);

        binding.tabs.setupWithViewPager(binding.viewpager);
        binding.tabs.getTabAt(AdapterTabsMain.TAB_FEED).setIcon(R.drawable.ic_view_list_white_24dp);
        binding.tabs.getTabAt(AdapterTabsMain.TAB_MAP).setIcon(R.drawable.ic_map_white_24dp);
    }

    @Nullable
    @Override
    protected BaseViewModel createViewModel(@Nullable BaseViewModel.State savedViewModelState) {
        viewModelMain = new ViewModelMain(savedViewModelState, this);
        return viewModelMain;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            onSearch(query);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        AdapterTabsMain adapter = new AdapterTabsMain(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void onSearch(String query) {
        viewModelMain.onSearch(query);
//        Snackbar.make(getWindow().getDecorView().getRootView(), "Search query = " + query, Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_toggle) {
            viewModelMain.toggleFav();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.drawer_deals) {

        } else if (id == R.id.drawer_settings) {
            startActivity(ActivitySettings.class);

        } else if (id == R.id.drawer_about) {
            startActivity(ActivityAbout.class);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}