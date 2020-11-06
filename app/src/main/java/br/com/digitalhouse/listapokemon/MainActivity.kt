package br.com.digitalhouse.listapokemon

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewParent
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var listPokemons: ArrayList<Pokemon>
    lateinit var adapter: PokemonAdapter
    lateinit var actionBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //usando a actionBar e pega o actionbar para que nao seja nula
        actionBar = this.supportActionBar!!


        listPokemons = getListPokemon()
        adapter = PokemonAdapter(this, listPokemons)
        vpPokemon.adapter = adapter
        vpPokemon.setPadding(100,0,100,0)

        //outra parte do actionbar
        vpPokemon.addOnAdapterChangeListener(object: ViewPager.OnPageChangeListener,
            ViewPager.OnAdapterChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                Log.i("TAG", "Chamou")
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val titulo = listPokemons.get(position).nome
                actionBar.title = titulo

            }

            override fun onPageSelected(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onAdapterChanged(
                viewPager: ViewPager,
                oldAdapter: PagerAdapter?,
                newAdapter: PagerAdapter?
            ) {
                TODO("Not yet implemented")
            }
        })
    }

    //Retorna uma lista de pokemons
    fun getListPokemon(): ArrayList<Pokemon> {
        return arrayListOf(
            Pokemon(
                1, "Bulbasaur",
                R.drawable.bulbasaur,
                R.color.fogo,
                arrayListOf("Fogo"),
                arrayListOf("Água", "Terra", "Rocha")
            ),
            Pokemon(
                2, "Charmander",
                R.drawable.charmander,
                R.color.fogo,
                arrayListOf("Fogo"),
                arrayListOf("Água", "Terra", "Rocha")
            ),Pokemon(
                3, "Pidgey",
                R.drawable.pidgey,
                R.color.fogo,
                arrayListOf("Fogo"),
                arrayListOf("Água", "Terra", "Rocha")
            ),Pokemon(
                4, "Squirtle",
                R.drawable.squirtle,
                R.color.fogo,
                arrayListOf("Fogo"),
                arrayListOf("Água", "Terra", "Rocha")
            )
        )
    }
}