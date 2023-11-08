package kr.jay.member.application.usecase.dto

import kr.jay.member.domain.model.Member
import kr.jay.member.domain.model.vo.PassWord

/**
 * MemberOutPutDto
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */
data class MemberOutPutDto(
    val id: String,
    val name: String,
    val passWord: String,
    val email: String,
    val point: Long,
){
    companion object{
        fun mapToDto(member: Member)
        = MemberOutPutDto(
            id = member.idName.id,
            name = member.idName.name,
            passWord = member.passWord.presentPwd,
            email = member.email.address,
            point = member.point.point,
        )
    }
}
