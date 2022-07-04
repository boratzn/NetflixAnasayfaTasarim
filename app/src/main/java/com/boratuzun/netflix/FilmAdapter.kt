package com.boratuzun.netflix

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.boratuzun.netflix.databinding.CardTasarimBinding

class FilmAdapter(var mContext: Context, var filmListesi:List<Films>)
    : RecyclerView.Adapter<FilmAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CardTasarimBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmListesi[position]
        val t = holder.tasarim

        t.imageView.setImageResource(
            mContext.resources.getIdentifier(film.filmResim, "drawable", mContext.packageName))

        t.cardView.setOnClickListener {
            //val gecis = HomePageFragmentDirections.detayGecis(film = film)
            //Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return filmListesi.size
    }
}