package grails.rewards

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*

class CustomerController {
    def calculationsService
    CustomerService customerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerService.list(params), model: [customerCount: customerService.count()]
    }

    def lookup() {
        def customerInstance = Customer.list(sort: "lastName", order: "desc", max: 5, offset: 5)
        [customerInstanceList: customerInstance]
    }

    def customerLookup(Customer lookupInstance) {

        def (customerInstance, welcomeMessage) = calculationsService.processCheckin(lookupInstance)

        render(view: "checkin", model: [customerInstance: customerInstance, welcomeMessage: welcomeMessage])
        // Query customer by phone #
        // If no result,
        // Create a new customer
        // Create a Welcome Message
        // Add award record
        // save customer
        // send welcome to kiosk
        //if customer found,
        // Calculate total points
        // Create a Welcome Message
        // Add award record
        // save customer
        // send welcome to kiosk
    }

//   def lookup() {
    //    def customerInstance = Customer.findAllByLastName("tecas")
    //     [customerInstanceList: customerInstance]
    //   }

    def checkin() {

    }

    def show(Long id) {

        respond customerService.get(id)

    }

    def create() {
        respond new Customer(params)
    }

    def save(Customer customer) {
        if (customer == null) {
            notFound()
            return
        }

        try {
            customerService.save(customer)
        } catch (ValidationException e) {
            respond customer.errors, view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customer.label', default: 'Customer'), customer.id])
                redirect customer
            }
            '*' { respond customer, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerService.get(id)
    }

    def update(Customer customer) {
        if (customer == null) {
            notFound()
            return
        }

        try {
            customerService.save(customer)
        } catch (ValidationException e) {
            respond customer.errors, view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customer.label', default: 'Customer'), customer.id])
                redirect customer
            }
            '*' { respond customer, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customer.label', default: 'Customer'), id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customer.label', default: 'Customer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
