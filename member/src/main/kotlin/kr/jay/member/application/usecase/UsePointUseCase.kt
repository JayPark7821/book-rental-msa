package kr.jay.member.application.usecase

import kr.jay.member.application.usecase.dto.MemberOutPutDto
import kr.jay.member.domain.model.vo.IdName

/**
 * UsePointUseCase
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
interface UsePointUseCase {
    fun usePoint(idName: IdName, point: Long): MemberOutPutDto
}