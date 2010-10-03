package ca.uqam.mgl7361

import javax.servlet.http.*
import org.springframework.web.context.support.*

class SessionLoaderListener implements HttpSessionListener {

    void sessionCreated (HttpSessionEvent evt) {
        def session = evt.session
        def ctx = WebApplicationContextUtils.getWebApplicationContext(session.servletContext)
        session.setAttribute('agenda', ctx.getBean('agenda'))
    }
    
    void sessionDestroyed (HttpSessionEvent evt) {
        // do nothing.
    }
}