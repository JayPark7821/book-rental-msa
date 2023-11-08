package kr.jay.member.application.inputport

import kr.jay.member.application.outputport.MemberOutPutPort
import kr.jay.member.application.usecase.InquiryMemberUseCase
import kr.jay.member.application.usecase.dto.MemberOutPutDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * InquiryMemberInputPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */

@Service
@Transactional
class InquiryMemberInputPort(
    private val memberOutPutPort: MemberOutPutPort,
) : InquiryMemberUseCase {
    override fun getMember(memberNo: Long): MemberOutPutDto =
        memberOutPutPort.loadMember(memberNo).let {
            return MemberOutPutDto.mapToDto(it)
        }


}