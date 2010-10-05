package ca.uqam.mgl7361.agenda

interface AgendaService {

    def findAllEvenements ()
    def findById (id)
    def addEvenement (Evenement evt)
    def updateEvenement (Evenement evt)
}