package com.example.android.unscramble.ui.game

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // data
    private var score = 0
    private var currentWordCount = 0

    // backing property in kotlin
    // counting the words solved

    // Declare private mutable variable that can only be modified
    // within the class it is declared.
    private var _count = 0

    // Declare another public immutable field and override its getter method.
    // Return the private property's value in the getter method.
    // When count is accessed, the get() function is called and
    // the value of _count is returned.
    val count : Int get() = _count


    // local
    private var _currentScrambledWord = "test"
    // global
    val currentScrambledWord : String get() = _currentScrambledWord

}