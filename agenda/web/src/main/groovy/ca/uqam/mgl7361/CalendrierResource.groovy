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
@Path('/rest/calendrier/{nom_du_calendrier}')
class CalendrierResource {

    @PathParam('nom_du_calendrier') String nomCalendrier
    @Autowired AgendaService agenda
    
    @PUT
    Response creer () {
        Response.ok().build() // TODO.
    }
    
    @PUT
    @Consumes("application/json")
    Response modifier (InputStream inputStream) {
        Response.ok().build() // TODO.
    }
    
    @DELETE
    Response retirer () {
        Response.ok().build() // TODO.
    }
}