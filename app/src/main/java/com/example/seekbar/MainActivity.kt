package com.example.seekbar

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

     public fun scaleImage(img: ImageView, scale: Int) {

        val WIDTH_SCALE_RATIO = 10;
        val HEIGHT_SCALE_RATIO = 10;
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

        val obraz1 = findViewById<ImageView>(R.id.imv1)
        val obraz2 = findViewById<ImageView>(R.id.imv2)
        val obraz3 = findViewById<ImageView>(R.id.imv3)

        val obraz1_poziom = findViewById<SeekBar>(R.id.poziom1)
        val obraz1_pion = findViewById<SeekBar>(R.id.pion1)
        val obraz2_poziom = findViewById<SeekBar>(R.id.poziom2)
        val obraz2_pion = findViewById<SeekBar>(R.id.pion2)
        val obraz3_poziom = findViewById<SeekBar>(R.id.poziom3)
        val obraz3_pion = findViewById<SeekBar>(R.id.pion3)
        val reset = findViewById<Button>(R.id.reset)
        val progress_poziom = findViewById<ProgressBar>(R.id.pgbpoziom)
        val progress_pion = findViewById<ProgressBar>(R.id.pgbpion)

        reset.setOnClickListener() {
            obraz1_pion.progress = 100
            obraz2_pion.progress = 100
            obraz3_pion.progress = 100
            obraz1_poziom.progress = 100
            obraz2_poziom.progress = 100
            obraz3_poziom.progress = 100
        }

        obraz1_pion.setOnSeekBarChangeListener(object:OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar,progres: Int, fromUser: Boolean) {
                val scale = progres/100f
                obraz1.scaleY = scale
                changed(progress_pion, suma_pionu())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        obraz1_poziom.setOnSeekBarChangeListener(object:OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar,progres: Int, fromUser: Boolean) {
                val scale = progres/100f
                obraz1.scaleX = scale
                changed(progress_poziom, suma_poziomu())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        obraz2_poziom.setOnSeekBarChangeListener(object:OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar,progres: Int, fromUser: Boolean) {
                val scale = progres/100f
                obraz2.scaleX = scale
                changed(progress_poziom, suma_poziomu())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        obraz2_pion.setOnSeekBarChangeListener(object:OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar,progres: Int, fromUser: Boolean) {
                val scale = progres/100f
                obraz2.scaleY = scale
                changed(progress_pion, suma_pionu())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })


    }
        fun suma_poziomu(): Int{
            val obraz1_poziom = findViewById<SeekBar>(R.id.poziom1)
            val obraz2_poziom = findViewById<SeekBar>(R.id.poziom2)
            val obraz3_poziom = findViewById<SeekBar>(R.id.poziom3)
            val suma = obraz1_poziom.progress + obraz2_poziom.progress + obraz3_poziom.progress
            return suma
        }

        fun suma_pionu(): Int{
            val obraz1_pion = findViewById<SeekBar>(R.id.pion1)
            val obraz2_pion = findViewById<SeekBar>(R.id.pion2)
            val obraz3_pion = findViewById<SeekBar>(R.id.pion3)
            val suma = obraz1_pion.progress + obraz2_pion.progress + obraz3_pion.progress
            return suma
        }

        fun changed(progressBar: ProgressBar, suma: Int){
            progressBar.progress = suma/3
        }
}


