package com.example.swiftiesquiz

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    //Get views
    lateinit var questionTextView: TextView
    lateinit var categoryTextView: TextView
    lateinit var answer1Buton: Button
    lateinit var answer2Button: Button
    lateinit var answer3Button: Button
    lateinit var answer4Button: Button

    //Start with an accessible map of questions
    val questionsMap = mapOf<Int, String>(
        1 to "Today is my first day at Blendex. I feel really _________  about it.",
        2 to "I will meet new _________ there.",
        3 to "I don’t know anything about my teacher but I think he/she is going to _________ me,",
        4 to "because I am a/an  _________  person.",
        5 to "I want to be his  _________." ,
        6 to "After all, a new language is going to _________ me in the future.",
        7 to "For example, I think English is  ________,",
        8 to "but French is  ________."
    )

    val categoryMap = mapOf<Int, String>(
        1 to "Select an Adjective!",
        2 to "Select a Plural noun!",
        3 to "Select a Verb!",
        4 to "Select an Adjective!",
        5 to "Select a Singular noun!",
        6 to "Select a Verb!",
        7 to "Select an Adjective!",
        8 to "Select an Adjective!"
    )

    //Also create a map with correlating answers to the questionsMap
    val answersMap = mapOf<Int, ArrayList<String>>(
        1 to arrayListOf("Help", "Friend", "Families","Crazy"),
        2 to arrayListOf("Friends","Need", "World",  "Cool"),
        3 to arrayListOf( "Pet","Kill", "Cats", "Amazing"),
        4 to arrayListOf("Hate", "Problem", "Children","Important"),
        5 to arrayListOf("Destroy",  "Animals","Question", "Special"),
        6 to arrayListOf("World", "Friends", "Cool","Need"),
        7 to arrayListOf("Hate", "Problem", "Amazing","Children"),
        8 to arrayListOf("Destroy", "Special", "Question", "Animals")


    )

    //We'll always begin with the first question
    var currentQuestion = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = this.findViewById(R.id.question)
        categoryTextView = this.findViewById(R.id.textView2)
        answer1Buton = this.findViewById(R.id.answer1)
        answer2Button = this.findViewById(R.id.answer2)
        answer3Button = this.findViewById(R.id.answer3)
        answer4Button = this.findViewById(R.id.answer4)

        //initially set the question
        setQuestion()

        answer1Buton.setOnClickListener {
            checkCorrect(1)
        }

        answer2Button.setOnClickListener {
            checkCorrect(2)
        }

        answer3Button.setOnClickListener {
            checkCorrect(3)
        }

        answer4Button.setOnClickListener {
            checkCorrect(4)
        }
    }


    // ✨ Calling this function will check which question we're currently on and update the UI accordingly ✨//
    private fun setQuestion() {
        questionTextView.text = questionsMap.get(currentQuestion)
        categoryTextView.text = categoryMap.get(currentQuestion)
        answer1Buton.text = answersMap.get(currentQuestion)!!.get(0)
        answer2Button.text = answersMap.get(currentQuestion)!!.get(1)
        answer3Button.text = answersMap.get(currentQuestion)!!.get(2)
        answer4Button.text = answersMap.get(currentQuestion)!!.get(3)

    }

    private fun resetQuiz() {
        currentQuestion = 1
        setQuestion()
    }

    private fun checkCorrect(buttonClicked: Int) {
        when(currentQuestion) {
            1 ->{
                Log.v(TAG, "Question 1")

                if(buttonClicked == 4) {
                    correct()
                } else {
                    wrong()
                }
            }
            2 -> {
                Log.v(TAG, "Question 2")

                if(buttonClicked == 1) {
                    correct()
                } else {
                    wrong()
                }
            }
            3 ->{
                Log.v(TAG, "Question 3")

                if(buttonClicked == 2) {
                    correct()
                } else {
                    wrong()
                }
            }
            4 ->{
                Log.v(TAG, "Question 4")

                if(buttonClicked == 4) {
                    correct()
                } else {
                   wrong()
                }
            }
            5 -> {
                Log.v(TAG, "Question 5")

                if(buttonClicked == 3) {
                    correct()
                } else {
                    wrong()
                }
            }
            6 -> {
                Log.v(TAG, "Question 6")

                if(buttonClicked == 4) {
                    correct()
                } else {
                    wrong()
                }
            }
            7 -> {
                Log.v(TAG, "Question 7")

                if(buttonClicked == 3) {
                    correct()
                } else {
                    wrong()
                }
            }
            8 -> {
                Log.v(TAG, "Question 8")

                if(buttonClicked == 2) {

                    AlertDialog.Builder (this)
                        .setTitle("Exercise Complete")
                        .setMessage("Excellent Job!")
                        .setPositiveButton("You are an expert in Parts of Speech", DialogInterface.OnClickListener { _ , _ ->
                            resetQuiz()
                        }).show()
                } else {
                    wrong()


                }
            }
        }
    }

    fun correct(){
        //answer is correct, move to next question
        currentQuestion++
        Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        setQuestion()
    }

    fun wrong() {
        //selection is incorrect, show toast for now
        Toast.makeText(this, "Incorrect, try again!", Toast.LENGTH_SHORT).show()

    }

    companion object {
        const val TAG = "MAIN_ACTIVITY"
    }
}
