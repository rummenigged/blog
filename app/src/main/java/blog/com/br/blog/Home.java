package blog.com.br.blog;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import blog.com.br.blog.Adapter.ArticleAdapter;
import blog.com.br.blog.Model.Article;

/**
 * Created by LGPC on 25/04/2016.
 */
public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar mToolbar;

    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mSelectedId;
    private boolean mUserSawDrawer = false;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    //int displayMode;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        //displayMode = getResources().getConfiguration().orientation;

        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        mToolbar.setTitle("Home");
        mToolbar.setTitleTextColor(Color.DKGRAY);


        mDrawer = (NavigationView) findViewById(R.id.main_drawer);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.drawer_open,R.string.drawer_closed);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(getAdapter(getListItems()));

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        mSelectedId = menuItem.getItemId();

        //navigate(mSelectedId);
        return true;
    }

    private ArticleAdapter getAdapter(List<Article> articles){

        ArticleAdapter adapter = new ArticleAdapter(articles);

        return adapter;
    }

    public List<Article> getListItems(){

        String testTitle = "Title ";
        String testBody = "With an ItemDecoration you can add an offset to each item " +
                "and modify the item so that items are separated from each other, highlighted or"+
                ", well, decorated.";
        List<Article> articles = new ArrayList<>();
        for (int i = 0 ; i < 5 ; i++){
            Article article = new Article(i,testTitle + String.valueOf(i),testBody);
            articles.add(article);
        }

        return articles;
    }
}

