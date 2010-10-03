interface Calculatrice {
    def add (lhs, rhs)
    def substract (lhs, rhs)
}

class DefaultCalculatrice implements Calculatrice {
    def add (lhs, rhs) {
        lhs + rhs
    }
    def substract (lhs, rhs) {
        lhs - rhs
    }
}

class LoggingDecorator implements Calculatrice {
    def target
    
    LoggingDecorator (target) {
        this.target = target
    }
    
    def add (lhs, rhs) {
        println "appel de la méthode 'add(${lhs}, ${rhs})'"
        def res = target.add(lhs, rhs)
        println "appel de la méthode 'add(${lhs}, ${rhs}) -> ${res}'"
        res
    }
    def substract (lhs, rhs) {
        println "appel de la méthode 'substract(${lhs}, ${rhs})'"
        def res = target.substract(lhs, rhs)
        println "appel de la méthode 'substract(${lhs}, ${rhs}) -> ${res}'"
        res
    }
}

class DoublingDecorator implements Calculatrice {
    def target
    
    DoublingDecorator (target) {
        this.target = target
    }
    def add (lhs, rhs) {
        target.add(lhs*2, rhs*2)
    }
    def substract (lhs, rhs) {
        target.substract(lhs*2, rhs*2)
    }
}

class AlwaysPositive implements Calculatrice {
    def target
    
    AlwaysPositive (target) {
        this.target = target
    }
    def add (lhs, rhs) {
        def res = target.add(lhs, rhs)
        res >= 0 ? res : 0
    }
    def substract (lhs, rhs) {
        def res = target.substract(lhs, rhs)
        res >= 0 ? res : 0
    }
}

calc = new AlwaysPositive (new DoublingDecorator(new LoggingDecorator(new DefaultCalculatrice())))

println calc.add (2, 3)

println calc.substract(2, 3)

