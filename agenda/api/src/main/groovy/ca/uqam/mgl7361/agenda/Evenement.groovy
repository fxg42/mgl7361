package ca.uqam.mgl7361.agenda

class Evenement {

    int id
    String nom
    Date du
    Date au
    
    def isValid () { du <= au }
    
    def inspect () { "${nom}: du ${du} au ${au}" }

}
