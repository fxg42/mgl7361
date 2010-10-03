package ca.uqam.mgl7361.agenda

class DefaultAgenda implements AgendaService {
    
    def repository
    
    def findAllEvenements () {
        repository.findAll()
    }
    
    def addEvenement (Evenement evt) {
        if (evt.isValid()) {
            repository.add(evt)
        }
    }
    
    void setEvenementRepository (EvenementRepository evenementRepository) {
        repository = evenementRepository
    }
}