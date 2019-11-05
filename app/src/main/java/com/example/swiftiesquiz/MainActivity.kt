package com.example.swiftiesquiz

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.Button
import android.widget.Switch
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
        1 to "How many cats does Taylor have?",
        2 to "When was Taylors album 1989 released?",
        3 to "What is Taylors favorite color",
        4 to "Which boy has Taylor NOT dated?",
        5 to "What is Taylors middle name?",
        6 to "What is Taylors favorite food?",
        7 to "How tall is Taylor Swift?",
        8 to "What is Taylors favorite book?"
    )

    val categoryMap = mapOf<Int, String>(
        1 to "How many cats does Taylor have?",
        2 to "When was Taylors album 1989 released?",
        3 to "What is Taylors favorite color",
        4 to "Which boy has Taylor NOT dated?",
        5 to "What is Taylors middle name?",
        6 to "What is Taylors favorite food?",
        7 to "How tall is Taylor Swift?",
        8 to "What is Taylors favorite book?"
    )

    //Also create a map with correlating answers to the questionsMap
    val answersMap = mapOf<Int, ArrayList<String>>(
        1 to arrayListOf("1 Cat", "2 Cats", "No cats", "3 Cats"),
        2 to arrayListOf("The year 2014", "The year 1987", "The year 2011", "The year 2018"),
        3 to arrayListOf("Orange", "Purple", "Green", "Blue"),
        4 to arrayListOf("Harry Styles", "John Mayer", "Calvin Harris", "James Bay"),
        5 to arrayListOf("Jennifer", "Carly", "Alison", "Stephanie"),
        6 to arrayListOf("Mac 'n Cheese", "Chicken Alfredo", "Blueberry Donuts", "Cheesecake"),
        7 to arrayListOf("5'8", "6'0", "5'10", "5'5"),
        8 to arrayListOf("The Maze Runner", "Of mice and men", "Life of pi", "To Kill a Mockingbird")


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

                if(buttonClicked == 4) {

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
