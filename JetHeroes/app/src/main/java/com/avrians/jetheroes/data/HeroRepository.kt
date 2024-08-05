package com.avrians.jetheroes.data

import com.avrians.jetheroes.model.Hero
import com.avrians.jetheroes.model.HeroesData

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }
}