package com.example.seekbar

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

     public fun scaleImage(img: ImageView, scale: Int) {

        val WIDTH_SCALE_RATIO = 10;
        val HEIGHT_SCALE_RATIO = 10;
        val previousProcess =
        var bitmap = (img.drawable as BitmapDrawable).bitmap
        var width = bitmap.width.toFloat()
        var height = bitmap.height.toFloat()
        width += scale * WIDTH_SCALE_RATIO
        height += scale * HEIGHT_SCALE_RATIO
        bitmap = Bitmap.createScaledBitmap(
            bitmap, width.toInt(), height.toInt(),
            true
        )
        img.setImageBitmap(bitmap)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         0;

        val obraz1 = findViewById<ImageView>(R.id.imv1)
        val obraz2 = findViewById<ImageView>(R.id.imv2)
        val obraz3 = findViewById<ImageView>(R.id.imv3)

        val obraz1_poziom = findViewById<SeekBar>(R.id.poziom1)
        val obraz1_pion = findViewById<SeekBar>(R.id.pion1)
        val obraz2_poziom = findViewById<SeekBar>(R.id.poziom2)
        val obraz2_pion = findViewById<SeekBar>(R.id.pion2)
        val obraz3_poziom = findViewById<SeekBar>(R.id.poziom3)
        val obraz3_pion = findViewById<SeekBar>(R.id.pion3)

        obraz1_poziom.setOnSeekBarChangeListener(){
        scaleImage(obraz1,)
        }




    }
}

private fun SeekBar.setOnSeekBarChangeListener(function: () -> Unit) {

}


