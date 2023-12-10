package com.BadaBazaar.Controller;

import com.BadaBazaar.Model.Seller;
import com.BadaBazaar.RequestDto.SellerRequestDto;
import com.BadaBazaar.ResponseDto.SellerResponseDto;
import com.BadaBazaar.Service.Imp.SellerServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/seller")
@Slf4j
@Tag(name = "SellerController")
public class SellerController {

    @Autowired
    SellerServiceImp sellerService;


    @Operation(summary = "Api to create a Seller", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Seller.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {@Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {@Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = {@Content(schema = @Schema()) }),
    })
    @PostMapping(value = "/add/{id}", produces = {"application/json"}, consumes = {"application/json"} )
    public ResponseEntity<Seller> addSeller(
            @Parameter(name = "Seller", example = "{}") @RequestBody SellerRequestDto sellerRequestDto){


        log.info("Seller adding..........");
        return new ResponseEntity(sellerService.addSeller(sellerRequestDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Api to get all sellers", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = {@Content(mediaType = "application/json",schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {@Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {@Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = {@Content(schema = @Schema()) }),
    })
    @GetMapping(value = "/get/all", produces = {"application/json"}, consumes = {"application/json"})
    public List<SellerResponseDto> getAllSellers(){
        return sellerService.getAllSellers();
    }

    @Operation(summary = "Api to get seller by pan no.", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = {@Content(mediaType = "application/json",schema = @Schema(implementation = SellerResponseDto.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {@Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {@Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = {@Content(schema = @Schema()) }),
    })
    @GetMapping(value = "/get/pan", produces = {"application/json"}, consumes = {"application/json"})
    public SellerResponseDto getSellerByPan(
            @Parameter(name = "PanNo", example = "BAQPN1690C") @RequestParam String panNo){
        return sellerService.getSellerByPan(panNo);
    }

    @Operation(summary = "Api to delete a seller", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Void.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {@Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {@Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = {@Content(schema = @Schema()) }),
    })
    @DeleteMapping(value = "/delete/seller/{sellerId}", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<Void> deleteSeller(
            @Parameter(in = ParameterIn.PATH, name = "SellerId", example = "65746646a494ed21add225d9") @PathVariable String sellerId) throws Exception
    {
        return sellerService.deleteSeller(sellerId);

    }
}
