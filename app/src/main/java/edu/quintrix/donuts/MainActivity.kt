package edu.quintrix.donuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
// guess renaming the package causes a little bit of mayhem
import edu.quintrix.donuts.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}