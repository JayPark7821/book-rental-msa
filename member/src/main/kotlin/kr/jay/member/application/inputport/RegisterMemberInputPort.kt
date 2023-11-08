package kr.jay.member.application.inputport

import kr.jay.member.application.outputport.MemberOutPutPort
import kr.jay.member.application.usecase.RegisterMemberUseCase
import kr.jay.member.application.usecase.dto.MemberInfoDto
import kr.jay.member.application.usecase.dto.MemberOutPutDto
import kr.jay.member.domain.model.Member
import kr.jay.member.domain.model.vo.Email
import kr.jay.member.domain.model.vo.IdName
import kr.jay.member.domain.model.vo.PassWord
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * RegisterMemberInputPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */

@Service
@Transactional
class RegisterMemberInputPort(
    private val memberOutPutPort: MemberOutPutPort
) : RegisterMemberUseCase{
    override fun registerMember(memberInfoDto: MemberInfoDto): MemberOutPutDto {
        Member.registerMember(
            idName = IdName(memberInfoDto.id, memberInfoDto.name),
            passWord = PassWord(memberInfoDto.passPwd, memberInfoDto.passPwd),
            email = Email(memberInfoDto.address)
        ).let {
            memberOutPutPort.saveMember(it)
            return MemberOutPutDto.mapToDto(it)
        }
    }
}