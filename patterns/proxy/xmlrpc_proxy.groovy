import groovy.xml.*

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

class XmlRpcProxyCalculatrice implements Calculatrice {
    def target
    
    XmlRpcProxyCalculatrice (target) {
        this.target = target
    }
    
    def add (lhs, rhs) {
        parseResponse (target.post (buildCall ('add', lhs, rhs)))
    }
    def substract (lhs, rhs) {
        parseResponse (target.post (buildCall ('substract', lhs, rhs)))
    }
    private String buildCall (name, param1, param2) {
        new StreamingMarkupBuilder().bind {
            methodCall {
                methodName name
                params {
                    param { value { i4 param1 } }
                    param { value { i4 param2 } }
                }
            }
        }
    }
    private parseResponse (xml) {
        def methodResponse = new XmlSlurper().parseText(xml)
        methodResponse.params.param.value.i4.toInteger()
    }
}

class XmlRpcCalculatriceExporter {
    def target
    
    XmlRpcCalculatriceExporter (target) {
        this.target = target
    }
    
    String post (xml) {
        def methodCall = new XmlSlurper().parseText(xml)
        def methodName = methodCall.methodName
        def lhs = methodCall.params.param[0].value.i4.toInteger()
        def rhs = methodCall.params.param[1].value.i4.toInteger()
        def res
        
        if (methodName == 'add') {
            res = target.add(lhs, rhs)
        } else {
            res = target.substract(lhs, rhs)
        }
        
        new StreamingMarkupBuilder().bind {
            methodResponse {
                params {
                    param { value { i4 res } }
                }
            }
        }
    }
}

Calculatrice calc = new XmlRpcProxyCalculatrice (new XmlRpcCalculatriceExporter (new DefaultCalculatrice ()))

println calc.add(2, 3)
println calc.substract(2, 3)
