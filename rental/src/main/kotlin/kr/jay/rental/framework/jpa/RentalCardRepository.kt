package kr.jay.rental.framework.jpa

import kr.jay.rental.domain.model.RentalCard
import kr.jay.rental.domain.model.vo.RentalCardNo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * RentalCardRepository
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
interface RentalCardRepository : JpaRepository<RentalCard, RentalCardNo> {
    @Query("select r from RentalCard r where r.member.id = :id")
    fun findByMemberId(@Param("id") memberId: String): RentalCard?

    @Query("select r from RentalCard r where r.rentalCardNo.no = :id")
    fun findById(@Param("id") rentalCardId: Long): RentalCard?
}