package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.ApiUtil;
import at.fhtw.swen3.controller.ParcelApi;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Slf4j
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-24T13:08:29.856611Z[Etc/UTC]")
@Controller
public class ParcelApiController implements ParcelApi {

    private final NativeWebRequest request;
    private final ParcelService parcelService;

    public ParcelApiController(NativeWebRequest request, ParcelService parcelService) {
        log.info(this.getClass().getSimpleName());
        this.request = request;
        this.parcelService = parcelService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/parcel",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    //auf public ändern
    public ResponseEntity<NewParcelInfo> submitParcel(Parcel parcel) {
        // Map parcel to parcelEntity
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);
        NewParcelInfo newParcelInfo = this.parcelService.submitNewParcel(parcelEntity);
        return new ResponseEntity<>(newParcelInfo, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/parcel/{trackingId}/reportDelivery/",
            produces = { "application/json" }
    )
    @Override
    public ResponseEntity<Void> reportParcelDelivery(@Parameter(name = "trackingId", description = "", required = true) @PathVariable("trackingId") String trackingId) {
        // Map parcel to parcelEntity
        parcelService.reportParcelDelivery(trackingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> reportParcelHop(String trackingId, String code) {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @Override
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/parcel/{trackingId}",
            produces = { "application/json" }
    )
    public ResponseEntity<TrackingInformation> trackParcel(@Parameter(name = "trackingId", description = "", required = true) @PathVariable("trackingId") String trackingId) {
        TrackingInformation trackingInformation = this.parcelService.getParcelByTrackingId(trackingId);
        return new ResponseEntity<>(trackingInformation, HttpStatus.OK);
    }

    @Override
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/parcel/{trackingId}",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<NewParcelInfo> transitionParcel(@Parameter(name = "trackingId", description = "", required = true) @PathVariable("trackingId") String trackingId, Parcel parcel) {
        // Map parcel to parcelEntity
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);
        NewParcelInfo newParcelInfo = this.parcelService.transitionParcel(trackingId, parcelEntity);
        return new ResponseEntity<>(newParcelInfo, HttpStatus.OK);
    }
}
