package grails.rewards

class WhiteboardController {
    def calculationsService

    def index() {}

    def variables() {
        def myTotal = 1
        render("Total: " + myTotal)
        render("</br>" + myTotal.class)

        def firstName = "Mike"
        render("</br>Name: " + firstName)
        render("</br>" + firstName.class)
        def today = new Date("2/1/2014")
        render("</br> Today is: " + today)
        render("</br>" + today.class)
    }

    def strings() {
        def first = "Mike"
        def last = "Kelly"
        def points = 4
        render("hey there $first. you already have $points!")
    }

    def conditions() {

        def welcomeMessage = calculationsService.welcome(params)
        render(welcomeMessage)
    }

}
