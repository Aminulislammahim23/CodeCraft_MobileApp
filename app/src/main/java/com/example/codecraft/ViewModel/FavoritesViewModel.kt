package com.example.codecraft.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoritesViewModel : ViewModel() {

    private val _favoriteCourses = MutableLiveData<List<Course>>()
    val favoriteCourses: LiveData<List<Course>> = _favoriteCourses

    fun loadFavorites() {
        // Load favorite courses from repository
        // _favoriteCourses.value = repository.getFavorites()
    }
}