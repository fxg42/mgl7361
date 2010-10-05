package ca.uqam.mgl7361.agenda

import groovy.sql.*
import javax.sql.*

class EvenementRepository {

    static FIND_ALL_STMT = "SELECT * FROM evenements ORDER BY id"
    static FIND_BY_ID_STMT = "SELECT * FROM evenements WHERE id = ?"
    static INSERT_STMT = "INSERT INTO evenements (nom, du, au) VALUES (?, ?, ?)"
    static UPDATE_STMT = "UPDATE evenements SET nom = ?, du = ?, au = ? WHERE id = ?"
    
    def sql
    def factory = new EvenementFactory()
    
    def findAll () {
        sql.rows(FIND_ALL_STMT).collect{factory.fromRow(it)}
    }
    
    def findById (id) {
        factory.fromRow(sql.firstRow(FIND_BY_ID_STMT, [id]))
    }
    
    def add (Evenement evt) {
        sql.executeUpdate(INSERT_STMT, [ evt.nom, evt.du.toTimestamp(), evt.au.toTimestamp() ])
    }
    
    def update (Evenement evt) {
        sql.executeUpdate(UPDATE_STMT, [ evt.nom, evt.du.toTimestamp(), evt.au.toTimestamp(), evt.id ])
    }
    
    void setDataSource (DataSource dataSource) {
        sql = new Sql(dataSource)
    }
}