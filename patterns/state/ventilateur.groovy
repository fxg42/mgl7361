class Ventilateur {
    def state
    def emplacement
    
    Ventilateur (emplacement) {
        this.emplacement = emplacement
        this.state = new Stopped ()
    }
    def tirerChainette () {
        state = state.nextState()
    }
    String toString () {
        state.getDescription(this)
    }
}

abstract class VitesseState {
    abstract nextState ()
    abstract getDescription (ventilateur)
}

class Stopped extends VitesseState {
    def nextState () {
        new Slow ()
    }
    def getDescription (ventilateur) {
        "le ventilateur de ${ventilateur.emplacement} ne tourne pas."
    }
}
class Slow extends VitesseState {
    def nextState () {
        new Medium ()
    }
    def getDescription (ventilateur) {
        "le ventilateur de ${ventilateur.emplacement} tourne au ralentit."
    }
}
class Medium extends VitesseState {
    def nextState () {
        new High ()
    }
    def getDescription (ventilateur) {
        "le ventilateur de ${ventilateur.emplacement} tourne moyennement vite."
    }
}
class High extends VitesseState {
    def nextState () {
        new Stopped ()
    }
    def getDescription (ventilateur) {
        "le ventilateur de ${ventilateur.emplacement} tourne rapidement."
    }
}

v = new Ventilateur("salon")
println v

5.times {
    v.tirerChainette()
    println v    
}

