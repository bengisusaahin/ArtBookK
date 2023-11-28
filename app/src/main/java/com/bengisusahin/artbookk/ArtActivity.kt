package com.bengisusahin.artbookk

import android.Manifest
import android.content.pm.PackageManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bengisusahin.artbookk.databinding.ActivityArtBinding
import com.google.android.material.snackbar.Snackbar

class ArtActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun saveButtonClicked(view: View){

    }

    fun selectImage(view: View){
        //read external izni dangerous level oldugu icin manifestte kontrol etmek yeterli degil
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                //rationale gösterdikten sonra request permission buna karar veren androidin kendisi
                Snackbar.make(view, "Permission needed for gallery", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Give permission", View.OnClickListener {
                        //request permission
                    }).show()
            }else{
                //rationale göstermeden direkt request permission
            }

        }else{
            val intentToGallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            //intent
        }
    }

}