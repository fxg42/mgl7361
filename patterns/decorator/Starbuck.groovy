abstract class Boisson {
    abstract getDescription ()
    abstract getPrix ()
    String toString () {
        "${getDescription()}: ${getPrix()}\$"
    }
}

class Espresso extends Boisson {
    def getDescription () {
        "Espresso"
    }
    def getPrix () {
        1.99
    }
}

class CafeFiltre extends Boisson {
    def getDescription () {
        "Café filtre"
    }
    def getPrix () {
        3.99
    }
}

abstract class BoissonDecorator extends Boisson { }

class CremeFouettee extends BoissonDecorator {
    def target
    
    CremeFouettee (target) {
        this.target = target
    }
    def getDescription () {
        target.getDescription() + ', avec de la crème fouettée'
    }
    def getPrix () {
        target.getPrix() + 2.00
    }
}

class Lait extends BoissonDecorator {
    def target

    Lait (target) {
        this.target = target
    }
    def getDescription () {
        target.getDescription() + ', avec du lait'
    }
    def getPrix () {
        target.getPrix() + 1.50
    }
}

class Mousse extends BoissonDecorator {
    def target

    Mousse (target) {
        this.target = target
    }
    def getDescription () {
        target.getDescription() + ', avec de la mousse de lait'
    }
    def getPrix () {
        target.getPrix() + 0.50
    }
}

class Eau extends BoissonDecorator {
    def target
    
    Eau (target) {
        this.target = target
    }
    def getDescription () {
        target.getDescription() + ", avec de l'eau"
    }
    def getPrix () {
        target.getPrix()
    }
}

class Shot extends BoissonDecorator {
    def target
    def espresso = new Espresso()
    
    Shot (target) {
        this.target = target
    }
    def getDescription () {
        target.getDescription() + ", avec un " + espresso.getDescription()
    }
    def getPrix () {
        target.getPrix() + espresso.getPrix()
    }
}

americano = new Eau (new Espresso ())
caffeLatte = new Lait (new Espresso ())
cafeViennois = new CremeFouettee (new Espresso ())
capuccino = new Mousse (new Lait (new Espresso ()))
redEye = new Shot (new CafeFiltre ())
redEyeViennois = new CremeFouettee (redEye)

println americano
println caffeLatte
println cafeViennois
println capuccino
println redEye
println redEyeViennois
