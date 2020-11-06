package br.com.digitalhouse.listapokemon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.card_pokemon.view.*

class PokemonAdapter(private val context: Context,private var listPokemon: ArrayList<Pokemon>):
    PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` == view
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //Inflando a view
        var view = LayoutInflater.from(context).inflate(R.layout.card_pokemon, container, false)
        //Obtendo o pokemon
        var pokemon = listPokemon.get(position)

        view.tvNomePokemon.text = pokemon.nome
        view.ivImgPokemon.setImageResource(pokemon.img)

        view.setOnClickListener{
            Toast.makeText(context, pokemon.nome, Toast.LENGTH_SHORT).show()
        }

        container.addView(view)
        return view
    }

    override fun getCount() = listPokemon.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

}
