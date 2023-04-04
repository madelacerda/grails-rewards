package grails.rewards

class Customer {
    String firstName
    String lastName
    Long phone
    String email
    Integer totalPoints
    static hasMany = [awards: Award, orders: CustomerOrder]


    static constraints = {
        phone()
        firstName(nullable: true)
        lastName(nullable: true)
        email(nullable: true)
        totalPoints(nullable: true)
    }
}
