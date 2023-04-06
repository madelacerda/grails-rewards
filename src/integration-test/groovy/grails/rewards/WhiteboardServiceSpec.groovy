package grails.rewards

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class WhiteboardServiceSpec extends Specification {

    WhiteboardService whiteboardService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Whiteboard(...).save(flush: true, failOnError: true)
        //new Whiteboard(...).save(flush: true, failOnError: true)
        //Whiteboard whiteboard = new Whiteboard(...).save(flush: true, failOnError: true)
        //new Whiteboard(...).save(flush: true, failOnError: true)
        //new Whiteboard(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //whiteboard.id
    }

    void "test get"() {
        setupData()

        expect:
        whiteboardService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Whiteboard> whiteboardList = whiteboardService.list(max: 2, offset: 2)

        then:
        whiteboardList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        whiteboardService.count() == 5
    }

    void "test delete"() {
        Long whiteboardId = setupData()

        expect:
        whiteboardService.count() == 5

        when:
        whiteboardService.delete(whiteboardId)
        sessionFactory.currentSession.flush()

        then:
        whiteboardService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Whiteboard whiteboard = new Whiteboard()
        whiteboardService.save(whiteboard)

        then:
        whiteboard.id != null
    }
}
