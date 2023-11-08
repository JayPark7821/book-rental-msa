package kr.jay.member.application.outputport

import kr.jay.member.domain.model.Member
import kr.jay.member.domain.model.vo.IdName

/**
 * MemberOutPutPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
interface MemberOutPutPort {
    fun loadMember(memberNo: Long): Member
    fun loadMemberByIdName(idName: IdName): Member
    fun saveMember(member: Member): Member
}