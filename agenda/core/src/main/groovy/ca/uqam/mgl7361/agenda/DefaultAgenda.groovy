package ca.uqam.mgl7361.agenda

class DefaultAgenda implements AgendaService {
    
    def repository
    
    def findAllEvenements () {
        repository.findAll()
    }
    
    def findById (id) {
        repository.findById(id)
    }
    
    def addEvenement (Evenement evt) {
        if (evt.isValid()) {
            repository.add(evt)
        }
    }
    
    def updateEvenement (Evenement evt) {
        if (evt.isValid()) {
            repository.update(evt)
        }
    }
    
    void setEvenementRepository (EvenementRepository evenementRepository) {
        repository = evenementRepository
    }
}