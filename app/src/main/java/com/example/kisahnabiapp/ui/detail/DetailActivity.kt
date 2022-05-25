package com.example.kisahnabiapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.kisahnabiapp.R
import com.example.kisahnabiapp.data.KisahResponse
import com.example.kisahnabiapp.databinding.ActivityDetailBinding
import com.example.kisahnabiapp.databinding.ActivityMainBinding
import com.example.kisahnabiapp.ui.MainViewModel

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<KisahResponse>(EXTRA_DATA)
        data?.let {
            binding.apply {
                Glide.with(this@DetailActivity).load(data?.imageUrl).into(detailImage)
                detailNama.text = data.name
                detailTahun.text = data.thnKelahiran
                detailTempat.text = data.tmp
                detailUsia.text = data.usia
                detailDesk.text = data.description

            }
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}
