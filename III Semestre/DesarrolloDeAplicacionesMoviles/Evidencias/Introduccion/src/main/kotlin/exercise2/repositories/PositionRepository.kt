package exercise2.repositories

import exercise2.models.Position

interface PositionRepository {

    fun getPositions(): MutableList<Position>;

}