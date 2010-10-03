package ca.uqam.mgl7361

import groovy.text.*

class Renderer {
    
    def servletContext
    
    def render (templatePath, binding) {
        binding.putAt('h', [
            include: { path -> render(path, binding) }
        ])
        
        (new GStringTemplateEngine()).createTemplate(
            servletContext.getResourceAsStream(templatePath).getText('UTF-8')
        ).make(
            binding
        ).toString()
    }
}
