package kr.jay.member.application.usecase

import kr.jay.member.application.usecase.dto.MemberInfoDto
import kr.jay.member.application.usecase.dto.MemberOutPutDto

/**
 * RegisterMemberUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
interface RegisterMemberUseCase {
    fun registerMember(memberInfoDto: MemberInfoDto): MemberOutPutDto
}