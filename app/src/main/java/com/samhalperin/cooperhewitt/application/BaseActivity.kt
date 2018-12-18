package com.samhalperin.cooperhewitt.application

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.samhalperin.cooperhewitt.R
import kotlinx.android.synthetic.main.activity_main.*

open class BaseActivity : AppCompatActivity() {

    protected fun setup(contentView: Int) {
        setContentView(contentView)
        setSupportActionBar(toolbar as Toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.setLogo(R.mipmap.ic_launcher)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}
