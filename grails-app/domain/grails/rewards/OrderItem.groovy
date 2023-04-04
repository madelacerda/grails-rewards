package grails.rewards

class OrderItem {
    Integer qty
    Float total
    static belongsTo = [order: CustomerOrder, product: Product]


    static constraints = {
    }
}
