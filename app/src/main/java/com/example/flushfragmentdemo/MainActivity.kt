package com.example.flushfragmentdemo



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragments = ArrayList<Fragment>()
        fragments.add(FooFragment())
        fragments.add(PlayerFragment(""))



        mainViewPager.apply {
            adapter = object :FragmentStateAdapter(this@MainActivity){
                override fun getItemCount(): Int {
                    return 2
                }

                override fun createFragment(position: Int): Fragment {
                    return fragments[position]
                }
            }
            setCurrentItem(1,false)
        }

        TabLayoutMediator(tabLayout,mainViewPager){ tab: TabLayout.Tab, i: Int ->
            when (i) {
                0 -> tab.text = "fpp"
                1 -> tab.text = "player"
            }
        }.attach()
    }
}