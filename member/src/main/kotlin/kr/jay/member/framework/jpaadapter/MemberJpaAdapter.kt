package kr.jay.member.framework.jpaadapter

import kr.jay.member.application.outputport.MemberOutPutPort
import kr.jay.member.domain.model.Member
import kr.jay.member.domain.model.vo.IdName
import org.springframework.stereotype.Repository

/**
 * MemberJpaAdapter
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */

@Repository
class MemberJpaAdapter(
    private val memberJpaRepository: MemberJpaRepository,
) : MemberOutPutPort {
    override fun loadMember(memberNo: Long): Member = memberJpaRepository.findById(memberNo).orElseThrow()

    override fun loadMemberByIdName(idName: IdName) = memberJpaRepository.findByIdName(idName) ?: throw Exception()

    override fun saveMember(member: Member) = memberJpaRepository.save(member)

}