package com.avrians.jetheroes.data

import com.avrians.jetheroes.model.Hero
import com.avrians.jetheroes.model.HeroesData

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }

    fun searchHeroes(query: String): List<Hero> {
        return HeroesData.heroes.filter { it.name.contains(query, ignoreCase = true) }
    }
}