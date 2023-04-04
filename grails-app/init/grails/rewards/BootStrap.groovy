package grails.rewards

class BootStrap {

    def init = { servletContext ->
        new Product(name: "Morning Blend", sku: "MB01", price: 14.50).save()
        new Product(name: "Dark Blend", sku: "MB02", price: 11.50).save()
    }
    def destroy = {
    }
}
