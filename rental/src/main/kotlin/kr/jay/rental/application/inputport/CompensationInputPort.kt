package kr.jay.rental.application.inputport

import kr.jay.rental.application.outputport.EventOutputPort
import kr.jay.rental.application.outputport.RentalCardOutputPort
import kr.jay.rental.application.usecase.CompensationUseCase
import kr.jay.rental.domain.event.PointUseCommand
import kr.jay.rental.domain.model.RentalCard
import kr.jay.rental.domain.model.vo.IdName
import kr.jay.rental.domain.model.vo.Item
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

/**
 * CompensationInputPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/13/23
 */

@Component
@Transactional
class CompensationInputPort(
    private val rentalCardOutputPort: RentalCardOutputPort,
    private val eventOutputPort: EventOutputPort,
) : CompensationUseCase {
    override fun cancelRentItem(idName: IdName, item: Item): RentalCard {
        return rentalCardOutputPort.loadRentalCard(idName.id)?.let {
            it.cancelRentItem(item)
            eventOutputPort.occurPointUseCommand(PointUseCommand(idName, 10L))
            it
        } ?: throw Exception("No Rental Card")
    }

    override fun cancelReturnItem(idName: IdName, item: Item, point: Long): RentalCard {
        return rentalCardOutputPort.loadRentalCard(idName.id)?.let {
            it.cancelReturnItem(item, point)
            eventOutputPort.occurPointUseCommand(PointUseCommand(idName, point))
            it
        } ?: throw Exception("No Rental Card")
    }

    override fun cancelMakeAvailableRental(idName: IdName, point: Long): Long {
        return rentalCardOutputPort.loadRentalCard(idName.id)
            ?.cancelMakeAvailableRental(point)
            ?: throw Exception("No Rental Card")
    }

}