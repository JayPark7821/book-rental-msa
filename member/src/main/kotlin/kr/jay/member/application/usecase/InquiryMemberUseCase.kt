package kr.jay.member.application.usecase

import kr.jay.member.application.usecase.dto.MemberOutPutDto

/**
 * InquiryMemberUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
interface InquiryMemberUseCase {
    fun getMember(memberNo: Long): MemberOutPutDto
}