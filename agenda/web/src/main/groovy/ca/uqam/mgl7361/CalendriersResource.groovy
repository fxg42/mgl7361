package ca.uqam.mgl7361

import ca.uqam.mgl7361.agenda.*
import javax.servlet.*
import javax.ws.rs.*
import javax.ws.rs.core.*
import javax.ws.rs.core.Response.*
import org.springframework.beans.factory.annotation.*
import org.springframework.context.annotation.*
import org.springframework.stereotype.*
import org.springframework.transaction.annotation.*
import org.springframework.web.context.support.*

@Component
@Scope('request')
@Path('/rest/calendriers')
class CalendriersResource {

    @Autowired AgendaService agenda
    
    @GET
    Response obtenir () {
        Response.ok().build() // TODO.
    }
}