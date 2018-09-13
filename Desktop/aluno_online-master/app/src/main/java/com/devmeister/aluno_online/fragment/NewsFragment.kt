package com.devmeister.aluno_online.fragment


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout

import com.devmeister.aluno_online.R
import com.devmeister.aluno_online.adapter.NewsAdapter
import com.devmeister.aluno_online.adapter.PageView
import com.devmeister.aluno_online.service.DataService
import kotlinx.android.synthetic.main.fragment_news.*
import java.util.*

class NewsFragment : Fragment() {

    lateinit var dotsLayout: LinearLayout
    lateinit var mPager: ViewPager
    var path: IntArray = intArrayOf(R.drawable.a1, R.drawable.a2, R.drawable.a3)
    lateinit var dots: Array<ImageView>
    lateinit var adapter: PageView
    var currentPage: Int = 0
    lateinit var timer: Timer
    val DELAY_MS: Long = 0
    val PERIOD_MS: Long = 3000
    lateinit var adapter2: NewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPager = view.findViewById(R.id.pager) as ViewPager
        adapter = PageView(context!!, path)
        mPager.adapter = adapter
        dotsLayout = view.findViewById(R.id.dotsLayout) as LinearLayout
        createDots(0)
        updatePage()
        mPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                currentPage = 0
                createDots(position)
            }

        })

        adapter2 = NewsAdapter(context!!, DataService.news)
        newsListView.adapter = adapter2
    }

    fun updatePage() {
        @Synchronized fun exec() {
            activity?.runOnUiThread {
                val it = if (mPager.currentItem == path.size -1) 0 else mPager.currentItem + 1
                mPager.setCurrentItem(it, true)
            }
        }

        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run () {
                exec()
            }
        }, DELAY_MS,PERIOD_MS)
    }

    fun createDots(position: Int) {

        if (dotsLayout != null) {
            dotsLayout.removeAllViews()
        }

        dots = Array(path.size, { i -> ImageView(context) })

        for (i in 0..path.size - 1) {
            dots[i] = ImageView(context!!)
            if (i == position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.activity_dots))
            } else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.inactive_dots))
            }

            var params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

            params.setMargins(4, 0, 4, 0)
            dotsLayout.addView(dots[i], params)
        }
    }

}
