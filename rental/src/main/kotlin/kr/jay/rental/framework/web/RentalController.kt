package kr.jay.rental.framework.web

import kr.jay.rental.application.usecase.*
import kr.jay.rental.application.usecase.dto.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * RentalController
 *
 * @author jaypark
 * @version 1.0.0
 * @since 11/3/23
 */
@RestController
@RequestMapping("/api")
class RentalController(
    private val clearOverdueItemUseCase: ClearOverdueItemUseCase,
    private val createRentalCardUseCase: CreateRentalCardUseCase,
    private val inquiryUseCase: InquiryUseCase,
    private val overdueItemUseCase: OverdueItemUseCase,
    private val returnItemUseCase: ReturnItemUseCase,
    private val rentItemUseCase: RentItemUseCase,
) {

    @PostMapping("/rental-card")
    fun createRentalCard(
        @RequestBody userInputDto: UserInputDto
    ):ResponseEntity<RentalCardOutputDto>{
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(createRentalCardUseCase.createRentalCard(userInputDto))
    }

    @GetMapping("/rental-card/{userId}")
    fun getRentalCard(@PathVariable("userId") userId:String): ResponseEntity<RentalCardOutputDto>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(inquiryUseCase.getRentalCard(UserInputDto(userId = userId, userName = "")))
    }

    @GetMapping("/rental-card/{userId}/rentbook")
    fun getAllRentItem(@PathVariable("userId") userId:String): ResponseEntity<List<RentalItemOutputDto>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(inquiryUseCase.getAllRentItem(UserInputDto(userId = userId, userName = "")))
    }

    @GetMapping("/rental-card/{userId}/returnbook")
    fun getAllReturnItem(@PathVariable("userId") userId:String): ResponseEntity<List<ReturnItemOutPutDto>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(inquiryUseCase.getAllReturnItem(UserInputDto(userId = userId, userName = "")))
    }

    @PostMapping("/rental-card/rent")
    fun rentItem(@RequestBody userItemInputDto: UserItemInputDto): ResponseEntity<RentalCardOutputDto>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(rentItemUseCase.rentItem(userItemInputDto))
    }

    @PostMapping("/rental-card/return")
    fun returnItem(@RequestBody userItemInputDto: UserItemInputDto): ResponseEntity<RentalCardOutputDto>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(returnItemUseCase.returnItem(userItemInputDto))
    }

    @PostMapping("/rental-card/overdue")
    fun overdueItem(@RequestBody userItemInputDto: UserItemInputDto): ResponseEntity<RentalCardOutputDto>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(overdueItemUseCase.overdueItem(userItemInputDto))
    }

    @PostMapping("/rental-card/clearoverdue")
    fun clearOverdueItem(@RequestBody clearOverdueInfoDto: ClearOverdueInfoDto): ResponseEntity<RentalResultOutputDto>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(clearOverdueItemUseCase.clearOverdue(clearOverdueInfoDto))
    }


}