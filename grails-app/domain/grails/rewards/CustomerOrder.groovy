package grails.rewards

class CustomerOrder {
    Date orderDate
    Integer orderNumber
    Float orderTotal
    static belongsTo = [customer: Customer]
    static hasMany = [orderItems: OrderItem]

    static constraints = {
    }
}
