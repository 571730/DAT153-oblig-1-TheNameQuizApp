package com.example.myapplication

/**
 * class is used to keep track of the quiz and all its states
 * @param data is the list of people from the database
 * @property score keeps track of the users correct answers
 * @property attempts total amount of attempts
 * @property done is the quiz done? true \ false
 * @property index points to the current position in the list of people
 * @property people a shuffled copy of the data
 */
class Quiz (data: ArrayList<Person>){
    var score: Int
    var attempts: Int
    var done: Boolean
    var index: Int
    var people: ArrayList<Person>

    /**
     * called when the user submits an answer
     * @param ans the name the user guessed
     * @return was the answer correct?
     */
    fun answer(ans: String): Boolean{
        attempts++
        var correct = false
        if (ans.equals(people[index].name, true)) {
            score++
            correct = true
        }
        index++
        done = isDone()
        return  correct
    }

    /**
     * gets the next person in the quiz
     * @return the next person object
     */
    fun pickPerson(): Person {
        val person = people[index]
        return person
    }

    /**
     * check if the quiz is done
     * @return is it done?
     */
    private fun isDone(): Boolean {
        return attempts == people.size
    }

    init {
        score = 0
        attempts = 0
        index = 0
        done = false
        data.shuffle()
        people = data
    }
}