package kr.jay.member.framework.web

import kr.jay.member.application.usecase.InquiryMemberUseCase
import kr.jay.member.application.usecase.RegisterMemberUseCase
import kr.jay.member.application.usecase.SavePointUseCase
import kr.jay.member.application.usecase.UsePointUseCase
import kr.jay.member.application.usecase.dto.MemberInfoDto
import org.springframework.web.bind.annotation.*

/**
 * MemberController
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/6/23
 */

@RestController
@RequestMapping("/api")
class MemberController (
    private val registerMemberUseCase: RegisterMemberUseCase,
    private val inquiryMemberUseCase: InquiryMemberUseCase,
){
    @PostMapping("/member")
    fun addMember(@RequestBody memberInfoDto: MemberInfoDto) =
        registerMemberUseCase.registerMember(memberInfoDto)

    @GetMapping("/member/{memberNo}")
    fun getMember(@PathVariable memberNo: Long) =
        inquiryMemberUseCase.getMember(memberNo)
}