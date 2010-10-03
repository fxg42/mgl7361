package ca.uqam.mgl7361.agenda

class EvenementFactory {

    def fromRow (row) {
        new Evenement([
            id: row.id,
            nom: row.nom,
            du: new Date(row.du.time),
            au: new Date(row.au.time)
        ])
    }
}