package com.boratuzun.netflix

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.boratuzun.netflix.databinding.FragmentComingSoonBinding
import com.boratuzun.netflix.databinding.FragmentDownloadsBinding
import com.google.android.material.snackbar.Snackbar

class DownloadsFragment : Fragment() {

    private lateinit var tasarim : FragmentDownloadsBinding
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim = FragmentDownloadsBinding.inflate(inflater, container, false)

        tasarim.textViewDiziler.setOnClickListener {
            Snackbar.make(it, "Diziler sayfasına geçiş yapıdı.", Snackbar.LENGTH_SHORT).show()
        }

        tasarim.textViewFilmler.setOnClickListener {
            Snackbar.make(it, "Filmler sayfasına geçiş yapıdı.", Snackbar.LENGTH_SHORT).show()
        }

        tasarim.textViewListem.setOnClickListener {
            Snackbar.make(it, "Listem sayfasına geçiş yapıdı.", Snackbar.LENGTH_SHORT).show()
        }

        tasarim.imageViewNetflix.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.homePageFragment)
        }

        return tasarim.root
    }
}