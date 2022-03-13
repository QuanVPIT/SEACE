package team.hacker.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import team.hacker.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        //  khai báo fragments và set adapter
        val fragments : List<Fragment> = listOf(
            sayhello(),intro1(),intro2(),intro3(),loginfacebook()
        )

        val adapter = ViewPagerAdapter(fragments,this)
        mainBinding.viewpager.adapter = adapter


        // circleindicator3
        mainBinding.indicator.setViewPager(mainBinding.viewpager)

    }

    override fun onBackPressed() {
        if(mainBinding.viewpager.currentItem == 0){
            super.onBackPressed()
        }else{
            mainBinding.viewpager.currentItem = mainBinding.viewpager.currentItem - 1
        }

    }
}