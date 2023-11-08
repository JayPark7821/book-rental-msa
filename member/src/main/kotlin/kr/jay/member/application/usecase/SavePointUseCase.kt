package kr.jay.member.application.usecase

import kr.jay.member.application.usecase.dto.MemberOutPutDto
import kr.jay.member.domain.model.vo.IdName

/**
 * SavePointUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
interface SavePointUseCase {
    fun savePoint(idName: IdName, point: Long): MemberOutPutDto
}