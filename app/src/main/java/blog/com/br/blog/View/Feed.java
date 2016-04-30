package blog.com.br.blog.View;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import blog.com.br.blog.Adapter.ArticleAdapter;
import blog.com.br.blog.Model.Article;
import blog.com.br.blog.R;

/**
 * Created by LGPC on 25/04/2016.
 */
public class Feed extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar mToolbar;

    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mSelectedId;
    private boolean mUserSawDrawer = false;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    //int displayMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);

        //displayMode = getResources().getConfiguration().orientation;

        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        mToolbar.setTitle("Feed");
        //mToolbar.setTitleTextColor(Color.WHITE);


        mDrawer = (NavigationView) findViewById(R.id.main_drawer);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_closed);
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

    private ArticleAdapter getAdapter(List<Article> articles) {

        ArticleAdapter adapter = new ArticleAdapter(articles);

        return adapter;
    }

    public List<Article> getListItems() {

        String testTitle = "Title ";
        String testBody = "orem ipsum dolor sit amet, consectetur adipiscing elit. In venenatis mi eu enim aliquam," +
                "ac faucibus orci posuere. Nullam facilisis commodo hendrerit. Nullam luctus nisl at enim iaculis" +
                ", Aenean dictum metus sit amet porta lacinia.";
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Article article = new Article(i, testTitle + String.valueOf(i), testBody);
            articles.add(article);
        }

        return articles;
    }
}

