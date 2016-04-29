package blog.com.br.blog.Adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import blog.com.br.blog.Model.Article;
import blog.com.br.blog.R;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<Article> articles;

    public ArticleAdapter(List<Article> articles) {

        this.articles = articles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setTextColor(Color.BLACK);
        holder.body.setTextColor(Color.BLACK);

        holder.title.setText(articles.get(position).getTitle());
        holder.body.setText(articles.get(position).getBody());
        Log.e("MARK", "Passei aki");
    }


    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView body;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.titleArticle);
            body = (TextView) itemView.findViewById(R.id.contentArticle);
        }


    }

}