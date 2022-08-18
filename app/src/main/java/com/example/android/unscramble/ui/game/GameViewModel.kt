package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // ========================== DATA SECTION ====================

    // data
    // local
    private var _score = 0
    // global
    val score : Int get() = _score

    // local
    private var _currentWordCount = 0
    // global
    val currentWordCount : Int get() = _currentWordCount

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
    private lateinit var _currentScrambledWord : String
    // global
    val currentScrambledWord : String get() = _currentScrambledWord



    // LIST OF WORDS ALREADY USED
    private var wordList : MutableList<String> = mutableListOf()

    // CURRENT WORD
    private lateinit var currentWord : String

    init {
        // initializer block runs when the object instance is first created and initialized
        Log.d("GameFragment","GameViewModel created!")
        // generate the 1st and next word
        getNextWord()
    }

    // ================== LOGIC TO UPDATE UI ======================

    // NEXT WORD
    private fun getNextWord(){
        currentWord = allWordsList.random()
        val temptWord = currentWord.toCharArray()
        temptWord.shuffle()

        // if the shuffled word is same the original word, shuffle the word again
        while(String(temptWord).equals(currentWord, false)){
            temptWord.shuffle()
        }

        //  check if a word has been used already
        if(wordList.contains(currentWord)){
            getNextWord()
        } else {
            _currentScrambledWord = String(temptWord)
            ++_currentWordCount
            // add the solved word to the list
            wordList.add(currentWord)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment","GameViewModel cleared!")
    }

    // Helper function - get next word or not?
    // finish the level if word is 10
    fun nextWord() : Boolean{
        return if (currentWordCount < MAX_NO_OF_WORDS){
            getNextWord()
            true
        } else false
    }
}