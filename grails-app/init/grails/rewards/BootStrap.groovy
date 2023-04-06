package grails.rewards

class BootStrap {

    def init = { servletContext ->
        new Product(name: "Morning Blend", sku: "MB01", price: 14.50).save()
        new Product(name: "Dark Blend", sku: "MB02", price: 11.50).save()
        new Customer(phone: 13621526, firstName: "Matias", lastName: "de la cerda", totalPoints: 3).save()
        new Customer(phone: 213123123, firstName: "Edgardo", lastName: "de la cerda", totalPoints: 5).save()
        new Customer(phone: 123123123, firstName: "Paula", lastName: "tecas", totalPoints: 6).save()
        new Customer(phone: 5645646456, firstName: "Benja", lastName: "sadasd", totalPoints: 1).save()
        new Customer(phone: 546453221, firstName: "Florencia", lastName: "buzeta", totalPoints: 8).save()
        new Customer(phone: 546546452, firstName: "Freddy", lastName: "pineda", totalPoints: 2).save()

    }
    def destroy = {
    }
}
