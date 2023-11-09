package kr.jay.member.framework.jpaadapter

import kr.jay.member.domain.model.Member
import kr.jay.member.domain.model.vo.IdName
import org.springframework.data.jpa.repository.JpaRepository

/**
 * MemberJpaRepoistory
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
interface MemberJpaRepository : JpaRepository<Member, Long> {
    fun findByIdName(idName: IdName): Member?
}