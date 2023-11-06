package kr.jay.member.domain.model

import jakarta.persistence.ElementCollection
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import kr.jay.member.domain.model.vo.*

/**
 * Member
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */

@Entity
class Member private constructor(
    memberNo: Long,
    idName: IdName,
    passWord: PassWord,
    email: Email,
    authorities: List<Authority> = mutableListOf(),
    point : Point,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var memberNo = memberNo
        private set
    @Embedded
    var idName = idName
        private set
    @Embedded
    var passWord = passWord
        private set
    @Embedded
    var email = email
        private set
    @ElementCollection
    var authorites = authorities
        private set
    @Embedded
    var point = point
        private set

    companion object{
        fun registerMember(
            idName: IdName,
            passWord: PassWord,
            email: Email,
        ) = Member(
            memberNo = 0,
            idName = idName,
            passWord = passWord,
            email = email,
            point = Point.createPoint(),
            authorities = mutableListOf(Authority(UserRole.USER))
        )
    }

    fun addPoint(point: Long) {
        this.point = this.point.addPoint(point)
    }

    fun usePoint(point: Long) {
        this.point = this.point.usePoint(point)
    }

}