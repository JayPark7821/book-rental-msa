package kr.jay.member.application.inputport

import kr.jay.member.application.outputport.MemberOutPutPort
import kr.jay.member.application.usecase.SavePointUseCase
import kr.jay.member.application.usecase.dto.MemberOutPutDto
import kr.jay.member.domain.model.vo.IdName
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * SavePointInputPort
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
@Service
@Transactional
class SavePointInputPort(
    private val memberOutPutPort: MemberOutPutPort,
) : SavePointUseCase {

    override fun savePoint(idName: IdName, point: Long): MemberOutPutDto {
        memberOutPutPort.loadMemberByIdName(idName).let {
            it.addPoint(point)
            val updatedMember = memberOutPutPort.saveMember(it)
            return MemberOutPutDto.mapToDto(updatedMember)
        }
    }
}