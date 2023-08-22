package exercise2.services

import exercise2.models.Position
import exercise2.repositories.PositionRepository

class PositionService: PositionRepository {

    private val positions: MutableList<Position> = mutableListOf(
        Position("CEO", 1),
        Position("Gerente", 2),
        Position("Empleado Profesional", 3),
        Position("Empleado Tecnólogo", 4),
        Position("Empleado Técnico", 5),
        Position("Pasante", 6),
    );

    override fun getPositions(): MutableList<Position> {
        return positions;
    }


}