package com.boratuzun.netflix

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.boratuzun.netflix.databinding.FragmentHomePageBinding
import com.google.android.material.snackbar.Snackbar

class HomePageFragment : Fragment() {
    private lateinit var tasarim : FragmentHomePageBinding
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim = FragmentHomePageBinding.inflate(inflater, container, false)

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

        //Popüler
        tasarim.rvPopuler.layoutManager = LinearLayoutManager(requireContext(), 0, false)

        val filmlerListesi = ArrayList<Films>()
        val f1 = Films(1, "The Witcher", "the_witcher")
        val f2 = Films(2, "Narcos", "narcos")
        val f3 = Films(3, "BlackAF", "black_af")
        val f4 = Films(4, "Red Notice", "red_notice")
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)

        val adapter = FilmAdapter(requireContext(), filmlerListesi)
        tasarim.rvPopuler.adapter = adapter

        //Gündemdekiler
        tasarim.rvGundem.layoutManager = LinearLayoutManager(requireContext(), 0, false)

        val filmlerListesi2 = ArrayList<Films>()
        val c1 = Films(1, "Kaplan Kral", "kaplan_kral")
        val c2 = Films(2, "Stranger Things", "st")
        val c3 = Films(3, "Underground 6", "underground")
        val c4 = Films(4, "Lupin", "lupin")
        filmlerListesi2.add(c1)
        filmlerListesi2.add(c2)
        filmlerListesi2.add(c3)
        filmlerListesi2.add(c4)

        val adapterGundem = FilmAdapter(requireContext(), filmlerListesi2)
        tasarim.rvGundem.adapter = adapterGundem

        //Yeniden İzle
        tasarim.rvYenidenIzle.layoutManager = LinearLayoutManager(requireContext(), 0, false)

        val filmlerListesi3 = ArrayList<Films>()
        val d1 = Films(1, "Breaking Bad", "bb")
        val d2 = Films(2, "Sick Note", "sick_note")
        val d3 = Films(3, "Ozark", "ozark")
        val d4 = Films(4, "How to Sell Drugs Online", "htsdof")
        filmlerListesi3.add(d1)
        filmlerListesi3.add(d2)
        filmlerListesi3.add(d3)
        filmlerListesi3.add(d4)

        val adapterYeniden = FilmAdapter(requireContext(), filmlerListesi3)
        tasarim.rvYenidenIzle.adapter = adapterYeniden

        return tasarim.root
    }

}