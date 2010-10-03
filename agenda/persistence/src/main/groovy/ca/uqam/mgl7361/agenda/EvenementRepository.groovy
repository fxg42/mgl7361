package ca.uqam.mgl7361.agenda

import groovy.sql.*
import javax.sql.*

class EvenementRepository {

    static FIND_ALL_STMT = "SELECT * FROM evenements"
    static INSERT_STMT = "INSERT INTO evenements (nom, du, au) VALUES (:nom, :du, :au)"
    
    def sql
    def factory = new EvenementFactory()
    
    def findAll () {
        sql.rows(FIND_ALL_STMT).collect{factory.fromRow(it)}
    }
    
    def add (Evenement evt) {
        sql.executeUpdate(INSERT_STMT, [ nom: evt.nom, du: evt.du.toTimestamp(), au: evt.au.toTimestamp() ])
    }
    
    void setDataSource (DataSource dataSource) {
        sql = new Sql(dataSource)
    }
}