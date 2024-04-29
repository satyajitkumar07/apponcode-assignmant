package com.example.aapoondigitaltest.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aapoondigitaltest.Model.ArticleModelItem
import com.example.aapoondigitaltest.R

class ArticleAdapter: RecyclerView.Adapter<ArticleAdapter.ArticleItem>() {
    var list:ArrayList<ArticleModelItem>?=null;

    class ArticleItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title=itemView.findViewById<TextView>(R.id.title)
        var post=itemView.findViewById<TextView>(R.id.post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleItem {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return ArticleItem(view)
    }

    override fun getItemCount(): Int {
        return if(list==null)0 else list!!.size
    }

    override fun onBindViewHolder(holder: ArticleItem, position: Int) {
        var item:ArticleModelItem= list!![position]
        holder.title.setText(item.title)
        holder.post.setText(item.description)
    }
}