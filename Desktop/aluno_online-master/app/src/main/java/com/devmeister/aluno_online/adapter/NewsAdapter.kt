package com.devmeister.aluno_online.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.devmeister.aluno_online.R
import com.devmeister.aluno_online.model.News

class NewsAdapter(val context: Context, val news: List<News>) : BaseAdapter() {

    // cell
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val newsView: View
        val holder: ViewHolder

        if (convertView == null) {
            newsView = LayoutInflater.from(context).inflate(R.layout.news_list, null)
            holder = ViewHolder()
            var count = 1
            //holder.newsImage = newsView.findViewById(R.id.new_image)
            holder.newsName = newsView.findViewById(count++)
            //holder.newsDate = newsView.findViewById(R.id.new_date)
            println("I exist for the first time!")
            newsView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            newsView = convertView
            println("Go green, recycle!")
        }

        val news = news[position]
        val resourceId = context.resources.getIdentifier(news.image, "drawable", context.packageName)
        holder.newsImage?.setImageResource(resourceId)
        holder.newsName?.text = news.title
        holder.newsDate?.text = news.datePosted
        return newsView
    }

    override fun getItem(position: Int): Any {
        return news[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    // number inSection
    override fun getCount(): Int {
        return news.count()
    }

    private class ViewHolder {
        var newsImage: ImageView? = null
        var newsName: TextView? = null
        var newsDate: TextView? = null
    }
}