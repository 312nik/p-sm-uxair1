package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.dto.DestinationDto;
import ru.uxair.flight.entity.dto.ErrorResponseDto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("/api/v.1/destinations")
@Tag(name = "Destination", description = "Methods for destination operation")
public interface DestinationController {

    @GetMapping("/{id}")
    @Operation(
            tags = {"Destination"},
            summary = "A method for searching airports by airport code",
            description = "A method for searching airports by airport code",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = DestinationDto.class)))

    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success Response",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Destination not  found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    ResponseEntity <DestinationDto> getDestinationById(@Parameter(description = "Unique identifier of airport", required = true)
                                                       @NotBlank @PathVariable("id") String id);
    @GetMapping("/city/{city}")
    @Operation(
            tags = {"Destination"},
            summary = "A method for searching airports by city`s name.",
            description = "A method for searching airports by city`s name. Returns a list ordered alphabetically by city`s names",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = DestinationDto.class)))

    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success Response",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Destination not  found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    ResponseEntity <List<DestinationDto>> getDestinationByCity (@Parameter(description = "Identifier of airport by city", required = true)
                                                                @NotBlank @PathVariable("city") String city);
    @GetMapping("/countryName/{countryName}")

    @Operation(
            tags = {"Destination"},
            summary = "A method for searching airports by country name.",
            description = "A method for searching airports by country name. Returns a list ordered alphabetically by country names and city names",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = DestinationDto.class)))

    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success Response",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DestinationDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Destination not  found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
       ResponseEntity  <List<DestinationDto>> getDestinationByCountry (@Parameter(description = "Identifier of airport by country", required = true)
                                                                       @NotBlank @PathVariable("countryName") String countryName);
    @PostMapping
    @Operation(
            tags = {"Destination"},
            summary = "A method for  create of destination",
            description = "A method for  create of destination",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "This  is the request body desc",
                    content = @Content(schema = @Schema(implementation = DestinationDto.class)))

    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success Response",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Not used",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    ResponseEntity <HttpStatus> createDestination (@Parameter(description = "DestinationDto", required = true)
                                                   @NotBlank  @RequestBody @Valid DestinationDto destinationDto);



 @PutMapping
 @Operation(
         tags = {"Destination"},
         summary = "A method for update of destination",
         description = "A method for update of destination",
         requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "This  is the request body desc",
                 content = @Content(schema = @Schema(implementation = DestinationDto.class)))
 )
 @ApiResponses(value = {
         @ApiResponse(responseCode = "200", description = "Success Response",
                 content = {@Content(schema = @Schema())}),
         @ApiResponse(responseCode = "400", description = "Incorrect data",
                 content = {@Content(mediaType = "application/json",
                         schema = @Schema(implementation = ErrorResponseDto.class))}),
         @ApiResponse(responseCode = "404", description = "Not used",
                 content = {@Content(schema = @Schema())}),
         @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                 content = {@Content(mediaType = "application/json",
                         schema = @Schema(implementation = ErrorResponseDto.class))})
 })

    ResponseEntity <HttpStatus> updateDestination ( @Parameter(description = "DestinationDto", required = true)
                                                    @NotBlank  @RequestBody @Valid DestinationDto destinationDto);

}