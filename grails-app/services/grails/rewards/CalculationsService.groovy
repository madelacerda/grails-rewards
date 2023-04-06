package grails.rewards

import grails.gorm.transactions.Transactional

@Transactional
class CalculationsService {
    def welcomeMessage = ""

    def welcome(params) {
        def firstName = params.first
        def totalPoints = params.points.toInteger()
        def welcomeMessage = ""
        if (totalPoints >= 5) {
            welcomeMessage = "Welcome back $customerInstance.firstName, this drink is on us"
        } else if (totalPoints == 4) {
            welcomeMessage = "Welcome back $customerInstance.firstName, your next drink is free"
        } else
            welcomeMessage = "Welcome back $customerInstance.firstName, you have $totalPoints points."

    }

    def getTotalPoints(Customer customerInstance) {
        def totalAwards = 0
        customerInstance.awards.each {
            totalAwards = totalAwards + it.points
        }
        customerInstance.totalPoints = totalAwards
        return customerInstance
    }


    def processCheckin(lookupInstance) {
        // Lookup customer by phone number
        def customerInstance = Customer.findByPhone(lookupInstance.phone)
        // set up new customer
        if (customerInstance == null) {
            customerInstance = lookupInstance
            customerInstance.firstName = "customer"
        }
        // calculate current award points
        // create welcome message
        //add new award
        // save customer
        customerInstance.save()

        def welcomeMessage = ""
        return [customerInstance, welcomeMessage]
    }
}
