package com.example.s205420__lykkehjulet

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.s205420__lykkehjulet.databinding.FragmentSecondBinding
import org.w3c.dom.Text
import kotlin.random.Random


/**
 * This is secondfragment, where all the gamelogic and viewmodel are designed
*/
class SecondFragment : Fragment() {


    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }


//create buttons and set buttons to visible/gone
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = binding.buttonSpin
        val text: TextView = binding.output
        val randomword: TextView = binding.word
        val button2: Button = binding.buttonGuess
        val guessletterButton: Button = binding.buttonLetter
        button.setOnClickListener {
            text.text = spin()
            button2.visibility = View.VISIBLE
            button.visibility = View.GONE
            guessletterButton.visibility = View.VISIBLE
            randomword.visibility = View.GONE
        }
        randomword.text = random()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun roll(): Int {
        return (1..6).random()
    }

//logic for spinwheel
    var lives = 5
    private fun spin(): String {
        var result = roll()

        guessWordButton()
        guessLetterButton()
        if (lives<1){
            gameLost()
        }
        when (result) {
            1 -> {
                lives-- ; return ("You have spun $result   Live: $lives ")
            }
            2 -> {
                return ("You have spun $result    Live: $lives ")
            }
            3 -> {
                lives--; return ("You have spun $result   Live: $lives")
            }
            4 -> {
                lives--; return ("You have spun $result   Live: $lives")
            }
            5 -> {
                lives--; return ("You have spun $result   Live: $lives ")
            }
            else -> {
                return ("You have spun $result   Live: $lives")
            }

        }

    }
    //navigate to lost fragment
    fun gameLost(){
        findNavController().navigate(R.id.action_SecondFragment_to_blankFragment)
    }
    //navigate to win fragment
    fun gameWon(){
        findNavController().navigate(R.id.action_SecondFragment_to_won)
    }
    //list of words
    object randomWords{
        val listOfWords = listOf("kat", "dog", "elephant","monkey","fish")
    }
    //make random words
    private lateinit var guessWord:String
    fun random():String{
        val randomElement = Random.nextInt(0,randomWords.listOfWords.size)
        guessWord = randomWords.listOfWords[randomElement]
        return guessWord
    }

    //win condition and what happens if guess wrong
    fun guessWords(editText: EditText){
        val input = editText.text
        val outputtoUser: TextView = binding.outputToUser
        if(input.toString() == guessWord){
            gameWon()
        }else{
            outputtoUser.text = "Try Again"
        }

    }

    fun guessAletter(editText: EditText) {
        val input = editText.text
        val outputtoUser: TextView = binding.outputToUser
        if (guessWord.contains("$input") )  {
            outputtoUser.text ="You Guessed Right, pls continue, when you have guessd all letters, pls enter the word and press 'guess a word'"

        } else {
            outputtoUser.text = "You guessed wrong, and lost 1 live,Try Again"
            lives--
        }
    }
    //Making guess button
    fun guessWordButton(){
        val editText: EditText = binding.inputFromUser
        val guessButton: Button = binding.buttonGuess
        val button: Button = binding.buttonSpin
        val guessLetterButton:Button = binding.buttonLetter
        guessButton.visibility = View.GONE
        guessButton.setOnClickListener{
            guessWords(editText)
            button.visibility = View.VISIBLE
            guessButton.visibility = View.GONE
            guessLetterButton.visibility = View.GONE
        }
    }
    //function that allows user to guess a letter
    fun guessLetterButton(){
        val guessletterButton: Button = binding.buttonLetter
        val editText: EditText = binding.inputFromUser
        val guesswordButton: Button = binding.buttonGuess
        val spinButton: Button = binding.buttonSpin
        val text: TextView = binding.inputView
        val input = editText.text
        guessletterButton.visibility = View.GONE
        guessletterButton.setOnClickListener{
            guessAletter(editText)
            guesswordButton.visibility = View.GONE
            guessletterButton.visibility = View.GONE
            spinButton.visibility = View.VISIBLE
            text.text = input
        }

    }

}


