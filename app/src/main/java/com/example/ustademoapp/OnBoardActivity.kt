package com.example.ustademoapp

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.ustademoapp.databinding.ActivityOnBoardBinding
import com.example.ustademoapp.utils.OnBoardingAdapter
import com.example.ustademoapp.utils.OnBoardingItem

class OnBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardBinding
    private lateinit var adapter: OnBoardingAdapter
    private lateinit var indicatorContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        setOnBoardingItems()
        setupIndicators()
        setCurrentIndicator(0)


    }

    private fun setOnBoardingItems() {
        adapter = OnBoardingAdapter(
            // Задаем текст и иконку для onBoard
            listOf(
                OnBoardingItem(
                    R.drawable.ic_on_board_1,
                    title = getString(R.string.find_specialist),
                    description = ""
                ),
                OnBoardingItem(
                    R.drawable.ic_on_board_2,
                    title = getString(R.string.find_specialist),
                    description = getString(R.string.if_u_customer)
                ),
                OnBoardingItem(
                    R.drawable.ic_on_board_3,
                    title = getString(R.string.find_client),
                    description = getString(R.string.if_u_specialist)
                ),
            )
        )

        val onBoardingViewPager = findViewById<ViewPager2>(R.id.viewPager_on_board)
        onBoardingViewPager.adapter = adapter

        onBoardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                setCurrentIndicator(position)

            }
        })
        (onBoardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER


        with(binding) {
            btnNextOnBoard.setOnClickListener {

                // По нажатию на кнопку, перелистывает onBoard на следующую

                if (onBoardingViewPager.currentItem + 1 < adapter.itemCount) {

                    onBoardingViewPager.currentItem += 1


                    // Получаем позицию viewPager2
                    // Если полученная позиция равна 2( третья страница onBoard )
                    // По нажатию на кнопку переходим в mainActivity
                    if (onBoardingViewPager.currentItem == 2) {
                        btnNextOnBoard.setOnClickListener {
                            startActivity(Intent(applicationContext, MainActivity::class.java))
                        }
                    }
                }

            }

            btnBackOnBoard.setOnClickListener {
                // По нажатию на кнопку, перелистывает onBoard на предыдущую

                if (onBoardingViewPager.currentItem - 1 < adapter.itemCount) {

                    onBoardingViewPager.currentItem -= 1

                    // Получаем позицию viewPager2
                    // Если полученная позиция равна 0( первая страница onBoard )
                    // По нажатию на кнопку переходим в startActivity
                    if (onBoardingViewPager.currentItem == 0) {
                        btnBackOnBoard.setOnClickListener {
                            startActivity(Intent(applicationContext, StartActivity::class.java))
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
                        }
                    }

                }

            }
        }

    }


    private fun setupIndicators() {
        // Находим индикатор перелистывания
        indicatorContainer = binding.onBoardIndicator

        val indicators = arrayOfNulls<ImageView>(adapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)

        layoutParams.setMargins(8, 0, 0, 8)

        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)

            indicators[i]?.let {

                it.setImageDrawable(

                    ContextCompat.getDrawable(

                        applicationContext,
                        R.drawable.indicator_inactive_background

                    )

                )

                it.layoutParams = layoutParams
                indicatorContainer.addView(it)

            }
        }

    }


    private fun setCurrentIndicator(position: Int) {
        val childCount = indicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorContainer.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }


}